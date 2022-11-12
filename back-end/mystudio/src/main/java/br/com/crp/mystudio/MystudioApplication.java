package br.com.crp.mystudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.crp.mystudio.domain.model.artista.Album;
import br.com.crp.mystudio.domain.repository.AlbumRepository;

@SpringBootApplication
public class MystudioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MystudioApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase (AlbumRepository repo){
		return args -> {
			repo.deleteAll();

			Album a = new Album();
			a.setAnoLancamento("25/12/2002");
			a.setArtista(null);
			a.setMusicas(null);
			a.setNome("Daniel DELES");
			a.setTempoTotalDur("2h:28m");

			repo.save(a);
		};
	}
}
