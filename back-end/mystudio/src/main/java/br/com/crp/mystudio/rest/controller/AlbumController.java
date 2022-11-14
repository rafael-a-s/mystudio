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

import br.com.crp.mystudio.domain.model.artista.Album;
import br.com.crp.mystudio.domain.repository.AlbumRepository;
import br.com.crp.mystudio.rest.dto.album.CreateAlbumDTO;
import br.com.crp.mystudio.rest.dto.album.ResponseAlbumDTO;
import br.com.crp.mystudio.rest.dto.album.UpdateAlbumDTO;

@RestController
@RequestMapping("api/album")
public class AlbumController {
    
    @Autowired //Faz injeção de dependencia
    private AlbumRepository repository;

    
    @GetMapping
    public List<ResponseAlbumDTO> list(){
        List<Album> list = repository.findAllActive();
        List<ResponseAlbumDTO> listResponse = new ArrayList<ResponseAlbumDTO>();
        for(Album a : list){
            ResponseAlbumDTO response = new ResponseAlbumDTO(a.getId(), a.getNome(), a.getAnoLancamento(), a.getTempoTotalDur());
            listResponse.add(response);
        }
        return listResponse;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseAlbumDTO> findById(@PathVariable Long id){
        return repository.findById(id)
        .map(alb -> ResponseEntity.ok().body(new ResponseAlbumDTO(alb.getId(),alb.getNome(), alb.getAnoLancamento(), alb.getTempoTotalDur())))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveEntity(@RequestBody CreateAlbumDTO userDTO){
        repository.save(new Album(userDTO));
    }

    @DeleteMapping("/{id}")
    public void inativar(@PathVariable Long id){
        Optional<Album> a = repository.findById(id);
        if(a.get() != null){
            a.get().setActive(false);
            repository.save(a.get());
        }
        System.out.println("Registo não encontrado.");
    }    


    @PutMapping("/{id}")
    public ResponseEntity<UpdateAlbumDTO> editUser(@PathVariable("id") Long id, @RequestBody UpdateAlbumDTO albumDTO){

            Optional<Album> a = repository.findById(id);
            a.get().setNome(albumDTO.nome());
            a.get().setTempoTotalDur(albumDTO.tempoTotalDur());
            Album albUpdated = repository.save(a.get());
            if(albUpdated != null)
                return ResponseEntity.ok().body(albumDTO = new UpdateAlbumDTO(albUpdated.getNome(), albUpdated.getTempoTotalDur()));
            return ResponseEntity.notFound().build();
    }
}
