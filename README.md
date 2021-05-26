# escola
Aplicação teste de uma API Rest


Segue a aplicação REST como exemplo prático. 

Fiz uma aplicação chamada Escola, onde disponibilizo métodos para criar, deletar, atualizar e buscar alunos.

Implementada através do Spring Boot.
IDE: sts Tools(Eclipse do Spring)
Banco de dados: MySql

Dentro da aplicação tem um arquivo chamado "application.properties" onde consta usuário, senha e o nome do banco de dados. Você poderá alterar de acordo com seus dados do banco MySql.

Segue as urls para teste(JSON), usei Postman para realizar os testes:
- Listar Alunos (GET)
localhost:8080/alunos

- Criar Aluno (Post)
localhost:8080/alunos
{
    "nome" : "Nome do Aluno",
    "idade" : 12
}

- Deletar Aluno(DELETE)
localhost:8080/alunos/9 - código do aluno

- Atualizar Aluno(PUT)
localhost:8080/alunos/8  - código do aluno que quer atualizar
{
    "nome": "Novo Nome",
    "idade": nova idade
}

- Buscar Aluno pelo Código(GET)
localhost:8080/alunos/1 - código do aluno 
