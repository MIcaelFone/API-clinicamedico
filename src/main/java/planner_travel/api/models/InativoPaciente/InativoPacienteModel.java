package planner_travel.api.models.InativoPaciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planner_travel.api.models.paciente.PacienteModel;
@Table(name = "inativoPaciente")
@Entity(name = "inativoPaciente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class InativoPacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @ManyToOne
    @JoinColumn(name = "id_paciente",nullable = false)
    public PacienteModel pacienteModel;

}
