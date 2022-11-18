package br.com.crp.mystudio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.crp.mystudio.domain.model.artista.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {  

    @Query("SELECT m FROM Musica m WHERE m.active = true ORDER BY m.nome")
    public List<Musica> findAllActive();

    @Query("SELECT m FROM Musica m WHERE UPPER(m.nome) LIKE CONCAT('%',UPPER(:nome),'%')")
    public List<Musica> findAllName(@Param("nome") String nome);

    @Query(nativeQuery = false, value = "SELECT DISTINCT m FROM Musica m, Artista a, musica_artistas ma WHERE m.id = ma.musica_id and a.id = ma.artistas_id and UPPER(a.nome) LIKE CONCAT('%',UPPER(:nome),'%')")
    public List<Musica> findAllMusicaByArtista(@Param("nome") String nome);




}
