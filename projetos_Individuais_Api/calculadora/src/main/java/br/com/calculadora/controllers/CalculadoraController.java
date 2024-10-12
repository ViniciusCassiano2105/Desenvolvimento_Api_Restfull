package br.com.calculadora.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Calculadora")
public class CalculadoraController {
	
	@GetMapping("/Soma")
	public int soma (int N1, int N2) {
		return N1 + N2;
	}
	@GetMapping("/Subtração")
	public int subtrair (int N1, int N2) {
		return N1 - N2;
	}
	@GetMapping("/Multiplicacão")
	public int multiplicar (int N1, int N2) {
		return N1 * N2;
	}
	@GetMapping("/Divisão")
	public double dividir (double N1, double N2) {
		if (N2 == 0) {
			throw new IllegalArgumentException("Não existe divisão por 0");
		}
		
		return N1 / N2;
	}
	
}
