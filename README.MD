# Biovitta - API de Gestão de Clínicas

Este é o repositório do backend da aplicação Biovitta, um sistema robusto para a gestão eficiente de clínicas. Ele oferece funcionalidades completas para gerenciamento de pacientes, médicos, consultas e relatórios, visando otimizar os processos internos de estabelecimentos de saúde.

## Tecnologias Utilizadas

* **Java 21**: Linguagem de programação principal.
* **Spring Boot**: Framework para o desenvolvimento rápido e eficiente de aplicações Java.
* **JWT (JSON Web Tokens)**: Para autenticação e autorização seguras.
* **MySQL**: Banco de dados relacional para persistência de dados.
* **Maven**: Ferramenta de gerenciamento de projetos e dependências.


####

<div align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" height="40" alt="mysql logo"  />

  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/azure/azure-original.svg" height="40" alt="azure logo"  />

  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" height="40" alt="git logo"  />

  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" height="40" alt="github logo"  />

  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/npm/npm-original-wordmark.svg" height="40" alt="npm logo"  />

  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" alt="spring logo"  />

  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" alt="java logo"  />

  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" height="40" alt="intellij logo"  />

  <img src="https://cdn.simpleicons.org/netlify/00C7B7" height="40" alt="netlify logo"  />
</div>

###


## Como Clonar e Iniciar o Projeto

Siga os passos abaixo para configurar e executar o projeto em sua máquina local:

1.  **Clonar o Repositório:**

    ```bash
    git clone https://github.com/Thiago-P-Sampaio/Biovitta_clinics_backend.git
    ```

2.  **Configurar as Variáveis de Ambiente:**

    Antes de iniciar a aplicação, você precisa configurar as variáveis de ambiente no arquivo `src/main/resources/application.properties` ou em um dos perfis (`application-dv_home.properties`, `application-dv_work.properties`).

    As variáveis essenciais são:

    ```properties
    spring.profiles.active=${APP_PROFILE:dv_work}
    spring.application.name=clinics
    spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/clinics_dev}
    spring.datasource.username=${DB_USERNAME:root}
    spring.datasource.password=${DB_PASSWORD:3960}
    api.secret.token.secret=${SECRET_KEY:a34ebc}

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    ```

    * `spring.profiles.active`: Define o perfil de ambiente ativo (ex: `dv_work`, `dv_home`).
    * `spring.datasource.url`: URL de conexão com o banco de dados MySQL.
    * `spring.datasource.username`: Nome de usuário do banco de dados.
    * `spring.datasource.password`: Senha do banco de dados.
    * `api.secret.token.secret`: Chave secreta para a geração e validação de JWTs.

    **Recomendação:** Para um ambiente de desenvolvimento, você pode usar os valores padrão fornecidos. Para ambientes de produção, é altamente recomendável usar variáveis de ambiente do sistema operacional para essas configurações sensíveis.

3.  **Iniciar a Aplicação:**

    Navegue até a pasta raiz do projeto e execute o seguinte comando Maven:

    ```bash
    ./mvnw spring-boot:run
    ```

    Ou, se preferir usar um IDE como IntelliJ IDEA, importe o projeto Maven e execute a classe `ClinicsApplication.java`.

A API estará disponível em `http://localhost:8080/`.

## Estrutura de Pastas

O projeto segue uma estrutura de pastas organizada, típica de aplicações Spring Boot, para melhor modularidade e manutenção:

