package planner_travel.api.service.Consulta;

import jakarta.servlet.annotation.HttpConstraint;
import jakarta.transaction.Status;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.temporal.ChronoUnit;
import planner_travel.api.DTO.CancelaConsulta.ConsultaCancelaDTO;
import planner_travel.api.DTO.Consulta.DadosCadastrarConsulta;
import planner_travel.api.DTO.Consulta.DadosMostrarConsultasCadastradas;
import planner_travel.api.Repository.CancelarConsulta.CancelarConsulta;
import planner_travel.api.Repository.Consullta.ConsultaRepository;
import planner_travel.api.Repository.InativosMedicos.InativosMedicos;
import planner_travel.api.Repository.InativosPaciente.InativosPaciente;
import planner_travel.api.Repository.Medico.MedicoRepository;
import planner_travel.api.Repository.Paciente.PacienteRepository;
import planner_travel.api.models.CancelaConsulta.CancelaConsultaModel;
import planner_travel.api.models.Consulta.ConsultaModel;
import planner_travel.api.models.InativoMedico.InativoMedicoModel;
import planner_travel.api.models.InativoPaciente.InativoPacienteModel;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@Service
    public class ConsultaService {
     @Autowired
     public ConsultaRepository consultaRepository;
     @Autowired
     public CancelarConsulta cancelarConsulta;
     public ConsultaModel consultaModel;
     public DadosCadastrarConsulta dadosCadastrarConsulta;
     @Autowired
     public InativosMedicos inativosMedicos;
     @Autowired
     public InativosPaciente inativosPaciente;
     @Autowired
     public PacienteRepository pacienteRepository;
     @Autowired
     public MedicoRepository medicoRepository;

     public boolean isHorarioConsultaValido(LocalTime horaconsulta){
         LocalTime horarioInicial = LocalTime.of(07,00);
         LocalTime horarioFinal = LocalTime.of(19,00);
         return horaconsulta.isBefore(horarioFinal) && horaconsulta.isAfter(horarioInicial) ;
     }
     @Transactional
     public boolean isDiaValido( LocalDate data_consulta){
         LocalDate diaAtual=LocalDate.now();
         return ChronoUnit.DAYS.between(diaAtual,data_consulta) >= 0;
     }
     @Transactional
     public boolean isMarcarHorarioConsultaAntecedente30minutos(LocalTime horaconsulta,LocalDate diaconsulta) {
         LocalTime horaConsulta = horaconsulta;
         LocalTime now = LocalTime.now();
         Duration diferenca = Duration.between(now, horaConsulta);
         LocalDate diaatual = LocalDate.now();
         if (diaconsulta.equals(diaatual) && isHorarioConsultaValido(horaconsulta)) {
             return diferenca.toMinutes() >= 30;
         } else return diaconsulta.isAfter(diaatual) && isHorarioConsultaValido(horaconsulta);
     }
     @Transactional
     public boolean isMedicoInativo(Long id_medico)
     {
        Optional<InativoMedicoModel> inativosMedicos1=inativosMedicos.findById(id_medico);
        return inativosMedicos1.isPresent();
     }
    @Transactional
    public boolean isPacienteInativo(Long id_paciente)
    {
         Optional<InativoPacienteModel> inativoPaciente1=inativosPaciente.findById(id_paciente);
         return inativoPaciente1.isPresent();
    }
    @Transactional
    public boolean isPacienteAgendadoConsulta(Long id_paciente,LocalDate date)
    {
        return consultaRepository.existsByPacienteModelAndDataConsulta(id_paciente,date);
    }
    @Transactional
    public boolean isMedicoCadastradoNumaDataHora(Long idmedico, LocalTime hora_consulta, LocalDate date)
    {
        return consultaRepository.existsByIdMedicoAndHoraConsultaInicioAndDataConsulta(idmedico,hora_consulta,date);
    }

    @Transactional
    public boolean isMedicoEstaraDisponivel(Long idMedico, LocalTime horarioConsulta, LocalDate diaConsulta) {
        List<ConsultaModel> consultasDoDia = consultaRepository.findHoraConsultaInicioByIdMedicoAndDataConsulta(idMedico, diaConsulta);
        for (ConsultaModel consultaModel : consultasDoDia) {
            if (consultaModel.getHoraConsultaInicio() == null) {
                continue;
            }
            if (horarioConsulta.getHour()==consultaModel.getHoraConsultaInicio().getHour() || horarioConsulta.equals(consultaModel.getHoraConsultaFinal()) || horarioConsulta.isBefore(consultaModel.getHoraConsultaFinal()) ) {
                return false;
            }
        }
        return true;
    }
    @Transactional
    public boolean cadastrarConsulta(@Valid DadosCadastrarConsulta dados)
    {
        if(isMarcarHorarioConsultaAntecedente30minutos(dados.hora_consulta_inicio(),dados.data_consulta())&& isMedicoEstaraDisponivel(dados.id_medico(),dados.hora_consulta_inicio(),dados.data_consulta())  && !isMedicoInativo(dados.id_medico())
         && !isPacienteInativo(dados.id_paciente()) && !isPacienteAgendadoConsulta(dados.id_paciente(),dados.data_consulta()) && !isMedicoCadastradoNumaDataHora(dados.id_medico(),dados.hora_consulta_inicio(),dados.data_consulta())
         && isDiaValido(dados.data_consulta()))
         {
             consultaRepository.save(new ConsultaModel(dados));
             return true;
         }
         else {
            return false;
        }
    }
    @Transactional
    public List<ConsultaModel> listar()
    {
        return consultaRepository.findAll();
    }
    @Transactional
    public boolean isConsultaDeletada(Long id,ConsultaCancelaDTO cancelaConsulta)
    {
        cancelarConsulta.save(new CancelaConsultaModel(cancelaConsulta));
        ConsultaModel consulta=consultaRepository.getReferenceById(id);
        consulta.consultaCancelada(id);

        return true;
    }
}
