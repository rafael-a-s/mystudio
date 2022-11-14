package br.com.crp.mystudio.domain.model.artista;

import java.io.Serial;

import br.com.crp.mystudio.domain.DefaultEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;



@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Genero{
    
    @Id
    private Long id;
    
    @NotBlank
    private String genero;
}
