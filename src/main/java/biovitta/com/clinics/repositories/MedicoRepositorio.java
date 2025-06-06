package biovitta.com.clinics.repositories;

import biovitta.com.clinics.entities.Medico;
import biovitta.com.clinics.entities.Paciente;
import biovitta.com.clinics.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepositorio extends JpaRepository<Medico, String> {

    boolean existsByEmail(String email);

    List<Medico> findByNomeContainingIgnoreCase(String nome);

    Usuario findByEmail(String email);

}
