package negocio;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entidades.Casa;

public class MainCasaSpring {
	
	public static ApplicationContext context = null;

	public static void main(String[] args) {
		//El contexto de spring tambien es un objeto
		//así que tenemos que crearlo
		context = new ClassPathXmlApplicationContext("recursos/contextCasa.xml");
		// a partir de aqui tendremos nuestro contexto de spring cargado, con
		//los objetos que haya en el xml
		
		Casa c1 = (Casa)context.getBean("casa1");
		System.out.println(c1);

	}

}
