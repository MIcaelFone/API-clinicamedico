package planner_travel.api.DTO;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String cidade,
        @NotBlank
        String uf) {

}
