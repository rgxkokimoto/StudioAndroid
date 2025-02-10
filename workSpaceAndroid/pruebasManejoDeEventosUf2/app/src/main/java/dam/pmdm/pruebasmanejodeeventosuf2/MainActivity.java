package dam.pmdm.pruebasmanejodeeventosuf2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaramos los elementos y se lo asignamos a los botones
        Button btnVistas = findViewById(R.id.button);
        Button btnLayouts = findViewById(R.id.button2);
        Button btnEventos = findViewById(R.id.button3);
        Button btnToast = findViewById(R.id.button4);


        btnVistas.setOnClickListener(new View.OnClickListener() { // Hola esto sirve para iniciar la aplicación
            @Override
            public void onClick(View view) {
                Intent intentVistas = new Intent(MainActivity.this, VistaActivity.class);
                startActivity(intentVistas);
                // setContentView(R.layout.activity_vistas);
            }
        });

        /* btnLayouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLayouts = new Intent(MainActivity.this, LayoutsActivity.class);
                startActivity(intentLayouts);
            }
        });

        btnEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEventos = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(intentEventos);
            }
        }); */

    }

}