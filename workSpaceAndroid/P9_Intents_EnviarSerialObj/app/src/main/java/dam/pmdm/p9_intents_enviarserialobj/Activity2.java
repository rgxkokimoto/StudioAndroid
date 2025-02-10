package dam.pmdm.p9_intents_enviarserialobj;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dam.pmdm.p9_intents_enviarserialobj.model.Persona;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Recoger objeto persona enviado desde main activity
        Persona persona = (Persona) getIntent().getSerializableExtra("persona");


        // Mostrar datos del objeto en el text view
        TextView textView = findViewById(R.id.txtViewObj); // TODO hacerlo en la vista

        if (persona != null) {
            textView.setText("Nombre: " + persona.getNombre() + "\nEdad: " + persona.getEdad());
        } else {
            textView.setText("No se ha recibido ningún objeto");
        }

    }
}