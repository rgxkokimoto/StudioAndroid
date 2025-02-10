package com.example.a03firebasestorage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.a03firebasestorage.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private DatabaseReference dbref;

    private StorageReference sRef;

    private Uri imageUri; // ruta local URL -> Ruta en Internet.

    private final ActivityResultLauncher<Intent> seleccionImagenLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
    result -> {
        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
            Intent data = result.getData();
            imageUri = data.getData();
            binding.ivUploadImage.setImageURI(imageUri);
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // vas a inicializar Realtime y storage en nodos especificos
        dbref = FirebaseDatabase.getInstance().getReference("Users"); // Si no esta creado se creará
        sRef = FirebaseStorage.getInstance().getReference("UsersImages"); // Si no esta creado se creará

        binding.ivUploadImage.setOnClickListener(v -> seleccionImagen());

        binding.btnGUardar.setOnClickListener(v -> guardarDatos());

        //binding.btnVerLista.setOnClickListener(v -> verLista());

        binding.btnVerLista.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), UserListActivity.class)));

    }

    private void seleccionImagen() {

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT); // recordar para acceder a documentos
        intent.setType("image/*");
        seleccionImagenLauncher.launch(intent); // Lanza la actividad y espera RESULT_OK

    }

    private  void guardarDatos() {

        String userName = binding.etUsername.getText().toString();
        StorageReference fileRef = sRef.child(userName + ".jpg") ;
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(uri -> {
                    User user = new User(
                            binding.etFirstName.getText().toString(),
                            binding.etLastName.getText().toString(),
                            userName,
                            binding.etEmail.getText().toString(),
                            uri.toString(),
                            Integer.parseInt(binding.etAge.getText().toString())
                    );

                    // Guardamos el objeto en Firebase Database bajo el nodo Users
                    dbref.child(userName).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                binding.etFirstName.setText("");
                                binding.etLastName.setText("");
                                binding.etUsername.setText("");
                                binding.etEmail.setText("");
                                binding.etAge.setText("");
                                binding.ivUploadImage.setImageResource(R.drawable.imagen);

                                Toast.makeText(MainActivity.this, "Registro Generado con exito", Toast.LENGTH_SHORT).show();
                            } else  {
                                Toast.makeText(MainActivity.this, "Error al generar el registro", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                });
            }
        });

    }

}