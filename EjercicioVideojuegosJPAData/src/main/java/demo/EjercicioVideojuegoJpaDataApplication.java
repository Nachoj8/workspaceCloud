package demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import demo.modelo.entidad.Videojuego;
import demo.modelo.persistencia.DaoVideojuego;

@SpringBootApplication
public class EjercicioVideojuegoJpaDataApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjercicioVideojuegoJpaDataApplication.class, args);
		
		DaoVideojuego daoVideojuego = context.getBean("daoVideojuego", DaoVideojuego.class);
		
		Videojuego v1 = new Videojuego();
		v1.setNombre("God of War");
		v1.setCompania("Sony");
		v1.setPrecio(79.99);
		v1.setPuntuacion(9);
		
		//persisitimos el videojuego en BBDD
		//notese, que no ponemos el ID del videojuego, ya
		//que la bbdd no pone uno por defecto y es autoincremental
		//daoCoche.save(videojuego);
		
		//para modificar, usaremos el mismo metodo pero esta vez
		//tendremos que pasarle el ID que queremos modificar.
		//Es decir, si NO le pasamos ID, lo dara de alta en la BBDD
		//si le pasamos el ID, entonces modificaremos dicho registro
		Videojuego v2 = new Videojuego();
		v2.setId(1);//importante poner el id que queremos modificars
		v2.setNombre("Zelda");
		v2.setCompania("Nintendo");
		v2.setPrecio(50);
		v2.setPuntuacion(8);
		//Notese que sobreescribimos TODO el objeto
		
		daoVideojuego.save(v2);
		
		//Para acceder a un videojuego
		//ojo, el metodo findById() devuelve un optinal
		//hay que desenvolverlo con get(), tambien podemos
		
		Videojuego v3 = daoVideojuego.findById(1).get();
		System.out.println(v3);
		
		//usar el emtodo isPresent() para ver si el objeto exite
		Optional<Videojuego> videojuegoOptional = daoVideojuego.findById(2);
		if(videojuegoOptional.isPresent()) {
			System.out.println("existe el videojuego");
			//deselvolvemos el objeto SOLO en caso de que
			//exista en la BBDD
			System.out.println(videojuegoOptional.get());
		}else {
			System.out.println("el videojuego no existe");
		}
		
		//recuperar todos los videojuego
		List<Videojuego> listaVideojuegos = daoVideojuego.findAll();
		System.out.println(listaVideojuegos);
		
		//borrar un coche
		//daoVideojuego.deleteById(1);
		
		listaVideojuegos = daoVideojuego.findAll();
		System.out.println(listaVideojuegos);
	}
	

}
