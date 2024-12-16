package planner_travel.api.controller.Pacienteinativos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planner_travel.api.DTO.InativoMedico.DadosCadastrarMedicoInativo;
import planner_travel.api.DTO.InativoPaciente.DadosInativoPaciente;
import planner_travel.api.DTO.paciente.DadosCadastrarPaciente;
import planner_travel.api.models.InativoMedico.InativoMedicoModel;
import planner_travel.api.models.InativoPaciente.InativoPacienteModel;
import planner_travel.api.service.MedicoInativo.MedicoInativoService;
import planner_travel.api.service.PacienteInativo.PacienteInativoService;

import java.util.List;

@RestController
@RequestMapping("/inativopaciente")
@Tag(name="Inativo paciente",description="API de paciente inativo")
public class PacienteInativosController {
    @Autowired
    public PacienteInativoService service;

    @PostMapping
    @Operation(summary = "Inserir paciente inativo", description = "Registrar um paciente como inativo no sistema. Requer informações detalhadas do paciente.")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> inserir(@Valid @RequestBody DadosInativoPaciente dados){
        boolean Iscadastrado=service.IsDadosCadastrado(dados);
        if(Iscadastrado){
            return ResponseEntity.status(HttpStatus.CREATED).body("Oaciente inativo criado com sucesso.");
        }
        else{
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Médico inativo delatado com sucesso.");
        }
    }
    @DeleteMapping
    @Operation(summary = "Deletar paciente inativo", description = "Remover um paciente inativo do sistema utilizando o ID.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deletar(Long id){
        boolean deletado=service.isDeletado(id);
        if(deletado){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Paciente inativo delatado com sucesso.");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Falha para deletar paciente inativo.");
        }
    }
    @GetMapping
    @Operation(summary = "Listar pacientes inativos", description = "Retornar uma lista de todos os pacientes que estão inativos no sistema.")
    @ResponseStatus(HttpStatus.OK)
    public List<String> listar(){
        return service.retornandoDados();
    }
}
