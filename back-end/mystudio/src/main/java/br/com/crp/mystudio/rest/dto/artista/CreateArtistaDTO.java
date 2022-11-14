package br.com.crp.mystudio.rest.dto.artista;

import br.com.crp.mystudio.domain.model.artista.Sexo;
import br.com.crp.mystudio.domain.model.artista.TipoArtista;

public record CreateArtistaDTO(String nome, String dataNascimento, String email,
                               Sexo sexo, TipoArtista tipoArtista) {
    
}
