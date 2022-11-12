package br.com.crp.mystudio.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.crp.mystudio.domain.model.artista.Musica;

@Repository
public interface MusicaRepository extends CrudRepository<Musica, Long> {  
}
