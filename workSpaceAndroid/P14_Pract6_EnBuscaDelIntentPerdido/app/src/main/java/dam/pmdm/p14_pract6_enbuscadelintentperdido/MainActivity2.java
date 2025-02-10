package dam.pmdm.p14_pract6_enbuscadelintentperdido;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvBienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        tvBienvenida = findViewById(R.id.tvBienvenida);
        // recuperamos el nombre de la clase singleton
        String name = ((ClasseApplicacionNombre) getApplicationContext()).getNombre();
        // String name = getIntent().getStringExtra("name");
        Resources res = getResources();
        tvBienvenida.setText(String.format(res.getString(R.string.tv_Bienvenida), name));
    }

    public  void atajoCorto (View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
        startActivity(intent);
    }

    public  void atajoLargo (View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
        startActivity(intent);
    }

}
