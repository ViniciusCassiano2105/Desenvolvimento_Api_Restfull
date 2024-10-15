package br.com.veiculo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.veiculo.entities.Veiculo;
import br.com.veiculo.services.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> adicionarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoService.adicionarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerVeiculo(@PathVariable Integer id) {
        if (!veiculoService.buscarVeiculoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        veiculoService.removerVeiculo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Integer id, @RequestBody Veiculo veiculo) {
        if (!veiculoService.buscarVeiculoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        veiculo.setId(id);
        Veiculo veiculoAtualizado = veiculoService.atualizarVeiculo(veiculo);
        return ResponseEntity.ok(veiculoAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Integer id) {
        Optional<Veiculo> veiculo = veiculoService.buscarVeiculoPorId(id);
        return veiculo.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarVeiculos();
    }
}