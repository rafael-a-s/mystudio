package com.crp.coders.mystudio.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crp.coders.mystudio.demo.model.Nacionalidade;
@Repository
public interface NacionalidadeRepository extends CrudRepository<Nacionalidade, Integer>{
    
}
