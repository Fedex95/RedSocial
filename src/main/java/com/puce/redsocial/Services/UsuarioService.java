package com.puce.redsocial.Services;

import com.puce.redsocial.Entitys.Usuario;
import com.puce.redsocial.Repository.UsuarioRepositorio;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepositorio usuarioRep;

    public List<Usuario> getAllUsers() {
        return usuarioRep.findAll();
    }

    public Usuario getUserById(Long id) {
        return usuarioRep.findById(id).orElseThrow(() -> new RuntimeException("Usuario no existente"));
    }

    public Usuario createUser(Usuario usuario) {
        return usuarioRep.save(usuario);
    }

    public Usuario updateUser(Long id, Usuario usuario) {
        Usuario user = getUserById(id);
        user.setNombre(usuario.getNombre());
        user.setCorreo(usuario.getCorreo());
        user.setContraseña(usuario.getContraseña());
        user.setBio(usuario.getBio());
        return usuarioRep.save(user);
    }
    @RolesAllowed("ADMINISTRADOR")
    public void deleteUser(Long id) {
        usuarioRep.deleteById(id);
    }
}
