package com.example.a03firebasestorage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a03firebasestorage.databinding.ActivityUserDetailBinding;
import com.squareup.picasso.Picasso;

public class UserDetailActivity extends AppCompatActivity {

    private ActivityUserDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        binding = ActivityUserDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent i = getIntent();

        if (i != null) {
            binding.tvFirstName.setText(i.getStringExtra("firstName"));
            binding.tvLastName.setText(i.getStringExtra("lastName"));
            binding.tvUsername.setText(i.getStringExtra("username"));
            binding.tvEmail.setText(i.getStringExtra("email"));
            binding.tvAge.setText(String.valueOf(i.getIntExtra("age", 0)));

            // Cargar Imagen de piccaso
            Picasso.get()
                    .load(i.getStringExtra("imageUrl"))
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(binding.ivProfile);
        }

        // Boton para volver a la listaç
        binding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(), UserListActivity.class));
                finish(); // Buena Práctica para finalizar la actividad ya que al ver muchos detalles la lista
                // se puede llenar
            }
        });

    }
}