package biovitta.com.clinics.controllers;

import biovitta.com.clinics.DTOs.MedicoDTO;
import biovitta.com.clinics.DTOs.PacienteDTO;
import biovitta.com.clinics.DTOs.UsuarioDTO;
import biovitta.com.clinics.DTOs.cadastro.MedicoRequestDTO;
import biovitta.com.clinics.DTOs.cadastro.PacienteRequestDTO;
import biovitta.com.clinics.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("biovitta/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    //AREA DO ADMINISTRADOR

    @PostMapping("/paciente/add")
    public ResponseEntity<PacienteDTO> adicionarPaciente(@RequestBody @Valid PacienteRequestDTO dto){
        return ResponseEntity.ok(usuarioService.novoPaciente(dto));
    }

    @PostMapping("/medico/add")
    public  ResponseEntity<MedicoDTO> adicionarMedico(@RequestBody @Valid MedicoRequestDTO dto){
        return ResponseEntity.ok(usuarioService.novoMedico(dto));
    }

    @PostMapping("adm/add")
    public ResponseEntity<?> adicionarAdministrador(@RequestBody @Valid UsuarioDTO dto){
        return ResponseEntity.ok(usuarioService.novoAdministrador(dto));
    }
}
