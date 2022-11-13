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

import br.com.crp.mystudio.domain.model.artista.Musica;
import br.com.crp.mystudio.domain.repository.MusicaRepository;

@RestController
@RequestMapping("api/musica")
public class MusicaController {
    @Autowired //Faz injeção de dependencia
    private MusicaRepository repository;

    @GetMapping
    public @ResponseBody List<Musica> list(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> findById(@PathVariable("id") Long id){
        return repository.findById(id)
        .map(musicaEncontrado -> ResponseEntity.ok().body(musicaEncontrado))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)//retorna o status de criação
    public void cadastrar(@RequestBody Musica musica){
        repository.save(musica);   
    }

    @DeleteMapping("/{id}")
    public void inativar(@PathVariable Long id){
        Optional<Musica> a = repository.findById(id);
        if(a.get() != null){
            a.get().setActive(false);
            repository.save(a.get());
        }
        System.out.println("Registo não encontrado.");
    }  
}
