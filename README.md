# API de Clínica Médica

Esta é a API de uma clínica médica desenvolvida com **Spring Boot**. O objetivo deste projeto é gerenciar informações de pacientes, médicos, agendamentos e consultas. A API oferece funcionalidades CRUD (Create, Read, Update, Delete) para os principais componentes do sistema de uma clínica médica.

## Sumário

- [Instalação](#instalação)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Funcionalidades](#funcionalidades)
- [Regras de negócio](#Regras_de_negócio)
- [Endpoints](#endpoints)
- [Swagger](#swagger)
- [Contribuindo](#contribuindo)
- [Licença](#licença)

## Instalação

Para rodar este projeto localmente, você precisará do seguinte:

### Pré-requisitos

- **Java 17** ou superior
- **Maven** (para gerenciamento de dependências)
- **MySQL** ou outro banco de dados relacional (pode ser configurado no `application.properties`)

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
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
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
## Regras
## Funcionalidades

O sistema fornecerá as seguintes funcionalidades (em desenvolvimento):

- **Pacientes**: Cadastro, atualização, listagem e remoção de pacientes.
- **Médicos**: Cadastro, atualização, listagem e remoção de médicos.
- **Agendamentos**: Criação e gerenciamento de agendamentos de consultas.
- **Consultas**: Registro ,cancelamento e visualização de consultas realizadas.
- **Medicos inativos**:Listar,cadastramento da inatividade de médicos.
- **Paciente inativos**:Listar,cadastramento da inatividade de pacientes.

## Endpoints

A seguir, uma lista dos endpoints planejados para o projeto (sujeitos a mudanças à medida que o desenvolvimento avança):

### Pacientes

- **GET** `/paciente` - Retorna a lista de todos os pacientes.
- **POST** `/paciente` - Cria um novo paciente.
- **PUT** `/paciente/{id}` - Atualiza as informações de um paciente.
- **DELETE** `/paciente/{id}` - Remove um paciente do sistema.

### Médicos

- **GET** `/medicos` - Retorna a lista de todos os médicos.
- **POST** `/medicos` - Cria um novo médico.
- **PUT** `/medicos/{id}` - Atualiza as informações de um médico.
- **DELETE** `/medicos/{id}` - Remove um médico do sistema.

### Consultas

- **GET** `/consulta` - Retorna a lista de todas as consultas.
- **POST** `/consulta` - Registra uma nova consulta.
- **DELETE** `/consulta/{id}` - Deleta uma consulta.

 ### Medico Inativos

 - **GET** `/inativomedico` - Retorna a lista de todos os médicos inativos.
- **POST** `/inativomedico` - Registra inatividade do médico.
- **DELETE** `/inativomedico` - Deleta uma inatividade do médico.

 ### Paciente Inativos

 - **GET** `/inativopaciente` - Retorna a lista de todos os pacientes inativos.
- **POST** `/inativopaciente` - Registra inatividade de paciente.
- **DELETE** `/inativopaciente` - Deleta uma inatividade do paciente.

 **Nota:** Endpoints adicionais podem ser incluídos conforme o desenvolvimento da API avança.

## Swagger

Esta API utiliza o Swagger para fornecer uma interface interativa e intuitiva para explorar e testar os endpoints. O Swagger facilita o entendimento das funcionalidades da API e permite que desenvolvedores integrem e consumam os serviços de forma mais eficiente.

### Recursos Disponíveis no Swagger
Visualização dos Endpoints: Explore os endpoints disponíveis, métodos HTTP suportados, e suas descrições.
Testes Interativos: Execute chamadas diretamente na interface para verificar o funcionamento dos endpoints.
Detalhamento de Modelos: Consulte os modelos de entrada e saída de dados para cada endpoint, incluindo validações e exemplos.

```bash
http://localhost:8080/swagger-ui.html
```
## Regras_de_negócio

O sistema de agendamento de consultas segue as regras abaixo para garantir o funcionamento adequado da clínica e evitar conflitos:

### Informações Necessárias para o Agendamento

- **Paciente:** Seleção de um paciente ativo cadastrado no sistema.
- **Médico:** Seleção de um médico ativo cadastrado no sistema.
- **Data/Hora da Consulta:** Definição de uma data e horário válidos.

### Regras de Funcionamento da Clínica

- O horário de funcionamento é de **segunda a sábado, das 07:00 às 19:00**.
- As consultas possuem uma duração fixa de **1 hora**.

### Validações no Agendamento

- As consultas devem ser agendadas com uma **antecedência mínima de 30 minutos**.
- **Pacientes inativos** não podem ter consultas agendadas.
- **Médicos inativos** não podem ter consultas agendadas.
- Um mesmo paciente não pode ter **mais de uma consulta no mesmo dia**.
- Um médico não pode ter mais de **uma consulta marcada para o mesmo horário**.

Essas regras asseguram a organização, eficiência e disponibilidade nos agendamentos realizados pela clínica.

## Contribuindo

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Faça um fork deste repositório.
2. Crie uma branch para sua feature ou correção de bug (`git checkout -b feature/nome-da-feature`).
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`).
4. Envie para a branch principal (`git push origin feature/nome-da-feature`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais informações.

