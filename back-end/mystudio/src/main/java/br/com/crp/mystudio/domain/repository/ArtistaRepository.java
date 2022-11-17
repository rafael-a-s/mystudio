package br.com.crp.mystudio.domain.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.crp.mystudio.domain.model.artista.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long>{
    @Query("SELECT a FROM Artista a WHERE a.active = true ORDER  BY a.nome")
    public List<Artista> findAllActive();

    @Query("SELECT a FROM Artista a WHERE UPPER(a.nome) LIKE CONCAT('%',UPPER(:nome),'%')")
    public List<Artista> findAllName(@Param("nome") String nome);

    List<Artista> findByNomeIgnoreCase(String nome);
   
    @Query("SELECT a FROM Artista a, Nacionalidade n WHERE  UPPER(a.nacionalidade.designacao) LIKE CONCAT('%',UPPER(:nacionalidade),'%')")
    List<Artista> findByArtistaForNacionalidade(@Param("nacionalidade") String nacionalidade);
}

