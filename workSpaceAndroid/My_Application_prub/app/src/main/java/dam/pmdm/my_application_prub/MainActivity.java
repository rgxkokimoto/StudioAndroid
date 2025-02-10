package dam.pmdm.my_application_prub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        Button btnVistas = findViewById(R.id.btnVistas);

        btnVistas.setOnClickListener(new View.OnClickListener() { // Hola esto sirve para iniciar la aplicación
            @Override
            public void onClick(View view) {
                Intent intentVistas = new Intent(MainActivity.this, VistaActivityEVA.class);
                startActivity(intentVistas);
            }
        });

        // FORMAS DDE CREAR ALERTAS O MENSAJES PARA EL USARIO TOAST
        // 1. Toast Normal.
        Toast.makeText(getApplicationContext(),"elige una opcion",Toast.LENGTH_LONG).show();


        // MENSAJE DE ALERTA
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Elige una opcion");
        builder.setMessage("Debes elegi una de las opciones disponibles");


    }
}