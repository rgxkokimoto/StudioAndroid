package com.example.a01progressbars;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressBarIndeterminada extends AppCompatActivity {

    ProgressBar progressBarIndeterminada;
    Button btnComenzar;
    TextView tvIrA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_indeterminated);

        progressBarIndeterminada = findViewById(R.id.progressBarIndeterminado);
        btnComenzar = findViewById(R.id.btnComenzar);
        tvIrA = findViewById(R.id.tvIrA);


        // Asignamos evento a boton comenzar
        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Mostrar la progress bar cuando empiece la tarea
                progressBarIndeterminada.setVisibility(View.VISIBLE);


                // Simulo una tarea en segundo plano
                new Thread(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(() -> {
                        //Ocultamos la progressbar después de completar la tarea
                        progressBarIndeterminada.setVisibility(View.GONE);
                        Toast.makeText(ProgressBarIndeterminada.this, "Actividad completada", Toast.LENGTH_SHORT).show();
                    });
                }).start(); // XXX mola este lamda
            }
        });

        // Evento para cambiar de actividad
        tvIrA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProgresBarDeterminated.class);
                startActivity(i);
            }
        });

    }
}