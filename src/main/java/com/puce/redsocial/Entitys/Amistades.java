package com.puce.redsocial.Entitys;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Amistades {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer usuarioid;
    private Integer amigoid;
    private Timestamp fecha;

    public Amistades() {}

    public Amistades(Integer id, Integer usuarioid, Integer amigoid) {
        this.id = id;
        this.usuarioid = usuarioid;
        this.amigoid = amigoid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuario() {
        return usuarioid;
    }

    public void setUsuario(Integer usuario) {
        this.usuarioid = usuarioid;
    }

    public Integer getAmigo() {
        return amigoid;
    }

    public void setAmigo(Integer amigoid) {
        this.amigoid = amigoid;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
