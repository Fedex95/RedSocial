package com.puce.redsocial.Repository;

import com.puce.redsocial.Entitys.Publicacion;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicacionRepositorio extends JpaRepository<Publicacion, Long> {
    List<Publicacion> findAll();
    Optional<Publicacion> findById(Long id);
    Publicacion save(Publicacion publicacion);
    @RolesAllowed("ADMINISTRADOR")
    @Query("DELETE FROM Publicacion WHERE id = :id")
    void delete(Long id);
}
