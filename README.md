# **Auth-Service** 🔐  
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.4-6DB33F?logo=springboot)
![Java](https://img.shields.io/badge/Java-21-007396?logo=openjdk)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-4169E1?logo=postgresql)
![JWT](https://img.shields.io/badge/JWT-0.12.2-000000?logo=jsonwebtokens)
![License](https://img.shields.io/badge/License-MIT-yellow)

*Microservicio de Autenticación con Spring Boot, JWT y OAuth2, para autenticar y autorizar usuarios de forma segura.*  

---

## **📌 Tabla de Contenidos**  
1. [Descripción](#-descripción)  
2. [Características](#-características)  
3. [Tecnologías](#-tecnologías)  
4. [Estructura del Proyecto](#-estructura-del-proyecto)  
5. [Configuración](#-configuración)  
6. [Endpoints](#-endpoints)  
7. [Despliegue](#-despliegue)  
 
---

## **📝 Descripción**  
**Auth-Service** es un microservicio de autenticación seguro y escalable, desarrollado con **Spring Boot 3**, que proporciona:  
✅ Autenticación basada en **JWT** (JSON Web Tokens)  
✅ Autorización por roles (**ADMIN**, **USER**)  
✅ Soporte para **OAuth2** (Google, GitHub)  
✅ Integración con **PostgreSQL**  
✅ Protección de endpoints con **Spring Security**  

---

## **✨ Características**  
- **Registro e Inicio de Sesión** con validación de credenciales  
- **Generación y Validación de Tokens JWT** con clave secreta configurable  
- **Gestión de Roles** para control de acceso granular  
- **Autenticación Social** mediante OAuth2 (Google/GitHub)  
- **APIs RESTful** documentadas y protegidas  

---

## **🛠 Tecnologías**  
| **Categoría**       | **Tecnologías**                                                                 |
|----------------------|---------------------------------------------------------------------------------|
| **Lenguaje**         | Java 21                                                                         |
| **Framework**        | Spring Boot 3.4.4 (Web, Security, Data JPA, OAuth2 Client)                      |
| **Autenticación**    | JWT (io.jsonwebtoken), Spring Security, OAuth2                                  |
| **Base de Datos**    | PostgreSQL                                                                      |
| **Herramientas**     | Lombok, Maven, Docker                                                           |

---

## **📂 Estructura del Proyecto**  
```
├── src/
│ ├── main/
│ │ ├── java/com/auth-service/
│ │ │ ├── config/ # Configuración de seguridad y beans
│ │ │ ├── domain/ # Lógica de negocio y modelos
│ │ │ ├── infrastructure/ # Adaptadores (BD, controladores)
│ │ │ └── AuthApplication.java
│ │ └── resources/ # application.yml, propiedades
```

## **📌 Capas principales:**  
- **`config/`**: Configuración de Spring Security, JWT y OAuth2  
- **`domain/`**: Modelos (User, Role) y servicios de autenticación  
- **`infrastructure/`**:  
  - `adapters/postgreSQL/`: Entidades JPA y repositorios  
  - `controller/`: Endpoints REST  


## **⚙ Configuración**  

### **🔧 Variables de Entorno** (`application.yml`)  
```application.properties
# ===============================
# DATABASE CONFIGURATION (PostgreSQL)
# ===============================
spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}

# ===============================
# JWT CONFIGURATION
# ===============================
jwt.secret-key=${JWT_SECRET}

# ===============================
# OAUTH2 CONFIGURATION
# ===============================
# Google OAuth2
spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}

# GitHub OAuth2
spring.security.oauth2.client.registration.github.client-id=${GITHUB_CLIENT_ID}
spring.security.oauth2.client.registration.github.client-secret=${GITHUB_CLIENT_SECRET}
```
## **📌 Requisitos**
Java 21

PostgreSQL 15+

Maven 3.9+

## **🌐 Endpoints**
Método	Ruta	Descripción	Acceso
POST	/auth/register	Registro de usuario	Público
POST	/auth/login	Genera JWT	Público
GET	/api/users/me	Datos del usuario autenticado	USER/ADMIN
GET	/oauth2/google	Login con Google	Público

## **🚀 Despliegue**
1. Con Docker Compose
bash
Copy
docker-compose up --build  # Inicia PostgreSQL + Auth-Service
2. Localmente
bash
Copy
mvn spring-boot:run -Dspring-boot.run.profiles=dev
