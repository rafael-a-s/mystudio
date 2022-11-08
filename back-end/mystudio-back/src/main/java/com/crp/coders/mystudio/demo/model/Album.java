package com.crp.coders.mystudio.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;



@Entity
public class Album extends DefaultEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(length = 30)
    private String nome;

    @Column
    private String capaUrl;

    @OneToMany(targetEntity = com.crp.coders.mystudio.demo.model.Musica.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Musica> musicas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapaUrl() {
        return capaUrl;
    }

    public void setCapaUrl(String capaUrl) {
        this.capaUrl = capaUrl;
    }

    public List<Musica> getMusicas() {
        if(this.musicas == null)
            this.musicas = new ArrayList<Musica>();
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    

    
}
