package com.aluracursos.desafio_literatura.principal;

import com.aluracursos.desafio_literatura.model.Datos;
import com.aluracursos.desafio_literatura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal {
    Scanner teclado = new Scanner(System.in);
    Scanner lectura = new Scanner(System.in);
    private LibroService libroService;

    @Autowired
    public Principal(LibroService libroService) {
        this.libroService = libroService;
    }

    public void mostrarMenu() {

        System.out.println("**********************************************");
        System.out.println("Escoja la opción  a travez de su numero");
        String menu = """
                
                1- Buscar libro por titulo
                2- Listar libros registrados
                3- Listar autores registrados
                4- Listar autores vivos en un determinado año
                5- Listar libros por por idioma
                0- salir
                Elija una opción válida;
                **********************************************
                """;

        int opcion = -1 ;

        while (opcion != 0) {
            System.out.println(menu);
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del libro que desea buscar: ");
                    String tituloLibro = lectura.nextLine();
                    libroService.buscarLibroPorTitulo(tituloLibro);
                    break;
                case 2:
                    libroService.listarLibros();
                    break;
                case 3:
                    libroService.listarAutoresRegistrados();
                    break;
                case 4:
                    System.out.println("Ingrese el año que desea buscar: ");
                    int anoAutor = Integer.parseInt(lectura.nextLine());
                    libroService.listaAutoresVivosAno(anoAutor);
                    break;
                case 5:
                    String idiomas = """
                            es - español
                            en - inglés
                            fr - frances
                            pt - portugués
                            """;
                    System.out.println("Ingrese el idioma que desea buscar: \n" + idiomas);
                    String idioma = lectura.nextLine();
                    libroService.listarLibroPorIdioma(idioma);
                    break;
                case 0:
                    System.out.println("Gracias por usar el buscador de libros");
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }
    }

}
