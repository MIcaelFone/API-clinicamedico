package planner_travel.api.Repository.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planner_travel.api.models.paciente.PacienteModel;
@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {
}
