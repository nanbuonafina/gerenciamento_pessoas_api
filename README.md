
# 🎓 Gerenciamento de Pessoas - Universidade

Este projeto é uma API REST desenvolvida com **Spring Boot** para o gerenciamento de pessoas de uma universidade. Ele permite cadastrar e consultar informações de pessoas armazenadas em um banco de dados MySQL.

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
  - Spring Web
  - Spring Data JPA
  - MySQL Driver
  - Lombok
- MySQL
- Maven

---

## 🧩 Estrutura do Projeto

```
gerenciamento-pessoas/
├── controller/
│   └── PessoaController.java       # Endpoints da API
├── dto/
│   └── PessoaDTO.java              # Objeto de transferência de dados
├── entity/
│   └── Pessoa.java                 # Entidade do banco
├── repository/
│   └── PessoaRepository.java       # Interface para acesso ao banco
├── GerenciamentoPessoasApplication.java # Classe principal
└── resources/
    └── application.properties      # Configuração da aplicação
```

---

## ⚙️ Configuração do Banco de Dados

1. **Crie o banco de dados** no MySQL com o seguinte comando:

```sql
CREATE DATABASE universidade_db;
```

2. **Configure o acesso ao banco** no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/universidade_db
spring.datasource.username=root
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

## ▶️ Como Executar

1. **Clone o repositório:**

```bash
git clone https://github.com/sua-conta/gerenciamento-pessoas.git
```

2. **Entre na pasta do projeto:**

```bash
cd gerenciamento-pessoas
```

3. **Execute a aplicação** via sua IDE (IntelliJ, VS Code, etc.) ou com o Maven:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:  
🔗 `http://localhost:8080`

---

## 📡 Endpoints da API

### ✅ Criar Pessoa

- **URL:** `POST /api/pessoas`
- **Descrição:** Cadastra uma nova pessoa.

#### Requisição

```json
POST http://localhost:8080/api/pessoas
Content-Type: application/json

{
  "nome": "Maria Oliveira",
  "cpf": "98765432100",
  "idade": 25
}
```

#### Resposta

```json
{
  "id": 1,
  "nome": "Maria Oliveira",
  "cpf": "98765432100",
  "idade": 25
}
```

---

### 🔍 Buscar Pessoa por ID

- **URL:** `GET /api/pessoas/{id}`
- **Descrição:** Retorna os dados de uma pessoa a partir do seu ID.

#### Exemplo de Requisição

```http
GET http://localhost:8080/api/pessoas/1
```

#### Resposta

```json
{
  "id": 1,
  "nome": "Maria Oliveira",
  "cpf": "98765432100",
  "idade": 25
}
```

#### Pessoa não encontrada

```http
404 Not Found
```

---

## 📄 Licença

Este projeto está licenciado sob a licença MIT.
