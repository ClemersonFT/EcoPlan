package Univille.EcoPlan.service;


import Univille.EcoPlan.entity.SolicitacaoColeta;
import Univille.EcoPlan.entity.Usuario;
import Univille.EcoPlan.repository.SolicitacaoColetaRepository;
import Univille.EcoPlan.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitacaoColetaService {

    private final SolicitacaoColetaRepository solicitacaoColetaRepository;
    private final UsuarioRepository usuarioRepository;

    public SolicitacaoColetaService(
            SolicitacaoColetaRepository solicitacaoColetaRepository,
            UsuarioRepository usuarioRepository) {

        this.solicitacaoColetaRepository = solicitacaoColetaRepository;
        this.usuarioRepository = usuarioRepository;
    }


    public SolicitacaoColeta criarSolicitacaoColeta(SolicitacaoColeta solicitacaoColeta, Long usuarioId){
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        solicitacaoColeta.setUsuario(usuario);
        return solicitacaoColetaRepository.save(solicitacaoColeta);
    }

    public List<SolicitacaoColeta> listarSolicitacoes(Long usuarioId){
        return solicitacaoColetaRepository.findByUsuarioId(usuarioId);
    }
}
