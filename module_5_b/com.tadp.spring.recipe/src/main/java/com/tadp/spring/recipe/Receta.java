package com.tadp.spring.recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receta {
	@Autowired
	private String nombre;
	@Autowired
    private List<Ingrediente> ingredientes;
	@Autowired
    private List<Instruccion> instrucciones;

	public Receta(String nombre) {
        this.nombre = nombre;
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
