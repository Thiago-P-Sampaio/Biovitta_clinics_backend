package biovitta.com.clinics.DTOs;

import biovitta.com.clinics.entities.Consulta;

import java.time.LocalDateTime;

public class ConsultaDTO {

    private Long consultaId;
    private LocalDateTime dataConsulta;
    private String paciente;
    private String medico;

    public ConsultaDTO(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public ConsultaDTO() {
    }

    public ConsultaDTO(Consulta entity){
        consultaId = entity.getConsultaId();
        dataConsulta = entity.getDataConsulta();
        paciente = entity.getPaciente().getNome();
        medico = entity.getMedico().getNome();
    }

    public Long getConsultaId() {
        return consultaId;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }
}
