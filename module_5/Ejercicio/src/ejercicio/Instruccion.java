package ejercicio;

public class Instruccion {
    private int paso;
    private String descripcion;

    public Instruccion(int paso, String descripcion) {
        this.paso = paso;
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return String.valueOf(paso) + " - " + descripcion;
    }
}
