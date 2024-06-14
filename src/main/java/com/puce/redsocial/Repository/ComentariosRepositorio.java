package com.puce.redsocial.Repository;

import com.puce.redsocial.Entitys.Comentarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComentariosRepositorio extends CrudRepository<Comentarios, Integer> {

}
