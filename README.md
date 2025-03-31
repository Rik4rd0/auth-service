# Auth-Service

Este microservicio **Auth-Service** utiliza **Spring Security**, **JWT** y **OAuth2** para autenticar y autorizar usuarios de forma segura. Ofrece emisión y validación de tokens, protegiendo los endpoints y facilitando la integración con otros servicios en una arquitectura de microservicios.

---

## Descripción del Proyecto

**Auth-Service** es un microservicio desarrollado en **Java** utilizando el framework **Spring Boot**. Este servicio está diseñado para gestionar la autenticación y autorización de usuarios, implementando **Spring Security** con soporte para **JWT (JSON Web Tokens)** y **OAuth2**. Además, utiliza una base de datos **PostgreSQL** para el almacenamiento de usuarios y roles.

---

## Funcionalidades Principales

1. **Autenticación y Registro de Usuarios**:
   - **Registro**: Permite a los usuarios registrarse proporcionando información básica como nombre, correo electrónico, contraseña y rol.
   - **Inicio de Sesión**: Los usuarios pueden autenticarse con su correo electrónico y contraseña para obtener un token JWT.

2. **Gestión de Roles**:
   - Los usuarios tienen roles definidos mediante un `enum` (`RoleEnum`), como `ADMIN` y `USER`, para controlar los permisos.

3. **Seguridad**:
   - Implementación de **JWT** para la autenticación basada en tokens.
   - Filtro de autenticación (`JwtAuthenticationFilter`) para validar los tokens en cada solicitud.
   - Configuración de seguridad personalizada con `SecurityFilterChain`.

4. **Soporte para OAuth2**:
   - Configuración para autenticación con proveedores externos como **Google** y **GitHub**.

5. **Exposición de Endpoints**:
   - **Endpoints de Autenticación**:
     - `/auth/register`: Registro de nuevos usuarios.
     - `/auth/login`: Inicio de sesión y generación de tokens JWT.
   - **Endpoints de Usuario**:
     - `/User/Form`: Devuelve un formulario de ejemplo.

6. **Base de Datos**:
   - Persistencia de usuarios y roles en una base de datos **PostgreSQL**.
   - Uso de **Spring Data JPA** para la interacción con la base de datos.

---

## Tecnologías Utilizadas

- **Java 21**: Lenguaje principal del proyecto.
- **Spring Boot 3.4.4**: Framework para el desarrollo del microservicio.
- **Spring Security**: Para la autenticación y autorización.
- **JWT (io.jsonwebtoken)**: Para la generación y validación de tokens.
- **OAuth2**: Para la integración con proveedores externos como Google y GitHub.
- **PostgreSQL**: Base de datos relacional para almacenar usuarios y roles.
- **Lombok**: Para reducir el código repetitivo (constructores, getters, setters, etc.).
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.

---

## Estructura del Proyecto

1. **`config`**:
   - Configuración de seguridad (`ConfigFilter`) y beans (`BeanConfiguration`).
   - Servicios relacionados con JWT (`JwtService`, `JwtAuthenticationFilter`).

2. **`domain`**:
   - Modelos de datos como `AuthenticationRequest`, `AuthenticationResponse`, `RegisterRequest`.
   - Servicios de dominio como `UserService`.

3. **`infraestructure`**:
   - **Adapters**:
     - Modelos de base de datos (`UserEntity`, `RoleEnum`).
     - Repositorios JPA (`UserRepository`).
   - **Controllers**:
     - Controladores REST para autenticación (`AutenticateController`) y usuarios (`UserRestController`).

4. **`resources`**:
   - Archivo de configuración `application.properties` con soporte para variables de entorno.

---

## Configuración del Proyecto

1. **Base de Datos**:
   - Configuración en `application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://${POSTGRES_HOST}:${POSTGRES_PORT}/${POSTGRES_DB}
     spring.datasource.username=${POSTGRES_USER}
     spring.datasource.password=${POSTGRES_PASSWORD}
     ```

2. **JWT**:
   - Clave secreta definida en `JwtService`:
     ```java
     private static final String SECRET_KEY = "294A404E635266556A586E327235753878214125442A472D4B6150645367566B";
     ```

3. **OAuth2**:
   - Configuración para Google y GitHub en `application.properties`:
     ```properties
     spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
     spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}
     ```

---

## Cómo Ejecutar el Proyecto

1. **Clonar el Repositorio**:
   ```bash
   git clone https://github.com/Rik4rd0/auth-service.git
   cd auth-service
