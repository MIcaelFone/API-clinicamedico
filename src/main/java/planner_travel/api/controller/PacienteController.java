package planner_travel.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import planner_travel.api.DTO.paciente.DadosAtualizarPaciente;
import planner_travel.api.DTO.paciente.DadosCadastrarPaciente;
import planner_travel.api.service.PacientesService;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@Tag(name="Paciente",description="API de paciente")
public class PacienteController {
    @Autowired
    private PacientesService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar paciente" ,description = "Lista todos pacientes")
    public List<DadosCadastrarPaciente> listarpaciente (){
         return service.Listar();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar paciente" ,description = "Todos os dados são valor string,lembrando uf só aceita 3 valores ")
    public void CadastrarPaciente(@RequestBody @Valid DadosCadastrarPaciente dados){
        service.cadastrar(dados);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar paciente" ,description = "Nome,telefone,enderenco,especialidade são os únicos dados atualizados ")
    public void AtualizarPaciente(@RequestBody @Valid  DadosAtualizarPaciente dados, @PathVariable long id){
        service.atualizar(dados,id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar paciente" ,description = "Através do Id, paciente é removido")
    public void DeletarPaciente(@PathVariable long id){
        service.Deletar(id);
    }


}
