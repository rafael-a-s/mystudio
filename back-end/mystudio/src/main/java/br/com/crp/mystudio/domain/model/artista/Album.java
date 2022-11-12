package br.com.crp.mystudio.domain.model.artista;

import br.com.crp.mystudio.domain.DefaultEntity;

import java.io.Serial;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class Album extends DefaultEntity{
    @Serial
    private static final long serialVersionUID = 1L;
    
    @NotBlank
    private String nome;

    @NotBlank
    private String anoLancamento;

    @NotBlank
    private String tempoTotalDur;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Artista> artista;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Musica> musicas;
}
