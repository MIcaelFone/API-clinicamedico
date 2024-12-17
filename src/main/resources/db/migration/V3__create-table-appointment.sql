 CREATE TABLE consulta (
     id BIGINT NOT NULL AUTO_INCREMENT,
     id_paciente BIGINT NOT NULL,
     id_medico BIGINT NULL,
     data_consulta_ DATE NOT NULL,
     hora_consulta_inicio TIME NOT NULL,
     hora_consulta_final TIME NOT NULL,
     PRIMARY KEY (id),
     CONSTRAINT fk_paciente FOREIGN KEY (id_paciente) REFERENCES paciente(id),
     CONSTRAINT fk_medico FOREIGN KEY (id_medico) REFERENCES medicos(id)
 );