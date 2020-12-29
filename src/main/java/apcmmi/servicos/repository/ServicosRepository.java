package apcmmi.servicos.repository;

import apcmmi.servicos.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicosRepository extends JpaRepository<Servico, Long> {

}
