package com.crp.coders.mystudio.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.crp.coders.mystudio.demo.model.Musica;

@Repository
public interface MusicaRepository extends CrudRepository<Musica, Integer>{
    
    @Query("SELECT m FROM Musica m ORDER BY m.nome")
    List<Musica> findByAllAndOrderNome();
    
}
