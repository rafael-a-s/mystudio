package com.crp.coders.mystudio.demo.model;

public enum Tipo {
    Compositor(1,"Compositor"),
    Cantor(2,"Cantor"),
    Letrista(3,"Letristra");

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
