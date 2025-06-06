package biovitta.com.clinics.DTOs;

import biovitta.com.clinics.entities.Consulta;

import java.time.format.DateTimeFormatter;

public class ConsultaRelatorioDTO {

    private Long consultaId;
    private String dataConsulta;
    private String paciente;
    private String medico;

    public ConsultaRelatorioDTO(Long consultaId, String dataConsulta, String paciente, String medico) {
        this.consultaId = consultaId;
        this.dataConsulta = dataConsulta;
        this.paciente = paciente;
        this.medico = medico;
    }

    public ConsultaRelatorioDTO(Consulta consulta) {
        this.consultaId = consulta.getConsultaId();
        this.dataConsulta = consulta.getDataConsulta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.paciente = consulta.getPaciente().getNome();
        this.medico = consulta.getMedico().getNome();
    }

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }
}

