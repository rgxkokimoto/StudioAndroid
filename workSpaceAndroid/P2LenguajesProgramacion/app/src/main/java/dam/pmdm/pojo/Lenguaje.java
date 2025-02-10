package dam.pmdm.pojo;

public class Lenguaje {

    private String nombre;
    private  String descripcion;

    public Lenguaje(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
