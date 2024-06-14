package com.puce.redsocial.Services;

import com.puce.redsocial.Entitys.Publicacion;
import com.puce.redsocial.Repository.PublicacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Optional;

@Service
public class PublicacionService {
    @Autowired
    private PublicacionRepositorio publicacionRep;

    public Iterable<Publicacion> getAllPublicaciones() {
        return publicacionRep.findAll();
    }

    public Optional<Publicacion> getPublicacionById(Integer id) {
        return publicacionRep.findById(id);
    }

    public Publicacion createPublicacion(Publicacion publicacion) {
        publicacion.setFechaPublicacion(new Timestamp(System.currentTimeMillis()));
        return publicacionRep.save(publicacion);
    }
    public void deletePublicacion(Integer id) {
        publicacionRep.deleteById(id);
    }
}