```
src
└── main
    └── java
        └── biovitta.com.clinics
            ├── config
            │   ├── AutorizacaoConfig.java
            │   └── FiltroSeguranca.java
            ├── controllers
            │   ├── AutenticacaoController.java
            │   ├── ConsultaController.java
            │   ├── MedicoController.java
            │   ├── RelatorioController.java
            │   └── UsuarioController.java
            ├── DTOs
            │   ├── cadastro
            │   │   ├── ConsultaRequestDTO.java
            │   │   ├── MedicoRequestDTO.java
            │   │   └── PacienteRequestDTO.java
            │   └── login
            │       ├── AutenticacaoDTO.java
            │       ├── BuscarUsuarioLogadoDTO.java
            │       ├── RespostaAutenticacaoDTO.java
            │       ├── ConsultaDTO.java
            │       ├── ConsultaRelatorioDTO.java
            │       ├── MedicoDTO.java
            │       ├── PacienteConsultaDTO.java
            │       ├── PacienteDTO.java
            │       └── UsuarioDTO.java
            ├── entities
            │   ├── Consulta.java
            │   ├── Medico.java
            │   ├── Paciente.java
            │   ├── Permissao.java
            │   └── Usuario.java
            ├── repositories
            │   ├── ConsultaRepositorio.java
            │   ├── MedicoRepositorio.java
            │   ├── PacienteRepositorio.java
            │   └── UsuarioRepositorio.java
            └── services
                ├── autenticacao
                │   ├── ConsultaService.java
                │   ├── MedicoService.java
                │   ├── PacienteService.java
                │   ├── RelatorioService.java
                │   └── UsuarioService.java
                └── ClinicsApplication.java
    └── resources
        ├── relatorio
        │   └── relatorio_consultas.jrxml
        ├── static
        ├── templates
        ├── application.properties
        ├── application-dv_home.properties
        └── application-dv_work.properties
```

* **`config`**: Contém classes de configuração da aplicação, incluindo configurações de segurança.
* **`controllers`**: Responsável por expor os endpoints da API e lidar com as requisições HTTP.
* **`DTOs`**: Data Transfer Objects, utilizados para transferir dados entre camadas da aplicação, com separação entre DTOs de cadastro e DTOs de login/resposta.
* **`entities`**: Define as entidades do banco de dados, mapeando as tabelas e seus relacionamentos.
* **`repositories`**: Interfaces para acesso a dados, utilizando Spring Data JPA para interagir com o banco de dados.
* **`services`**: Contém a lógica de negócio da aplicação, orquestrando as operações e interagindo com os repositórios.
* **`resources`**: Inclui arquivos de configuração, templates de relatório e recursos estáticos.

## Rotas e Respostas Comuns

As rotas da API são acessíveis a partir da base `http://localhost:8080/`.

### Autenticação Controller: `/biovitta/auth`

* **POST (Login e Geração de Token):** `http://localhost:8080/biovitta/auth/login`
  ```json
  {
    "usuario": "mariaclara.souza@example.com",
    "senha": "senhaSegura123"
  }
  ```
  **Resposta:**
  ```json
  {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJiaW92aXR0YSIsInN1YiI6ImpvYW8ubGltYUBjbGluaWNhbWVkaWNhLmNvbSIsImV4cCI6MTc0OTYwMjI2MH0.CmqOa8qW9rcDDrDR1sbNEa5cPeV30Q6lt5ITDZkjn4",
    "role": "MEDICO",
    "usuario": "joao.lima@clinicamedica.com"
  }
  ```
* **POST (Registrar Paciente):** `http://localhost:8080/biovitta/auth/register`
  ```json
  {
    "nome": "Maria Clara Souza",
    "email": "mariaclara.souza@example.com",
    "telefone": "(11) 91234-5678",
    "imgUrl": "https://example.com/imagens/mariaclara.jpg",
    "dataNascimento": "2001-08-15",
    "senha": "senhaSegura123"
  }
  ```

### Usuario Controller: `biovitta/api/usuario`

#### Paciente:

* **POST (Registrar Paciente):** `http://localhost:8080/biovitta/api/usuario/paciente/add`
  ```json
  {
    "nome": "Maria Clara Souza",
    "email": "mariaclara.souza@example.com",
    "telefone": "(11) 91234-5678",
    "imgUrl": "https://example.com/imagens/mariaclara.jpg",
    "dataNascimento": "2001-08-15",
    "senha": "senhaSegura123"
  }
  ```
