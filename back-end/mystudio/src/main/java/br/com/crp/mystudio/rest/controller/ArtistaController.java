package br.com.crp.mystudio.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.crp.mystudio.domain.model.artista.Artista;
import br.com.crp.mystudio.domain.repository.ArtistaRepository;
import br.com.crp.mystudio.rest.dto.artista.CreateArtistaDTO;
import br.com.crp.mystudio.rest.dto.artista.ResponseArtistaDTO;
import br.com.crp.mystudio.rest.dto.artista.UpdateArtistaDTO;

@RestController
@RequestMapping("api/artista")
public class ArtistaController {
    
    @Autowired
    private ArtistaRepository repository;

    @GetMapping
    public List<ResponseArtistaDTO> list(){
        List<Artista> list = repository.findAllActive();
        List<ResponseArtistaDTO> listResponse = new ArrayList<ResponseArtistaDTO>();
        for(Artista art : list){
            ResponseArtistaDTO response = new ResponseArtistaDTO(art.getId(),art.getNome(), art.getEmail(),
            art.getSexo(), art.getTipoArtista());
            listResponse.add(response);
        }
        return listResponse;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseArtistaDTO> findById(@PathVariable Long id){
        return repository.findById(id)
        .map(art -> ResponseEntity.ok().body(new ResponseArtistaDTO(art.getId(),art.getNome(), art.getEmail(), art.getSexo(), art.getTipoArtista())))
        .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/buscar/{nome}")
    public List<ResponseArtistaDTO> findByNome(@PathVariable String nome){
        List<Artista> list = repository.findAllName(nome);
        List<ResponseArtistaDTO> listResponse = new ArrayList<ResponseArtistaDTO>();
        for(Artista art : list){
            ResponseArtistaDTO response = new ResponseArtistaDTO(art.getId(),art.getNome(), art.getEmail(),
            art.getSexo(), art.getTipoArtista());
            listResponse.add(response);
        }
        return listResponse;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveEntity(@RequestBody CreateArtistaDTO artDTO){
        repository.save(new Artista(artDTO));
    } 
    
    @DeleteMapping("/{id}")
    public void inativar(@PathVariable Long id){
        Optional<Artista> a = repository.findById(id);
        if(a.get() != null){
            a.get().setActive(false);
            repository.save(a.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateArtistaDTO> editUser(@PathVariable("id") Long id, @RequestBody UpdateArtistaDTO artistaDTO){

            Optional<Artista> u = repository.findById(id);
            
            u.get().setEmail(artistaDTO.email());
            Artista artUpdated = repository.save(u.get());
            if(artUpdated != null)
                return ResponseEntity.ok().body(artistaDTO = new UpdateArtistaDTO( artUpdated.getEmail()));
            return ResponseEntity.notFound().build();
    }
}
