package br.com.crp.mystudio.rest.dto.artista;

import br.com.crp.mystudio.domain.model.artista.Nacionalidade;
import br.com.crp.mystudio.domain.model.artista.Sexo;
import br.com.crp.mystudio.domain.model.artista.TipoArtista;

public record ResponseArtistaDTO(Long id, String nome, String email, Sexo sexo, TipoArtista tipoArtista, Nacionalidade nacionalidade) {
    
}
