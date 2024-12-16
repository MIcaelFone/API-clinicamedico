package planner_travel.api.service.PacienteInativo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planner_travel.api.DTO.InativoMedico.DadosCadastrarMedicoInativo;
import planner_travel.api.DTO.InativoPaciente.DadosInativoPaciente;
import planner_travel.api.Repository.InativosMedicos.InativosMedicos;
import planner_travel.api.Repository.InativosPaciente.InativosPaciente;
import planner_travel.api.Repository.Medico.MedicoRepository;
import planner_travel.api.Repository.Paciente.PacienteRepository;
import planner_travel.api.models.InativoMedico.InativoMedicoModel;
import planner_travel.api.models.InativoPaciente.InativoPacienteModel;
import planner_travel.api.models.medicos.MedicoModel;
import planner_travel.api.models.paciente.PacienteModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteInativoService {
    @Autowired
    public InativosPaciente inativosPaciente;

    @Autowired
    public PacienteRepository pacienteRepository;

    @Transactional
    public boolean IsDadosCadastrado(DadosInativoPaciente dados){
        inativosPaciente.save(new InativoPacienteModel(dados));
        return true;
    }
    @Transactional
    public boolean isDeletado(Long id){
        inativosPaciente.deleteById(id);
        return  true;
    }
    @Transactional
    public List<String> retornandoDados(){
        List<String>lista=new ArrayList<>();
        inativosPaciente.findAll().forEach(inativo->{
            Long id=inativo.pacienteModel;
            Optional<PacienteModel> pacienteModel=pacienteRepository.findById(id);
            pacienteModel.ifPresent(pacienteModel1 -> {
                lista.add("Id do registro inatividade do paciente:"+id);
                String descricao="Nome do paciente:"+pacienteModel1.getNome();
                lista.add(descricao);
            });

        });
        return lista;
    }
}
