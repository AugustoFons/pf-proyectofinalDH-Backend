# marketplease! – Backend

## Descripción
Backend desarrollado en Java con Spring Boot que expone una API REST para la gestión de productos.
Este repositorio corresponde al backend del proyecto desarrollado para el Sprint 1.

## Tecnologías utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Documentación
La documentación correspondiente al Sprint 1 se encuentra en la carpeta `/docs`:
- Bitácora del sprint
- Identidad de marca
- Plan de testing

## Requisitos
- Java 21
- Maven
- MySQL 8+

## Base de datos (MySQL)

### Crear base y usuario (ejemplo)
```sql
CREATE DATABASE marketplease
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

CREATE USER 'mp'@'localhost' IDENTIFIED BY 'mp';
GRANT ALL PRIVILEGES ON marketplease.* TO 'mp'@'localhost';
FLUSH PRIVILEGES;
```

Configuración
Editar el archivo src/main/resources/application.properties con las credenciales locales de MySQL:

spring.datasource.url

spring.datasource.username

spring.datasource.password

Nota: el esquema de tablas se genera y actualiza automáticamente al iniciar la aplicación por primera vez mediante Hibernate (spring.jpa.hibernate.ddl-auto=update). El archivo src/main/resources/data.sql incializa datos para la tabla de categorias de productos. Y opcionalmente se deja disponible el archivo src/main/resources/data/dataproducts.sql con los inserts de productos e imagenes si se quiere llenar la db de datos manualmente luego de la inicialización.

Ejecución
mvn spring-boot:run
API
http://localhost:8080

Repositorio Frontend
https://github.com/AugustoFons/pf-proyectofinalDH-Front

---

