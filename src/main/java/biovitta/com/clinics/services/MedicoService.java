package biovitta.com.clinics.services;


import biovitta.com.clinics.DTOs.MedicoDTO;
import biovitta.com.clinics.DTOs.PacienteDTO;
import biovitta.com.clinics.DTOs.cadastro.MedicoRequestDTO;
import biovitta.com.clinics.entities.Medico;
import biovitta.com.clinics.entities.Paciente;
import biovitta.com.clinics.entities.Usuario;
import biovitta.com.clinics.repositories.MedicoRepositorio;
import biovitta.com.clinics.repositories.UsuarioRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    MedicoRepositorio medicoRepositorio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    PasswordEncoder config;


    @Transactional
    public MedicoDTO editarMedico(MedicoRequestDTO dto,  String crm){
        Medico medico = medicoRepositorio.findById(crm).
                orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com CRM: " + crm));
        Optional.ofNullable(dto.getCrm())
                .filter(s -> !s.isBlank())
                .ifPresent(medico::setCrm);

        Optional.ofNullable(dto.getNome())
                .filter(s -> !s.isBlank())
                .ifPresent(medico::setNome);

        Optional.ofNullable(dto.getEmail())
                .filter(s -> !s.isBlank())
                .ifPresent(medico::setEmail);

        Optional.ofNullable(dto.getTelefone())
                .filter(s -> !s.isBlank())
                .ifPresent(medico::setTelefone);

        Optional.ofNullable(dto.getImgUrl())
                .filter(s -> !s.isBlank())
                .ifPresent(medico::setImgUrl);

        medico = medicoRepositorio.save(medico);

        Usuario usuario = medicoRepositorio.findByEmail(dto.getEmail());
        Optional.ofNullable(dto.getSenha())
                .filter(s -> !s.isBlank())
                .map(config::encode)
                .ifPresent(usuario::setSenha);

        usuario = usuarioRepositorio.save(usuario);

        return new MedicoDTO(medico);


    }

    public List<MedicoDTO> listarMedicos(){
        return medicoRepositorio.findAll()
                .stream()
                .map(MedicoDTO::new)
                .collect(Collectors.toList());
    }

    public MedicoDTO buscarMedico(String crm){
        Medico medico = medicoRepositorio.findById(crm).
                orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com CRM: " + crm));
        return new MedicoDTO(medico);
    }

    public  String deletarMedico(String crm){
        Medico medico = medicoRepositorio.findById(crm).
                orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com CRM: " + crm));

        usuarioRepositorio.deleteById(medico.getUsuario().getUsuarioId());
        medicoRepositorio.deleteById(crm);

        return "Médico deletado com Sucesso!";
    }
}
