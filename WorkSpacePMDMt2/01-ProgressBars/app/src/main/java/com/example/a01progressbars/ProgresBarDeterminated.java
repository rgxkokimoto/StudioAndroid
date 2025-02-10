package com.example.a01progressbars;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProgresBarDeterminated extends AppCompatActivity {

    ProgressBar progressBarDeterminado;
    Button btnComenzar;
    TextView tvIrA;

    // Nuevo elemento
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progres_bar_determinated);

        // Asignamos los componentes a la vista
        progressBarDeterminado = findViewById(R.id.progressBarDeterminado);
        btnComenzar = findViewById(R.id.btnComenzar);
        tvIrA = findViewById(R.id.tvIrA);

        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBarDeterminado.setVisibility(View.VISIBLE);

                Runnable task = new Runnable() {

                    int progress = 0;
                    @Override
                    public void run() {
                        if (progress <= 100) {
                            progressBarDeterminado.setProgress(progress);
                            progress++;
                            // llamar al run cada 10 miliseguntos para que se valla actualizando
                            handler.postDelayed(this, 10);
                        } else {
                            progressBarDeterminado.setVisibility(View.GONE);
                            Toast.makeText(ProgresBarDeterminated.this, "Actividad completada", Toast.LENGTH_SHORT).show();
                        }

                    }
                };

                // Inicio el proceso
                handler.post(task);

            }
        });
    }
}