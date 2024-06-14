package com.puce.redsocial.Services;

import com.puce.redsocial.Entitys.Amistades;
import com.puce.redsocial.Repository.AmistadesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service

public class AmistadesService {
        @Autowired
        private AmistadesRepositorio amistadesRep;

        public Iterable<Amistades> getAllAmistades() {
            return amistadesRep.findAll();
        }

        public Optional<Amistades> getAmistadById(Integer id) {
            return amistadesRep.findById(id);
        }

        public Amistades createAmistad(Amistades amistades) {
            amistades.setFecha((new Timestamp(System.currentTimeMillis())));
            return amistadesRep.save(amistades);
        }
        public void deleteAmistad(Integer id) {
            amistadesRep.deleteById(id);
        }
}
