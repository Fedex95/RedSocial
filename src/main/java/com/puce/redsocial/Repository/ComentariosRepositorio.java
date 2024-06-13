package com.puce.redsocial.Repository;

import com.puce.redsocial.Entitys.Comentarios;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComentariosRepositorio extends JpaRepository<Comentarios, Long> {
    List<Comentarios> findAll();
    Optional<Comentarios> findById(Long id);
    Comentarios save(Comentarios comentarios);
    @RolesAllowed("ADMINISTRADOR")
    @Query("DELETE FROM Comentarios WHERE id = :id")
    void delete(Long id);
}
