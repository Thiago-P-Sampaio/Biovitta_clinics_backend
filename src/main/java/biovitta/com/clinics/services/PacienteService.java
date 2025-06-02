package biovitta.com.clinics.services;

import biovitta.com.clinics.DTOs.PacienteDTO;
import biovitta.com.clinics.DTOs.cadastro.PacienteRequestDTO;
import biovitta.com.clinics.entities.Paciente;
import biovitta.com.clinics.entities.Permissao;
import biovitta.com.clinics.entities.Usuario;
import biovitta.com.clinics.repositories.PacienteRepositorio;
import biovitta.com.clinics.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepositorio pacienteRepositorio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    PasswordEncoder config;

    @Transactional
    public PacienteDTO novoPaciente(PacienteRequestDTO dto){
        if(pacienteRepositorio.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Email em uso!");
        }
        Paciente novoPaciente = new Paciente();
        novoPaciente.setNome(dto.getNome());
        novoPaciente.setEmail(dto.getEmail());
        novoPaciente.setTelefone(dto.getTelefone());
        novoPaciente.setDataNascimento(dto.getDataNascimento());
        novoPaciente.setImgUrl(dto.getImgUrl());
        novoPaciente = pacienteRepositorio.save(novoPaciente);

        Usuario usuario = new Usuario();
        usuario.setRole(Permissao.PACIENTE);
        usuario.setUsuario(dto.getEmail());
        usuario.setSenha(config.encode(dto.getSenha()));
        usuario = usuarioRepositorio.save(usuario);


        return  new PacienteDTO(novoPaciente);
    }
}
