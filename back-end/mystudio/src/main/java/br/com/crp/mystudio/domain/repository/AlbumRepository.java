package br.com.crp.mystudio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crp.mystudio.domain.model.artista.Album;
import br.com.crp.mystudio.domain.model.artista.Artista;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    
    @Query("SELECT a FROM Album a WHERE a.active = true")
    public List<Album> findAllActive();

    @Query("SELECT a FROM Album a WHERE a.nome LIKE %:nome%")
    public List<Album> buscarAllName(String nome);

  
}
