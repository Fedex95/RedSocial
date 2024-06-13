package com.puce.redsocial.Entitys;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Comentarios {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Publicacion publicacion;
    @ManyToOne
    private Usuario usuario;
    private String contenido;
    private Timestamp fechaComentario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
