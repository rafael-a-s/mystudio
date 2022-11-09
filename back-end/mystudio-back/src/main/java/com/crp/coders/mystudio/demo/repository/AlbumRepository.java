package com.crp.coders.mystudio.demo.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crp.coders.mystudio.demo.model.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer>{
    
}
