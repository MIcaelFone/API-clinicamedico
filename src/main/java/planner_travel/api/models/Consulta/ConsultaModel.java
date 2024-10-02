package planner_travel.api.models.Consulta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import planner_travel.api.models.medicos.MedicoModel;
import planner_travel.api.models.paciente.PacienteModel;

import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "consulta")
@Table(name = "Consulta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsultaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_paciente",referencedColumnName = "id")
    private PacienteModel pacienteModel;
    @ManyToOne
    @JoinColumn(name = "id_medico", referencedColumnName = "id")
    private MedicoModel medicoModel;
    @Column(name = "data_consulta")
    private LocalDateTime data_consulta;
}
