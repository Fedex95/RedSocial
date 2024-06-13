package com.puce.redsocial.Services;

import com.puce.redsocial.Entitys.Amistades;
import com.puce.redsocial.Entitys.Likes;
import com.puce.redsocial.Repository.AmistadesRepositorio;
import com.puce.redsocial.Repository.LikesRepositorio;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class LikesService {
    @Autowired
    private LikesRepositorio likesRep;

    public List<Likes> getAllLikes() {
        return likesRep.findAll();
    }

    public Optional<Likes> getLikeById(Long id) {
        return likesRep.findById(id);
    }

    public Likes createLike(Likes likes) {
        return likesRep.save(likes);
    }

    @RolesAllowed("ADMINISTRADOR")
    public void deleteLike(Long id) {
        likesRep.delete(id);
    }
}
