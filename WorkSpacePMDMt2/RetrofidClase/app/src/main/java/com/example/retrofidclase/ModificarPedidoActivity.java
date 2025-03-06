package com.example.retrofidclase;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofidclase.controler.PedidoControler;
import com.example.retrofidclase.databinding.ActivityModificarPedidoBinding;
import com.example.retrofidclase.model.Pedido;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModificarPedidoActivity extends AppCompatActivity {

    private ActivityModificarPedidoBinding binding;
    private static Pedido oldpedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_pedido);

        binding = ActivityModificarPedidoBinding.inflate(getLayoutInflater());
        binding.getRoot();

        binding.btnBuscar.setOnClickListener(v -> buscarPedido());

        binding.btnModificar.setOnClickListener(v -> modificarPedido());


    }


    private void modificarPedido() {

        int id = Integer.parseInt(binding.etPedidoId.getText().toString().trim());
        String cliente = binding.etCliente.getText().toString().trim();
        String producto = binding.etProducto.getText().toString().trim();
        int cantidad = Integer.parseInt(binding.etCantidad.getText().toString().trim());
        String fecha = binding.etFecha.getText().toString().trim();

        Pedido updates = new Pedido(cliente, producto, cantidad, fecha);

        PedidoControler api = PedidoControler.retrofit.create(PedidoControler.class);

        api.modificarPedido(id, updates).enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(ModificarPedidoActivity.this, "Pedido Alterado Correctamente", Toast.LENGTH_SHORT).show();
                    buscarPedido();
                } else {
                    Toast.makeText(ModificarPedidoActivity.this, "Error al modificar el pedido: " + response.code(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                Toast.makeText(ModificarPedidoActivity.this, "Error al modificar el pedido: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void buscarPedido() {

        // Obtenemos el Id del edit text y lo convertimos a entero recuerda pedir el mismo tipo de daato que el de la api
        int id = Integer.parseInt(binding.etPedidoId.getText().toString().trim());

        // Instancia de retrofit
        PedidoControler api = PedidoControler.retrofit.create(PedidoControler.class);

        // LLamada asíncrona
        // Se realiza atraves de enqueue
        api.obtenerPedidoPorId(id).enqueue(new Callback<Pedido>() {
            @Override
            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                // Donde obtengo los datos en caso de que la respuesta sea exitosa.
                if (response.isSuccessful() && response.body() != null) {

                    oldpedido = response.body();
                    binding.etCliente.setText(oldpedido.getCliente());
                    binding.etProducto.setText(oldpedido.getProducto());
                    binding.etCantidad.setText(String.valueOf(oldpedido.getCantidad()));
                    binding.etFecha.setText(oldpedido.getFecha());

                } else {
                    Toast.makeText(ModificarPedidoActivity.this, "Pedido no encontrado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                Toast.makeText(ModificarPedidoActivity.this, "Error al cargar el pedido: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}