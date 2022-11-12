package br.com.crp.mystudio.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.crp.mystudio.domain.model.usuario.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
}
