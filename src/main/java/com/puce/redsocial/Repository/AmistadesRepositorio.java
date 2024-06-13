package com.puce.redsocial.Repository;

import com.puce.redsocial.Entitys.Amistades;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AmistadesRepositorio extends JpaRepository<Amistades, Long> {
    List<Amistades> findAll();
    Optional<Amistades> findById(Long id);
    Amistades save(Amistades amistades);
    @RolesAllowed("ADMINISTRADOR")
    @Query("DELETE FROM Amistades WHERE id = :id")
    void delete(Long id);
}