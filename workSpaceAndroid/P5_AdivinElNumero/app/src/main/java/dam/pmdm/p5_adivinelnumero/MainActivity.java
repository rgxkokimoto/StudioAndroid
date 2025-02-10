package dam.pmdm.p5_adivinelnumero;

import android.content.res.Resources; // es para la prueba no lo quites
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    // TODO  revisa esta practica junto a la de jorge que estara en su repositorio y mira las diferencias.

    // Componentes Alterables
    private ConstraintLayout layoutMain;
    private TextView tvIntentos;
    private TextView tvPista;
    private  Button btnComparacion;
    private EditText etNumero;
    // Variables lógicas
    private int intents = 5;
    private int rdInt = generarRandomInt(); // esto deberia ser final?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Asociamos las variables Embajadoras con sus componentes
        btnComparacion = findViewById(R.id.btnComparacion);
        tvIntentos = findViewById(R.id.tvIntentos);
        tvPista = findViewById(R.id.tvPista);
        // Inmunized Error : se te olivido esta asociación de arriba y en un setText de abajo te ponia una
        // NullPointerException porque el objeto existia pero sin su asociación con la pantalla es cosniderado null
        layoutMain = findViewById(R.id.main);
        etNumero = findViewById(R.id.etNumero);

        // TODO prueba esto jorge ha hecho algo muy interesante con parametros y strings
        // Resources res = getResources(); // es lo mismo que usar el this dice axel.
        //tvIntentos.setText(String.format(res.getString(R.string.intentos_restantes), intents)); // params: String del recurso, variable que por orden se pondra en %1$d

        btnComparacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Valores de entrada
                String textUser = etNumero.getText().toString().trim();
                int respUser;

                // en caso de que el úsuario meta un caracter no romperá el código
                try {
                    respUser = Integer.parseInt(textUser);
                } catch (NumberFormatException e) {
                    respUser = -1;
                }

                // primer caso el juego sigue activo
                if (respUser != rdInt && intents > 1) {
                    // caso en el que el usario falla restará un intento
                    intents -= 1;
                    tvIntentos.setText(getString(R.string.intentos_restantes) + intents);

                    if (respUser > rdInt) {
                        tvPista.setText(R.string.el_n_mero_secreto_es_menor);
                    } else {
                        tvPista.setText(R.string.el_n_mero_secreto_es_mayor);
                    }
                // 2º caso el juego ha termidado y el usuario ha ganado o perdido
                } else {
                    btnComparacion.setEnabled(false);

                    if (respUser != rdInt) {
                        layoutMain.setBackgroundColor(getColor(R.color.color_derrota));
                        tvPista.setText(R.string.has_perdido);
                    } else {
                        layoutMain.setBackgroundColor(getColor(R.color.color_victoria));
                        tvPista.setText(R.string.has_ganado);
                    }

                }

            }
        });

    }

    private int generarRandomInt() {
        int randomN = (int) (Math.random() * 100 + 1);
        System.out.println(randomN);
        return randomN;

    }

}