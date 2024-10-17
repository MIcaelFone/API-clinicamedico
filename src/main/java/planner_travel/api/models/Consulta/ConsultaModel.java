package planner_travel.api.models.Consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import planner_travel.api.DTO.Consulta.DadosCadastrarConsulta;
import planner_travel.api.models.medicos.MedicoModel;
import planner_travel.api.models.paciente.PacienteModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name = "Consulta")
@Table(name = "consulta")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Data
public class ConsultaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_paciente")

    private  Long pacienteModel;
    @Column(name = "id_medico")
    private Long idMedico;
    @Column(name = "data_consulta")
    private LocalDate data_consulta;
    @Column(name = "hora_consulta")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime hora_consulta;

    public ConsultaModel(DadosCadastrarConsulta dados) {
        this.idMedico=dados.id_medicoModel();
        this.pacienteModel=dados.id_pacienteModel();
        this.hora_consulta= dados.hora_consulta();
        this.data_consulta=dados.data_consulta();
    }

}
