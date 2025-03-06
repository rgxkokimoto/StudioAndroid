package com.example.retrofidclase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.retrofidclase.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ver todos los pedidos
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnListarPedidos.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ListarPedidosActivity.class));
        });

        // ver un pedido por id
        binding.btnConsultarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DetallePedidoActivity.class);
                startActivity(i);
            }
        });

        // crear un pedido por id
        binding.btnCrearPedido.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CrearPedidoActivity.class));
        });


    }
}