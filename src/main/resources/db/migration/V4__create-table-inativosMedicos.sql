 CREATE TABLE inativosMedicos (
     id BIGINT NOT NULL AUTO_INCREMENT,
     id_medico BIGINT  NOT NULL UNIQUE,
     PRIMARY KEY (id),
     CONSTRAINT fk_inativosMedicos FOREIGN KEY (id_medico) REFERENCES medicos(id)
 );