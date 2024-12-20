package org.serratec.musicmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.musicmanager.domain.Artista;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artista")
public class ArtistaController {
	private List<Artista> artistas = new ArrayList();
	public ArtistaController() {
		artistas.add(new Artista(1l, "Michael jackson", "S"));
		artistas.add(new Artista(2l, "Pink Floyd", "B"));
		artistas.add(new Artista(3l, "Legião urbana", "B"));
		artistas.add(new Artista(4l, "Roberto Carlos", "S"));
	}
	
	
	@GetMapping
	public List<Artista> listaTodos(){
		return artistas;
	}
	
	@GetMapping("/(id)")
	public Artista busca(@PathVariable Long id) {
		for(int i = 0; i<artistas.size(); i++) {
			Artista artista = artistas.get(i);
			if (artista.getId().equals(id)) {
				return artista;
			}
		}
	}
}
