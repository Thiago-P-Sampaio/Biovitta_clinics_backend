package biovitta.com.clinics.DTOs;

import biovitta.com.clinics.entities.Consulta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaDTO {

    private Long consultaId;
    private LocalDateTime dataConsulta;
    private String paciente;
    private String medico;
    private String especialidades;

    public ConsultaDTO(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public ConsultaDTO() {
    }

    public ConsultaDTO(Consulta entity) {
        this.consultaId = entity.getConsultaId();
        this.dataConsulta = entity.getDataConsulta();
        this.paciente = entity.getPaciente().getNome();
        this.medico = entity.getMedico().getNome();
        this.especialidades = entity.getMedico().getEspecialidades();
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

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }
}
