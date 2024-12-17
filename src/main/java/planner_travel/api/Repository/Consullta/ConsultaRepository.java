package planner_travel.api.Repository.Consullta;

import org.springframework.data.jpa.repository.JpaRepository;

import planner_travel.api.models.Consulta.ConsultaModel;
import planner_travel.api.models.paciente.PacienteModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<ConsultaModel,Long> {
    boolean existsByPacienteModelAndDataConsulta(Long id, LocalDate dataConsulta);
    boolean existsByidMedico(Long idMedico);
    boolean existsByIdMedicoAndHoraConsultaInicioAndDataConsulta(Long idMedico, LocalTime horaConsulta, LocalDate dataConsulta);

    List <ConsultaModel> findHoraConsultaInicioByIdMedicoAndDataConsulta(Long idMedico,LocalDate diaConsulta);
}


