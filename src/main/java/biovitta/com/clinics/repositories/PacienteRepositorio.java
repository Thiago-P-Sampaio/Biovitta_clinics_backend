package biovitta.com.clinics.repositories;

import biovitta.com.clinics.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {

    boolean existsByEmail(String email);
}
