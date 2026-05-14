# 📚 Sistema Escolar - CRUD de Alunos, Professores, Instituições e Turma (Java + MySQL)

Nesta atividade, desenvolvemos uma aplicação Java conectada a um banco de dados MySQL utilizando JDBC, aplicando o padrão de projeto DAO (Data Access Object).  

O sistema realiza operações CRUD completas para:

- 👨‍🎓 Alunos  
- 👨‍🏫 Professores  
- 🏫 Instituições  

O padrão DAO foi utilizado para separar a lógica de acesso aos dados da lógica principal da aplicação, deixando o código mais organizado, reutilizável e de fácil manutenção.

---
## 🗄️ Modelagem Banco de Dados

<br> <img width="1536" height="1024" alt="modelagem" src="https://github.com/user-attachments/assets/0d3ff96a-7b8a-454a-80cf-af9d6c01382c" />


---

# 📁 Estrutura do projeto

```bash
src/main/java
│
├── dao
│   ├── IAlunoDAO
│   ├── IProfessorDAO
│   └── IInstituicaoDAO
│
├── daoImplements
│   ├── AlunoDAOImplements
│   ├── ProfessorDAOImplements
│   └── InstituicaoDAOImplements
│
├── Database
│   └── sqlConn
│
├── model
│   ├── Aluno
│   ├── Professor
│   └── Instituicao
│
└── org.example
    └── App
```
---

# 🛠️ Tecnologias utilizadas

- Java
- JDBC  
- MySQL  
- Maven  
- MySQL Connector/J  

---

# 📌 Funcionalidades do sistema

## 👨‍🎓 CRUD de Alunos

O sistema permite:

- Cadastrar alunos
- Atualizar alunos
- Excluir alunos
- Listar todos os alunos
- Buscar aluno por ID

### Dados do aluno:
- ID
- Nome
- CPF
- Email
- Data de nascimento
- Telefone

---

## 👨‍🏫 CRUD de Professores

O sistema também possui gerenciamento completo de professores.

### Funcionalidades:
- Cadastrar professores
- Atualizar professores
- Excluir professores
- Listar professores
- Buscar professor por ID

### Dados do professor:
- ID
- Instituição vinculada
- Nome
- CPF
- Email
- Titulação

### Titulações disponíveis:
- GRADUACAO
- ESPECIALIZACAO
- MESTRADO
- DOUTORADO

---

## 🏫 CRUD de Instituições

Foi implementado o gerenciamento das instituições de ensino.

### Funcionalidades:
- Cadastrar instituições
- Atualizar instituições
- Excluir instituições
- Listar instituições
- Buscar instituição por ID

### Dados da instituição:
- ID
- Nome
- CNPJ
- Cidade
- Estado
- Email
- Telefone

---

# 🔌 Conexão com o banco de dados

Foi criada uma classe responsável pela conexão com o MySQL utilizando JDBC.

### Recursos utilizados:
- `DriverManager`
- `Connection`
---

## ⚙️ Conceitos aplicados

Durante o desenvolvimento do projeto foram praticados diversos conceitos importantes utilizados no desenvolvimento backend com Java:

- Programação Orientada a Objetos (POO)
- JDBC 
- CRUD (Create, Read, Update, Delete)
- DAO
- Manipulação de banco de dados com Java
- Tratamento de exceções
- Conexão com MySQL
- Boas práticas de código
