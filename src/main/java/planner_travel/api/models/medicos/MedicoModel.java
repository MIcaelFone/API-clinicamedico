package planner_travel.api.models.medicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planner_travel.api.DTO.medico.DadosAtualizarMedico;
import planner_travel.api.DTO.medico.DadosCadastrarMedico;
import planner_travel.api.Enum.Especialidade;
import planner_travel.api.models.enderenco.Enderenco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class MedicoModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Enderenco endereco;

    public MedicoModel(DadosCadastrarMedico dados) {
        this.nome= dados.nome();
        this.crm=dados.crm();
        this.cpf=dados.cpf();
        this.endereco=dados.enderenco();
        this.especialidade=dados.especialidade();
    }

    public void atualizar(DadosAtualizarMedico dados) {
        if(dados.nome()!=null){
            this.nome=dados.nome();
        }
        else if(dados.telefone()!=null){
            this.cpf=dados.telefone();
        }
        else if(dados.endereco()!=null){
            this.endereco= new Enderenco(dados.endereco());
        }
        else if(dados.especialidade()!=null){
            this.especialidade=dados.especialidade();
        }
    }

}
