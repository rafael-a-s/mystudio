package com.crp.coders.mystudio.demo.model;

public enum Tipo {
    AUTOR(1,"Autor"),
    INTERPRETE(2,"Interprete"),
    CANTOR(3,"Cantor");

    private Integer id;
    private String label;

    Tipo (Integer id, String label){
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    
}
