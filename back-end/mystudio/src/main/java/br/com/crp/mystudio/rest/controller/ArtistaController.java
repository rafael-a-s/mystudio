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

import br.com.crp.mystudio.domain.model.artista.Artista;
import br.com.crp.mystudio.domain.repository.ArtistaRepository;

@RestController
@RequestMapping("api/artista")
public class ArtistaController {
    
    @Autowired
    private ArtistaRepository repository;

    @GetMapping
    public @ResponseBody List<Artista> list(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> findById(@PathVariable Long id){
        return repository.findById(id)
        .map(artistaEncontrado -> ResponseEntity.ok().body(artistaEncontrado))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveEntity(@RequestBody Artista artista){
        repository.save(artista);

    }   
    
    @DeleteMapping("/{id}")
    public void inativar(@PathVariable Long id){
        Optional<Artista> a = repository.findById(id);
        if(a.get() != null){
            a.get().setActive(false);
            repository.save(a.get());
        }
    }


}
