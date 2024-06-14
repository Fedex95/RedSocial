package com.puce.redsocial.Services;

import com.puce.redsocial.Entitys.Comentarios;
import com.puce.redsocial.Repository.ComentariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class ComentariosService {
    @Autowired
    private ComentariosRepositorio comentariosRep;

    public Iterable<Comentarios> getAllComentarios() {
        return comentariosRep.findAll();
    }

    public Optional<Comentarios> getComentarioById(Integer id) {
        return comentariosRep.findById(id);
    }

    public Comentarios createComentario(Comentarios comentarios) {
        comentarios.setFechaComentario((new Timestamp(System.currentTimeMillis())));
        return comentariosRep.save(comentarios);
    }
    public void deleteComentario(Integer id) {
        comentariosRep.deleteById(id);
    }
}