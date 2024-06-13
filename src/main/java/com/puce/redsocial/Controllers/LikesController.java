package com.puce.redsocial.Controllers;

import com.puce.redsocial.Entitys.Likes;
import com.puce.redsocial.Services.LikesService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/likes")
public class LikesController {
    @Autowired
    private LikesService likesServ;

    @GetMapping
    public List<Likes> getAllLikes() {
        return likesServ.getAllLikes();
    }

    @GetMapping("/{id}")
    public Optional<Likes> getLikeById(@PathVariable Long id) {
        return likesServ.getLikeById(id);
    }

    @PostMapping
    public Likes createLike(@RequestBody Likes likes) {
        return likesServ.createLike(likes);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ADMINISTRADOR")
    public void deleteLike(@PathVariable Long id) {
        likesServ.deleteLike(id);
    }
}

