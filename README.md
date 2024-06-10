![titulo](https://github.com/KevinJJurado/desafioLiteraturaSpring/assets/128235203/869b42f3-d43e-40b0-870c-c99e36caa2f0)
# DESAFIO LITERALURA
# Menú 
- [Descripción](#Descripción)
- [funcionalidades](#Funcionalidades)
- [Instalación](#Instalación)
- [Uso](#Uso)
- [Capturas de Pantalla](#Capturas-de-pantalla)
- [Video demostrativo](#Video-demostrativo)
- [Créditos](#Créditos)

# Descripción
Este desafío de literatura tiene como objetivo crear una aplicación de consola para buscar libros y autores utilizando Spring Boot, una base de datos PostgreSQL y la API Gutendex. La aplicación permite a los usuarios buscar libros por título, listar todos los libros registrados, listar todos los autores registrados, buscar autores que estuvieron vivos en un año específico y buscar libros por idioma.

# Funcionalidades
- Búsqueda de Libros por Título: Los usuarios pueden ingresar el título de un libro y la aplicación buscará y mostrará todos los libros que coincidan con el título proporcionado.

- Listado de Todos los Libros Registrados: La aplicación permite a los usuarios listar todos los libros registrados en la base de datos.

- Listado de Todos los Autores Registrados: Los usuarios pueden ver una lista de todos los autores registrados en la base de datos.

- Búsqueda de Autores por Año: Los usuarios pueden ingresar un año específico y la aplicación mostrará todos los autores que estuvieron vivos en ese año.

- Búsqueda de Libros por Idioma: Los usuarios pueden buscar libros por idioma. La aplicación proporciona una lista de códigos de idioma disponibles y permite al usuario seleccionar uno para ver los libros disponibles en ese idioma.

# Tecnologías Utilizadas:
- Spring Boot: Se utiliza para crear la aplicación Java y proporcionar funcionalidades como inyección de dependencias, configuración de la aplicación y acceso a datos.

- PostgreSQL: Se utiliza como base de datos relacional para almacenar información sobre libros y autores.

- Hibernate: Se utiliza como framework de mapeo objeto-relacional (ORM) para facilitar la interacción con la base de datos PostgreSQL desde la aplicación Spring Boot.

- Gutendex API: Se utiliza para obtener datos de libros de dominio público. La aplicación hace llamadas a la API Gutendex para obtener información sobre los libros que coincidan con las consultas de los usuarios.

- JPQL (Java Persistence Query Language): Se utiliza para escribir consultas personalizadas para acceder a datos en la base de datos PostgreSQL desde la capa de persistencia de la aplicación.

# Ejecución de la Aplicación:
Para ejecutar la aplicación, sigue estos pasos:

- Clona el repositorio de GitHub en tu máquina local.

- Configura una base de datos PostgreSQL en tu entorno local y actualiza la configuración de la base de datos en el archivo application.properties.

- Ejecuta la aplicación utilizando Maven o tu IDE favorito.

- Una vez que la aplicación esté en funcionamiento, podrás acceder a las diferentes funcionalidades de búsqueda de libros desde la consola.

# Uso
- Una vez que la aplicación esté en funcionamiento, verás un menú con opciones enumeradas.
- Selecciona una opción ingresando el número correspondiente y presiona Enter.
- Dependiendo de la opción seleccionada, la aplicación te pedirá información adicional, como el título del libro, el año para la búsqueda de autores, etc.
- La aplicación realizará la búsqueda o acción correspondiente y mostrará los resultados en la consola.

# Capturas de Pantalla
![Menu conversor](https://github.com/KevinJJurado/ConversorMonedaKevinJurado/assets/128235203/0f00aceb-e421-4b91-9196-41eacdfad867)
![Funcionamiento](https://github.com/KevinJJurado/ConversorMonedaKevinJurado/assets/128235203/3874bd0b-a394-4932-a30b-0c667c5cfb42)


# Video Demostrativo
![videoConversor]()


# Créditos
Este proyecto fue desarrollado por [Kevin Jurado](https://github.com/KevinJJurado).
