package br.com.calculadora.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SeuPesoNoSistemaSolar")
public class ConversorPesoSistemaSolarController {

	@GetMapping("/Seu Peso em Mercurio")
	public String converterPesoParaMercurio(double pesoNaTerra) {
		double gravidadeTerra = 9.81;
		double gravidadeMercurio = 3.7;
		double pesoEmMercurio = (pesoNaTerra * gravidadeMercurio) / gravidadeTerra;
		return String.format("%.2f", pesoEmMercurio) + " kg em Mercúrio";
	}

	@GetMapping("/Seu Peso em Venus")
	public String converterPesoParaVenus(double pesoNaTerra) {
		double gravidadeTerra = 9.81;
		double gravidadeVenus = 8.87;
		double pesoEmVenus = (pesoNaTerra * gravidadeVenus) / gravidadeTerra;
		return String.format("%.2f", pesoEmVenus) + " kg em Vênus";
	}

	@GetMapping("/Seu Peso em Marte")
	public String converterPesoParaMarte(double pesoNaTerra) {
		double gravidadeTerra = 9.81;
		double gravidadeMarte = 3.71;
		double pesoEmMarte = (pesoNaTerra * gravidadeMarte) / gravidadeTerra;
		return String.format("%.2f", pesoEmMarte) + " kg em Marte";
	}

	@GetMapping("/Seu Peso em Júpiter")
	public String converterPesoParaJupiter(double pesoNaTerra) {
		double gravidadeTerra = 9.81;
		double gravidadeJupiter = 24.79;
		double pesoEmJupiter = (pesoNaTerra * gravidadeJupiter) / gravidadeTerra;
		return String.format("%.2f", pesoEmJupiter) + " kg em Júpiter";
	}

	@GetMapping("/Seu Peso em Saturno")
	public String converterPesoParaSaturno(double pesoNaTerra) {
		double gravidadeTerra = 9.81;
		double gravidadeSaturno = 10.44;
		double pesoEmSaturno = (pesoNaTerra * gravidadeSaturno) / gravidadeTerra;
		return String.format("%.2f", pesoEmSaturno) + " kg em Saturno";
	}

	@GetMapping("/Seu Peso em Urano")
	public String converterPesoParaUrano(double pesoNaTerra) {
		double gravidadeTerra = 9.81;
		double gravidadeUrano = 8.69;
		double pesoEmUrano = (pesoNaTerra * gravidadeUrano) / gravidadeTerra;
		return String.format("%.2f", pesoEmUrano) + " kg em Urano";
	}

	@GetMapping("/Seu Peso em Netuno")
	public String converterPesoParaNetuno(double pesoNaTerra) {
		double gravidadeTerra = 9.81;
		double gravidadeNetuno = 11.15;
		double pesoEmNetuno = (pesoNaTerra * gravidadeNetuno) / gravidadeTerra;
		return String.format("%.2f", pesoEmNetuno) + " kg em Netuno";
	}

	@GetMapping("/Seu Peso na Lua")
	public String converterPesoParaLua(double pesoNaTerra) {
		double gravidadeTerra = 9.81;
		double gravidadeLua = 1.62;
		double pesoNaLua = (pesoNaTerra * gravidadeLua) / gravidadeTerra;
		return String.format("%.2f", pesoNaLua) + " kg na Lua";
	}

	@GetMapping("/Seu Peso no Sol")
	public String converterPesoParaSol(double pesoNaTerra) {
		double gravidadeTerra = 9.81;
		double gravidadeSol = 274.0;
		double pesoNoSol = (pesoNaTerra * gravidadeSol) / gravidadeTerra;
		return String.format("%.2f", pesoNoSol) + " kg no Sol - Se você sobreviver um milésimo de segundo ;)";
	}

}
