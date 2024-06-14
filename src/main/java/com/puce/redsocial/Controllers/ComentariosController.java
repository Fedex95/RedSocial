package com.puce.redsocial.Controllers;

import com.puce.redsocial.Entitys.Comentarios;
import com.puce.redsocial.Services.ComentariosService;
import com.puce.redsocial.Services.PublicacionService;
import com.puce.redsocial.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

@RestController
@RequestMapping("/api/comentarios")
public class ComentariosController {
    @Autowired
    private ComentariosService comentariosServ;
    @Autowired
    private PublicacionService publicacionServ;
    @Autowired
    private UsuarioService usuarioServ;

    @GetMapping
    public Iterable<Comentarios> getAllComentarios() {
        return comentariosServ.getAllComentarios();
    }

    @GetMapping("/{id}")
    public Optional<Comentarios> getComentarioById(@PathVariable Integer id) {
        return comentariosServ.getComentarioById(id);
    }

    @RequestMapping(value="/create", method = RequestMethod.POST, produces = "application/json")
    public Comentarios createComentario(@RequestBody Comentarios comentarios) throws AccessDeniedException {
        if(publicacionServ.getPublicacionById(comentarios.getPublicacion()).isEmpty()){
            throw new AccessDeniedException("Publicación no existe");
        }
        if(usuarioServ.getUserById(comentarios.getUsuario()).isEmpty()){
            throw new AccessDeniedException("Usuario no existe");
        }
        return comentariosServ.createComentario(comentarios);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComentario(@PathVariable Integer id, @RequestHeader Integer userid) throws AccessDeniedException {
        Comentarios cometarios = comentariosServ.getComentarioById(id).get();
        if (!cometarios.getUsuario().equals(userid)) {
            throw new AccessDeniedException("Acción denegada");
        }
        comentariosServ.deleteComentario(id);
    }
}
