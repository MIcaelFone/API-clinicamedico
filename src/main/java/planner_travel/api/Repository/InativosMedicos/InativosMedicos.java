package planner_travel.api.Repository.InativosMedicos;

import org.springframework.data.jpa.repository.JpaRepository;
import planner_travel.api.models.InativoMedico.InativoMedicoModel;

public interface InativosMedicos extends JpaRepository<InativoMedicoModel, Long> {
}
