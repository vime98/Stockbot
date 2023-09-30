# Stockbot Consulta de Precios de Acciones

Este proyecto es una aplicación web de Spring Boot que permite consultar los precios de las acciones en la bolsa de valores.

## Requisitos

Antes de ejecutar la aplicación, asegúrate de tener instalado lo siguiente:

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)

## Instalación

1. Clona este repositorio en tu máquina local:

   ```shell
   git clone https://github.com/vime98/Stockbot
Navega al directorio del proyecto:

shell
Copy code
cd consulta-acciones-spring
Ejecuta la aplicación con Maven:

shell
Copy code
mvn spring-boot:run
La aplicación estará disponible en http://localhost:8080/. Puedes acceder a ella desde tu navegador web.

Uso
Ingresa a la página principal en http://localhost:8080/.

Ingresa el código de la acción que deseas consultar y haz clic en "Consultar Precio".

El precio de la acción se mostrará en la página.

Para realizar consultas adicionales, simplemente vuelve a la página principal.

Tecnologías Utilizadas
Spring Boot
Thymeleaf (motor de plantillas)
RestTemplate (para hacer solicitudes HTTP)
HTML y CSS (para la interfaz de usuario)
