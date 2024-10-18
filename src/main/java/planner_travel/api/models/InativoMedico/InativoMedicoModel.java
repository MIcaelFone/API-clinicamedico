package planner_travel.api.models.InativoMedico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planner_travel.api.models.medicos.MedicoModel;

@Table(name = "Inativomedicos")
@Entity(name = "inativoMedicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class InativoMedicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @ManyToOne
    @JoinColumn(name = "medico_id",nullable = false)
    public MedicoModel medicoModel;
}
