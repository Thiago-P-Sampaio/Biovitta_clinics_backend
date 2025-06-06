package biovitta.com.clinics.repositories;

import biovitta.com.clinics.entities.Paciente;
import biovitta.com.clinics.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Long> {

    Usuario findByEmail(String email);

    List<Paciente> findByNomeContainingIgnoreCase(String nome);

    boolean existsByEmail(String email);
}
