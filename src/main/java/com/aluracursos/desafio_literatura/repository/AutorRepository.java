package com.aluracursos.desafio_literatura.repository;

import com.aluracursos.desafio_literatura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libros")
    List<Autor> findAllWithLibros();

    @Query("SELECT a FROM Autor a WHERE  a.fechaDeNacimiento <= :year AND a.fechaFallecimiento >= :year")
    List<Autor> findAutorByFechaDeNacimientoIsBetweenAndFechaFallecimiento(int year);
}
