package Univille.EcoPlan.service;

import Univille.EcoPlan.entity.Usuario;
import Univille.EcoPlan.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        if (usuarioRepository.findByEmailContainingIgnoringCase(usuario.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado");
        }

        if (usuarioRepository.findByCpf(usuario.getCpf()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cpf já cadastrado");
        }
        return usuarioRepository.save(usuario);

    }
    public Usuario login(String email, String senha){
        Optional<Usuario> usuarioOpcional = usuarioRepository.findByEmail(email);

        if(usuarioOpcional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais inválidas");
        }

        Usuario usuario = usuarioOpcional.get();

        if(!usuario.getSenha().equals(senha)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais inválidas");
        }

        return usuario;
    }
}
