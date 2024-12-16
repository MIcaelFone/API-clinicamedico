package planner_travel.api.models.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import planner_travel.api.DTO.Consulta.DadosCadastrarConsulta;
import planner_travel.api.DTO.paciente.DadosAtualizarPaciente;
import planner_travel.api.DTO.paciente.DadosCadastrarPaciente;
import planner_travel.api.models.enderenco.EnderencoModel;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    @Column(name = "nome",unique = true)
   private String nome;
    @Column(name = "email")
   private String email;
    @Column(name = "telefone")
   private String telefone;
    @Column(name = "CPF")
   private String CPF;
    @Embedded
   private EnderencoModel enderenco;

    public PacienteModel(DadosCadastrarPaciente dados) {
        this.nome=dados.nome();
        this.email=dados.email();
        this.telefone=dados.telefone();
        this.CPF=dados.CPF();
        this.enderenco=dados.endereco();
    }




    public void atualizar(DadosAtualizarPaciente dados) {
        nome=dados.nome();
        telefone=dados.telefone();
        enderenco=new EnderencoModel(dados.endereco());
    }
}

