package br.com.projeto.imperialflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.imperialflix.services.EmailService;

@RestController
@RequestMapping("/Filme")
public class FilmeController {
	
	@Autowired
	EmailService emailService;
		
	@GetMapping
	public String writerTeste() {
		emailService.writerTeste();
		return "Email enviado com sucesso";
	}
	
	@GetMapping("/envioemail")
	public String writerTeste2() {
		emailService.writerTeste2();
		return "Email enviado com sucesso";
	}
	@GetMapping("/mailsend")
	public String mailSend() {
		emailService.mailSend();
		return "Email enviado com sucesso";
	}
}
