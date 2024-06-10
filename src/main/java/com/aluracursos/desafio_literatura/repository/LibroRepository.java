package com.aluracursos.desafio_literatura.repository;

import com.aluracursos.desafio_literatura.model.Autor;
import com.aluracursos.desafio_literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTituloContainsIgnoreCase(String titulo);

    @Query("SELECT a FROM Libro a JOIN a.idiomas idioma WHERE UPPER(idioma) LIKE UPPER(CONCAT('%',:idioma, '%') ) ")
    List<Libro> findAllByIdiomas(String idioma);
}
