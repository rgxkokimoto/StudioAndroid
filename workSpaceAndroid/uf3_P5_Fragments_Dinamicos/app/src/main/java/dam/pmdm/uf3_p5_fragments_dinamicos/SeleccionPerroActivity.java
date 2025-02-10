package dam.pmdm.uf3_p5_fragments_dinamicos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionPerroActivity extends AppCompatActivity {
    // TODO boss

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_perro);

        LinearLayout layoutButtons = findViewById(R.id.layoutButtons);

        PerroDatos perroDatos = new PerroDatos();

        Button btnPerro = null;

        for (Perro perro : perroDatos.getPerrosNombres()) {
            btnPerro = new Button(this);
            btnPerro.setText(perro.getNombre());

            layoutButtons.addView(btnPerro);

            btnPerro.setOnClickListener(view -> {
                Intent intent = new Intent();
                intent.putExtra("nombrePerro", perro.getNombre());
                setResult(RESULT_OK, intent);
                finish();
            });

        }
    }

    public  void cancelar(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

}