package Univille.EcoPlan.service;

import Univille.EcoPlan.entity.Denuncia;
import Univille.EcoPlan.entity.Usuario;
import Univille.EcoPlan.repository.DenunciaRepository;
import Univille.EcoPlan.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DenunciaService {

    private final DenunciaRepository denunciaRepository;
    private final UsuarioRepository usuarioRepository;

    public DenunciaService(DenunciaRepository denunciaRepository,
                           UsuarioRepository usuarioRepository) {
        this.denunciaRepository = denunciaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Denuncia criarDenuncia(Denuncia denuncia, Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        denuncia.setUsuario(usuario);

        return denunciaRepository.save(denuncia);
    }

    public List<Denuncia> listarPorUsuario(Long usuarioId){
        return denunciaRepository.findByUsuarioId(usuarioId);
    }
}
