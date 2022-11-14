package br.com.crp.mystudio.domain.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crp.mystudio.domain.model.artista.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long>{
    @Query("SELECT a FROM Artista a WHERE a.active = true ORDER  BY a.nome")
    public List<Artista> findAllActive();

    @Query("SELECT a FROM Artista a WHERE a.nome LIKE %:nome%")
    public List<Artista> findAllName(String nome);

   
}

