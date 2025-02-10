package dam.pmdm.p8_intentsenviardatosactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);

    }

    public void enviarDatos(View view) {
        String nombre = etNombre.getText().toString();
        String edad = etEdad.getText().toString();

        //añadimos una lista de elementos
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");

        // Creamos inttent
        Intent intent = new Intent(this, Activity2.class);

        // creamos un bundle y añadimos los datos a enviar
        Bundle extras = new Bundle();
        extras.putString("nombre", nombre);
        extras.putString("edad", edad);
        extras.putStringArrayList("lista", lista);

        //añadimos el bundle a intent
        intent.putExtras(extras);

        // iniciamos la actividad
        startActivity(intent);
    }

}