package dam.pmdm.uf3_p5_fragments_dinamicos;

import java.util.ArrayList;
import java.util.List;

public class Perro {

    private String nombre;
    private List<Intervencion> intervenciones;

    public Perro(String nombre) {
        this.nombre = nombre;
        this.intervenciones = new ArrayList<>();;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Intervencion> getIntervenciones() {
        return intervenciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addIntervenciones(String fecha, String motivo, String observacion) {
        intervenciones.add(new Intervencion(fecha, motivo, observacion));
    }
}
