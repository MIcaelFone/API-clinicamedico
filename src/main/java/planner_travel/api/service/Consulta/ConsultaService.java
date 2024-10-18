package planner_travel.api.service.Consulta;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import planner_travel.api.DTO.Consulta.DadosCadastrarConsulta;
import planner_travel.api.DTO.medico.DadosCadastrarMedico;
import planner_travel.api.Repository.Consullta.ConsultaRepository;
import planner_travel.api.Repository.InativosMedicos.InativosMedicos;
import planner_travel.api.Repository.InativosPaciente.InativosPaciente;
import planner_travel.api.Repository.Medico.MedicoRepository;
import planner_travel.api.models.Consulta.ConsultaModel;
import planner_travel.api.models.InativoMedico.InativoMedicoModel;
import planner_travel.api.models.InativoPaciente.InativoPacienteModel;
import planner_travel.api.models.medicos.MedicoModel;
import planner_travel.api.models.paciente.PacienteModel;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class ConsultaService {
     @Autowired
     public ConsultaRepository consultaRepository;

    public ConsultaModel consultaModel;
     public DadosCadastrarConsulta dadosCadastrarConsulta;
     @Autowired
     public InativosMedicos inativosMedicos;
    @Autowired
    public InativosPaciente inativosPaciente;

     public boolean isHorarioConsultaValido(@Valid @RequestBody DadosCadastrarConsulta dadosCadastrarConsulta){
         String horaInicio="07:00";
         String horaFinal="19:00";
         LocalTime horarioInicial = LocalTime.parse(horaInicio);
         LocalTime horarioFinal = LocalTime.parse(horaFinal);
         LocalTime horaConsulta= dadosCadastrarConsulta.hora_consulta();
         return horaConsulta.isBefore(horarioFinal) && horaConsulta.isAfter(horarioInicial);
     }
     @Transactional
     public boolean isMarcarHorarioConsultaAntecedente30minutos(@Valid @RequestBody DadosCadastrarConsulta dadosCadastrarConsulta){
         Date dataHoraAtual = new Date();
         LocalTime horaConsulta= LocalTime.from(dadosCadastrarConsulta.hora_consulta());
         System.out.println(horaConsulta);
         LocalTime now = LocalTime.now();
         Duration diferenca= Duration.between(horaConsulta,now);
         return diferenca.toMinutes() >= 30;
     }
    @Transactional
     public boolean isMedicoInativo(Long id_medico){
        Optional<InativoMedicoModel> inativosMedicos1=inativosMedicos.findById(id_medico);
        return inativosMedicos1.isPresent();
     }
    @Transactional
     public boolean isPacienteInativo(Long id_paciente){
         Optional<InativoPacienteModel> inativoPaciente1=inativosPaciente.findById(id_paciente);
         return inativoPaciente1.isPresent();
     }
     @Transactional
     public void cadastrarConsulta(@Valid @RequestBody DadosCadastrarConsulta dados){
         consultaRepository.save(new ConsultaModel(dados));
         if(isMarcarHorarioConsultaAntecedente30minutos(dados) &&
             isHorarioConsultaValido(dados) && !isMedicoInativo(dados.id_medicoModel()) && !isPacienteInativo(dados.id_pacienteModel())) {
             System.out.println("Entrou aqui");
             consultaRepository.save(new ConsultaModel(dados));
         }
     }
    @Transactional
    public List<DadosCadastrarConsulta> listar(){
        return consultaRepository.findAll().stream().map(DadosCadastrarConsulta::new).toList();
    }


}

