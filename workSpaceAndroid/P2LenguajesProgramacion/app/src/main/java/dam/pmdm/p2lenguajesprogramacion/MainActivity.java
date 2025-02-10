package dam.pmdm.p2lenguajesprogramacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dam.pmdm.control.DataManager;
import dam.pmdm.pojo.Lenguaje;

public class MainActivity extends AppCompatActivity {

    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // inicializar el DataManager
        dataManager = new DataManager();

        // Enlazar los elementos  de la vista con el código Java
        TextView tvLenguaje = findViewById(R.id.tvLenguaje);
        Button btnVerOtroLenguaje = findViewById(R.id.btnVerOtroLenguaje);
        Button btnVerDescripcion = findViewById(R.id.btnVerDescripcion);

        // Mostrar el primer lenguaje
        actualizarVista(tvLenguaje);

        // Configurar el lissener del boton para cambiar de lenguaje
        btnVerOtroLenguaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataManager.siguienteLenguaje();
                actualizarVista(tvLenguaje);
            }
        });

        // Configurar el listener del botón para mostrar la descripción del lenguaje
        btnVerDescripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar la descripción del lenguaje actual
                Lenguaje lenguajeActual = dataManager.getLenguajeActual();
                tvLenguaje.setText(lenguajeActual.getNombre() + ": " + lenguajeActual.getDescripcion());
            }
        });

    }

    // Metodo para actualizar la vista con el lenguaje actual

    private void actualizarVista(TextView tvLenguaje) {
        Lenguaje lenguajeActual = dataManager.getLenguajeActual();
        tvLenguaje.setText(lenguajeActual.getNombre());
    }

    //

}