package com.example.retrofidclase.controler;

import com.example.retrofidclase.model.Pedido;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PedidoControler {
    // Si la monto en un docker y tengo una ip pongo el docker

    String API_URL = "http://10.0.2.2:8080/"; // En android es localhost o 10.0.2.2 (emulador)

    // Intancia de retrofit para comunicarnos con la api
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create()) // para que los datos de conviertan de json a objetos java
            .build();

    // Método para obtener todos los pedidos (GET)
    @GET("pedidos")
    Call<List<Pedido>> obtenerTodosLosPedidos();

    // Método para obtener un pedido por ID (GET)
    @GET("pedidos/{id}")
    Call<Pedido> obtenerPedidoPorId(@Path("id") int id); // que hace path?

    // Método para crear un pedido (POST)
    @POST("pedidos")
    Call<Pedido> crearPedido(@Body Pedido pedido);

    // Método para actualizar un pedido (PUT)
    @PUT("pedidos/{id}")
    Call<Pedido> modificarPedido(@Path("id") int id, @Body Pedido pedido);
}
