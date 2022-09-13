package ejercicio;

import java.util.List;

public class Receta {
    private String nombre;
    private List<Ingrediente> ingredientes;
    private List<Instruccion> instrucciones;

    public Receta(String nombre, List<Ingrediente> ingredientes, List<Instruccion> instrucciones) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
    }
	
   public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public List<Instruccion> getInstrucciones() {
		return instrucciones;
	}

    public void detallesReceta() {
        System.out.println("---Receta---");
        System.out.println(nombre);
        System.out.println("---Ingredientes---");
        for (Ingrediente ingrediente : ingredientes) {
            System.out.println(ingrediente.toString());
        }
        System.out.println("---Pasos---");
          for (Instruccion instruccion : instrucciones) {
            System.out.println(instruccion.toString());
        }
    }
}
