package com.puce.redsocial.Repository;

import com.puce.redsocial.Entitys.Likes;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikesRepositorio extends JpaRepository<Likes, Long> {
    List<Likes> findAll();
    Optional<Likes> findById(Long id);
    Likes save(Likes likes);
    @RolesAllowed("ADMINISTRADOR")
    @Query("DELETE FROM Likes WHERE id = :id")
    void delete(Long id);
}
