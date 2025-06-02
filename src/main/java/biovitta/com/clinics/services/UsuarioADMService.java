package biovitta.com.clinics.services;

import biovitta.com.clinics.DTOs.DTOUsuarioADM;
import biovitta.com.clinics.entities.Permissao;
import biovitta.com.clinics.entities.Usuario;
import biovitta.com.clinics.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioADMService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    PasswordEncoder config;

    public DTOUsuarioADM adicionarADM(DTOUsuarioADM dto){
        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsuario(dto.getUsuario());
        novoUsuario.setSenha(config.encode(dto.getSenha()));
        novoUsuario.setRole(Permissao.ADMIN);
       usuarioRepositorio.save(novoUsuario);
       return new DTOUsuarioADM(novoUsuario);
    }
}
