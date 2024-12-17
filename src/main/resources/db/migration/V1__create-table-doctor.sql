 CREATE TABLE medicos (
     id BIGINT NOT NULL AUTO_INCREMENT,
     nome VARCHAR(150) NOT NULL,
     cpf CHAR(14) NOT NULL,
     crm VARCHAR(10) NOT NULL,
     especialidade VARCHAR(60) NOT NULL,
     logradouro VARCHAR(250) NOT NULL,
     cidade VARCHAR(50) NOT NULL,
     uf CHAR(2) NOT NULL,
     pais VARCHAR(30) NOT NULL,
     PRIMARY KEY (id)
 );

