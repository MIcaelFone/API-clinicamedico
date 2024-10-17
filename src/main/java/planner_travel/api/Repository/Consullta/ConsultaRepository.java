package planner_travel.api.Repository.Consullta;

import org.springframework.data.jpa.repository.JpaRepository;
import planner_travel.api.models.Consulta.ConsultaModel;

public interface ConsultaRepository extends JpaRepository<ConsultaModel,Long> {
}
