package ejercicio;

import java.util.List;

public class Receta {
    private String nombre;
    private final List<Ingrediente> ingredientes;
    private final List<Instruccion> instrucciones;

    public Receta(String nombre, List<Ingrediente> ingredientes, List<Instruccion> instrucciones) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
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

    @Override
    public String toString(){
        return nombre;
    }
}