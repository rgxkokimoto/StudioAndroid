package com.example.retrofidclase;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.retrofidclase.controler.PedidoControler;
import com.example.retrofidclase.databinding.ActivityDetallePedidoBinding;
import com.example.retrofidclase.model.Pedido;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*

Tip: en el cmd usa arp -a para ver todos los puertos de la red local

 */

public class DetallePedidoActivity extends AppCompatActivity {

    private ActivityDetallePedidoBinding binding;

    private static Pedido pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detalle_pedido);

        binding = ActivityDetallePedidoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configuramos el boton para buscar el pedido por su ID
        binding.btnBuscar.setOnClickListener(v ->  buscarPedido());


    }



    private Pedido buscarPedido() {

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
                    pedido = response.body();
                    String info = pedido.toString();
                    binding.tvResultado.setText(info);

                } else {
                    binding.tvResultado.setText("Pedido no encontrado");
                }
            }

            @Override
            public void onFailure(Call<Pedido> call, Throwable t) {
                Toast.makeText(DetallePedidoActivity.this, "Error al cargar el pedido: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return pedido;
    }
}