 CREATE TABLE paciente (
     id BIGINT NOT NULL AUTO_INCREMENT,
     nome VARCHAR(100) NOT NULL,
     email VARCHAR(13) NOT NULL,
     telefone VARCHAR(12) NOT NULL,
     CPF VARCHAR(100) NOT NULL,
     logradouro VARCHAR(20) NOT NULL,
     cidade VARCHAR(50) NOT NULL,
     uf VARCHAR(3) NOT NULL,
     PRIMARY KEY (id)
 );
