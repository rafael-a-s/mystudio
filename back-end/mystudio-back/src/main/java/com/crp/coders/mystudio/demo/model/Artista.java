package com.crp.coders.mystudio.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class Artista extends DefaultEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @NotBlank(message = "O nome deve ser preenchido.")
    @Column(length = 50)
    private String nome;
    private String dataNascimento;
    private String email;
    
    @Enumerated(EnumType.ORDINAL)
    private Sexo sexo;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private List<String> tipos;

    @ManyToOne(optional = true)
    @JoinColumn
    private Nacionalidade nacionalidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

}
