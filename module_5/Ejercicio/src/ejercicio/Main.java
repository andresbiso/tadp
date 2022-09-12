package ejercicio;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
	    List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	    ingredientes.add(new Ingrediente("caja de brownies"));
	    ingredientes.add(new Ingrediente("2 huevos"));
	    ingredientes.add(new Ingrediente("queso crema"));
	    ingredientes.add(new Ingrediente("manteca"));
	    ingredientes.add(new Ingrediente("harina"));

	    List<Instruccion> instrucciones = new ArrayList<Instruccion>();
	    instrucciones.add(new Instruccion(1, "Enmantecar y harinar molde"));
	    instrucciones.add(new Instruccion(2, "Mezclar huevos, manteca y brownies hasta lograr consistencia homogenea"));
	    instrucciones.add(new Instruccion(3, "Volcar preparacion en el molde y colocar cucharadas de queso crema por toda la superficie"));
	    instrucciones.add(new Instruccion(4, "Llevar al horno por 25 minutos"));

	    Receta miReceta = new Receta("torta brownie", ingredientes, instrucciones);
	    miReceta.detallesReceta();
	}

}
