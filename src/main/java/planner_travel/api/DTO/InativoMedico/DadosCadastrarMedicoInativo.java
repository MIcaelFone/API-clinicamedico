package planner_travel.api.DTO.InativoMedico;

import jakarta.validation.constraints.NotNull;
import planner_travel.api.models.InativoMedico.InativoMedicoModel;

public record DadosCadastrarMedicoInativo(
        @NotNull
        Long id_medico
) {
    public DadosCadastrarMedicoInativo(InativoMedicoModel model){
        this(model.getId());
    }
}
