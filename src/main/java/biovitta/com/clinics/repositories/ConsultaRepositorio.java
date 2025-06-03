package biovitta.com.clinics.repositories;

import biovitta.com.clinics.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepositorio extends JpaRepository<Consulta, Long> {

    boolean existsByMedico_CrmAndDataConsulta(String crm, LocalDateTime dataConsulta);
}
