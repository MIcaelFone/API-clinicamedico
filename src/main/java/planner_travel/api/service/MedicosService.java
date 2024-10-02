package planner_travel.api.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planner_travel.api.DTO.medico.DadosAtualizarMedico;
import planner_travel.api.DTO.medico.DadosCadastrarMedico;
import planner_travel.api.models.medicos.MedicoModel;
import planner_travel.api.Repository.MedicoRepository;

import java.util.List;

@Service
public class MedicosService {
   @Autowired
   private MedicoRepository repository;
   @Transactional
   public void cadastrar(DadosCadastrarMedico dados){
      repository.save(new MedicoModel(dados));
   }
   @Transactional
   public void atualizar(DadosAtualizarMedico dados,long id){
     MedicoModel medico =repository.getReferenceById(id);
     medico.atualizar(dados);
   }
   @Transactional
   public void deletar(long id){
      repository.deleteById(id);
   }
   @Transactional
   public List<DadosCadastrarMedico> listar(){
      return repository.findAll().stream().map(DadosCadastrarMedico::new).toList();
   }

}
