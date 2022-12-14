package br.com.crp.mystudio.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.crp.mystudio.domain.model.usuario.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    @Query("SELECT u FROM Usuario u WHERE u.active = true")
    public List<Usuario> findAllActive();

    @Query("SELECT u FROM Usuario u WHERE u.active = true and u.email = :email")
    Optional<Usuario> findUsuarioByEmail(@Param("email") String email);
}
