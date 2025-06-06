package biovitta.com.clinics.controllers;

import biovitta.com.clinics.DTOs.EspecialidadesDTO;
import biovitta.com.clinics.services.EspecialidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("biovitta/api/especialidades")
public class EspecialidadeController {

    @Autowired
    EspecialidadesService especialidadesService;

    @PostMapping("add")
    public ResponseEntity<EspecialidadesDTO> adicionarEspecialidade(@RequestBody EspecialidadesDTO dto) {
        return ResponseEntity.ok(especialidadesService.addEspecialidade(dto));
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<EspecialidadesDTO> editarEspecialidade(@RequestBody EspecialidadesDTO dto, @PathVariable long id) {
        return ResponseEntity.ok(especialidadesService.editarEspecialidade(id, dto));
    }

    @DeleteMapping("dell/{id}")
    public String deletarEspecialidade(@PathVariable long id) {
     return  especialidadesService.deletarEspecialidade(id);
    }

    @GetMapping("get/all")
    public ResponseEntity<List<EspecialidadesDTO>> buscarTodasEspecialidades() {
        return ResponseEntity.ok(especialidadesService.listarEspecialidades());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<EspecialidadesDTO> buscarEspecialidade(@PathVariable long id) {
        return ResponseEntity.ok(especialidadesService.buscarEspecialidadePorId(id));
    }
}
