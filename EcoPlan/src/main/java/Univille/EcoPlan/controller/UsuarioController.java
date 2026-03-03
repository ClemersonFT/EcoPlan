package Univille.EcoPlan.controller;

import Univille.EcoPlan.dto.ChamadoLogin;
import Univille.EcoPlan.entity.Usuario;
import Univille.EcoPlan.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
        Usuario usuarioSalvo = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @PostMapping("/login")
    public ResponseEntity<String> logar(@RequestBody ChamadoLogin chamadoLogin){

        Usuario usuario = usuarioService.login(
                chamadoLogin.getEmail(),
                chamadoLogin.getSenha()
        );
        return ResponseEntity.ok("Login realizado com sucesso");
    }
}
