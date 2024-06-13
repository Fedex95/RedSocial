package com.puce.redsocial.Services;

import com.puce.redsocial.Entitys.Comentarios;
import com.puce.redsocial.Repository.ComentariosRepositorio;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentariosService {
    @Autowired
    private ComentariosRepositorio comentariosRep;

    public List<Comentarios> getAllComentarios() {
        return comentariosRep.findAll();
    }

    public Optional<Comentarios> getComentarioById(Long id) {
        return comentariosRep.findById(id);
    }

    public Comentarios createComentario(Comentarios comentarios) {
        return comentariosRep.save(comentarios);
    }
    @RolesAllowed("ADMINISTRADOR")
    public void deleteComentario(Long id) {
        comentariosRep.delete(id);
    }
}