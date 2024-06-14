package com.puce.redsocial.Entitys;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Publicacion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer usuarioId;
    private String contenido;
    private Timestamp fechaPublicacion;

    public Publicacion() {}

    public Publicacion(Integer id, Integer usuarioId, String contenido) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.contenido = contenido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuario() {
        return usuarioId;
    }

    public void setUsuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Timestamp getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Timestamp fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
