CREATE TABLE cancelaconsulta (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_paciente BIGINT  NOT NULL,
    id_consulta BIGINT NOT NULL,
    motivo_cancelamento VARCHAR(300) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_paciente_cancelaconsulta FOREIGN KEY (id_paciente) REFERENCES paciente(id),
    CONSTRAINT fk_consulta__cancelaconsulta FOREIGN KEY (id_consulta) REFERENCES consulta(id)
)