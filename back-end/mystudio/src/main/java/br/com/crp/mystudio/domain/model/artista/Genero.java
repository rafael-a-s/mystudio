package br.com.crp.mystudio.domain.model.artista;

import java.io.Serial;

import br.com.crp.mystudio.domain.DefaultEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
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
public class Genero extends DefaultEntity{
    @Serial
    private static final long serialVersionUID = 1L;
    
    @NotBlank
    private String genero;
}
