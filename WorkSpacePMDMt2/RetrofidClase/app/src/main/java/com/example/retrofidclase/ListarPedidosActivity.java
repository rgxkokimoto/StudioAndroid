package com.example.retrofidclase;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.retrofidclase.controler.PedidoControler;
import com.example.retrofidclase.databinding.ActivityListarPedidosBinding;
import com.example.retrofidclase.model.Pedido;

import java.lang.reflect.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarPedidosActivity extends AppCompatActivity {

    private ActivityListarPedidosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListarPedidosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Creamos una istancia de retrofit con los metodos necesarios para crear la solicitud
        PedidoControler api = PedidoControler.retrofit.create(PedidoControler.class);

        // Llamamos de forma asincrona al metodo para obtener todos los pedidos
        api.obtenerTodosLosPedidos().enqueue(new Callback<List<Pedido>>() {
            @Override
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {
                if (response.isSuccessful()) {
                    // Obtenemos la lista de pedidos
                    List<Pedido> pedidos = response.body();

                    // Creamos un adpatador para el ListView
                    ArrayAdapter<Pedido> adapter = new ArrayAdapter<>(ListarPedidosActivity.this, android.R.layout.simple_list_item_1, pedidos);

                    // Asigamos el adaptador al ListView
                    binding.listViewPedidos.setAdapter(adapter);

                } else {
                    Toast.makeText(ListarPedidosActivity.this, "Error al cargar los pedidos: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Pedido>> call, Throwable t) {
                Toast.makeText(ListarPedidosActivity.this, "Error al cargar pedidos: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("ListarPedidosActivity", "Error al cargar pedidos" +  t.getStackTrace());
            }
        });

    }
}