* **GET (Todos os Pacientes):** `http://localhost:8080/biovitta/api/usuario/paciente/get/all`
* **GET (Paciente por ID):** `http://localhost:8080/biovitta/api/usuario/paciente/get/{id}`
* **DELETE (Paciente por ID):** `http://localhost:8080/biovitta/api/usuario/paciente/dell/{id}`
* **PUT (Atualizar Paciente por ID):** `http://localhost:8080/biovitta/api/usuario/paciente/edit/{id}`

#### Médico:

* **POST (Registrar Médico):** `http://localhost:8080/biovitta/api/usuario/medico/add`
  ```json
  {
    "crm": "123456-SP",
    "nome": "Dr. João Pedro Lima",
    "email": "joao.lima@clinicamedica.com",
    "telefone": "(11) 99876-5432",
    "imgUrl": "https://example.com/imagens/joaopedro.jpg",
    "senha": "medicoForte2025",
    "especialidades": "cardiologista"
  }
  ```

#### Usuário (ADM):

* **POST (Registrar ADM):** `http://localhost:8080/biovitta/api/usuario/adm/add`
  ```json
  {
    "usuario": "admin123",
    "senha": "senhaSuperSegura!"
  }
  ```

### Consulta Controller: `biovitta/api/consulta`

* **POST (Registrar Consulta):** `http://localhost:8080/biovitta/api/consulta/add`
  ```json
  {
    "dataConsulta": "2025-06-10T14:30:00",
    "pacienteId": 1,
    "medicoId": "123456-SP"
  }
  ```
* **GET (Consultas por Paciente):** `http://localhost:8080/biovitta/api/consulta/paciente/{id}`
* **GET (Consultas por ID):** `http://localhost:8080/biovitta/api/consulta/get/{id}`
* **GET (Todas as Consultas):** `http://localhost:8080/biovitta/api/consulta/get/all`
* **PUT (Atualizar Consulta):** `http://localhost:8080/biovitta/api/consulta/edit/{id}`
  ```json
  {
  "dataConsulta": "2025-06-10T14:30:00"
  }
  ```
* **DELETE (Deletar Consulta):** `http://localhost:8080/biovitta/api/consulta/dell/{id}`

### Medico Controller: `biovitta/api/medicos`

* **GET (Todos os Médicos):** `http://localhost:8080/biovitta/api/usuario/medico/get/all`
* **GET (Médico por ID - CRM):** `http://localhost:8080/biovitta/api/usuario/medico/get/{crm}`
* **DELETE (Médico por ID - CRM):** `http://localhost:8080/biovitta/api/usuario/medico/dell/{crm}`
* **PUT (Atualizar Médico por ID - CRM):** `http://localhost:8080/biovitta/api/usuario/medico/edit/{crm}`

### Relatórios: `biovitta/api/relatorios`

* **GET (Relatório de Consultas):** `http://localhost:8080/biovitta/api/relatorios/consultas`

### Busca (Barra de Pesquisa): `biovitta/api/usuario`

* **GET (Buscar Paciente por Nome):** `http://localhost:8080/biovitta/api/usuario/paciente/busca?nome={nome}`
* **GET (Buscar Médico por Nome):** `http://localhost:8080/biovitta/api/usuario/medico/busca?nome={nome}`

## Deploy

A aplicação Biovitta está implantada nos seguintes ambientes:

* **Backend (Azure for Students):** [https://biovitta.azurewebsites.net/](https://biovitta.azurewebsites.net/)
* **Frontend (Netlify):** [https://biovitta.netlify.app/login](https://biovitta.netlify.app/login)

---

<table align="center">
  <tr>
    <td align="center">
      <a href="https://github.com/Thiago-P-Sampaio/Biovitta_clinics_frontend.git">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/react/react-original.svg" width="100px;" alt="Foto"/><br>
        <sub>
          <b>Repositório Front-End</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Thiago-P-Sampaio/Biovitta_clinics_app.git">
        <img src="https://cdn.simpleicons.org/android/3DDC84" width="100px;" alt="Foto"/><br>
        <sub>
          <b>Repositório REACT-MOBILE</b>
        </sub>
      </a>
    </td>
    </tr>
    </table>