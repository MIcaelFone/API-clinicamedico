package planner_travel.api.DTO.Consulta;

import jakarta.validation.constraints.NotNull;
import planner_travel.api.models.Consulta.ConsultaModel;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

public record DadosCadastrarConsulta(
        @NotNull
        Long id_pacienteModel,

        Long id_medicoModel,
        @NotNull
        LocalDate data_consulta,
        @NotNull
        LocalTime hora_consulta
        ) {

    public DadosCadastrarConsulta(ConsultaModel consultaModel){
        this(consultaModel.getPacienteModel(),consultaModel.getIdMedico(),consultaModel.getData_consulta(),consultaModel.getHora_consulta());
    }
}

