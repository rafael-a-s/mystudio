package com.crp.coders.mystudio.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Musica extends DefaultEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "O nome deve ser preenchido.")
    @Column(length = 50)
    private String nome;
    private String anoLancamento;

    @NotBlank(message = "A duração deve ser preenchido.")
    @Column(length = 10)
    private Double tempoDuracao;
    private Album album;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="artista_has_musicas", joinColumns= {@JoinColumn(name="musica_id")},
                                   inverseJoinColumns = {@JoinColumn(name="artista_id")})
    private List<Artista> artistas;

    @NotNull
    @ManyToOne(optional = true)
    @JoinColumn
    private Genero genero;

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

    public Double getTempoDuracao() {
        return tempoDuracao;
    }

    public void setTempoDuracao(Double tempoDuracao) {
        this.tempoDuracao = tempoDuracao;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

}
