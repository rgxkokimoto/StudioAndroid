package dam.pmdm.p12_intentsnavegar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }

    public void openURL(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // esto ya no es necesario pero bueno es un ejemplo ademas asi sera compatible con versiones
        // antiguas de android.
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.google.com"));
        startActivity(intent);
    }

    // para abrir el marcador de llamadas
    public void openDialer(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:123456789"));
        startActivity(intent);
    }

    // Metodo para enviar un sms
    public void openSms(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO); // ACTION_SEND || ACTION_VIEW
        intent.setData(Uri.parse("smsto:123456789"));
        intent.putExtra("sms_body", "Hola mundo");
        startActivity(intent);
    }

    // METODO PARA ABRIR EMAIL
    public void openEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822"); // MINE
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"james.monroe@examplepetstore.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "RECLAMACION");
        intent.putExtra(Intent.EXTRA_TEXT, "Hola mundo que guapo eres");
        // Puede fallar porque no reconozaca el gmail
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent.createChooser(intent, "Enviar un cliente de correo"));
        } else {
            Toast.makeText(this, "No se encontro un cliente de correo", Toast.LENGTH_SHORT).show();
        }
        // cuidado dependiendo de la api puede explotar esto.

    }

    // TODO NO ME VA 
    public void openMedia(View view) {
        // Asiganr el videoView
        VideoView videoView = findViewById(R.id.viewVideo);
        // Binding es otra forma de hacerlo en vez de findViewById y tiene su particularidades

        //Ruta al video
        //TODO Descarga un video lijero en el navegador y ponlo en la carpeta raw
        String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(uriPath);

        // Configurar el videoView y reproducirlo
        videoView.setVideoURI(uri);
        videoView.start();
    }



}