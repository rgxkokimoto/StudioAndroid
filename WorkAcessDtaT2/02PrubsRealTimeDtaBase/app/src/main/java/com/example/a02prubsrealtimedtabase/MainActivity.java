package com.example.a02prubsrealtimedtabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a02prubsrealtimedtabase.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String firstName, lastName , userName;
    Integer age;
    FirebaseDatabase firebass;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);         //binding no usa el típico setContentView

        binding = ActivityMainBinding.inflate(getLayoutInflater());         // Inicializar un objeto binding y utilizamos inflate para vincular la vista al controlador
        View view = binding.getRoot();
        setContentView(view);         // Establecemos la vista raiz inflada al que referencio todo el tiempo


        binding.btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = binding.etFirstName.getText().toString();
                lastName = binding.etLastName.getText().toString();
                age = Integer.parseInt(binding.etAge.getText().toString());
                userName = binding.etUsername.getText().toString();

                // Comprobar que no estan vacios
                if (!firstName.isEmpty() && !lastName.isEmpty() && age != null && !userName.isEmpty()) {

                    User user = new User(firstName, lastName, userName, age); // Creamos un objeto de tipo user con los campos inicializados

                    firebass = FirebaseDatabase.getInstance();  // obtenemos la refernecia de la bbdd

                    ref = firebass.getReference("users"); // Obtenemos la refernecia al nodo "users"

                    ref.child(userName).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.etFirstName.setText("");
                            binding.etLastName.setText("");
                            binding.etUsername.setText("");
                            binding.etAge.setText("");
                            Toast.makeText(MainActivity.this, "Registro almacenado con exito" , Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    Toast.makeText(MainActivity.this , "Hubo un problema con el registro", Toast.LENGTH_SHORT).show();
                }

            }
        });

        binding.tvIrLectura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RealData.class);
                startActivity(i);
            }
        });
    }
}