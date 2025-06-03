package biovitta.com.clinics.controllers.login;

import biovitta.com.clinics.DTOs.cadastro.PacienteRequestDTO;
import biovitta.com.clinics.DTOs.login.AutenticacaoDTO;
import biovitta.com.clinics.services.UsuarioService;
import biovitta.com.clinics.services.autenticacao.AutenticacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "biovitta/auth")
public class AutenticacaoController {

    @Autowired
    AutenticacaoService autenticacaoService;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AutenticacaoDTO dados ){
        return ResponseEntity.ok(autenticacaoService.login(dados));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody @Valid PacienteRequestDTO dto){
        return  ResponseEntity.ok(usuarioService.novoPaciente(dto));
    }

}
