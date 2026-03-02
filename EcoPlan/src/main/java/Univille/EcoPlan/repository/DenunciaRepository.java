package Univille.EcoPlan.repository;

import Univille.EcoPlan.entity.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia,Long> {

    List<Denuncia> findByUsuarioId(Long usuarioId);
}
