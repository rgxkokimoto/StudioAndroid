package dam.pmdm.p9_intents_enviarserialobj.model;

import java.io.Serializable;

public class Persona implements Serializable{
    private static  final long serialVerssionUID = 1L;

    private String nombre;
    private int edad;

    // alt + insert0 (abajo a la derecha)

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
