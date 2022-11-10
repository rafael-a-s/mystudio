package com.crp.coders.mystudio.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.crp.coders.mystudio.demo.model.Artista;

@Repository
public interface ArtistaRepository extends CrudRepository<Artista, Integer> {
    @Query("SELECT a FROM Artista a ORDER BY a.nome")
    List<Artista>findByAllAndOrderNome();
}
