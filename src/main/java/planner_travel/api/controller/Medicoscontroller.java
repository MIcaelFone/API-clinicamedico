package planner_travel.api.controller;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import planner_travel.api.DTO.DadosCadastrarMedico;
import planner_travel.api.medicos.Medico;
import planner_travel.api.medicos.MedicoRepository;
import planner_travel.api.DTO.DadosAtualizarMedico;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class Medicoscontroller {

    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastrarMedico dados){
        repository.save(new Medico(dados));
    }
    @GetMapping
    public List<DadosCadastrarMedico> listar() {
        return repository.findAll().stream().map(DadosCadastrarMedico::new).toList();
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedico dados){
        Medico medico = repository.getReferenceById(dados.id());
        medico.atualizar(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }

}
