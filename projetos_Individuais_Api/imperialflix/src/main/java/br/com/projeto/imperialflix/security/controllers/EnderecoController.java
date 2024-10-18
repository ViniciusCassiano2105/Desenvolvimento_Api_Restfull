package br.com.projeto.imperialflix.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.imperialflix.security.dto.EnderecoResponseDTO;
import br.com.projeto.imperialflix.security.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping("/{id}")
	public EnderecoResponseDTO buscarEndereco(@PathVariable Integer id) {
		return enderecoService.buscarEndereco(id);
		
		//Repetir o método acima no controller para fazer DeleteMapping - retorno VOID
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
	    enderecoService.deletarEndereco(id);
		
	}
}
