package com.mvc.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.modelo.entidad.Usuario;
import com.mvc.modelo.entidad.Videojuego;

@Repository
public interface DaoVideojuego extends JpaRepository<Videojuego, Integer>{
	
	//Con JPA podemos crear busquedas usando convenciones de creacio
	//de metodos. Todo metodo que empiece con las palabras
	//"findBy" + Atributo, JPA data te creara la consulta
	//automaticamente
	
	

}
