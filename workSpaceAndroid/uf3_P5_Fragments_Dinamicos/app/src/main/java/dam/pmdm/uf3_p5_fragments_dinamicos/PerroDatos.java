package dam.pmdm.uf3_p5_fragments_dinamicos;

import java.util.ArrayList;
import java.util.List;

public class PerroDatos {

    private List<Perro> perros;

    // crear instancia cuando quiera de la lista
    public PerroDatos() {
        this.perros = new ArrayList<>();
        inicializarDatos();
    }

    private void inicializarDatos() {
        Perro rex = new Perro("Rex");
        rex.addIntervenciones("13/32/2323", "Vacunación", "Vacunación contra la rabia");
        rex.addIntervenciones("15/02/2022", "Chequeo General", "Revisión completa, sin anomalías.");
        rex.addIntervenciones("10/03/2022", "Desparasitación", "Administración de antiparasitarios internos.");
        perros.add(rex);
        Perro tor = new Perro("Tor");
        tor.addIntervenciones("05/04/2022", "Radiografía", "Fractura en la pata delantera derecha.");
        tor.addIntervenciones("20/04/2022", "Cirugía", "Reparación quirúrgica de la fractura.");
        perros.add(tor);
        Perro jambo = new Perro("Jambo");
        jambo.addIntervenciones("12/07/2021", "Vacunación", "Refuerzo de vacuna antirrábica.");
        jambo.addIntervenciones("15/08/2021", "Chequeo General", "Peso elevado, recomendación de dieta.");
        perros.add(jambo);
    }

    public Perro getPerroPorNombre(String nombre) {
        for (Perro perro : perros) {
            if (perro.getNombre().equalsIgnoreCase(nombre)) {
                return perro;
            }
        }
        return null;
    }

    // Método para obtener la lista de los nombres:
    public List<Perro> getPerrosNombres() {
        return perros;
    }


}
