package br.com.crp.mystudio.domain.model.artista;

import br.com.crp.mystudio.domain.DefaultEntity;
import br.com.crp.mystudio.rest.dto.artista.CreateArtistaDTO;

import java.io.Serial;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Artista extends DefaultEntity {
    
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String nome;

    @NotBlank
    private String dataNascimento;

    @NotBlank
    private String email;

    @Enumerated(
        EnumType.ORDINAL
    )
    private Sexo sexo;

    @Enumerated(
        EnumType.ORDINAL
    )
    private TipoArtista tipoArtista;

    @OneToOne
    private Nacionalidade nacionalidade;


    public Artista(CreateArtistaDTO dto){
        this.nome = dto.nome();
        this.dataNascimento = dto.dataNascimento();
        this.email = dto.email();
        this.sexo = dto.sexo();
        this.tipoArtista = dto.tipoArtista();
    }
}

