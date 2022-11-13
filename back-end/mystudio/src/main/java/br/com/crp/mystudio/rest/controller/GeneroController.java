package br.com.crp.mystudio.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crp.mystudio.domain.model.artista.Genero;
import br.com.crp.mystudio.domain.repository.GeneroRepository;

@RestController
@RequestMapping("api/genero")
public class GeneroController {

    @Autowired
    private GeneroRepository repository;

    @GetMapping
    public List<Genero> list(){
        return repository.findAll();
    }

    
}
