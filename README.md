# 📚 Sistema Escolar - CRUD de Alunos e Professores (Java + MySQL)

Nesta atividade, desenvolvemos uma aplicação Java conectada a um banco de dados MySQL utilizando JDBC, aplicando o padrão de projeto DAO (Data Access Object).  

Esse padrão é utilizado para separar a lógica de acesso a dados da lógica de negócios da aplicação, tornando o código mais organizado, reutilizável e de fácil manutenção.

---

## 🛠️ Tecnologias utilizadas

- Java SE  
- JDBC  
- MySQL  
- MySQL Connector (Driver JDBC)  

---

## 📌 O que foi feito

### 🔌 Configuração da conexão com o MySQL
- Criamos a classe `MysqlConnection`, responsável por abrir a conexão com o banco de dados utilizando `DriverManager`.
- Adicionamos o driver JDBC do MySQL ao projeto.
- Configuramos corretamente a conexão com usuário, senha e URL do banco.

---

### 👨‍🎓 Criação da entidade Aluno
- Definimos a classe `Aluno`, que representa os registros da tabela `alunos` no banco de dados.
- A classe contém os atributos principais do aluno, como:
  - id  
  - nome  
  - email  
  - outros dados acadêmicos  

---

### 📁 Interface DAO (dao)
- Criamos a interface `IAlunoDAO`, contendo os métodos principais:
  - listar alunos  
  - buscar aluno por ID  
  - cadastrar aluno  
  - atualizar aluno  
  - excluir aluno  

---

### ⚙️ Implementação DAO (daoImpl)
- Implementamos a interface `IAlunoDAO` na classe `AlunoDAOImpl`.
- Utilizamos `PreparedStatement` e `ResultSet` para manipulação segura dos dados.
- Aplicamos boas práticas como `try-with-resources` para gerenciamento de conexões.

---

### ➕ Inserção e leitura de dados
- Criamos o método para cadastrar novos alunos no banco de dados.
- Implementamos a listagem de todos os alunos cadastrados.
- Adicionamos validação para exibir mensagem quando não houver alunos registrados.

---

## 🎯 Objetivo do projeto

O objetivo principal foi praticar:

- Conexão Java com MySQL
- Uso de JDBC
- Aplicação do padrão DAO
- Organização de código em camadas
- Operações CRUD (Create, Read, Update, Delete)

---

## 🚀 Melhorias futuras

- Implementar interface gráfica (JavaFX ou Swing)  
- Adicionar validações de dados  
- Criar relacionamento com outras entidades (ex: Turma)  
- Implementar API REST com Spring Boot  

---

## 🗄 Modelagem Banco de Dados
<br>
<img width="1536" height="1024" alt="modelagem" src="https://github.com/user-attachments/assets/0d3ff96a-7b8a-454a-80cf-af9d6c01382c" />

