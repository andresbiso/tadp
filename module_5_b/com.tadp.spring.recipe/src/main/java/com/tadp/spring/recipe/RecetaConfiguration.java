package com.tadp.spring.recipe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Receta.class)
public class RecetaConfiguration {
	@Bean
    public String getINombre() {
        return "Ensalada";
    }
	@Bean
    public Ingrediente getIngredienteTomate() {
        return new Ingrediente("Tomate",2,"kg");
    }
	@Bean
    public Ingrediente getIngredienteLechuga() {
        return new Ingrediente("Lechuga",1,"kg");
    }
	@Bean
    public Ingrediente getIngredienteZanahoria() {
        return new Ingrediente("Zanahoria",2,"kg");
    }
	@Bean
    public Instruccion getInstruccionUno() {
        return new Instruccion(1, "Lavar y cortar el tomate");
    }
	@Bean
    public Instruccion getInstruccionDos() {
        return new Instruccion(2, "Lavar y cortar la lechuga");
    }
	@Bean
    public Instruccion getInstruccionTres() {
        return new Instruccion(3, "Lavar, pelar y cortar la zanahoria");
    }
	@Bean
    public Instruccion getInstruccionCuatro() {
        return new Instruccion(4, "Poner en un recipiente, condimentar con aceite y mezclar");
    }
}
