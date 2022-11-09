package com.crp.coders.mystudio.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Genero extends DefaultEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "O nome deve ser preenchido.")
    @Column(length = 15)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
