package com.puce.redsocial.Entitys;

import jakarta.persistence.*;

@Entity
public class Likes {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer publicacionid;
    private Integer usuarioid;

    public Likes() {}

    public Likes(Integer id, Integer publicacionid, Integer usuarioid) {
        this.id = id;
        this.publicacionid = publicacionid;
        this.usuarioid = usuarioid;
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

    public void setPublicacion(Integer publicacion) {
        this.publicacionid = publicacionid;
    }

    public Integer getUsuario() {
        return usuarioid;
    }

    public void setUsuario(Integer usuario) {
        this.usuarioid = usuarioid;
    }
}
