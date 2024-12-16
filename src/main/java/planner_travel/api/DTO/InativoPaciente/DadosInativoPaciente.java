package planner_travel.api.DTO.InativoPaciente;

import jakarta.validation.constraints.NotNull;
import planner_travel.api.models.InativoPaciente.InativoPacienteModel;

public record DadosInativoPaciente(
        @NotNull
        Long id_Paciente
) {
    public DadosInativoPaciente(InativoPacienteModel model){
        this(model.pacienteModel);
    }
}
