-- Altere a tabela 'consulta' para adicionar a coluna 'id_cancela' com o tipo correto
ALTER TABLE consulta
ADD COLUMN id_cancela BIGINT; -- Altere o tipo para corresponder a 'cancelaconsulta.id'

-- Adicione a chave estrangeira
ALTER TABLE consulta
ADD CONSTRAINT fk_cancelaconsulta FOREIGN KEY (id_cancela) REFERENCES cancelaconsulta(id);