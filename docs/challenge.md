Olá candidato(a),

Este desafio faz parte do processo seletivo para a vaga de Desenvolvedor Backend no Nubank. Nosso objetivo é avaliar sua capacidade de estruturar uma API RESTful utilizando boas práticas, relacionamentos de entidades e persistência de dados com Spring Boot e PostgreSQL.

# Desafio
Construa uma API REST para gerenciamento de clientes e seus contatos. Cada cliente pode ter um ou mais contatos associados.

# Requisitos Técnicos:
Sua aplicação deve conter:
àdadadad
- Cadastro de Cliente (POST /clientes)
- Cadastro de Contato (POST /contatos) associado a um cliente existente
- Listagem de todos os clientes com seus contatos (GET /clientes)
- Listagem de contatos de um cliente específico (GET /clientes/{id}/contatos)
- Uso de Spring Boot + Spring Data JPA
- Banco de dados PostgreSQL
- Entidades Cliente e Contato com relacionamento OneToMany / ManyToOne

# Requisitos de Código:
Esperamos que seu código siga boas práticas de desenvolvimento, incluindo:

- Separação de responsabilidades (camadas: controller, service, repository)
- Uso de DTOs para entrada e saída de dados
- Tratamento adequado de erros
- Usar Lombok

# Diferenciais (Não obrigatórios)
- Uso de Docker para subir o PostgreSQL
- Testes automatizados
- Documentação com Swagger

# Considerações Finais
Você pode usar qualquer estrutura de projeto que preferir. Ao finalizar, envie um link para o repositório GitHub com instruções de como rodar o projeto localmente.

Boa sorte!