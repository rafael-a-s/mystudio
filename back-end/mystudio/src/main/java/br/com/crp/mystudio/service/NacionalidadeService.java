package br.com.crp.mystudio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crp.mystudio.domain.model.artista.Nacionalidade;
import br.com.crp.mystudio.domain.repository.NacionalidadeRepository;

@Service
public class NacionalidadeService {
    
   
    private NacionalidadeRepository repo;

    NacionalidadeService(NacionalidadeRepository repo){

    }
    public NacionalidadeService(){

    }
    public Nacionalidade getNacionalidadeForId(long id){
        Optional<Nacionalidade> opt = this.repo.findById(id);
       
            return opt.get();
       
    }

}
