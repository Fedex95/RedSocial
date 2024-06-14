package com.puce.redsocial.Repository;

import com.puce.redsocial.Entitys.Amistades;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AmistadesRepositorio extends CrudRepository<Amistades, Integer> {

}