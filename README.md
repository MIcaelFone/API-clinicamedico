# API de Clínica Médica

Esta é a API de uma clínica médica desenvolvida com **Spring Boot**. O objetivo deste projeto é gerenciar informações de pacientes, médicos, agendamentos e consultas. A API oferece funcionalidades CRUD (Create, Read, Update, Delete) para os principais componentes do sistema de uma clínica médica.

## Sumário

- [Instalação](#instalação)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Funcionalidades](#funcionalidades)
- [Endpoints](#endpoints)
- [Contribuindo](#contribuindo)
- [Licença](#licença)

## Instalação

Para rodar este projeto localmente, você precisará do seguinte:

### Pré-requisitos

- **Java 17** ou superior
- **Maven** (para gerenciamento de dependências)
- **MySQL** ou outro banco de dados relacional (pode ser configurado no `application.properties`)
- **** ou outro banco de dados relacional (pode ser configurado no `application.properties`)

### Passos

1. Clone o repositório:

    ```bash
    git clone https://github.com/MIcaelFone/API-clinicamedico.git
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd API-clinicamedico
    ```

3. Compile o projeto e baixe as dependências:

    ```bash
    mvn clean install
    ```

4. Configure o arquivo `application.properties` com as credenciais do  banco de dados:

    ```properties
    spring.datasource.url=${DB_URL}
    spring.datasource.username=${DB_USERNAME}
    spring.datasource.password=${DB_USERNAME}   
    ```

5. Execute a aplicação:

    ```bash
    mvn spring-boot:run
    ```

6. A API estará disponível em `http://localhost:8080`.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Data JPA**
- **MySQL**  
- **Maven** (para o build do projeto)

## Funcionalidades

O sistema fornecerá as seguintes funcionalidades (em desenvolvimento):

- **Pacientes**: Cadastro, atualização, listagem e remoção de pacientes.
- **Médicos**: Cadastro, atualização, listagem e remoção de médicos.
- **Agendamentos**: Criação e gerenciamento de agendamentos de consultas.
- **Consultas**: Registro ,cancelamento e visualização de consultas realizadas.
- **Medicos inativos**:Listar,cadastramento da inatividade.
- **Paciente inativos**:Listar,cadastramento da inatividade.

## Endpoints

A seguir, uma lista dos endpoints planejados para o projeto (sujeitos a mudanças à medida que o desenvolvimento avança):

### Pacientes

- **GET** `/api/pacientes` - Retorna a lista de todos os pacientes.
- **GET** `/api/pacientes/{id}` - Retorna detalhes de um paciente específico.
- **POST** `/api/pacientes` - Cria um novo paciente.
- **PUT** `/api/pacientes/{id}` - Atualiza as informações de um paciente.
- **DELETE** `/api/pacientes/{id}` - Remove um paciente do sistema.

### Médicos

- **GET** `/api/medicos` - Retorna a lista de todos os médicos.
- **GET** `/api/medicos/{id}` - Retorna detalhes de um médico específico.
- **POST** `/api/medicos` - Cria um novo médico.
- **PUT** `/api/medicos/{id}` - Atualiza as informações de um médico.
- **DELETE** `/api/medicos/{id}` - Remove um médico do sistema.

### Agendamentos

- **GET** `/api/agendamentos` - Retorna a lista de todos os agendamentos.
- **POST** `/api/agendamentos` - Cria um novo agendamento.

### Consultas

- **GET** `/api/consultas` - Retorna a lista de todas as consultas.
- **POST** `/api/consultas` - Registra uma nova consulta.

> **Nota:** Endpoints adicionais podem ser incluídos conforme o desenvolvimento da API avança.

## Contribuindo

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Faça um fork deste repositório.
2. Crie uma branch para sua feature ou correção de bug (`git checkout -b feature/nome-da-feature`).
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`).
4. Envie para a branch principal (`git push origin feature/nome-da-feature`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais informações.

