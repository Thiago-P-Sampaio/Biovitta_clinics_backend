package biovitta.com.clinics.services;

import biovitta.com.clinics.DTOs.ConsultaDTO;
import biovitta.com.clinics.DTOs.EspecialidadesDTO;
import biovitta.com.clinics.entities.Especialidades;
import biovitta.com.clinics.repositories.EspecialidadeRepositorio;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EspecialidadesService {

    @Autowired
    EspecialidadeRepositorio especialidadeRepositorio;


    public EspecialidadesDTO addEspecialidade(EspecialidadesDTO dto) {
        Optional<Especialidades> existente = Optional.ofNullable(especialidadeRepositorio.findByNome(dto.getNome()));
        if(existente.isPresent()) {
            return null;
        } else {
            Especialidades novaEspecialidade = new Especialidades();
            novaEspecialidade.setNome(dto.getNome());
            especialidadeRepositorio.save(novaEspecialidade);
            return new EspecialidadesDTO(novaEspecialidade);
        }
    }

    public EspecialidadesDTO editarEspecialidade(Long id, EspecialidadesDTO dto) {
        Especialidades especialidade = especialidadeRepositorio.findById(id).get();
        if(especialidade != null) {
            especialidade.setNome(dto.getNome());
            return new EspecialidadesDTO(especialidade);
        } else {
            return null;
        }
    }

    public String deletarEspecialidade(Long id) {
        Especialidades especialidade = especialidadeRepositorio.findById(id).get();
        if(especialidade != null) {
            especialidadeRepositorio.deleteById(id);
            return "Especialidade deletada com sucesso";
        }
        return "Especialidade não encontrada com o ID:" + id;
    }

    public List<EspecialidadesDTO> listarEspecialidades() {
        return especialidadeRepositorio.findAll()
                .stream()
                .map(EspecialidadesDTO::new)
                .collect(Collectors.toList());
    }

    public EspecialidadesDTO buscarEspecialidadePorId(Long id) {
        Especialidades especialidade = especialidadeRepositorio.findById(id).get();
        if(especialidade != null) {
            return new EspecialidadesDTO(especialidade);
        } else{
            return null;
        }
    }

}
