# Gerenciando as Rotas:

`http://localhost:8080/`

### Autenticação Controller: `/biovitta/auth`

- POST(login + token): http://localhost:8080/biovitta/auth/login

```JSON
{
  "usuario": "mariaclara.souza@example.com",
  "senha": "senhaSegura123"
}
   ```

### Resposta autenticação!
```JSON
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJiaW92aXR0YSIsInN1YiI6ImpvYW8ubGltYUBjbGluaWNhbWVkaWNhLmNvbSIsImV4cCI6MTc0OTYwMjI2MH0.CmqOa8qW9rcDDrDR1sbNEOa5cPeV30Q6lt5ITDZkjn4",
  "role": "MEDICO",
  "usuario": "joao.lima@clinicamedica.com"
}
```
- POST(registrar | paciente): http://localhost:8080/biovitta/auth/register

```JSON
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

#### -Paciente:
- POST(registrar paciente): http://localhost:8080/biovitta/api/usuario/paciente/add
```JSON
{
  "nome": "Maria Clara Souza",
  "email": "mariaclara.souza@example.com",
  "telefone": "(11) 91234-5678",
  "imgUrl": "https://example.com/imagens/mariaclara.jpg",
  "dataNascimento": "2001-08-15",
  "senha": "senhaSegura123"
}
   ```
- GET (todos pacientes): http://localhost:8080/biovitta/api/usuario/paciente/get/all
- GET (paciente por ID): http://localhost:8080/biovitta/api/usuario/paciente/get/{id}
- DELETE (paciente por ID): http://localhost:8080/biovitta'/api/usuario/paciente/dell/{id}'
- PUT(paciente por ID): http://localhost:8080/biovitta/api/usuario/paciente/edit/{id}

#### -Medico:
- POST(registrar médico ): http://localhost:8080/biovitta/api/usuario/medico/add

```JSON
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

##### -Usuário(ADM):
- POST(registrar adm): http://localhost:8080/biovitta/api/usuario/adm/add
```JSON
{
  "usuario": "admin123",
  "senha": "senhaSuperSegura!"
}
```

### Consulta Controller: `biovitta/api/consulta`
- POST(consulta):  http://localhost:8080/biovitta/api/consulta/add
```JSON
{
  "dataConsulta": "2025-06-10T14:30:00",
  "pacienteId": 1,
  "medicoId": "123456-SP"
}
```
- GET(consulta por paciente):  http://localhost:8080/biovitta/api/consulta/paciente/{id}
- GET( consultas por id): http://localhost:8080/biovitta/api/consulta/get/{id}
- GET ( todas as consultas): http://localhost:8080/biovitta/api/consulta/get/all
- PUT (atualizar consulta): http://localhost:8080/biovitta/api/consulta/edit/{id}
```JSON
{
"dataConsulta": "2025-06-10T14:30:00",
}
```
- DELETE (deletar consulta): http://localhost:8080/biovitta/api/consulta/dell/{id}


### Medico Controller: `biovitta/api/medicos`

- GET(todos médicos): http://localhost:8080/biovitta/api/usuario/medico/get/all
- GET(Médico por ID): http://localhost:8080/biovitta/api/usuario/medico/get/{crm}
- DELETE(Médico por ID): http://localhost:8080/biovitta/api/usuario/medico/dell/{crm}
- PUT(Médico por ID): http://localhost:8080/biovitta/api/usuario/medico/edit/{crm}


### Relatórios: `biovitta/api/relatorios`
- GET (consultas): http://localhost:8080/biovitta/api/relatorios/consultas

### Busca barra de pesquisa: `biovitta/api/usuario` 
- GET (buscar paciente | Barra de pesquisa): http://localhost:8080/biovitta/api/usuario/paciente/busca?nome=
- GET (buscar médico | Barra de pesquisa): http://localhost:8080/biovitta/api/usuario/medico/busca?nome=