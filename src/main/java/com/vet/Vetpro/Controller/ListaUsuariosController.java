package com.vet.Vetpro.Controller;

import com.vet.Vetpro.Models.User;
import com.vet.Vetpro.Service.RoleService;
import com.vet.Vetpro.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListaUsuariosController {

    @Autowired
    public UserService userService;

    @Autowired
    public RoleService roleService;

    @GetMapping("/usuarios")
    public String VerUsuarios(Model model) {
        List<User> usuarios = userService.findAllUser();
        model.addAttribute("listUsers", usuarios);
        return "usuarios";
    }
}
