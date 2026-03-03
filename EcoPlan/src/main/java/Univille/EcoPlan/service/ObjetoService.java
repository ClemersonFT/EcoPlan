package Univille.EcoPlan.service;

import Univille.EcoPlan.entity.Objeto;
import Univille.EcoPlan.repository.ObjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetoService {

    public ObjetoService(ObjetoRepository objetoRepository) {
        this.objetoRepository = objetoRepository;
    }

    private final ObjetoRepository objetoRepository;

    public List<Objeto> listarTodos() {
        return objetoRepository.findAll();
    }

    public List<Objeto> buscarPorNome(String tipo) {
        return objetoRepository.findByTipoContainingIgnoreCase(tipo);
    }

    public Optional<Objeto> buscarPorId (Long id){
        return objetoRepository.findById(id);
    }
}
