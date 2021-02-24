package com.mvc.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.modelo.entidad.Usuario;
import com.mvc.modelo.persistencia.DaoUsuario;

//Tenemos que dar de alta este objeto en el contexto de Spring

//Con la anotacion @Service damos de alta un objeto en el contexto
//de Spring, es equivalente a la anotacion @Component, lo que pasa
//es que si un programador ve que esta etiqueta, sabe que lleva
//la logica de negocio de tu app
@Service
public class GestorUsuario {

	@Autowired
	private DaoUsuario daoUsuario;
	
	//Esta capa se encarga de logida de la aplicacion, de validaciones
	//, de aplicar requisitos del cliente
	public boolean validarUsuario(Usuario usuario) {
		Usuario usuarioAux = 
				daoUsuario
				.findByNombreAndPassword(usuario.getNombre(), 
				usuario.getPassword());
		
		//si usuarioAux es null, entonces no esta en la BBDD
		//Si existe, entonces el usuario si existe
		if(usuarioAux == null) {
			return false;
		}else {
			return true;
		}
	}
}
