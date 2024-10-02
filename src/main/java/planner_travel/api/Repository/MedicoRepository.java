package planner_travel.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planner_travel.api.models.medicos.MedicoModel;

public interface MedicoRepository extends JpaRepository<MedicoModel,Long> {
}
