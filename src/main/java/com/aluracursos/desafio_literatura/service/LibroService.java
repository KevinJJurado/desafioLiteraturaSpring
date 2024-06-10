package com.aluracursos.desafio_literatura.service;

import com.aluracursos.desafio_literatura.model.Autor;
import com.aluracursos.desafio_literatura.model.Datos;
import com.aluracursos.desafio_literatura.model.DatosLibros;
import com.aluracursos.desafio_literatura.model.Libro;
import com.aluracursos.desafio_literatura.repository.AutorRepository;
import com.aluracursos.desafio_literatura.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository repository;
    private final AutorRepository autorRepository;
    private ConsumoApi consumoApi = new ConsumoApi();
    private final String URL = "https://gutendex.com/books/";
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private List<Libro> libros;
    private List<Autor> autores;

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.repository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void buscarLibroPorTitulo(String tituloLibro) {
        String json1 = consumoApi.obtenerDatos(URL);
        var datos = convierteDatos.obtenerDatos(json1, Datos.class);
        System.out.println(datos);

        Optional<Libro> libroExistente = repository.findByTituloContainsIgnoreCase(tituloLibro);
        if (libroExistente.isPresent()) {
            System.out.println("El libro ya existe en la base de datos");
        } else {
            String json = consumoApi.obtenerDatos(URL + "?search=" + tituloLibro.replace(" ", "+"));
            var datosBusqueda = convierteDatos.obtenerDatos(json, Datos.class);
            Optional<DatosLibros> libroBuscado = datosBusqueda.libros().stream()
                    .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                    .findFirst();
            if (libroBuscado.isPresent()) {
                System.out.println("Libro encontrado");
                DatosLibros datosLibros = libroBuscado.get();
                System.out.println(datosLibros);

                Libro libro = new Libro(datosLibros);
                repository.save(libro);
            } else {
                System.out.println("Libro no encontrado");
            }
        }

    }

    @Transactional
    public void listarLibros() {
        libros = repository.findAll();

        libros.stream()
                .forEach(libro -> {
                    System.out.println(libro.toString());
                });
    }

    @Transactional
    public void listarAutoresRegistrados() {
        autores = autorRepository.findAllWithLibros();
        autores.forEach(autor -> {
            System.out.println("------ AUTOR ----------");
            System.out.println("Nombre: " + autor.getNombre());
            System.out.println("Libros:");
            autor.getLibros().forEach(l -> System.out.println("[ " + l.getTitulo() + " ]"));
        });
        System.out.println();
    }

    public void listaAutoresVivosAno(int ano) {
        autores = autorRepository.findAutorByFechaDeNacimientoIsBetweenAndFechaFallecimiento(ano);
        autores.forEach(autor -> {
            System.out.println("------ AUTOR ----------");
            System.out.println("Nombre: " + autor.getNombre());
            System.out.println("Libros:");
            autor.getLibros().forEach(l -> System.out.println("[ " + l.getTitulo() + " ]"));
        });
    }

    public void listarLibroPorIdioma(String idioma) {
        libros = repository.findAllByIdiomas(idioma);
        libros.stream()
                .forEach(libro -> {
                    System.out.println(libro.toString());
                });
    }
}
