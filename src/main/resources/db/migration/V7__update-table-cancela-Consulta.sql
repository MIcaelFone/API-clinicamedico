ALTER TABLE cancelaconsulta
DROP FOREIGN KEY fk_consulta__cancelaconsulta;
ALTER TABLE cancelaconsulta
ADD CONSTRAINT fk_consulta__cancelaconsulta
FOREIGN KEY (id_consulta) REFERENCES consulta(id)
ON DELETE CASCADE;
