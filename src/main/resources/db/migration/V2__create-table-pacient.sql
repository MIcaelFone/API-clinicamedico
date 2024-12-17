CREATE TABLE paciente (
     id BIGINT NOT NULL AUTO_INCREMENT,
     nome VARCHAR(100) NOT NULL, -- Mantido, pois 100 caracteres é suficiente para um nome completo.
     email VARCHAR(100) NOT NULL, -- Alterado para 100, já que emails podem ser maiores que 13.
     telefone VARCHAR(15) NOT NULL, -- Alterado para 15, para incluir o formato com DDD e código internacional.
     CPF VARCHAR(14) NOT NULL, -- Alterado para 14, no formato "000.000.000-00".
     logradouro VARCHAR(100) NOT NULL, -- Alterado para 100, já que endereços podem ser longos.
     cidade VARCHAR(50) NOT NULL, -- Mantido, pois 50 caracteres é suficiente para a maioria dos nomes de cidades.
     uf CHAR(2) NOT NULL, -- Alterado para CHAR(2), já que UFs têm exatamente 2 caracteres.
     pais VARCHAR(50) NOT NULL, -- Alterado para 50, pois nomes de países podem ser maiores.
     PRIMARY KEY (id)
);
