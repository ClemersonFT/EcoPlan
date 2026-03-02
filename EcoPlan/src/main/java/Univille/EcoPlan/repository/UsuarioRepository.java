package Univille.EcoPlan.repository;

import Univille.EcoPlan.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByEmailContainingIgnoringCase(String email);
    Optional<Usuario> findByCpf(String cpf);
}
