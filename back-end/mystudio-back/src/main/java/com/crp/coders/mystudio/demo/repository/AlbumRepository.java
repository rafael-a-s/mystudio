package com.crp.coders.mystudio.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crp.coders.mystudio.demo.model.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer>{

    @Query("SELECT a FROM Album a ORDER BY a.nome")
    List<Album> findByAllAndOrderNome();
    
    @Query("SELECT a From Album a ORDER BY a.tempoDuracao")
    List<Album> findByAllAndOrdertempoDuracao();

    @Query("SELECT a From Album a ORDER BY a.ano")
    List<Album> findByAllAndOrderano();
}
