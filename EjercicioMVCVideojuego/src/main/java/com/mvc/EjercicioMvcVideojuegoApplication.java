package com.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mvc.modelo.entidad.Usuario;
import com.mvc.modelo.entidad.Videojuego;
import com.mvc.modelo.persistencia.DaoUsuario;
import com.mvc.modelo.persistencia.DaoVideojuego;

@SpringBootApplication
public class EjercicioMvcVideojuegoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjercicioMvcVideojuegoApplication.class, args);
		
		DaoUsuario du = context.getBean("daoUsuario", DaoUsuario.class);
		
		DaoVideojuego dv = context.getBean("daoVideojuego", DaoVideojuego.class);
	
		Usuario u = new Usuario();
		u.setNombre("nacho");
		u.setPassword("123456");
		
		du.save(u);
		
		List<Videojuego> listaVideojuegos = new ArrayList<>();
		
		Videojuego v1 = new Videojuego();
		v1.setNombre("Star Wars");
		v1.setCompania("EA");
		dv.save(v1);
		
		listaVideojuegos.add(v1);
		
		Videojuego v2 = new Videojuego();
		v2.setNombre("Pokemon");
		v2.setCompania("Nintendo");
		dv.save(v2);
		
		listaVideojuegos.add(v2);
		
		Videojuego v3 = new Videojuego();
		v3.setNombre("Call of Duty");
		v3.setCompania("Activision");
		dv.save(v3);
		
		listaVideojuegos.add(v3);
		
		
		System.out.println(dv.findAll());
		
		
	
	}

}
