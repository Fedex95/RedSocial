package com.puce.redsocial.Repository;

import com.puce.redsocial.Entitys.Usuario;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Long> {
    List<Usuario>findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    @RolesAllowed("ADMINISTRADOR")
    @Query("DELETE FROM Usuario WHERE id = :id")
    void delete(Long id);
}
