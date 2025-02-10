package dam.pmdm.pt4apchechoscuriosos3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declaramos las variables para las vistas
    private TextView tvHechoCurioso;
    private Button btnVerHecho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Conectar las vistas con el código Java es vital para que funcionen los botones
        tvHechoCurioso = findViewById(R.id.tvHechoCurioso);
        btnVerHecho = findViewById(R.id.btnVerHecho);

        // Añadir el OnClickListener al boton desde la interfaz
        /*  ListaHechos listaHechos = new ListaHechos();
         btnVerHecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvHechoCurioso.setText(listaHechos.getHechoAleatorio());
            }
        }); */
    }

    //Paso 2: Enlazar Eventos desde el Layout
    // Vamos a hacer que la aplicación sea más limpia eliminando
    // la necesidad de declarar eventos en la clase Java
    // y enlazándolos directamente desde el archivo XML del layout.
    /*
        Captura de error 001: aqui me dio error al final era culpa del metodo Onclick en la vista activity_main.xml
        el problema no era el metodo que creste en si sino el metodo que usabas en xml para ejecutarlo daba error
        porque estaba en un lyout Contraint que no conteia
    */
    public void mostrarHechoCurioso(View view) {
        ListaHechos listaHechos = new ListaHechos();
        tvHechoCurioso.setText(listaHechos.getHechoAleatorio());
        // crear objeto para poder asignarlo
        ColoresFondo coloresFondo = new ColoresFondo();
        RelativeLayout layoutPrincipal = findViewById(R.id.main);
        layoutPrincipal.setBackgroundColor(coloresFondo.getColorAleatorio());
    }
}