package biovitta.com.clinics.services;


import biovitta.com.clinics.DTOs.MedicoDTO;
import biovitta.com.clinics.DTOs.cadastro.MedicoRequestDTO;
import biovitta.com.clinics.entities.*;
import biovitta.com.clinics.repositories.ConsultaRepositorio;
import biovitta.com.clinics.repositories.MedicoRepositorio;
import biovitta.com.clinics.repositories.UsuarioRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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
    @Autowired
    private ConsultaRepositorio consultaRepositorio;


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

        Optional.ofNullable(dto.getEspecialidades())
                .filter(s -> !s.isBlank())
                .ifPresent(medico::setEspecialidades);

        medicoRepositorio.save(medico);

        Usuario usuario = usuarioRepositorio.findById(medico.getUsuario().getUsuarioId()).get();
        Optional.ofNullable(dto.getSenha())
                .filter(s -> !s.isBlank())
                .map(config::encode)
                .ifPresent(usuario::setSenha);

        usuario = usuarioRepositorio.save(usuario);

        return new MedicoDTO(medico);


    }

    @Transactional
    public List<MedicoDTO> listarMedicos(){
        return medicoRepositorio.findAll()
                .stream()
                .map(MedicoDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public MedicoDTO buscarMedico(String crm){
        Medico medico = medicoRepositorio.findById(crm).
                orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com CRM: " + crm));
        return new MedicoDTO(medico);
    }

    @Transactional
    public  String deletarMedico(String crm){
        Medico medico = medicoRepositorio.findById(crm).
                orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com CRM: " + crm));

        //Exclua também as consultas desse paciente
        // NÃO SEI SE NUM CONTEXTO REAL DEVE-SE APLICAR ISSO!
        if(!medico.getConsultasMedico().isEmpty()){
        List<Consulta> consultaMedico = Collections.singletonList(consultaRepositorio.findByMedico_Crm(crm));
        consultaRepositorio.deleteAll(consultaMedico);
        }

        usuarioRepositorio.deleteById(medico.getUsuario().getUsuarioId());
        medicoRepositorio.deleteById(crm);

        return "Médico deletado com Sucesso!";
    }



    @Transactional
    public List<MedicoDTO> listarMedicosBusca(String nome){
        List<Medico> medico = medicoRepositorio.findByNomeContainingIgnoreCase(nome);
        return  medico.stream().map(MedicoDTO::new).toList();
    }

}
