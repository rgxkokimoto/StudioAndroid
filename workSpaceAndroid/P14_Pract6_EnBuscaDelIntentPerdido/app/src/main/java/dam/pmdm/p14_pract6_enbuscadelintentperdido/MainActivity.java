package dam.pmdm.p14_pract6_enbuscadelintentperdido;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edInpName;
    private Button btnEmpezar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edInpName = findViewById(R.id.edInputName);
        btnEmpezar = findViewById(R.id.btnEmpezar);

        btnEmpezar.setOnClickListener(
                view -> {

                    /*
                        al tener la clase ApplicacionNombre en el manifest
                        y util podriamos hacer que si no introduce nada ponga por defacto jugador para
                        no romper la lógica.
                     */

                    if (edInpName.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "El campo Introducir nombre no puede estar vacio", Toast.LENGTH_SHORT).show();
                    } else {
                        String name = edInpName.getText().toString();
                        Intent intent = new Intent(this, MainActivity2.class);

                        // guardar en el singleton nombre para usarla en el ciclo de vida de la aplicación
                        ((ClasseApplicacionNombre) getApplication()).setNombre(name);

                        startActivity(intent);
                    }
                }
        );

    }
}