package com.puce.redsocial.Repository;

import com.puce.redsocial.Entitys.Likes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LikesRepositorio extends CrudRepository<Likes, Integer> {

}
