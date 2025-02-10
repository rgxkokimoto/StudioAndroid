package dam.pmdm.p14_pract6_enbuscadelintentperdido;

import android.app.Application;

// TODO Recuerda ponerla en el manifest del proyecto para que no  coja al padre Application por defecto

public class ClasseApplicacionNombre  extends Application {
    // un pojo
    /*
        es una singelton para usar el nombre en toda la aplicación
        muy util y importante!!!
     */

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        nombre = "Jugador"; // tambien podrias dejarlo vacio ""
    }

}
