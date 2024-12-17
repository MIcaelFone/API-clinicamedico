 CREATE TABLE inativosPaciente (
     id BIGINT NOT NULL AUTO_INCREMENT,
     id_paciente BIGINT  NOT NULL UNIQUE,
     PRIMARY KEY (id),
     CONSTRAINT fk_inativosPaciente FOREIGN KEY (id_paciente) REFERENCES paciente(id)
 );