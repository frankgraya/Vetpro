package com.vet.Vetpro.RestController;

import com.vet.Vetpro.Models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioRestController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("francisco");
        usuario.setApellido("granados");
        usuario.setEmail("francisco.graya26@gmail.com");
        usuario.setTelefono("7223897339");
        usuario.setPassword("1234");
        return usuario;
    }

    @RequestMapping(value = "usuario12")
    public Usuario Modificar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("francisco");
        usuario.setApellido("granados");
        usuario.setEmail("francisco.graya26@gmail.com");
        usuario.setTelefono("7223897339");
        usuario.setPassword("1234");
        return usuario;
    }
}
