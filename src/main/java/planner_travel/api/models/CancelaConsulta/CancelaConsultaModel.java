package planner_travel.api.models.CancelaConsulta;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import planner_travel.api.DTO.CancelaConsulta.ConsultaCancelaDTO;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Table(name = "cancelaconsulta")
@Data
@Getter
public class CancelaConsultaModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "id_consulta")
  private Long id_consulta;
  @Column(name = "id_paciente")
  private Long id_paciente;
  @Column(name = "motivo_Cancelamento")
  private String motivo_cancelamento;

  public CancelaConsultaModel( ConsultaCancelaDTO cancelaDTO) {
    this.id_consulta = cancelaDTO.idconsulta();
    this.id_paciente = cancelaDTO.idpaciente();
    this.motivo_cancelamento=cancelaDTO.motivo_cancelamento();
  }
}

