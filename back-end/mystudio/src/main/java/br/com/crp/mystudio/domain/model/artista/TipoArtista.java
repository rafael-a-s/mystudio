package br.com.crp.mystudio.domain.model.artista;

public enum TipoArtista {

    CANTOR(1,"Cantor"),
    COMPOSITOR(2,"Compositor"),
    LETRISTA(3, "Letrista");

    private Integer id;
    private String label;

    TipoArtista(Integer id, String label){
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
