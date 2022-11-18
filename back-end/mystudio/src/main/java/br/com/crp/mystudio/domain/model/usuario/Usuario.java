package br.com.crp.mystudio.domain.model.usuario;

import java.io.Serial;

import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.crp.mystudio.domain.DefaultEntity;
import br.com.crp.mystudio.rest.dto.CreateUsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Usuario extends DefaultEntity{
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    @Column(unique = true)
    private String senha;

    public Usuario(CreateUsuarioDTO dto, PasswordEncoder encoder){
        this.nome = dto.nome();
        this.email = dto.email();
        this.senha = encoder.encode(dto.senha());
    }

}
