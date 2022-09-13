package ejercicio;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
	    List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	    ingredientes.add(new Ingrediente("Tomate",2,"kg"));
	    ingredientes.add(new Ingrediente("Lechuga",1,"kg"));
	    ingredientes.add(new Ingrediente("Zanahoria",2,"kg"));

	    List<Instruccion> instrucciones = new ArrayList<Instruccion>();
	    instrucciones.add(new Instruccion(1, "Lavar y cortar el tomate"));
	    instrucciones.add(new Instruccion(2, "Lavar y cortar la lechuga"));
	    instrucciones.add(new Instruccion(3, "Lavar, pelar y cortar la zanahoria"));
	    instrucciones.add(new Instruccion(4, "Colocar todo en un recipiente, condimentar con aceite y mezclar"));

	    Receta miReceta = new Receta("ensalada", ingredientes, instrucciones);
	    miReceta.detallesReceta();
	}

}
