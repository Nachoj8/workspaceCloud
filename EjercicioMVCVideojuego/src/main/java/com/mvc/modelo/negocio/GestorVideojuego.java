package com.mvc.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.modelo.entidad.Videojuego;
import com.mvc.modelo.persistencia.DaoVideojuego;

@Service
public class GestorVideojuego {
	
	@Autowired
	private DaoVideojuego daoVideojuego;
	
	/***
	 * Metodo que busca en bbdd un videojuego por un ID
	 * @param id el id del videojuego a buscar
	 * @return el videojuego en caso de que exista el id en la bbdd, null en  caso de que
	 * el videojuego no exista
	 */
	public Videojuego buscarVideojuego(int id) {
		Optional<Videojuego> oVideojuego = daoVideojuego.findById(id);
				
		
		if(oVideojuego.isPresent()) {
			return oVideojuego.get();
		}else {
			return null;
		}
	}
	
	public List<Videojuego> obtenerListaVideojuegos() {
		return daoVideojuego.findAll();
	}

}
