package com.mvc.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.modelo.entidad.Videojuego;
import com.mvc.modelo.negocio.GestorVideojuego;

@Controller
public class ControladorVideojuego {

	@Autowired
	private GestorVideojuego gestorVideojuego;

	@GetMapping("listaVideojuego")
	public String lista (Model model) {

		List<Videojuego> lv = gestorVideojuego.obtenerListaVideojuegos();

		if (lv == null) {
			return "inicio";
		} else {
			model.addAttribute("lista", lv);
			return "inicio";
		}		

	}
	
	@GetMapping("videojuego")
	public String busqueda(@RequestParam("busqueda_id") int id, Model model) {

		Videojuego v = gestorVideojuego.buscarVideojuego(id);

		if (v == null) {
			return "inicio";
		} else {
			model.addAttribute("v", v);
			return "inicio";
		}
			
	}

}
