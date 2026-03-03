package Univille.EcoPlan.controller;


import Univille.EcoPlan.entity.Objeto;
import Univille.EcoPlan.service.ObjetoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objetos")
public class ObjetoController {

    private final ObjetoService objetoService;

    public ObjetoController(ObjetoService objetoService) {
        this.objetoService = objetoService;
    }

    @GetMapping
    public ResponseEntity<List<Objeto>> listarObjetos(
            @RequestParam String tipo){

        List<Objeto> objetos = objetoService.buscarPorNome(tipo);
        return ResponseEntity.ok(objetos);
    }
}
