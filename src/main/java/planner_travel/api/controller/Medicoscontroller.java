package planner_travel.api.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import planner_travel.api.DTO.medico.DadosCadastrarMedico;
import planner_travel.api.DTO.medico.DadosAtualizarMedico;
import planner_travel.api.service.MedicosService;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@Tag(name="Medico",description="API de Medico")
public class Medicoscontroller {

    @Autowired
    private MedicosService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar medico",description ="Descrição de medico")
    public void cadastrar(@RequestBody @Valid DadosCadastrarMedico dados){
       service.cadastrar(dados);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar medicos",description ="Lista todos médicos")
    public List<DadosCadastrarMedico> listar() {
        return service.listar();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualiza medicos",description ="Apenas nome,telefone,enderenco e especialidade são atualizados")
    public void atualizar(@RequestBody @Valid DadosAtualizarMedico dados, @PathVariable long id){
        service.atualizar(dados,id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar paciente" ,description = "Através do Id, paciente é removido")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

}
