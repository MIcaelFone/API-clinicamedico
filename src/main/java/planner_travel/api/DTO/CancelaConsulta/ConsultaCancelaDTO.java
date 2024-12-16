package planner_travel.api.DTO.CancelaConsulta;


import planner_travel.api.models.CancelaConsulta.CancelaConsultaModel;

public record ConsultaCancelaDTO(
        Long idconsulta,
        Long idpaciente,
        String motivo_cancelamento
) {
    public ConsultaCancelaDTO(CancelaConsultaModel cancelaConsultaModel){
        this(cancelaConsultaModel.getId_consulta(),cancelaConsultaModel.getId_paciente(),cancelaConsultaModel.getMotivo_cancelamento());
    }
}
