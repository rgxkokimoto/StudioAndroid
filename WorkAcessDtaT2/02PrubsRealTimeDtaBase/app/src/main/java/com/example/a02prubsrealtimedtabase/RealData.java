package com.example.a02prubsrealtimedtabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a02prubsrealtimedtabase.databinding.ActivityRealDataBinding;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class RealData extends AppCompatActivity {
    ActivityRealDataBinding binding;
    // Declarar instancia de ActivityReadDataBinging binding;
    // Referencia a la bbdd de firebase
    DatabaseReference ref;
    // Iniciar la bbdd de firebase
    FirebaseDatabase firebase;
    // Inicializar variale Lissener
    ValueEventListener listener;

    int lecturaCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_real_data);

        // Inicializamos bunding, con el layout de la vista ReadData
        binding = ActivityRealDataBinding.inflate(getLayoutInflater());

        // Establecemos el contenido de la actividad  con la vista generada por ViewBinding
        setContentView(binding.getRoot());

        // Configuramos 1 click lissener para el botón de leer datos

        binding.btnReadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.etUserName.getText().toString();

                // Validar si tiene contenido el campo
                if (!username.isEmpty()) {

                    // metodo para hacer la lectura
                    readData(username);

                } else {
                    Toast.makeText(RealData.this, "Introduce el username",Toast.LENGTH_SHORT).show();
                }

            }

        });


    }

    // METODOS DE LECTURA

    // 1º  Metodos comun

    private void readData(String username) {
            // Obtenemos la refernecia a la bbdd de la firebase del nodo "Users"
            ref = firebase.getInstance().getReference("users");

            ref.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String firstName = snapshot.child("firstName").getValue(String.class);
                        String lastName = snapshot.child("lastName").getValue(String.class);
                        Integer age = snapshot.child("age").getValue(Integer.class);

                        binding.tvFirstName.setText("Nombre: " + firstName);
                        binding.tvLastName.setText("Apellido: " + lastName);
                        binding.tvAge.setText("Edad: " + age);

                        Toast.makeText(RealData.this, "Lectura correcta del usuario", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(RealData.this, "El usario no exite en la bbdd", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(RealData.this, "Error al leer", Toast.LENGTH_SHORT).show();
                }
            });



    }

    // 2º METODO con ValueEvennt Listener (se queda escuchando para mantener actualizado la UI)

    /* private void readData(String username) {

        ref = firebase.getInstance().getReference("users");

        listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String firstName = snapshot.child("firstName").getValue(String.class);
                    String lastName = snapshot.child("lastName").getValue(String.class);
                    Integer age = snapshot.child("age").getValue(Integer.class);

                    binding.tvFirstName.setText("Nombre: " + firstName);
                    binding.tvLastName.setText("Apellido: " + lastName);
                    binding.tvAge.setText("Edad: " + age);

                    //
                    lecturaCount++;

                    if (lecturaCount == 1) {

                        ref.removeEventListener(listener);
                        Toast.makeText(RealData.this, "Lissener eliminado no se actualiza mas la ui", Toast.LENGTH_SHORT).show();

                    }

                    Toast.makeText(RealData.this, "Lectura correcta del usuario", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RealData.this, "El usario no exite en la bbdd", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(RealData.this, "Error al leer", Toast.LENGTH_SHORT).show();
            }
        };

        ref.child(username).addValueEventListener(listener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Eliminar el lisener cuando la actividad no este visible para
        // Ahorrar memoria ;)

        if (listener != null) {
            ref.removeEventListener(listener);
            Log.d("Listener", "Listener eliminado");
        }

    } */

    // 3º Forma de lectura de forma Asincrona

   /* private void readData(String username) {

        ref = firebase.getInstance().getReference("users");

        // Adcedo al nodo especifico con el usario especifico
        ref.child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {
                        Toast.makeText(RealData.this, "Lectura correcta", Toast.LENGTH_SHORT).show();

                        DataSnapshot dataSnapshot = task.getResult();

                        String firstName = dataSnapshot.child("firstName").getValue(String.class);
                        String lastName = dataSnapshot.child("lastName").getValue(String.class);
                        Integer age = dataSnapshot.child("age").getValue(Integer.class);

                        binding.tvFirstName.setText("Nombre: " + firstName);
                        binding.tvLastName.setText("Apellido: " + lastName);
                        binding.tvAge.setText("Edad: " + age);

                    } else {
                        Toast.makeText(RealData.this, "El Usario no existe", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RealData.this, "Error al leer", Toast.LENGTH_SHORT).show();
                }

            }
        });
    } */

    // 4º METODO

    /*private void readData(String username) {
        ref = FirebaseDatabase.getInstance().getReference("users");

        // Este método hace que internamente los ides se reextructure para mantener un nuevo orden
        Query query = ref.orderByChild("lastName");
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String userName = snapshot.child("firstName").getValue(String.class);
                String lastName = snapshot.child("lastName").getValue(String.class);
                System.out.println("Usario agregado al nodo: " + userName + " " + lastName);
            }


            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String firstName = snapshot.child("firstName").getValue(String.class);
                String lastName = snapshot.child("lastName").getValue(String.class);

                System.out.println("Usuario " + firstName + " " + lastName + "  modificado en el nodo");
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                String firstName = snapshot.child("firstName").getValue(String.class);
                String lastName = snapshot.child("lastName").getValue(String.class);

                System.out.println("Usuario " + firstName + " " + lastName + "  borrado en el nodo");
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String firstName = snapshot.child("firstName").getValue(String.class);
                String lastName = snapshot.child("lastName").getValue(String.class);

                System.out.println("Usuario " + firstName + " " + lastName + "  movido dentro del nodo");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Error al leer los datos: " + error.getMessage());
            }
        });

    } */

}