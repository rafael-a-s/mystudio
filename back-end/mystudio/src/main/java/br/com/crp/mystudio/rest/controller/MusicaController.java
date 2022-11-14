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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.crp.mystudio.domain.model.artista.Musica;
import br.com.crp.mystudio.domain.repository.MusicaRepository;
import br.com.crp.mystudio.rest.dto.album.UpdateAlbumDTO;
import br.com.crp.mystudio.rest.dto.musica.CreateMusicaDTO;
import br.com.crp.mystudio.rest.dto.musica.ResponseMuiscaDTO;
import br.com.crp.mystudio.rest.dto.musica.UpdateMusicaDTO;

@RestController
@RequestMapping("api/musica")
public class MusicaController {
    @Autowired //Faz injeção de dependencia
    private MusicaRepository repository;

    @GetMapping
    public List<ResponseMuiscaDTO> list(){
        List<Musica> list = repository.findAllActive();
        List<ResponseMuiscaDTO> listResponse = new ArrayList<ResponseMuiscaDTO>();
        for(Musica m : list){
            ResponseMuiscaDTO response = new ResponseMuiscaDTO(m.getId(),m.getNome(), m.getAnoLancamento(), m.getTempoDuracao());
            listResponse.add(response);
        }
        return listResponse;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMuiscaDTO> findById(@PathVariable Long id){
        return repository.findById(id)
        .map(art -> ResponseEntity.ok().body(new ResponseMuiscaDTO(art.getId(),art.getNome(), art.getAnoLancamento(), art.getTempoDuracao())))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveEntity(@RequestBody CreateMusicaDTO userDTO){
        repository.save(new Musica(userDTO));
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

    @PutMapping("/{id}")
    public ResponseEntity<UpdateMusicaDTO> editUser(@PathVariable("id") Long id, @RequestBody UpdateMusicaDTO musicaDTO){

            Optional<Musica> m = repository.findById(id);
            m.get().setNome(musicaDTO.nome());
            m.get().setTempoDuracao(musicaDTO.tempoDuracao());
            Musica mscUpdated = repository.save(m.get());
            if(mscUpdated != null)
                return ResponseEntity.ok().body(musicaDTO = new UpdateMusicaDTO(mscUpdated.getNome(), mscUpdated.getTempoDuracao()));
            return ResponseEntity.notFound().build();
    }
}
