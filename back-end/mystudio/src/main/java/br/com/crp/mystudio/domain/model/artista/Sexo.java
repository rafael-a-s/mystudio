package br.com.crp.mystudio.domain.model.artista;

public enum Sexo {
    
    FEMININO(1, "Feminino"),
    MASCULINO(2, "Masculino"),
    OUTRO(3, "Outros");

    private Integer id;
    private String label;

    Sexo(Integer id, String label){
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
