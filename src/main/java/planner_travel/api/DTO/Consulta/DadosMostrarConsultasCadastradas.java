package planner_travel.api.DTO.Consulta;

import jakarta.validation.constraints.NotNull;
import planner_travel.api.models.Consulta.ConsultaModel;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosMostrarConsultasCadastradas(
        Long id_paciente,
        Long id_medico,
        LocalDate data_consulta,
        LocalTime hora_consulta_inicio,
        LocalTime hora_consulta_final
) {
    public DadosMostrarConsultasCadastradas(ConsultaModel consultaModel) {
        this(consultaModel.getPacienteModel(),consultaModel.getIdMedico(),consultaModel.getDataConsulta(),consultaModel.getHoraConsultaInicio(),consultaModel.getHoraConsultaFinal());
    }
}
