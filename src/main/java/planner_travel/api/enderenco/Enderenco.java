package planner_travel.api.enderenco;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planner_travel.api.DTO.DadosEndereco;
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Enderenco {

    private String logradouro;
    private String cidade;
    private String uf;

    public Enderenco(@Valid  DadosEndereco dados){
          this.logradouro=dados.logradouro();
          this.cidade= dados.cidade();
          this.uf=dados.uf();
    }

}
