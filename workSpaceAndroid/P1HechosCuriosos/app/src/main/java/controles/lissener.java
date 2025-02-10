package controles;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dam.pmdm.p1T1HechosCuriosos.R;

public class lissener {

    // Inicializar los elementos para poder intactuar con ellos desde código java
    TextView tvSabiasQ = findViewById(R.id.tvSabiasQ);
    TextView tvHechoCurioso = findViewById(R.id.tvHechoCurioso);
    Button btnVerOtroHecho = findViewById(R.id.btnVerOtroHecho);

        btnVerOtroHecho.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // cambiar el texto de textView con otro hecho curioso
            tvHechoCurioso.setText("Los delfines duermen con un ojo abierto");
        }
    });

}
