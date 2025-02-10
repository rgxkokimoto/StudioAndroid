package dam.pmdm.firebaseauthentication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {

    //Inicializar variables
    TextInputEditText etEmail, etPassword;
    Button btnRegistro;
    ProgressBar progressBar;
    TextView tvClickLogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Asignar los componentes a la vista
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etContrasenia);
        btnRegistro = findViewById(R.id.btnRegistro);
        progressBar = findViewById(R.id.progressBar);
        tvClickLogin = findViewById(R.id.tvClickLogin);

        tvClickLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

        etEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    etEmail.setText("");
                }
            }
        });

        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    etPassword.setText("");
                }
            }
        });

        //Obtener una instancia de FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        // Crear el registro en fire base a aprtir del boton registro
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Activo la progres bar
                progressBar.setVisibility(View.VISIBLE);

                String email, password;
                email = String.valueOf(etEmail.getText());
                password = String.valueOf(etPassword.getText());

                // Comprobar que los campos estan vacios
                if (email.isEmpty()) {
                    Toast.makeText(Registro.this, "Introduce un email" , Toast.LENGTH_SHORT).show();
                }

                if (password.isEmpty()) {
                    Toast.makeText(Registro.this, "Introduce una contraseña" , Toast.LENGTH_SHORT).show(); // TODO
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Registro.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                //Ocultar la progresBar ya que la acción de registro se ha comletado
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Log.d("reg", "register:succes");
                                    Toast.makeText(Registro.this, " Cuenta creada con exito", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(getApplicationContext(),Login.class);
                                    startActivity(i);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Registro.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}