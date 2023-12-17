package com.voabrasil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/destino")
	public String destino() {
		return "destino"; //nome da pagina html
	}
	
	@GetMapping("/contato")
	public String contato() {
		return "contato"; 
	}
	
	@GetMapping("/promocoes")
	public String promocoes() {
		return "promocoes"; 
	}
	
	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro"; 
	}
}
