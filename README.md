# 📚 API Biblioteca – CRUD de Livros

API REST desenvolvida em **Java + Spring Boot**, utilizando **JPA/Hibernate**, **H2 Database**, arquitetura em camadas (Controller, Service, Repository) e validação com **Jakarta Validation**.

Este projeto atende ao requisito de criar uma aplicação com operações completas de CRUD para a entidade **Livro**, incluindo validações e tratamento de erros.

---

## 🚀 Tecnologias utilizadas

* **Java 17+**
* **Spring Boot 3.5.x**
* **Spring Web**
* **Spring Data JPA**
* **H2 Database**
* **Jakarta Validation**
* **Maven**

---

## 📁 Estrutura do Projeto

```
src/main/java/br/com/seu/biblioteca/
│
├── BibliotecaApplication.java
│
├── controller/
│   └── LivroController.java
│
├── service/
│   └── LivroService.java
│
├── repository/
│   └── LivroRepository.java
│
├── entity/
│   └── Livro.java
│
├── dto/
│   └── LivroDTO.java
│
└── exception/
    └── GlobalExceptionHandler.java
```

---

## 🗃️ Banco de Dados

O projeto usa **H2 Database** (arquivo local), pronto para desenvolvimento.

Você pode acessar o console em:

👉 **[http://localhost:8080/h2-console](http://localhost:8080/h2-console)**

Configuração padrão:

```
JDBC URL: jdbc:h2:file:./biblioteca-db
Usuário: sa
Senha: (vazia)
```

---

## ⚙️ Configuração – `application.properties`

```properties
spring.datasource.url=jdbc:h2:file:./biblioteca-db;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

---

## ▶️ Como rodar o projeto

### 1) Clonar o repositório

```bash
git clone https://github.com/SEU_USUARIO/biblioteca-api.git
cd biblioteca-api
```

### 2) Compilar o projeto

```bash
mvn clean package
```

### 3) Rodar a aplicação

```bash
mvn spring-boot:run
```

A API ficará disponível em:

👉 **[http://localhost:8080](http://localhost:8080)**

---

## 📚 Endpoints da API

### ➕ Criar novo livro

**POST /api/livros**

Exemplo de JSON:

```json
{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "isbn": "9788572320008",
  "anoPublicacao": 1899,
  "disponivel": true
}
```

---

### 📄 Listar todos os livros

**GET /api/livros**

---

### 🔍 Buscar livro por ID

**GET /api/livros/{id}**

---

### ✏️ Atualizar livro (substituição completa)

**PUT /api/livros/{id}**

---

### 🛠️ Atualização parcial

**PATCH /api/livros/{id}**

---

### ❌ Excluir livro

**DELETE /api/livros/{id}**

---

## 🧪 Exemplos com curl

### Criar livro

```bash
curl -X POST http://localhost:8080/api/livros \
 -H "Content-Type: application/json" \
 -d '{"titulo":"Dom Casmurro","autor":"Machado de Assis","isbn":"9788572320008","anoPublicacao":1899}'
```

### Listar todos

```bash
curl http://localhost:8080/api/livros
```

### Buscar por ID

```bash
curl http://localhost:8080/api/livros/1
```

### Atualizar

```bash
curl -X PUT http://localhost:8080/api/livros/1 \
 -H "Content-Type: application/json" \
 -d '{"titulo":"Dom Casmurro (edição revisada)","autor":"Machado de Assis","isbn":"9788572320008"}'
```

### Deletar

```bash
curl -X DELETE http://localhost:8080/api/livros/1
```

---

## 🛡️ Tratamento de erros

A API possui tratamento global de erros (via `@RestControllerAdvice`):

Exemplos:

| Erro | Motivo                              |
| ---- | ----------------------------------- |
| 400  | Validação de campos, ISBN duplicado |
| 404  | Livro não encontrado                |
| 409  | Conflito de dados                   |
| 500  | Erro inesperado                     |

---

## 📌 Critérios atendidos do exercício

✔ CRUD completo da entidade **Livro**
✔ Arquitetura organizada: Controller + Service + Repository
✔ Validações com Jakarta Validation
✔ Tratamento de erros centralizado
✔ Banco de dados relacional + ORM (JPA/Hibernate)
✔ Endpoints REST bem definidos
✔ Código limpo e pronto para avaliação

---

## 📝 Melhorias futuras (opcional)

* Adicionar Swagger (OpenAPI)
* Usar DTOs para entrada e saída
* Implementar testes automatizados (JUnit + MockMVC)
* Adicionar autenticação (Spring Security)

---

# 📦 Licença

Este projeto é livre para uso acadêmico e estudos.

---
