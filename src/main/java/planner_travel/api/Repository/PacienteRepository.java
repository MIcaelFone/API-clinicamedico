package planner_travel.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planner_travel.api.models.paciente.PacienteModel;

public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {
}
