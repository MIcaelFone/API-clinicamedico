package planner_travel.api.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planner_travel.api.DTO.paciente.DadosAtualizarPaciente;
import planner_travel.api.DTO.paciente.DadosCadastrarPaciente;
import planner_travel.api.Repository.PacienteRepository;
import planner_travel.api.models.paciente.PacienteModel;

import java.util.List;

@Service
public class PacientesService {
    @Autowired
    private PacienteRepository repository;
    @Transactional
    public void cadastrar(DadosCadastrarPaciente dados){
         repository.save(new PacienteModel(dados));
    }
    @Transactional
    public void atualizar(DadosAtualizarPaciente dados,long id){
        PacienteModel paciente=repository.getReferenceById(id);
        paciente.atualizar(dados);
    }
    @Transactional
    public List<DadosCadastrarPaciente> Listar(){
        return repository.findAll().stream().map(DadosCadastrarPaciente::new).toList();
    }
    @Transactional
    public void Deletar(Long id){
        repository.deleteById(id);
    }

}
