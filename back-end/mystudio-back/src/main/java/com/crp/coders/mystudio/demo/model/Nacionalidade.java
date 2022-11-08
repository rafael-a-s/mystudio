package com.crp.coders.mystudio.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Nacionalidade extends DefaultEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Column(length = 20)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
