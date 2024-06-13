package com.puce.redsocial.Controllers;

import com.puce.redsocial.Entitys.Publicacion;
import com.puce.redsocial.Services.PublicacionService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
    @Autowired
    private PublicacionService publicacionServ;

    @GetMapping
    public List<Publicacion> getAllPublicaciones() {
        return publicacionServ.getAllPublicaciones();
    }

    @GetMapping("/{id}")
    public Optional<Publicacion> getPublicacionById(@PathVariable Long id) {
        return publicacionServ.getPublicacionById(id);
    }

    @PostMapping
    public Publicacion createPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionServ.createPublicacion(publicacion);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ADMINISTRADOR")
    public void deletePublicacion(@PathVariable Long id) {
        publicacionServ.deletePublicacion(id);
    }
}