package com.tadp.spring.recipe;

public class Instruccion {
	private int numero;
    private String descripcion;
    
    public Instruccion(int numero, String descripcion) {
        setNumero(numero);
        setDescripcion(descripcion);
    }

	public int getNumero() {
		return numero;
	}

	public void setNumero(int posicion) {
		this.numero = posicion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return numero + "-" + descripcion;
	}

    
}
