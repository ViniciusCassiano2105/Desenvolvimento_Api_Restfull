package br.com.veiculo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.veiculo.entities.Veiculo;
import br.com.veiculo.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo adicionarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void removerVeiculo(Integer id) {
        veiculoRepository.deleteById(id);
    }

    public Veiculo atualizarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Optional<Veiculo> buscarVeiculoPorId(Integer id) {
        return veiculoRepository.findById(id);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

}