package br.com.projeto.imperialflix.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import br.com.projeto.imperialflix.security.dto.EnderecoRequestDTO;
import br.com.projeto.imperialflix.security.dto.EnderecoResponseDTO;
import br.com.projeto.imperialflix.security.services.EnderecoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
    @Autowired
    private EnderecoService enderecoService;

    // Buscar um endereço por ID
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public EnderecoResponseDTO buscarEndereco(@PathVariable Integer id) {
        return enderecoService.buscarEndereco(id);
    }

    // Deletar um endereço por ID
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        enderecoService.deletarEndereco(id);
    }

    // Criar um novo endereço
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping
    public EnderecoResponseDTO criarEndereco(@RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        return enderecoService.consultarEndereco(enderecoRequestDTO);
    }

    // Atualizar um endereço existente
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("/{id}")
    public EnderecoResponseDTO atualizarEndereco(@PathVariable Integer id, @RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        return enderecoService.updateEndereco(id, enderecoRequestDTO);
    }

    // Listar todos os endereços
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public List<EnderecoResponseDTO> listarEnderecos() {
        return enderecoService.findAll();
    }
}
