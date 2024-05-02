package com.its.orientaTest;

import com.its.orientaTest.model.entities.Categoria;
import com.its.orientaTest.model.entities.Pregunta;
import com.its.orientaTest.repository.CategoriaRepository;
import com.its.orientaTest.repository.PreguntaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class OrientaTestApplication {

	private final CategoriaRepository categoriaRepository;
	private final PreguntaRepository preguntaRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrientaTestApplication.class, args);
	}


	@Bean
	public CommandLineRunner dataLoader(CategoriaRepository categoriaRepository, PreguntaRepository preguntaRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				// Carga de datos de preguntas y categorías al iniciar la aplicación
				Categoria categoria1 = new Categoria(1L,"Categoría 1");
				Categoria categoria2 = new Categoria(2L,"Categoría 2");

				categoriaRepository.save(categoria1);
				categoriaRepository.save(categoria2);

				Pregunta pregunta1 = new Pregunta(1L,"¿Pregunta 1?", categoria1);
				Pregunta pregunta2 = new Pregunta(2L,"¿Pregunta 2?", categoria2);

				preguntaRepository.save(pregunta1);
				preguntaRepository.save(pregunta2);
			}
		};
	}



}
