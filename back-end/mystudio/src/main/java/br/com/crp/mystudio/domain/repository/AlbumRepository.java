package br.com.crp.mystudio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crp.mystudio.domain.model.artista.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    
}
