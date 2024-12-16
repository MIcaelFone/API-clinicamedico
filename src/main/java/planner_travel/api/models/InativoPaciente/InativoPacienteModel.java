package planner_travel.api.models.InativoPaciente;

import jakarta.persistence.*;
import lombok.*;
import planner_travel.api.DTO.InativoPaciente.DadosInativoPaciente;
import planner_travel.api.models.paciente.PacienteModel;
@Table(name = "inativospaciente")
@Entity(name = "inativoPaciente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class InativoPacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "id_paciente",nullable = false)
    public Long pacienteModel;

    public InativoPacienteModel(DadosInativoPaciente dadosInativoPaciente) {
        this.pacienteModel = dadosInativoPaciente.id_Paciente();
    }
}
