package dam.pmdm.firebaseauthentication;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    TextInputEditText etEmail, etPassword;
    // TODO hacer el boton para logearse con login (hay que mirar la docu oh el repositorio de jorge)
    Button btnLogin;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView tvClickRegister;

    //TODO Para que servia esto?
    /* @Override
    protected void onStart() {
        super.onStart();

        // Chequear que hay un usario activo
        FirebaseUser currentUser = mAuth.getCurrentUser();

        // esto es por seguridad
        if(currentUser != null) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }

    } */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // TODO Cambiar a binding
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etContrasenia);
        btnLogin = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);
        tvClickRegister = findViewById(R.id.tvClickRegister);

        tvClickRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Registro.class);
                startActivity(i);
            }
        });

        // borramos el contenido el el et email al tocar sobre el
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

        // Obtenemos la instancia de firebase auth
        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                progressBar.setVisibility(View.VISIBLE);

                String email, password;
                email = String.valueOf(etEmail.getText());
                password = String.valueOf(etPassword.getText());

                if (email.isEmpty()) {
                    Toast.makeText(Login.this, "Introduce un email" , Toast.LENGTH_SHORT).show();
                }

                if (password.isEmpty()) {
                    Toast.makeText(Login.this, "Introduce una contraseña" , Toast.LENGTH_SHORT).show();
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this,  "Login realizado con exito", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                    progressBar.setVisibility(View.GONE);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(Login.this,  "No se pudo realizar el login revise los datos introducidos", Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        });

            }
        });

    }
}