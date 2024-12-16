package planner_travel.api.Repository.CancelarConsulta;

import org.springframework.data.jpa.repository.JpaRepository;
import planner_travel.api.models.CancelaConsulta.CancelaConsultaModel;


public interface CancelarConsulta extends JpaRepository<CancelaConsultaModel,Long> {
}
