package dam.pmdm.uf3_p3_incremento;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tVIncremento;
    private int contador = 0;
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

        tVIncremento = findViewById(R.id.tVIncremento);
    }


    // Método para guardar la variable tras el giro
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("cicle", "onSaveInstanceState llamado");
        outState.putInt("cuenta", contador); // mira clave valor

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d("cicle", "onRestoreInstanceState llamado");
        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt("cuenta", 0);
        }

        tVIncremento.setText(String.valueOf(contador));

    }


    public void reinicioC(View view) {
        contador = 0;
        tVIncremento.setText(String.valueOf(contador));
    }

    public void incrementC(View view) {
        contador ++;
        tVIncremento.setText(String.valueOf(contador));

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("cicle", "onStart");
    }

    @Override
    protected void  onResume() {
        super.onResume();
        Log.d("cicle", "onResume");
    }



    @Override
    protected void onPause() {
        super.onPause();
        Log.d("cicle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("cicle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("cicle", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("cicle", "onRestart");
    }
}