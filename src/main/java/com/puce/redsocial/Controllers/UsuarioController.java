package com.puce.redsocial.Controllers;

import com.puce.redsocial.Entitys.Usuario;
import com.puce.redsocial.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioServ;

    @GetMapping
    public Iterable<Usuario> getAllUsers() {
        return usuarioServ.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUserById(@PathVariable Integer id) {
        return usuarioServ.getUserById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public Usuario createUser(@RequestBody Usuario usuario) {
        return usuarioServ.createUser(usuario);
    }

    @PutMapping("/update/{id}")
    public Usuario updateUser(@PathVariable Integer id, @RequestBody Usuario usuario) {
        return usuarioServ.updateUser(id, usuario);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces= "application/json")
    public void deleteUser(@PathVariable Integer id, @RequestHeader Integer userid) throws AccessDeniedException {
        Usuario usuario = usuarioServ.getUserById(userid).get();
        if (!usuario.getRol().equals("ADMINISTRADOR")) {
            throw new AccessDeniedException("Este usuario no tiene permisos");
        }
        usuarioServ.deleteUser(id);
    }
}
