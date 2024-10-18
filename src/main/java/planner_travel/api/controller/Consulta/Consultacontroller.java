package planner_travel.api.controller.Consulta;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import planner_travel.api.DTO.Consulta.DadosCadastrarConsulta;
import planner_travel.api.models.medicos.MedicoModel;
import planner_travel.api.models.paciente.PacienteModel;
import planner_travel.api.service.Consulta.ConsultaService;

@RestController
@RequestMapping("/consulta")
@Tag(name="Consulta",description="API de Consulta")
public class Consultacontroller {

    @Autowired
    public ConsultaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarConsulta(@Valid @RequestBody DadosCadastrarConsulta dados){
        service.cadastrarConsulta(dados);
    }

}
