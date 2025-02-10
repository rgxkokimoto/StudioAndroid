package dam.pmdm.p6_intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // asignar componentes
    EditText editText;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignamos componentes a la vista
        editText = findViewById(R.id.editText);
        btnSend = findViewById(R.id.btnSend);
    }

    // XXX esto esta contruido en el xml con un Onclick
    public void enviarDta (View view) {
        // recoge el dato
        String datos = editText.getText().toString();

        // lo introduce en la lógica de intent.
        Intent intent = new Intent(this, Activity.class);

        // METODO 1 putExtra()
        intent.putExtra("Info", datos); // $1 identificador $2 dato
        // METODO 2 Bundle
        /*Bundle extra = new Bundle();
        extra.putString("Info", datos);
        intent.putExtras(extra); */

        startActivity(intent);

        /*  ENVIAR INFORACION
            METODO 1
            En este caso hemos asignado el intent a una variable
            que le añade el metodo putExtra aunque este se puede
            llamar simplemente sin asiganr nada al intent que lo sepas.

            startActivity(new Intent(this, Actividad2.class));

            putExtra()
            Este método se encarga de añadir al intent el dato que queremos
            trasportar con el nombre que queramos.


            METODO 2 Bundle
            el metodo dos usan una clase llamada Bundle a la que de  la misma
            forma asignas un clave/valor que pueda asignarse a este para poder
            ser enviado.

            OPN: a primera vista el metodo 1 es mas simple no hace falta llamar
            a una clase.
            TODO investiga cual es mejor


         */

    }

}