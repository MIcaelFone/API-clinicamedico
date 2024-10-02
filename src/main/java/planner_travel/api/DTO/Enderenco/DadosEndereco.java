package planner_travel.api.DTO.Enderenco;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String cidade,

        String uf,

        String pais
) {

}
