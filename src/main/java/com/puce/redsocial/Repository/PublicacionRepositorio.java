package com.puce.redsocial.Repository;

import com.puce.redsocial.Entitys.Publicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicacionRepositorio extends CrudRepository<Publicacion, Integer>{

}
