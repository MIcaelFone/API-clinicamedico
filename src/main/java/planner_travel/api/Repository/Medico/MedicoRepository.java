package planner_travel.api.Repository.Medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planner_travel.api.models.medicos.MedicoModel;
@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel,Long> {
}
