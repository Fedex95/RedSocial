package com.puce.redsocial.Services;

import com.puce.redsocial.Entitys.Usuario;
import com.puce.redsocial.Repository.UsuarioRepositorio;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepositorio usuarioRep;

    public Iterable<Usuario> getAllUsers() {
        return usuarioRep.findAll();
    }

    public Optional <Usuario> getUserById(Integer id) {
        return usuarioRep.findById(id);
    }

    public Usuario createUser(Usuario usuario) {
        return usuarioRep.save(usuario);
    }

    public Usuario updateUser(Integer id, Usuario usuario) {
        Usuario user = getUserById(id).get();
        user.setNombre(usuario.getNombre());
        user.setCorreo(usuario.getCorreo());
        user.setContraseña(usuario.getContraseña());
        user.setBio(usuario.getBio());
        return usuarioRep.save(user);
    }
    public void deleteUser(Integer id) {
        usuarioRep.deleteById(id);
    }
}
