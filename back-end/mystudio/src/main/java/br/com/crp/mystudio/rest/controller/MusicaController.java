package br.com.crp.mystudio.rest.controller;

import br.com.crp.mystudio.domain.model.artista.Musica;
import br.com.crp.mystudio.domain.repository.MusicaRepository;
import br.com.crp.mystudio.rest.dto.musica.CreateMusicaDTO;
import br.com.crp.mystudio.rest.dto.musica.ResponseMuiscaDTO;
import br.com.crp.mystudio.rest.dto.musica.UpdateMusicaDTO;
import br.com.crp.mystudio.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/musica")
public class MusicaController {
    @Autowired //Faz injeção de dependencia
    private MusicaRepository repository;

    @Autowired
    private MusicaService service;

    @GetMapping//funcionando
    public List<ResponseMuiscaDTO> list(){
        List<Musica> list = repository.findAllActive();
        List<ResponseMuiscaDTO> listResponse = new ArrayList<ResponseMuiscaDTO>();
        for(Musica m : list){
            ResponseMuiscaDTO response = service.convertMusicaToDTO(m);
            listResponse.add(response);
        }
        return listResponse;
    }

    @GetMapping("/{id}")//funcionando
    public ResponseEntity<ResponseMuiscaDTO> findById(@PathVariable Long id){
        return repository.findById(id)
        .map(art -> ResponseEntity.ok().body(service.convertMusicaToDTO(art)))
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findByName-{nome}")//funcionando
    public List<ResponseMuiscaDTO> findByName(@PathVariable String nome){
        List<Musica> list = repository.findAllName(nome);
        List<ResponseMuiscaDTO> listResponse = new ArrayList<ResponseMuiscaDTO>();
        for(Musica m : list){
            ResponseMuiscaDTO response = service.convertMusicaToDTO(m);
            listResponse.add(response);
        }
        return listResponse;
    }

    @GetMapping("/findByArtista-{nome}")//funcionando
    public List<ResponseMuiscaDTO> findByArtista(@PathVariable String nome){
        System.out.println("entrou1=================================================================");

        System.out.println("entrou2");
        List<ResponseMuiscaDTO> listResponse = new ArrayList<ResponseMuiscaDTO>();

        return listResponse;
    }

    @PostMapping//funcionando
    @ResponseStatus(code = HttpStatus.CREATED)//funcionando
    public void saveEntity(@RequestBody CreateMusicaDTO musicaDTO){
        repository.save(service.preencheRelacionamentos(musicaDTO));
    }

    @DeleteMapping("/{id}")//funcionando
    public void inativar(@PathVariable Long id){
        Optional<Musica> a = repository.findById(id);
        if(a.get() != null){
            a.get().setActive(false);
            repository.save(a.get());
        }
        System.out.println("Registo não encontrado.");
    }  

    @PutMapping("/{id}")//Funcionando 
    public ResponseEntity<ResponseMuiscaDTO> editUser(@PathVariable("id") Long id, @RequestBody UpdateMusicaDTO musicaDTO){

            Optional<Musica> m = repository.findById(id);
            m.get().setNome(musicaDTO.nome());
            m.get().setTempoDuracao(musicaDTO.tempoDuracao());
            Musica mscUpdated = repository.save(m.get());
            if(mscUpdated != null)
                return ResponseEntity.ok().body(service.convertMusicaToDTO(mscUpdated));
            return ResponseEntity.notFound().build();
    }
}
