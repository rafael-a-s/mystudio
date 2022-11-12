package br.com.crp.mystudio.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.crp.mystudio.domain.model.artista.Album;
import br.com.crp.mystudio.domain.repository.AlbumRepository;

@RestController
@RequestMapping("api/album")
public class AlbumController {
    
    @Autowired //Faz injeção de dependencia
    private AlbumRepository repository;

    @GetMapping
    public @ResponseBody List<Album> list(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> findById(@PathVariable("id") Long id){
        return repository.findById(id)
        .map(albumEncontrado -> ResponseEntity.ok().body(albumEncontrado))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)//retorna o status de criação
    public void cadastrar(@RequestBody Album album){
        repository.save(album);   
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
}
