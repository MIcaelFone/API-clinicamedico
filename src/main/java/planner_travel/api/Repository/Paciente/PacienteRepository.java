package planner_travel.api.Repository.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import planner_travel.api.models.paciente.PacienteModel;

public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {
}
