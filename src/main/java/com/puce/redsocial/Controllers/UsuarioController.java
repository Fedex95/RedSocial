package com.puce.redsocial.Controllers;

import com.puce.redsocial.Entitys.Usuario;
import com.puce.redsocial.Services.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioServ;

    @GetMapping
    public List<Usuario> getAllUsers() {
        return usuarioServ.getAllUsers();
    }

    @GetMapping("/{id}")
    public Usuario getUserById(@PathVariable Long id) {
        return usuarioServ.getUserById(id);
    }

    @PostMapping
    public Usuario createUser(@RequestBody Usuario usuario) {
        return usuarioServ.createUser(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUser(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioServ.updateUser(id, usuario);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ADMINISTRADOR")
    public void deleteUser(@PathVariable Long id) {
        usuarioServ.deleteUser(id);
    }
}
