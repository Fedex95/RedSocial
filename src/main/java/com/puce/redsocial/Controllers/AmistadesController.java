package com.puce.redsocial.Controllers;

import com.puce.redsocial.Entitys.Amistades;
import com.puce.redsocial.Services.AmistadesService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/amistades")
public class AmistadesController {
    @Autowired
    private AmistadesService amistadesServ;

    @GetMapping
    public List<Amistades> getAllAmistades() {
        return amistadesServ.getAllAmistades();
    }

    @GetMapping("/{id}")
    public Optional<Amistades> getAmistadById(@PathVariable Long id) {
        return amistadesServ.getAmistadById(id);
    }

    @PostMapping
    public Amistades createAmistad(@RequestBody Amistades amistades) {
        return amistadesServ.createAmistad(amistades);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ADMINISTRADOR")
    public void deleteAmistad(@PathVariable Long id) {
        amistadesServ.deleteAmistad(id);
    }
}
