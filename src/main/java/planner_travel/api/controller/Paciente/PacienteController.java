package planner_travel.api.controller.Paciente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import planner_travel.api.DTO.paciente.DadosAtualizarPaciente;
import planner_travel.api.DTO.paciente.DadosCadastrarPaciente;
import planner_travel.api.service.Paciente.PacientesService;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@Tag(name="Paciente",description="API de paciente")
public class PacienteController {
    @Autowired
    private PacientesService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar pacientes", description = "Obter uma lista com todas as informações dos pacientes cadastrados no sistema.")
    public List<DadosCadastrarPaciente> listarpaciente (){
        return service.Listar();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar paciente", description = "Registrar um novo paciente no sistema. Requer informações como nome, telefone, endereço e especialidade.")
    public void CadastrarPaciente(@RequestBody @Valid DadosCadastrarPaciente dados){
        service.cadastrar(dados);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar paciente", description = "Atualizar informações de um paciente existente. Apenas nome, telefone, endereço e especialidade podem ser modificados.")
    public void AtualizarPaciente(@RequestBody @Valid  DadosAtualizarPaciente dados, @PathVariable long id){
        service.atualizar(dados,id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar paciente", description = "Remove um paciente existente pelo ID.")
    public void DeletarPaciente(@PathVariable long id){
        service.Deletar(id);
    }
}
