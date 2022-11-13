package br.com.crp.mystudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import br.com.crp.mystudio.domain.model.usuario.Usuario;
import br.com.crp.mystudio.domain.repository.UsuarioRepository;

@SpringBootApplication
public class MystudioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MystudioApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase (UsuarioRepository repo){
		return args -> {
			repo.deleteAll();

			Usuario u = new Usuario();
			u.setNome("Rafael Aguiar Silva");
			u.setEmail("rafael.aguiar@gmail.com");
			u.setSenha("1234");
			repo.save(u);
		};
	}
}
