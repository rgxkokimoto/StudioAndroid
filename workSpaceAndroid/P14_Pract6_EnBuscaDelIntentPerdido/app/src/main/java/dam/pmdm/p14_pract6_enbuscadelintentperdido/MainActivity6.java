package dam.pmdm.p14_pract6_enbuscadelintentperdido;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity6 extends AppCompatActivity {

    private Button btnSeeInt;
    private Button btnExitGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSeeInt = findViewById(R.id.btnSeeInt);
        btnExitGame = findViewById(R.id.btnExitGame);

        btnSeeInt.setOnClickListener(
                view -> {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    // esto ya no es necesario pero bueno es un ejemplo ademas asi sera compatible con versiones
                    // antiguas de android.
                    //intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("https://developer.android.com/guide/components/intents-filters?hl=es-419"));
                    startActivity(intent);
                }
        );

        btnExitGame.setOnClickListener(
                view -> {
                    // Te reinicia la aplicación y todas las actividades por las que pasaste
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    // cierra todas las actividades de la aplicacion
                    // finishAffinity();
                }
        );
    }



}