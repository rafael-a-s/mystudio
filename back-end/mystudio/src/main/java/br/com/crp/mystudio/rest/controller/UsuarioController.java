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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.crp.mystudio.domain.model.usuario.Usuario;
import br.com.crp.mystudio.domain.repository.UsuarioRepository;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController{

    @Autowired
    private UsuarioRepository repository;


    @GetMapping
    public List<Usuario> list(){
        return repository.findAllActive();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return repository.findById(id)
        .map(usuarioEncontrado -> ResponseEntity.ok().body(usuarioEncontrado))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveEntity(@RequestBody Usuario usuario){
        repository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void inativar(@PathVariable Long id){
        Optional<Usuario> u = repository.findById(id);
        if(u.get() != null){
            u.get().setActive(false);
            repository.save(u.get());
        }
        System.out.println("Registo não encontrado.");
    }    

}
