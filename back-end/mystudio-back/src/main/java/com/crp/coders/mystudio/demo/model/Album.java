package com.crp.coders.mystudio.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Album extends DefaultEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "O nome deve ser preenchido.")
    @Column(length = 30)
    private String nome;

    @Column
    private String anoLancamento;
    
    @Column
    private String tempoTotalDur;

    @OneToMany(targetEntity = com.crp.coders.mystudio.demo.model.Musica.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Musica> musicas;

    private List<Artista> artistas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getTempoTotalDur() {
        return tempoTotalDur;
    }

    public void setTempoTotalDur(String tempoTotalDur) {
        this.tempoTotalDur = tempoTotalDur;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    
}
