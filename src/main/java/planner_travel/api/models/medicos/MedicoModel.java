package planner_travel.api.models.medicos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.*;
import planner_travel.api.DTO.medico.DadosAtualizarMedico;
import planner_travel.api.DTO.medico.DadosCadastrarMedico;
import planner_travel.api.Enum.Especialidade;
import planner_travel.api.models.enderenco.EnderencoModel;

@Entity
@Table(name = "medicos")
@AllArgsConstructor
@Data
public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    public String cpf;
    @Column(name = "crm")
    public String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private EnderencoModel enderenco;

    // Construtor padrão (necessário para o Hibernate)
    public MedicoModel() {
    }

    public MedicoModel(DadosCadastrarMedico dados) {
        this.nome = dados.nome();
        this.crm = dados.crm();
        this.cpf = dados.cpf();
        this.enderenco = dados.enderenco();
        this.especialidade = dados.especialidade();
    }

    public void atualizar(DadosAtualizarMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.endereco() != null) {
            this.enderenco = new EnderencoModel(dados.endereco());
        }
        if (dados.especialidade() != null) {
            this.especialidade = dados.especialidade();
        }
    }
}


