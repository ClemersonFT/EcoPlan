package Univille.EcoPlan.controller;

import Univille.EcoPlan.entity.SolicitacaoColeta;
import Univille.EcoPlan.service.SolicitacaoColetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoColetaController {

    private final SolicitacaoColetaService solicitacaoColetaService;

    public SolicitacaoColetaController(SolicitacaoColetaService solicitacaoColetaService) {
        this.solicitacaoColetaService = solicitacaoColetaService;
    }

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<SolicitacaoColeta> solicitarColeta(@RequestBody SolicitacaoColeta solicitacaoColeta,
                                                             @PathVariable Long usuarioId){

        SolicitacaoColeta solicitacaoSalva = solicitacaoColetaService.criarSolicitacaoColeta(solicitacaoColeta, usuarioId);

        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoSalva);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<SolicitacaoColeta>> solicitacoes(@PathVariable Long usuarioId){
        List<SolicitacaoColeta> solicitacoes = solicitacaoColetaService.listarSolicitacoes(usuarioId);
        return ResponseEntity.ok(solicitacoes);
    }
}
