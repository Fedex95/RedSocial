package com.puce.redsocial.Controllers;

import com.puce.redsocial.Entitys.Comentarios;
import com.puce.redsocial.Services.ComentariosService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comentarios")
public class ComentariosController {
    @Autowired
    private ComentariosService comentariosServ;

    @GetMapping
    public List<Comentarios> getAllComentarios() {
        return comentariosServ.getAllComentarios();
    }

    @GetMapping("/{id}")
    public Optional<Comentarios> getComentarioById(@PathVariable Long id) {
        return comentariosServ.getComentarioById(id);
    }

    @PostMapping
    public Comentarios createComentario(@RequestBody Comentarios comentarios) {
        return comentariosServ.createComentario(comentarios);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ADMINISTRADOR")
    public void deleteComentario(@PathVariable Long id) {
        comentariosServ.deleteComentario(id);
    }
}
