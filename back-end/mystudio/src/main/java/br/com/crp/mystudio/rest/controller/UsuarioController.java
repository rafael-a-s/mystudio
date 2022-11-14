package br.com.crp.mystudio.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.crp.mystudio.domain.model.usuario.Usuario;
import br.com.crp.mystudio.domain.repository.UsuarioRepository;
import br.com.crp.mystudio.rest.dto.CreateUsuarioDTO;
import br.com.crp.mystudio.rest.dto.ResponseUsuarioDTO;
import br.com.crp.mystudio.rest.dto.UpdateUsuarioDTO;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController{

    @Autowired
    private UsuarioRepository repository;


    @GetMapping
    public List<ResponseUsuarioDTO> list(){
        List<Usuario> list = repository.findAllActive();
        List<ResponseUsuarioDTO> listResponse = new ArrayList<ResponseUsuarioDTO>();
        for(Usuario u : list){
            ResponseUsuarioDTO response = new ResponseUsuarioDTO(u.getNome(), u.getEmail());
            listResponse.add(response);
        }
        return listResponse;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUsuarioDTO> findById(@PathVariable Long id){
        return repository.findById(id)
        .map(user -> ResponseEntity.ok().body(new ResponseUsuarioDTO(user.getNome(), user.getEmail())))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveEntity(@RequestBody CreateUsuarioDTO userDTO){
        repository.save(new Usuario(userDTO));
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

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUsuarioDTO> editUser(@PathVariable("id") Long id, @RequestBody UpdateUsuarioDTO usuarioDTO){

            Optional<Usuario> u = repository.findById(id);
            u.get().setNome(usuarioDTO.nome());
            u.get().setEmail(usuarioDTO.email());
            Usuario userUpdated = repository.save(u.get());
            if(userUpdated != null)
                return ResponseEntity.ok().body(usuarioDTO = new UpdateUsuarioDTO(userUpdated.getNome(), userUpdated.getEmail()));
            return ResponseEntity.notFound().build();
    }

}
