package Univille.EcoPlan.repository;

import Univille.EcoPlan.entity.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ObjetoRepository extends JpaRepository<Objeto,Long> {

    List<Objeto> findByTipoContainingIgnoreCase(String nome);
}
