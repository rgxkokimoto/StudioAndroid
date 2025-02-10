package dam.pmdm.pt3apchechoscuriosos2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    // Declaramos las variables para las vistas
    private TextView tvHechoCurioso;
    private Button btnVerHecho;

    // Array de hechos curiosos
    private String[] hechosCuriosos  = {
            "Las hormigas se estiran cuando se despiertan por la mañana.",
            "Las avestruces pueden correr más rápido que los caballos.",
            "el hit the all stars salio en srhek debido al 11s",
            "Las medallas de oro de los juegos olímpicos están hechas de plata.",
            "Naciste con 300 huesos pero en la edad adulta tendrás solo 206.",
            "Toma unos 8 minutos en llegar la luz del sol a la tierra.",
            "Algunas plantas de bambú pueden crecer hasta un metro al día.",
            "Los 10 trabajos más demandados en 2010 no existían en 2004.",
            "Algunos pingüinos pueden saltar de 2 a 3 metros por encima del agua.",
            "De media se tarda 66 días en tomar un nuevo hábito.",
            "Los mamuts seguían caminando sobre la tierra en la época en que se construyeron las grandes pirámides."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Conectar las vistas con el código Java
        tvHechoCurioso = findViewById(R.id.tvHechoCurioso);
        btnVerHecho = findViewById(R.id.btnVerHecho);

        // Añadir el OnClickListener al botón
        btnVerHecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Generar un hecho curioso aleatorio
                Random random = new Random();
                int index = random.nextInt(hechosCuriosos.length);
                String hecho = hechosCuriosos[index];

                // Mostrar el hecho curioso en el TextView
                tvHechoCurioso.setText(hecho);
            }
        });

    }
}