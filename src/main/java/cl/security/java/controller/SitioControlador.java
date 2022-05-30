package cl.security.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SitioControlador {
	
	@GetMapping("/")
	public String inicio() {
		return "inicio";
	}
	
	@GetMapping("/nosotros")
	public String nosotros() {
		return "nosotros";
		
	}
	
	@GetMapping("/contacto")
	public String contacto() {
		return "contacto";
	}

}
