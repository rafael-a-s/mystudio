package br.com.crp.mystudio.rest.dto.musica;

import java.util.List;

import br.com.crp.mystudio.domain.model.artista.Genero;
import br.com.crp.mystudio.rest.dto.artista.ResponseArtistaDTO;

public record ResponseMuiscaDTO(Long id, String nome, String anoLacamento, String tempoDuracao, List<ResponseArtistaDTO> artistas, Genero genero  ) {
    
}
