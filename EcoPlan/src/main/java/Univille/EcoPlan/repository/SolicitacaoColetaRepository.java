package Univille.EcoPlan.repository;

import Univille.EcoPlan.entity.SolicitacaoColeta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SolicitacaoColetaRepository extends JpaRepository<SolicitacaoColeta,Long> {

    List<SolicitacaoColeta> findByUsuarioId(Long usuarioId);
}
