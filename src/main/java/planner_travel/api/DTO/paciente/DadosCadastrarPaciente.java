package planner_travel.api.DTO.paciente;


import jakarta.validation.constraints.NotBlank;
import planner_travel.api.models.enderenco.EnderencoModel;
import planner_travel.api.models.paciente.PacienteModel;

public record DadosCadastrarPaciente(

        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        String CPF,

        EnderencoModel endereco) {

        public DadosCadastrarPaciente(PacienteModel paciente){
                this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(),paciente.getCPF(),paciente.getEnderenco());
        }

}
