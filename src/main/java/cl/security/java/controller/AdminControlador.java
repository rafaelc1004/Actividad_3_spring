package cl.security.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminControlador {

	
	@GetMapping("index")
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("/reporte")
	public String reporte() {
		return "admin/reporte";
	}
}
