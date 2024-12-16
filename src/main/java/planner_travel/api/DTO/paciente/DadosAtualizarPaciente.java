package planner_travel.api.DTO.paciente;

import planner_travel.api.DTO.Enderenco.DadosEndereco;

public record DadosAtualizarPaciente(
        long id,
        String nome,

        String telefone,

        DadosEndereco endereco) {
}
