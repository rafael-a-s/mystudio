package br.com.crp.mystudio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crp.mystudio.domain.model.artista.Artista;
import br.com.crp.mystudio.domain.model.artista.Genero;
import br.com.crp.mystudio.domain.model.artista.Musica;
import br.com.crp.mystudio.domain.repository.ArtistaRepository;
import br.com.crp.mystudio.domain.repository.GeneroRepository;
import br.com.crp.mystudio.domain.repository.MusicaRepository;
import br.com.crp.mystudio.rest.dto.artista.CreateArtistaDTO;
import br.com.crp.mystudio.rest.dto.artista.ResponseArtistaDTO;
import br.com.crp.mystudio.rest.dto.musica.CreateMusicaDTO;
import br.com.crp.mystudio.rest.dto.musica.ResponseMuiscaDTO;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository repository;

    @Autowired
    private ArtistaRepository repositoryArtisa;

    @Autowired
    private GeneroRepository repositoryGenero;

    public Musica preencheRelacionamentos(CreateMusicaDTO musicaDTO){
        Musica musica = new Musica(musicaDTO);
        findArtistas(musicaDTO.artistas(), musica);
        findGenero(musicaDTO.genero(), musica);
        return musica;
    }


    void findArtistas(List<ResponseArtistaDTO> response, Musica musica){
        for(ResponseArtistaDTO dto : response){
           Optional<Artista> artista = repositoryArtisa.findById(dto.id());
           if(musica.getArtistas() == null)
                musica.setArtistas(new ArrayList<Artista>());
           if(artista.get() != null)
                musica.getArtistas().add(artista.get());
        }
        
    }

    void findGenero(Genero genero, Musica musica){
        Optional<Genero> generoOptional = repositoryGenero.findById(genero.getId());
        musica.setGenero(generoOptional.get());
    }


    public ResponseMuiscaDTO convertMusicaToDTO(Musica musica){
        ResponseMuiscaDTO response = new ResponseMuiscaDTO(musica.getId(), musica.getNome(), musica.getAnoLancamento(), musica.getTempoDuracao(), new ArrayList<ResponseArtistaDTO>(), musica.getGenero());
        toMusicaDTO(musica.getArtistas(), response);
        return response;
    }

    void toMusicaDTO(List<Artista> list, ResponseMuiscaDTO dto){
        for(Artista a : list){
            dto.artistas().add(new ResponseArtistaDTO(a.getId(), a.getNome(), a.getEmail() , a.getSexo(), a.getTipoArtista(), a.getNacionalidade()));
        }
    }
}
