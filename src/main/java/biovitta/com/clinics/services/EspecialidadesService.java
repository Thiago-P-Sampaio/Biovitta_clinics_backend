package biovitta.com.clinics.services;

import biovitta.com.clinics.DTOs.EspecialidadesDTO;
import biovitta.com.clinics.entities.Especialidades;
import biovitta.com.clinics.repositories.EspecialidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
