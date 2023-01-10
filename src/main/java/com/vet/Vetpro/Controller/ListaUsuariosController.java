package com.vet.Vetpro.Controller;

import com.vet.Vetpro.Models.Role;
import com.vet.Vetpro.Models.User;
import com.vet.Vetpro.Service.RoleService;
import com.vet.Vetpro.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ListaUsuariosController {

    @Autowired
    public UserService userService;

    @Autowired
    public RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @GetMapping("/usuarios")
    public String VerUsuarios(Model model) {
        List<User> usuarios = userService.findAllUser();
        model.addAttribute("listUsers", usuarios);
        return "usuarios";
    }

    @GetMapping("/register")
    public String RegistroUsuarios(Model model) {
        model.addAttribute("role", roleService.findAllRole());
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }


    @PostMapping("/guardarUsuario")
    public String saveUser(@ModelAttribute("user")  @Valid User user , BindingResult bindingResult, Model model) {
        if (user.getConfirmpassword() == null){
            bindingResult.rejectValue("confirmpassword","confirmar","Debe confirmar el password");
        }
        else if (!user.getPassword().equals(user.getConfirmpassword())){
            bindingResult.rejectValue("password","confirmar","La contraseña y confirmar contraseña no son iguales");
        }

        if (bindingResult.hasErrors()){
            model.addAttribute("role", roleService.findAllRole());
            return "NuevoUsuario";
        }

        Role rol = roleService.findByIdRole(user.getRole().getId());
        user.setRole(rol);
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/indexusuarios";
    }
}
