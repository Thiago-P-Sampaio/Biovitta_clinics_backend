package biovitta.com.clinics.services;

import biovitta.com.clinics.DTOs.cadastro.ConsultaRequestDTO;
import biovitta.com.clinics.entities.Consulta;
import biovitta.com.clinics.entities.Medico;
import biovitta.com.clinics.entities.Paciente;
import biovitta.com.clinics.repositories.ConsultaRepositorio;
import biovitta.com.clinics.repositories.MedicoRepositorio;
import biovitta.com.clinics.repositories.PacienteRepositorio;
import biovitta.com.clinics.repositories.UsuarioRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepositorio consultaRepositorio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    PacienteRepositorio pacienteRepositorio;

    @Autowired
    MedicoRepositorio  medicoRepositorio;

    public ConsultaRequestDTO adicionarConsulta(ConsultaRequestDTO dto){
        Paciente paciente = pacienteRepositorio.getReferenceById(dto.getPacienteId());
        Medico medico = medicoRepositorio.getReferenceById(dto.getMedicoId());


        pacienteRepositorio.findById(dto.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        medicoRepositorio.findById(dto.getMedicoId())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));

        boolean  agendado = consultaRepositorio.existsByMedico_CrmAndDataConsulta(dto.getMedicoId(), dto.getDataConsulta());
        if(agendado){
            throw new  IllegalArgumentException("Data Indisponível");
        }

        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataConsulta(dto.getDataConsulta());

        consulta = consultaRepositorio.save(consulta);

        return  new ConsultaRequestDTO(consulta);
}




}
