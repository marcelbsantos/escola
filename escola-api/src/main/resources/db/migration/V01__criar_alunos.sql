CREATE TABLE aluno (
  codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(60) NOT NULL,
  idade INT NOT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


--Insert Alunos
INSERT INTO aluno(nome, idade)VALUES("Marcos Antonio",12);
INSERT INTO aluno(nome, idade)VALUES("Maria de Paula",10);
INSERT INTO aluno(nome, idade)VALUES("Danilo Gomes",8);
INSERT INTO aluno(nome, idade)VALUES("Paulo Costa",10);
INSERT INTO aluno(nome, idade)VALUES("Adriana Santos",7);
INSERT INTO aluno(nome, idade)VALUES("Paula Sousa",11);