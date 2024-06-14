package com.puce.redsocial.Controllers;

import com.puce.redsocial.Entitys.Publicacion;
import com.puce.redsocial.Services.PublicacionService;
import com.puce.redsocial.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.nio.file.AccessDeniedException;
import java.util.Optional;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
    @Autowired
    private PublicacionService publicacionServ;
    @Autowired
    private UsuarioService usuarioServ;

    @GetMapping
    public Iterable<Publicacion> getAllPublicaciones() {
        return publicacionServ.getAllPublicaciones();
    }

    @GetMapping("/{id}")
    public Optional<Publicacion> getPublicacionById(@PathVariable Integer id) {
        return publicacionServ.getPublicacionById(id);
    }

    @RequestMapping(value="/create", method = RequestMethod.POST, produces = "application/json")
    public Publicacion createPublicacion(@RequestBody Publicacion publicacion) throws AccessDeniedException {
        if(usuarioServ.getUserById(publicacion.getUsuario()).isEmpty()){
            throw new AccessDeniedException("Usuario no existe");
        }
        return publicacionServ.createPublicacion(publicacion);
    }

    @RequestMapping("/delete/{id}")
    public void deletePublicacion(@PathVariable Integer id, @RequestHeader Integer userid) throws AccessDeniedException {
        Publicacion publicacion = publicacionServ.getPublicacionById(id).get();
        if (!publicacion.getUsuario().equals(userid)) {
            throw new AccessDeniedException("Acción denegada");
        }
        publicacionServ.deletePublicacion(id);
    }
}