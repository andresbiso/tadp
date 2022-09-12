package ejercicio;

public class Ingrediente {
	
	private String descripcion;

	public Ingrediente(String descripcion) {
	  this.descripcion = descripcion;
	}
	
	@Override
	public String toString(){
	    return descripcion;
	}
}
