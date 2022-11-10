package com.crp.coders.mystudio.demo.maintest;

import java.util.Comparator;
import java.util.List;

import org.hibernate.validator.internal.engine.validationcontext.ParameterExecutableValidationContext;
import org.springframework.data.domain.Sort;

import com.crp.coders.mystudio.demo.model.Artista;
import com.crp.coders.mystudio.demo.repository.ArtistaRepository;



public class Test {
    private ArtistaRepository a;

    public Test(ArtistaRepository a ){
        this.a = a;
    }
    public void visualizarOrdenado(){
        
        List<Artista> lista = a.findByAllAndOrderNome();
        
    }
}
