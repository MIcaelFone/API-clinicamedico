 CREATE TABLE medicos (
     id BIGINT NOT NULL AUTO_INCREMENT,
     nome VARCHAR(100) NOT NULL,
     cpf VARCHAR(13) NOT NULL,
     crm VARCHAR(12) NOT NULL,
     especialidade VARCHAR(100) NOT NULL,
     logradouro VARCHAR(20) NOT NULL,
     cidade VARCHAR(50) NOT NULL,
     uf VARCHAR(3) NOT NULL,
     PRIMARY KEY (id)
 );
