package com.tadp.spring.recipe;

public class Ingrediente {
	private String nombre;
	private float cantidad;
	private String unidad;

	public Ingrediente(String nombre, float cantidad, String unidad) {
	  setNombre(nombre);
	  setCantidad(cantidad);
	  setUnidad(unidad);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	@Override
	public String toString(){
	    return nombre + "-" + cantidad + unidad;
	}
}
