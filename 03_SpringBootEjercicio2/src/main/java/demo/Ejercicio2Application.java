package demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import demo.modelo.entidad.Autor;
import demo.modelo.entidad.Email;
import demo.modelo.entidad.Libro;


@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class Ejercicio2Application {
	
	public static ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio2Application.class, args);
		context = SpringApplication.run(Ejercicio2Application.class, args);
		
		Email email1 = context.getBean("email", Email.class);
		email1.setRemitente("AAA");
		email1.setDestinatario("BBB");
		email1.setId(22);
		
		
		Email email2 = context.getBean("emailSingleton", Email.class);
		Email email3 = context.getBean("emailSingleton", Email.class);
		
		System.out.println("Email por anotaciones");
		System.out.println(email1);
		
		// XML
		System.out.println("\nEmails por XML");
		System.out.println(email2);
		System.out.println(email3);
		
		// Primero damos de alta un autor por anotaciones para luego poder dar de alta el libro con el autor
		System.out.println("\nAutores");
		Autor autor1 = context.getBean("autor", Autor.class);
		autor1.setEdad(27);
		autor1.setId(1);
		autor1.setNombre("Julian");
		
		// Ahora ya damos de alta el libro por anotaciones con el autor creado
		Libro libro1 = context.getBean("libro", Libro.class);
		libro1.setAutor(autor1);
		libro1.setEditorial("Altaya");
		libro1.setIsb("A15");
		
		System.out.println("Autor por anotaciones");
		System.out.println(autor1);
		
		System.out.println("\nLibro por anotaciones");
		System.out.println(libro1);
		
		// XML
		System.out.println("\nLibro XML");
		Autor autor2 = context.getBean("autorXml1", Autor.class);
		System.out.println(autor2);
		
		Libro libro2 = context.getBean("libroXml1", Libro.class);
		System.out.println(libro2);
		
		
		// Por si queremos dar de alta un arrayList
		System.out.println("\nArrayList");
		List<Libro> listaLibros = context.getBean("listaLibros", List.class);
		for (Libro libro : listaLibros) {
			System.out.println(libro);
		}
		
		// Autowired
		Libro libroAuto = context.getBean("libroAuto", Libro.class);
		System.out.println(libroAuto);
		
	}
	

}
