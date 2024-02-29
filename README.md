# Laboratorio 4 - AREP

## Descripción

Este proyecto consiste en la implementación de un servidor web en Java con Spark, que puede manejar solicitudes HTTP y proporcionar servicios REST para calcular funciones matemáticas y verificar si una cadena es un palíndromo. Además, se incluye un cliente web para interactuar con estos servicios.

## Arquitectura del Proyecto

El proyecto sigue una arquitectura cliente-servidor, donde el servidor Spark actúa como el servidor que escucha las solicitudes entrantes de los clientes y procesa las solicitudes. El cliente web envía solicitudes HTTP al servidor para realizar cálculos matemáticos o verificar si una cadena es un palíndromo.

## Estructura del Repositorio

El repositorio contiene el código fuente del proyecto, que está estructurado y gestionado utilizando Apache Maven.

### Componentes Principales

1. **Servidor Spark**: Representa el servidor web principal que maneja las solicitudes HTTP entrantes y proporciona servicios REST.
2. **Controladores Spark**: Funciones lambda que procesan las solicitudes HTTP y generan respuestas dinámicas para calcular funciones matemáticas y verificar palíndromos.
3. **Cliente Web**: Interfaz de usuario que permite al usuario interactuar con los servicios REST proporcionados por el servidor Spark.

## Ejemplo de Uso

- A continuación se muestra un ejemplo de cómo se desarrollarían las aplicaciones en este servidor Spark:

    ```java
    // Controlador para calcular el seno
    get("/sin/:value", (req, res) -> {
        double value = Double.parseDouble(req.params(":value"));
        return Math.sin(value);
    });
    ```

- Un ejemplo de una solicitud GET para calcular el seno:
  ![GET](img/pal.png)
- Un ejemplo de una solicitud GET para verificar si una cadena es un palíndromo:
  ![GET](img/sin.png)
- Un ejemplo de la interfaz
  ![GET](img/interfaz.png)
- Containers construidos
  ![GET](img/img.png)
## Instrucciones de Ejecución

Para ejecutar el proyecto, sigue estos pasos:

1. Clona el repositorio desde GitHub.
2. **Compilar el Proyecto:** Ejecutar `mvn compile`.
3. **Ejecutar el Servidor Spark:** Ejecutar `java -cp "target/classes;target/dependency/*" co.edu.escuelaing.sparkdockerdemolive.SparkWebServer`.
4. **Acceder al Cliente Web:** Entrar desde un navegador a `http://localhost:4567`.

