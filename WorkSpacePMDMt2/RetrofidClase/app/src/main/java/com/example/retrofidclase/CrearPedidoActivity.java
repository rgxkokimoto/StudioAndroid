package com.example.retrofidclase;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.retrofidclase.controler.PedidoControler;
import com.example.retrofidclase.databinding.ActivityCrearPedidoBinding;
import com.example.retrofidclase.model.Pedido;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CrearPedidoActivity extends AppCompatActivity {

    private ActivityCrearPedidoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCrearPedidoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCrear.setOnClickListener(v -> crearPedido());

    }

    // Metodo para crear un pedido en la api
    private void crearPedido() {
        String cliente = binding.etCliente.getText().toString().trim();
        String producto = binding.etProducto.getText().toString().trim();
        int cantidad = Integer.parseInt(binding.etCantidad.getText().toString().trim());
        String fecha = binding.etFecha.getText().toString().trim();

        PedidoControler api = PedidoControler.retrofit.create(PedidoControler.class);

        // En swagger veras si en request body te pide el id la api oh no;
        Pedido newpedido = new Pedido(cliente, producto, cantidad, fecha);

        api.crearPedido(newpedido).enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CrearPedidoActivity.this, "Pedido creado correctamente", Toast.LENGTH_SHORT).show();
                    finish(); // Cierra la actividad
                } else {
                    Toast.makeText(CrearPedidoActivity.this, "Error al crear el pedido", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                Toast.makeText(CrearPedidoActivity.this, "Error de conexion oh servidor: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}