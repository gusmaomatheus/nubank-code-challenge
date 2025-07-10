# 🏦 Desafio Backend Nubank

Este projeto foi desenvolvido como parte do processo seletivo para a vaga de Desenvolvedor Backend no Nubank. A proposta consiste na construção de uma API RESTful para gerenciamento de **clientes** e seus respectivos **contatos**, utilizando **Spring Boot** e **PostgreSQL**.

## ✅ Funcionalidades Implementadas

- [x] Cadastro de Cliente (`POST /api/v1/clientes`)
- [x] Cadastro de Contato associado a um Cliente (`POST /api/v1/contatos`)
- [x] Listagem de todos os clientes com seus contatos (`GET /api/v1/clientes`)
- [x] Listagem de contatos de um cliente específico (`GET /api/v1/clientes/{id}/contatos`)

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL 15**
- **Flyway** (para versionamento do banco de dados)
- **Lombok**
- **Docker** (para subir o PostgreSQL)
- **Maven**

## 📁 Estrutura do Projeto

O projeto segue a arquitetura em camadas:

```
src
├── application     # Camada com configurações da aplicação (exceptions, responses, security)
├── controller      # Camada de entrada (REST Controllers)
├── model
    ├── dto         # Objetos de transferência de dados (entrada e saída)
    ├── entity      # Entidades JPA
├── repository      # Interfaces de acesso ao banco
├── service         # Regras de negócio
```

## 🧾 Documentação Técnica

A pasta [`/docs`](./docs) contém:

- 🧬 **Diagrama MER** – Modelo entidade-relacionamento do banco
- 🔄 **Diagrama UML** – Representação visual das classes e seus relacionamentos

## 🚀 Como Rodar o Projeto

### Pré-requisitos
- Docker e Docker Compose instalados
- Java 21
- Maven

### Passos

1. **Clone o repositório:**

   ```bash
   git clone git@github.com:gusmaomatheus/nubank-code-challenge.git
   cd nubank-code-challenge
   ```

2. **Suba o banco de dados com Docker Compose:**

   ```bash
   cd challenge && docker-compose up -d
   ```

3. **Execute a aplicação:**

   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acesse a API em:**

   ```
   http://localhost:8080/api/v1
   ```

## 📌 Melhorias Futuras

- [ ] Adicionar documentação da API com **Swagger/OpenAPI**
- [ ] Implementar testes automatizados com **JUnit e Mockito**

## 🧑‍💻 Autor

Feito por **[Matheus Gusmão](https://www.linkedin.com/in/gusmaom/)** para o desafio técnico do Nubank.  
Para dúvidas ou sugestões, fique à vontade para entrar em contato!