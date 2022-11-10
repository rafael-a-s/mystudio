package com.crp.coders.mystudio.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario extends DefaultEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "O nome deve ser preenchido.")
    @Column(length = 50)
    private String nome;

    @NotBlank(message = "O email deve ser preenchido.")
    @Column(length = 50)
    private String email;

    @NotBlank(message = "A senha deve ser preenchido.")
    @Column(length = 8)
    private String senha;

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
