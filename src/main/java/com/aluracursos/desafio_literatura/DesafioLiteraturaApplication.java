package com.aluracursos.desafio_literatura;

import com.aluracursos.desafio_literatura.principal.Principal;
import com.aluracursos.desafio_literatura.repository.LibroRepository;
import com.aluracursos.desafio_literatura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioLiteraturaApplication implements CommandLineRunner {

	private final LibroService libroService;

	@Autowired
	public DesafioLiteraturaApplication(LibroService libroService) {
		this.libroService = libroService;
	}
	public static void main(String[] args) {
		SpringApplication.run(DesafioLiteraturaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroService);
		principal.mostrarMenu();
	}
}
