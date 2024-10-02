package planner_travel.api.models.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import planner_travel.api.DTO.paciente.DadosAtualizarPaciente;
import planner_travel.api.DTO.paciente.DadosCadastrarPaciente;
import planner_travel.api.models.enderenco.Enderenco;

@Entity(name = "paciente")
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    @Column(name = "nome")
    @UniqueElements
   private String nome;
    @Column(name = "email")
   private String email;
    @Column(name = "telefone")
   private String telefone;
    @Column(name = "CPF")
   private String CPF;
    @Embedded
   private Enderenco enderenco;

    public PacienteModel(DadosCadastrarPaciente dados) {
        nome=dados.nome();
        email=dados.email();
        telefone=dados.telefone();
        CPF=dados.CPF();
        enderenco=dados.endereco();
    }

    public void atualizar(DadosAtualizarPaciente dados) {
        nome=dados.nome();
        email=dados.email();
        telefone=dados.telefone();
        CPF=dados.CPF();
        enderenco=new Enderenco(dados.endereco());
    }
}

