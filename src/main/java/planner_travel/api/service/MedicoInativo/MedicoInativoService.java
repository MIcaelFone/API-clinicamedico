package planner_travel.api.service.MedicoInativo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import planner_travel.api.DTO.InativoMedico.DadosCadastrarMedicoInativo;
import planner_travel.api.Repository.InativosMedicos.InativosMedicos;
import planner_travel.api.Repository.Medico.MedicoRepository;
import planner_travel.api.models.InativoMedico.InativoMedicoModel;
import planner_travel.api.models.medicos.MedicoModel;
import planner_travel.api.service.Medicos.MedicosService;
import planner_travel.api.service.PacienteInativo.PacienteInativoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoInativoService {
  @Autowired
  public InativosMedicos inativosMedicos;
  @Autowired
  public MedicoRepository medicoRepository;

  @Transactional
  public boolean IsDadosCadastrado(DadosCadastrarMedicoInativo dados) {
    inativosMedicos.save(new InativoMedicoModel(dados));
    return true;
  }

  @Transactional
  public boolean isDeletado(Long id) {
    inativosMedicos.deleteById(id);
    return true;
  }

  @Transactional
  public List<String> buscarNomesDeMedicosInativos() {
    List<String> lista = new ArrayList<>();

    inativosMedicos.findAll().forEach(medicoInativo -> {
      Long id = medicoInativo.getMedicoModel(); // Supondo que esse método retorna o ID.
      Optional<MedicoModel> medicoOptional = medicoRepository.findById(id);
      medicoOptional.ifPresent(medico -> {
        lista.add("Id do registro inatividade:"+id);
        String descricao="Nome do médico:" + medico.getNome();
        lista.add(descricao);
      });
    });
    return lista;
  }
}

