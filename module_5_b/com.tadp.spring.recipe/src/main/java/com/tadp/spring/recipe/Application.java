package com.tadp.spring.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(
				Application.class, args);
 
	    Receta miReceta = context.getBean("receta", Receta.class);
	    miReceta.detallesReceta();
	}

}
