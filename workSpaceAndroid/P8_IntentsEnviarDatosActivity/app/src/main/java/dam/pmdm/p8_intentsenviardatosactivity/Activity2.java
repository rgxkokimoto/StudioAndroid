package dam.pmdm.p8_intentsenviardatosactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private TextView tvNombreRec;
    private TextView tvEdadRec;
    private ListView lvListaRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);

        tvNombreRec = findViewById(R.id.tvNombre);
        tvEdadRec = findViewById(R.id.tvEdad);
        lvListaRec = findViewById(R.id.lvLista);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        // usamos los datos
        if (extras != null) {
            String nombre = extras.getString("nombre");
            String edad = extras.getString("edad");
            ArrayList<String> lista = extras.getStringArrayList("lista");

            tvNombreRec.setText("Bienvenido: " + nombre);
            tvEdadRec.setText("Tu edad es: " + edad);

            // Creo un adaptador para mostrar la lista en el list view
            // PASO OBLIGATORIO EN LA LISTAS
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
            lvListaRec.setAdapter(adapter);

        }



    }




}