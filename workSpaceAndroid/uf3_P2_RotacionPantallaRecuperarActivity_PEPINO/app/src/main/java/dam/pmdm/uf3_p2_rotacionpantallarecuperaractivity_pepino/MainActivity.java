package dam.pmdm.uf3_p2_rotacionpantallarecuperaractivity_pepino;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "cicleView"; // Tag para ver el ciclo de vida en los enventos del Logcat

    /*
        ---------------------------- PROCESS STARTED (6981) for package dam.pmdm.uf3_p2_rotacionpantallarecuperaractivity_pepino ----------------------------
2024-11-26 09:38:03.958  6981-6981  cicleView               dam...tallarecuperaractivity_pepino  D  onCreate llamada // se crea
2024-11-26 09:38:41.001  6981-6981  cicleView               dam...tallarecuperaractivity_pepino  D  mul llamada // usa el metodo mul
                                                                                                                // Se rota la llamada
2024-11-26 09:39:02.299  6981-6981  cicleView               dam...tallarecuperaractivity_pepino  D  onSaveInstanceState llamada // guarda el resultado antes de destruirse
2024-11-26 09:39:02.481  6981-6981  cicleView               dam...tallarecuperaractivity_pepino  D  onCreate llamada // se hace el ciclo y se vuelve a crear
2024-11-26 09:39:02.489  6981-6981  cicleView               dam...tallarecuperaractivity_pepino  D  onRestoreInstanceState llamada // se restaura el resultado

     */


    private EditText ed1;
    private EditText ed2;
    private TextView tvResult;
    private Bundle btnMul;
    private int resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate llamada");

        // TODO QUE LE PASA A ESTO
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        tvResult = findViewById(R.id.tvResult);

        /*
        // Restaurar el estado si savedInstanceState no es null antes crear el metodo para guardar en el final
        if (savedInstanceState != null) {
            resultado = savedInstanceState.getInt("resultado", 0);
            tvResult.setText(String.valueOf(resultado));
            tvResult.setText("Resultado: " + resultado);
        } */

        // Metodo que le mola a jorge onRestoreInstantState que no necesita del onCreate
        // Pero cuidado los dos son necesario savedIntance es para guardar las variables

    }

    public void mul(View view) {

        Log.d(TAG, "mul llamada");

        int num1 = Integer.parseInt(ed1.getText().toString());
        int num2 = Integer.parseInt(ed2.getText().toString());
        resultado = num1 * num2;
        tvResult.setText(String.valueOf(resultado));

    }

    // EVENTOS QUE NOS SALVAN DEL VOLCADO poner siempre al final
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState llamada");
        // Guardar el resultado en el bundle outState
        outState.putInt("resultado", resultado); // mira clave valor

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d(TAG, "onRestoreInstanceState llamada");
        if (savedInstanceState != null) {
            resultado = savedInstanceState.getInt("resultado", 0);
        }

        // Actualizar text view con el resultado restaurado
        tvResult.setText(String.valueOf(resultado));

    }

}

