package planner_travel.api.DTO.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import planner_travel.api.models.enderenco.Enderenco;
import planner_travel.api.Enum.Especialidade;
import planner_travel.api.models.medicos.MedicoModel;

public record DadosCadastrarMedico(
        @NotBlank
        String nome,
        @NotBlank
        String crm,
        @NotBlank
        String cpf,
        @NotNull
        Especialidade especialidade,
        Enderenco enderenco) {
    public DadosCadastrarMedico(MedicoModel medico) {
        this(medico.getNome(),medico.getCrm(),medico.getCpf(),medico.getEspecialidade(),medico.getEndereco());
    }

}