package dam.pmdm.uf3_p5_fragments_dinamicos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etNombrePerro;

    private Button btnSeleccionar;

    private ActivityResultLauncher<Intent> seleccionPerroLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etNombrePerro = findViewById(R.id.etNombrePerro);
        btnSeleccionar = findViewById(R.id.btnSeleccionar);

        // Configurar el ActivityResoultLouncher

        seleccionPerroLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),

                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String nomDog = result.getData().getStringExtra("nombrePerro");

                        if (nomDog != null) {
                            etNombrePerro.setText(nomDog);
                            btnSeleccionar.setText("Limpiar Datos");

                            // Cargaremos las intervenciones del perro selecionado
                            // cargarIntervenciones(nombrePerro); // TODO
                        }

                    }
                }
        );

        // Configuramos el botton selecionar perro para lanzar la actividad
        btnSeleccionar.setOnClickListener(View -> {
            if (btnSeleccionar.getText().toString().equals("Selecionar Perro")) { // TODO revisar como esta escrito
                // Lanzo la actividad para selecionar un perro
                Intent intent = new Intent(MainActivity.this, SeleccionPerroActivity.class);
                seleccionPerroLauncher.launch(intent);
            } else {
                // limpiarDatos(); todo
            }
        });
    }

    private void cargarItervenciones(String nombrePerro) {

        // Crear intancia de Perros datos
        PerroDatos perroDatos = new PerroDatos();
        // Buscar perro Selecionado en la instancia de perroDatos
        Perro perro = perroDatos.getPerroPorNombre(nombrePerro);

        // Obtener Fragment Manager y comenzar la transación
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        // Crear Fragmento dinamico para mostrar las intervenciones del Perro
        for (Intervencion inter : perro.getIntervenciones()) {
            Intervent_Frag fragment = Intervent_Frag.newInstance(inter); // TODO boss
            ft.add(R.id.contentFragmentos, fragment);
        }
        ft.commit();

    }

    private void limpiarDatos() {
        etNombrePerro.setText("");
        btnSeleccionar.setText("Selecionar Perro");

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        List<Fragment> fragmentosActivos = fm.getFragments();

        for (Fragment fragmento : fragmentosActivos) {
           if (fragmento instanceof Intervent_Frag) {
               ft.remove(fragmento);
           }
        }
        ft.commit();


    }

}