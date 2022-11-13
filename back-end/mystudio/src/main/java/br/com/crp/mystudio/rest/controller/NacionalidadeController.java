package br.com.crp.mystudio.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crp.mystudio.domain.model.artista.Nacionalidade;
import br.com.crp.mystudio.domain.repository.NacionalidadeRepository;

@RestController
@RequestMapping("api/nacionalidade")
public class NacionalidadeController {

    @Autowired
    private NacionalidadeRepository repository;

    @GetMapping
    public List<Nacionalidade> list(){
        return repository.findAll();
    }
    
}
