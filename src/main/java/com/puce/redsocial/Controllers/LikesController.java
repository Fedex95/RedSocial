package com.puce.redsocial.Controllers;

import com.puce.redsocial.Entitys.Amistades;
import com.puce.redsocial.Entitys.Likes;
import com.puce.redsocial.Services.LikesService;
import com.puce.redsocial.Services.PublicacionService;
import com.puce.redsocial.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.nio.file.AccessDeniedException;
import java.util.Optional;

@RestController
@RequestMapping("/api/likes")
public class LikesController {
    @Autowired
    private LikesService likesServ;
    @Autowired
    private PublicacionService publicacionServ;
    @Autowired
    private UsuarioService usuarioServ;

    @GetMapping
    public Iterable<Likes> getAllLikes() {
        return likesServ.getAllLikes();
    }

    @GetMapping("/{id}")
    public Optional<Likes> getLikeById(@PathVariable Integer id) {
        return likesServ.getLikeById(id);
    }

    @RequestMapping(value="/create/{publicacionid}/{usuarioid}", method= RequestMethod.POST, produces = "application/json")
    public Likes createLike(@PathVariable Integer publicacionid, @PathVariable Integer usuarioid) throws AccessDeniedException {
        Likes likes = new Likes(1, publicacionid, usuarioid);
        if(publicacionServ.getPublicacionById(likes.getPublicacion()).isEmpty()){
            throw new AccessDeniedException("Publicacion no existe");
        }
        else if(usuarioServ.getUserById(likes.getUsuario()).isEmpty()){
            throw new AccessDeniedException("Usuario no existe");
        }
        return likesServ.createLike(likes);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLike(@PathVariable Integer id, @RequestHeader Integer userid) throws AccessDeniedException {
        Likes likes = likesServ.getLikeById(id).get();
        if(!likes.getPublicacion().equals(userid)){
            throw new AccessDeniedException("Accion denegada");
        }
        else if(publicacionServ.getPublicacionById(likes.getPublicacion()).isEmpty()){
            throw new AccessDeniedException("Accion denegada");
        }
        likesServ.deleteLike(id);
    }
}

