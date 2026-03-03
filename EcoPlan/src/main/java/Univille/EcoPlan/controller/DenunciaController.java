package Univille.EcoPlan.controller;

import Univille.EcoPlan.entity.Denuncia;
import Univille.EcoPlan.service.DenunciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    private final DenunciaService denunciaService;

    public DenunciaController(DenunciaService denunciaService) {
        this.denunciaService = denunciaService;
    }

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<Denuncia> denunciar(@RequestBody Denuncia denuncia,
                                              @PathVariable Long usuarioId) {

        Denuncia denunciaSalva = denunciaService.criarDenuncia(denuncia, usuarioId);

        return ResponseEntity.status(HttpStatus.CREATED).body(denunciaSalva);
    }
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Denuncia>> listarDenuncias(
            @PathVariable Long usuarioId){

        List<Denuncia> denuncias = denunciaService.listarPorUsuario(usuarioId);
        return ResponseEntity.ok(denuncias);
    }
}
