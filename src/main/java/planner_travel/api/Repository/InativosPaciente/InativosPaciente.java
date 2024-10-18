package planner_travel.api.Repository.InativosPaciente;

import org.springframework.data.jpa.repository.JpaRepository;
import planner_travel.api.Repository.InativosMedicos.InativosMedicos;
import planner_travel.api.models.InativoPaciente.InativoPacienteModel;
import planner_travel.api.models.paciente.PacienteModel;

public interface InativosPaciente extends JpaRepository<InativoPacienteModel,Long> {
}
