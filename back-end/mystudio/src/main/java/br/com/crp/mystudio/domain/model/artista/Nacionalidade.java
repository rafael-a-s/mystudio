package br.com.crp.mystudio.domain.model.artista;

import br.com.crp.mystudio.domain.DefaultEntity;

import java.io.Serial;


import jakarta.persistence.Entity;
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
public class Nacionalidade extends DefaultEntity{
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    @NotBlank
    private String designacao;

    @NotBlank
    private String siglaPais;

}