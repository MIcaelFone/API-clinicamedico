package planner_travel.api.models.InativoMedico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planner_travel.api.DTO.InativoMedico.DadosCadastrarMedicoInativo;
import planner_travel.api.models.medicos.MedicoModel;

@Table(name = "Inativosmedicos")
@Entity(name = "inativosMedicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InativoMedicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "id_medico",nullable = false)
    public Long medicoModel;

    public InativoMedicoModel(DadosCadastrarMedicoInativo dados) {

        this.medicoModel=dados.id_medico();
    }
}
