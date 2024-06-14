package com.puce.redsocial.Entitys;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Comentarios {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer publicacionid;
    private Integer usuarioid;
    private String contenido;
    private Timestamp fechaComentario;

    public Comentarios() {}

    public Comentarios(Integer usuarioid, Integer id, Integer publicacionid, String contenido) {
        this.usuarioid = usuarioid;
        this.id = id;
        this.publicacionid = publicacionid;
        this.contenido = contenido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublicacion() {
        return publicacionid;
    }

    public void setPublicacion(Integer publicacionid) {
        this.publicacionid = publicacionid;
    }

    public Integer getUsuario() {
        return usuarioid;
    }

    public void setUsuario(Integer usuario) {
        this.usuarioid = usuario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Timestamp getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Timestamp fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
}
