package planner_travel.api.controller.Medicoinativos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planner_travel.api.DTO.InativoMedico.DadosCadastrarMedicoInativo;
import planner_travel.api.models.InativoMedico.InativoMedicoModel;
import planner_travel.api.service.MedicoInativo.MedicoInativoService;

import java.util.List;

@RestController
@RequestMapping("/inativomedico")
@Tag(name="Inativo Medico",description="API de medico de inativo")
public class MedicoInativosController {
    @Autowired
    public MedicoInativoService service;
    @PostMapping
    @Operation(summary = "Cadastrar médico inativo", description = "Registrar um médico como inativo no sistema. Requer informações detalhadas do médico.")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> inserir(@Valid @RequestBody DadosCadastrarMedicoInativo dados){
      boolean Iscadastrado=service.IsDadosCadastrado(dados);
      if(Iscadastrado){
          return ResponseEntity.status(HttpStatus.CREATED).body("Médico inativo criado com sucesso.");
      }
      else{
          return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Médico inativo delatado com sucesso.");
      }
    }
    @DeleteMapping
    @Operation(summary = "Deletar médico inativo", description = "Remover um médico inativo do sistema com base no ID fornecido.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deletar(Long id){
        boolean deletado=service.isDeletado(id);
        if(deletado){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Médico inativo delatado com sucesso.");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Falha para deletar médico inativo.");
        }
    }
    @GetMapping
    @Operation(summary = "Listar médicos inativos", description = "Retornar uma lista com todos os médicos que estão registrados como inativos no sistema.")
    @ResponseStatus(HttpStatus.OK)
    public List<String> listar(){
        return service.buscarNomesDeMedicosInativos();
    }
}
