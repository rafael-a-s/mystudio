package br.com.crp.mystudio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crp.mystudio.domain.model.artista.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {  

    @Query("SELECT m FROM Musica m WHERE m.active = true")
    public List<Musica> findAllActive();

    @Query("SELECT m FROM Musica m WHERE m.nome LIKE %:nome%")
    public List<Musica> findAllName(String nome);

}
