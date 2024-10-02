package planner_travel.api.DTO.Consulta;

import jakarta.validation.constraints.NotNull;
import planner_travel.api.models.Consulta.ConsultaModel;
import planner_travel.api.models.medicos.MedicoModel;
import planner_travel.api.models.paciente.PacienteModel;

import java.time.LocalDateTime;

public record DadosCadastrarConsulta(
        @NotNull
        PacienteModel pacienteModel,

        MedicoModel medicoModel,
        @NotNull
        LocalDateTime data_consulta) {

    public DadosCadastrarConsulta(ConsultaModel consultaModel){
        this(consultaModel.getPacienteModel(),consultaModel.getMedicoModel(),consultaModel.getData_consulta());
    }
}

