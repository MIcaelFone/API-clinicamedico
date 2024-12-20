package planner_travel.api.controller.Consulta;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planner_travel.api.DTO.CancelaConsulta.ConsultaCancelaDTO;
import planner_travel.api.DTO.Consulta.DadosCadastrarConsulta;
import planner_travel.api.DTO.Consulta.DadosMostrarConsultasCadastradas;
import planner_travel.api.models.Consulta.ConsultaModel;
import planner_travel.api.models.medicos.MedicoModel;
import planner_travel.api.models.paciente.PacienteModel;
import planner_travel.api.service.Consulta.ConsultaService;

import java.util.List;

@RestController
@RequestMapping("/consulta")
@Tag(name="Consulta",description="API de Consulta")
public class Consultacontroller {

    @Autowired
    public ConsultaService service;

    @PostMapping
    @Operation(summary = "Cadastrar Consulta" ,description = "Cadastra uma nova consulta no sistema. É necessário fornecer os dados do paciente, médico, data e hora da consulta. A hora deve estar no formato HH:mm:ss.")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> cadastrarConsulta(@Valid @RequestBody DadosCadastrarConsulta dados){
         boolean success=service.cadastrarConsulta(dados);
         if(success){
             return ResponseEntity.status(HttpStatus.CREATED).body("Consulta marcada com sucesso");
         }
         else{
             return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Não foi possivel marcar consulta");
         }
    }
    @DeleteMapping
    @Operation(summary = "Deletar consulta" ,description = "Para deletar consulta precisa preencher motivo da cancelamento,id consulta,id medico")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deletarConsulta(@Valid @RequestBody ConsultaCancelaDTO dados){
        boolean deletar=service.isConsultaDeletada(dados.idconsulta(),dados);
        if(deletar) {
          return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("Consulta deletada com sucesso");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel deletar consulta ,verifique o id inserido");
        }
    }
    @GetMapping
    @Operation(summary = "Listar consultas" ,description  = "Retornar uma lista de todas as consultas registradas no sistema")
    public List<ConsultaModel> retornarConsulta(){
      List<ConsultaModel> dados=service.listar();
      if(dados.isEmpty()){
          ResponseEntity.status(HttpStatus.NO_CONTENT).body("Consultas retornadas vazias");
      }
      ResponseEntity.status(HttpStatus.OK).body("Consultas retornadas com sucesso.");
      return  dados;
    }
}
