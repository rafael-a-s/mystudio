package br.com.crp.mystudio.domain.model.artista;

import br.com.crp.mystudio.domain.DefaultEntity;
import br.com.crp.mystudio.domain.repository.NacionalidadeRepository;

import java.io.Serial;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;



@Data
@AllArgsConstructor
@Entity
public class Nacionalidade  {
    
    @Id
    private Long id;
    
  
    private String designacao;

    
    private String siglaPais;

    public Nacionalidade(){
        
    }

    

}
