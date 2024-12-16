package planner_travel.api.models.Consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import planner_travel.api.DTO.Consulta.DadosCadastrarConsulta;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name = "Consulta")
@Table(name = "consulta")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_paciente")
    private Long pacienteModel;

    @Column(name = "id_medico")
    private Long idMedico;

    @Column(name = "data_consulta")
    private LocalDate dataConsulta;

    @Column(name = "hora_consulta_inicio")
    private LocalTime horaConsultaInicio;

    @Column(name = "hora_consulta_final")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horaConsultaFinal;
    @Column(name = "id_cancela")
    private Long idConsultaCancelada;

    public ConsultaModel(DadosCadastrarConsulta dados) {
        this.idMedico = dados.id_medico();
        this.pacienteModel = dados.id_paciente();
        this.horaConsultaInicio = dados.hora_consulta_inicio();
        this.horaConsultaFinal = (dados.hora_consulta_inicio() != null) ? dados.hora_consulta_inicio().plusHours(1) : null;
        this.dataConsulta = dados.data_consulta();
    }
    public void consultaCancelada(Long id){
          this.idConsultaCancelada=id;
    }
}
