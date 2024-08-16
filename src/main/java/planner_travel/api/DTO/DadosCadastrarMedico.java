package planner_travel.api.DTO;

import planner_travel.api.enderenco.Enderenco;
import planner_travel.api.medicos.Especialidade;
import planner_travel.api.medicos.Medico;

public record DadosCadastrarMedico(String nome, String crm, String cpf, Especialidade especialidade,Enderenco enderenco) {
    public DadosCadastrarMedico(Medico medico) {
        this(medico.getNome(),medico.getCrm(),medico.getCpf(),medico.getEspecialidade(),medico.getEndereco());
    }

}