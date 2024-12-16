package planner_travel.api.controller.Medicos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import planner_travel.api.DTO.medico.DadosCadastrarMedico;
import planner_travel.api.DTO.medico.DadosAtualizarMedico;
import planner_travel.api.service.Medicos.MedicosService;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@Tag(name="Medico",description="API de Medico")
public class Medicoscontroller {

    @Autowired
    private MedicosService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar médico", description = "Registrar um novo médico no sistema. É necessário fornecer informações como nome, telefone, endereço e especialidade.")
    public void cadastrar(@RequestBody @Valid DadosCadastrarMedico dados){
       service.cadastrar(dados);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar médicos", description = "Obter uma lista com todos os médicos registrados no sistema.")
    public List<DadosCadastrarMedico> listar() {
        return service.listar();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar informações do médico", description = "Atualizar os dados de um médico existente no sistema. Apenas nome, telefone, endereço e especialidade podem ser alterados.")
    public void atualizar(@RequestBody @Valid DadosAtualizarMedico dados, @PathVariable long id){
        service.atualizar(dados,id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar médico", description = "Remover um médico do sistema com base no ID fornecido.")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

}
