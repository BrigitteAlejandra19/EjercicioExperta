# EJERCICIO EXPERTA

El ejercicio consistió en hacer una Api Rest que permite hacer registro de bares, en donde se puede visualizar un listado delmismo con su nombre, domicilio, puntuación, email, tel, cuit, horario y si posee o no estacionamiento. El sistema permite agregar y eliminar los bares.

##  Consideraciones
Para rellenar la base de datos en memoria H2 se ejecuta el endpoint
Post: http://localhost:8080/bar/init .

## Requerimientos del sistema:

####Tener instalado y configurado:

- [x] JDK: `<link>`  https://docs.oracle.com/en/java/javase/index.html
- [x] Maven:  `<link>` https://maven.apache.org/download.cgi
- [ ] Git client: `<link>`https://www.atlassian.com/git/tutorials/install-git

####Correr la aplicación
- Clonar el repositorio
  `<link>`: https://github.com/BrigitteAlejandra19/EjercicioExperta.git
- Parados en la raíz del proyecto desde la terminal, ejecutar:
  `$ mvn clean install`
- Correr la app usando el jar Java file desde la terminal:
  `$ java -jar ./target/EjercicioExperta-0.0.1-SNAPSHOT.jar`

## Tecnologias y herramientas utilizadas
- [x] Springboot.
- [x] Github.
- [x] Java 16
- [x] H2 database
- [x] lombok.
- [x] Postman: [Descargar collection aqui](https://github.com/BrigitteAlejandra19/EjercicioExperta/blob/master/postman)
- [x] Docker.
- [x] Intellij ide.

Documentacion

### Arquitectura utilizada
Arquitectura REST

### Posibles mejoras
- Clean code
- Agregar todas las validaciones de los atributos
- Mejorar las excepciones