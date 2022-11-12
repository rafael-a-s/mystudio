package br.com.crp.mystudio.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.crp.mystudio.domain.model.artista.Artista;

@Repository
public interface ArtistaRepository extends CrudRepository<Artista, Long>{
    
}
