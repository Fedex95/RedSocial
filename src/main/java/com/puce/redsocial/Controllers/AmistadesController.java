package com.puce.redsocial.Controllers;

import com.puce.redsocial.Entitys.Amistades;
import com.puce.redsocial.Services.AmistadesService;
import com.puce.redsocial.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.nio.file.AccessDeniedException;
import java.util.Optional;

@RestController
@RequestMapping("/api/amistades")
public class AmistadesController {
    @Autowired
    private AmistadesService amistadesServ;
    @Autowired
    private UsuarioService usuarioServ;

    @GetMapping
    public Iterable<Amistades> getAllAmistades(){
        return amistadesServ.getAllAmistades();
    }

    @GetMapping("/{id}")
    public Optional<Amistades> getAmistadById(@PathVariable Integer id){
        return amistadesServ.getAmistadById(id);
    }

    @RequestMapping(value="/create/{amigoid}/{usuarioid}", method = RequestMethod.POST, produces = "application/json")
    public Amistades createAmistad(@PathVariable Integer amigoid,@PathVariable Integer usuarioid) throws AccessDeniedException {
        Amistades amistades = new Amistades(1, amigoid, usuarioid);
        if (usuarioServ.getUserById(amistades.getUsuario()).isEmpty()) {
            throw new AccessDeniedException("Usuario no existe");
        }
        return amistadesServ.createAmistad(amistades);
    }

    @DeleteMapping("/{id}")
    public void deleteAmistad(@PathVariable Integer id) {
        amistadesServ.deleteAmistad(id);
    }
}
