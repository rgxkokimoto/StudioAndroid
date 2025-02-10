package dam.pmdm.p6_intents;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Activity extends AppCompatActivity {

    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity);

        textView = findViewById(R.id.txtIntent);

        // recibir mensaje
        Intent intent = getIntent();
        String dato = intent.getStringExtra("Info");
        textView.setText("Has escrito: " + dato);

        // con Bundle
        /* Bundle extra = getIntent().getExtras();
        String dato2 = extra.getString("Info");
        textView.setText("Has escrito: " + dato2); */


        /*
            El código de arriba recibe un objeto intent
            lo extrae usando el nombre del dato que creamos en el
            MainActivity en el putExtra y lo imprimimos.

            es muy importante que el nombre del dato sea el mismo
         */


        // DAR RESPUSTA
        /*
            Ahora que recibimos la información vamos a devolver el mensaje
            y vamos a finalizar la actividad con el método finish()

         */

        // TODO el código de dar respuesta no se como se comporta del todo
        /*Intent resp = new Intent();
        resp.putExtra("Respuesta", "Mensaje recibido");
        setResult(RESULT_OK,resp);
        finish();*/

    }
}