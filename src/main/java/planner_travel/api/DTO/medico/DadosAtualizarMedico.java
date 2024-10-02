package planner_travel.api.DTO.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import planner_travel.api.DTO.Enderenco.DadosEndereco;
import planner_travel.api.Enum.Especialidade;

public record DadosAtualizarMedico(long id,
                                   @NotBlank
                                   String nome,
                                   @NotBlank
                                   String telefone,
                                   DadosEndereco endereco,
                                   @NotNull
                                   Especialidade especialidade) {
}
