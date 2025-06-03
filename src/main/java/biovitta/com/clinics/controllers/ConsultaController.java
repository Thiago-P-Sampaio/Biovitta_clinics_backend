package biovitta.com.clinics.controllers;

import biovitta.com.clinics.DTOs.PacienteConsultaDTO;
import biovitta.com.clinics.DTOs.cadastro.ConsultaRequestDTO;
import biovitta.com.clinics.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("biovitta/api/consulta")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @PostMapping("/add")
    public ResponseEntity<ConsultaRequestDTO> novaConsulta(@RequestBody ConsultaRequestDTO dto){
        return ResponseEntity.ok(consultaService.adicionarConsulta(dto));
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<PacienteConsultaDTO> consultasPorPaciente(@PathVariable Long id){
        return ResponseEntity.ok(consultaService.consultaPaciente(id));
    }

}
