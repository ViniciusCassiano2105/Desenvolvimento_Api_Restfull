package br.com.projeto.imperialflix.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Filme")
public class FilmeController {
	@GetMapping
	public String olaMundo() {
		return "Hello, world";
	}
}
