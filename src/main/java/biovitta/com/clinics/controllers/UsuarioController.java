package biovitta.com.clinics.controllers;

import biovitta.com.clinics.DTOs.PacienteDTO;
import biovitta.com.clinics.DTOs.cadastro.PacienteRequestDTO;
import biovitta.com.clinics.services.PacienteService;
import biovitta.com.clinics.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("biovitta/api")
public class UsuarioController {

    @Autowired
    UsuarioService pacienteService;

    @PostMapping("/paciente/add")
    public ResponseEntity<PacienteDTO> adicionarPaciente(@RequestBody @Valid PacienteRequestDTO dto){
        return ResponseEntity.ok(pacienteService.novoPaciente(dto));
    }
}
