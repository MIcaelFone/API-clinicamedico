package planner_travel.api.DTO;

import planner_travel.api.medicos.Especialidade;

public record DadosAtualizarMedico(long id, String nome, String crm, DadosEndereco endereco, Especialidade especialidade) {
}
