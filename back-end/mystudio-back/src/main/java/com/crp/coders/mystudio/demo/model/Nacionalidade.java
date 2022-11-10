package com.crp.coders.mystudio.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;


@Entity
public class Nacionalidade extends DefaultEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @NotBlank(message = "O nome deve ser preenchido.")
    @Column(length = 20)
    private String designacao;
    private String siglaPais;

    public String getDesignacao() {
        return designacao;
    }
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
    public String getSiglaPais() {
        return siglaPais;
    }
    public void setSiglaPais(String siglaPais) {
        this.siglaPais = siglaPais;
    }
    
}
