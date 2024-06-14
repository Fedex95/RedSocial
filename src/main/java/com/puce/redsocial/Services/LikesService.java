package com.puce.redsocial.Services;

import com.puce.redsocial.Entitys.Likes;
import com.puce.redsocial.Repository.LikesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public class LikesService {
    @Autowired
    private LikesRepositorio likesRep;

    public Iterable<Likes> getAllLikes() {
        return likesRep.findAll();
    }

    public Optional<Likes> getLikeById(Integer id) {
        return likesRep.findById(id);
    }

    public Likes createLike(Likes likes) {
        return likesRep.save(likes);
    }

    public void deleteLike(Integer id) {
        likesRep.deleteById(id);
    }
}
