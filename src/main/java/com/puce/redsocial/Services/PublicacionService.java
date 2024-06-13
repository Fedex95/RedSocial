package com.puce.redsocial.Services;

import com.puce.redsocial.Entitys.Publicacion;
import com.puce.redsocial.Repository.PublicacionRepositorio;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {
    @Autowired
    private PublicacionRepositorio publicacionRep;

    public List<Publicacion> getAllPublicaciones() {
        return publicacionRep.findAll();
    }

    public Optional<Publicacion> getPublicacionById(Long id) {
        return publicacionRep.findById(id);
    }

    public Publicacion createPublicacion(Publicacion publicacion) {
        return publicacionRep.save(publicacion);
    }
    @RolesAllowed("ADMINISTRADOR")
    public void deletePublicacion(Long id) {
        publicacionRep.delete(id);
    }
}
