# Proyecto de Gestión de Empleados

## Descripción
Este proyecto es una aplicación Spring Boot que proporciona una API REST para gestionar información de empleados. Utiliza una API externa para obtener datos de empleados y calcula sus salarios anuales.

## Requisitos
- Java 17
- Maven 3.9.7 o superior

## Configuración
El proyecto utiliza Maven para la gestión de dependencias. Las principales dependencias incluyen:
- Spring Boot Starter Web
- Lombok
- Spring Boot Starter Test (para pruebas)

## Estructura del Proyecto
- `src/main/java/com/siigroup/employees`: Contiene el código fuente principal
  - `controller`: Controladores REST
  - `models`: Clases de modelo (Employee, Person, etc.)
  - `repository`: Interfaces y implementaciones de repositorios
  - `service`: Lógica de negocio

## Características Principales
1. Obtener lista de todos los empleados
2. Obtener detalles de un empleado por ID
3. Cálculo automático del salario anual

## Cómo Ejecutar
1. Clona el repositorio
2. Navega al directorio del proyecto
3. Ejecuta: `./mvnw spring-boot:run`

## Endpoints de la API
- GET `/api/employees`: Obtiene todos los empleados
- GET `/api/employees/{id}`: Obtiene un empleado por ID

## Pruebas
El proyecto incluye pruebas unitarias para controladores, servicios y repositorios. Para ejecutar las pruebas:

bash
./mvnw test

## Configuración CORS
El proyecto incluye una configuración CORS que permite solicitudes desde cualquier origen para los endpoints `/api/**`.

## Notas Adicionales
- La aplicación utiliza una API externa (https://dummy.restapiexample.com/api/v1/) para obtener datos de empleados.
- Se calcula automáticamente el salario anual de cada empleado.