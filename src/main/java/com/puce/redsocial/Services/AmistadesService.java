package com.puce.redsocial.Services;

import com.puce.redsocial.Entitys.Amistades;
import com.puce.redsocial.Repository.AmistadesRepositorio;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class AmistadesService {
        @Autowired
        private AmistadesRepositorio amistadesRep;

        public List<Amistades> getAllAmistades() {
            return amistadesRep.findAll();
        }

        public Optional<Amistades> getAmistadById(Long id) {
            return amistadesRep.findById(id);
        }

        public Amistades createAmistad(Amistades amistades) {
            return amistadesRep.save(amistades);
        }
        @RolesAllowed("ADMINISTRADOR")
        public void deleteAmistad(Long id) {
            amistadesRep.delete(id);
        }
}
