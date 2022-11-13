package br.com.crp.mystudio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crp.mystudio.domain.model.artista.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long>{
    
}
