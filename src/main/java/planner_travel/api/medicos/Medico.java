package planner_travel.api.medicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planner_travel.api.DTO.DadosAtualizarMedico;
import planner_travel.api.DTO.DadosCadastrarMedico;
import planner_travel.api.enderenco.Enderenco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Enderenco endereco;

    public Medico(DadosCadastrarMedico dados) {
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
        else if(dados.crm()!=null){
            this.cpf=dados.crm();
        }
        else if(dados.endereco()!=null){
            this.endereco= new Enderenco(dados.endereco());
        }
        else if(dados.especialidade()!=null){
            this.especialidade=dados.especialidade();
        }
    }

}
