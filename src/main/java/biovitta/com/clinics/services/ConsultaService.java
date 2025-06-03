package biovitta.com.clinics.services;

import biovitta.com.clinics.DTOs.ConsultaDTO;
import biovitta.com.clinics.DTOs.PacienteConsultaDTO;
import biovitta.com.clinics.DTOs.PacienteDTO;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        public String deletarConsulta(Long id){
         consultaRepositorio.deleteById(id);
         return "Consulta deletada com sucesso!";
        }

        public List<ConsultaDTO> listarConsultas(){
            return consultaRepositorio.findAll()
                    .stream()
                    .map(ConsultaDTO::new)
                    .collect(Collectors.toList());
        }

        public ConsultaDTO buscarConsulta(Long id){
            Consulta consulta = consultaRepositorio.findById(id).
                    orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada com o  ID: " + id));
            return new ConsultaDTO(consulta);
        }

        public ConsultaDTO editarConsulta(ConsultaDTO dto, Long id){
            Consulta consulta = consultaRepositorio.findById(id).
                    orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada com o  ID: " + id));
            boolean  agendado = consultaRepositorio.existsByMedico_CrmAndDataConsulta(consulta.getMedico().getCrm(), dto.getDataConsulta());
            if(agendado){
                throw new  IllegalArgumentException("Data Indisponível");
            }
            consulta.setDataConsulta(dto.getDataConsulta());
            consulta = consultaRepositorio.save(consulta);
            return new ConsultaDTO(consulta);
        }

        @Transactional
        public PacienteConsultaDTO consultaPaciente(Long id){
            Paciente paciente = pacienteRepositorio.findById(id).
                    orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + id));

            return new PacienteConsultaDTO(paciente);
        }






}

