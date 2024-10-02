package planner_travel.api.models.enderenco;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planner_travel.api.DTO.Enderenco.DadosEndereco;
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Enderenco {
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "uf")
    private String uf;
    @Column(name = "pais")
    private String pais;


    public Enderenco(@Valid  DadosEndereco dados){
          this.logradouro=dados.logradouro();
          this.cidade= dados.cidade();
          this.uf=dados.uf();
          this.pais=dados.pais();
    }

}
