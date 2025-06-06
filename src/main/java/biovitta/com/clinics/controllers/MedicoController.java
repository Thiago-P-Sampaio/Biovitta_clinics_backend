package biovitta.com.clinics.controllers;

import biovitta.com.clinics.DTOs.MedicoDTO;
import biovitta.com.clinics.DTOs.MedicoEspecialidadesDTO;
import biovitta.com.clinics.DTOs.cadastro.MedicoRequestDTO;
import biovitta.com.clinics.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("biovitta/api/medicos")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @GetMapping("/{crm}/especialidades")
    public ResponseEntity<MedicoEspecialidadesDTO> medicoEspecialidades(@PathVariable String crm){
        return ResponseEntity.ok(medicoService.medicoEspecialidades(crm));
    }


    @GetMapping("get/all")
    public  ResponseEntity<List<MedicoDTO>> listarMedicos(){
        return ResponseEntity.ok(medicoService.listarMedicos());
    }

    @GetMapping("get/{crm}")
    public ResponseEntity<MedicoDTO> buscarMedico(@PathVariable String crm){
        return ResponseEntity.ok(medicoService.buscarMedico(crm));
    }

    @DeleteMapping("dell/{crm}")
    public String deletarMedico(@PathVariable String crm){
        return medicoService.deletarMedico(crm);
    }

    @PutMapping("edit/{crm}")
    public ResponseEntity<MedicoDTO> editarMedico(@PathVariable String crm, @RequestBody MedicoRequestDTO dto){
        return ResponseEntity.ok(medicoService.editarMedico(dto, crm));
    }
}
