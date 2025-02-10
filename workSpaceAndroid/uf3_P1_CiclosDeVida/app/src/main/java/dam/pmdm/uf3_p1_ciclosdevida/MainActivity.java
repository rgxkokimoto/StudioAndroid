package dam.pmdm.uf3_p1_ciclosdevida;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicleDeVida";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Registro mensaje en el onCrete
        Log.d(TAG, "onCreate llamado");
        Toast.makeText(this, "onCreate llmado", Toast.LENGTH_SHORT).show();

    }

    /*
    *   Estos metodos sirven para ver por QUE FASES
    *   pasa la aplicación cuando la ponemos en segundo plano
    *   la movemos oh la destruimos
    *
    *   todo esta en las  esta en las slides de la uf3 Ciclos de vida
     */

    @Override
    protected void onStart(){
        super.onStart();

        // Registro mensaje en el onStart
        Log.d(TAG, "onStart llamado");
        Toast.makeText(this, "onStart llamado", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume(){
        super.onResume();

        // Registro mensaje en el onStart
        Log.d(TAG, "onResumellamado");
        Toast.makeText(this, "onResume llamado", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        // Registro mensaje en el onPause
        Log.d(TAG, "onPause llamado");
        Toast.makeText(this, "onPause llamado", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        // Registro mensaje en el onStop
        Log.d(TAG, "onStop llamado");
        Toast.makeText(this, "onStop llamado", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy(){
        super.onDestroy();
        // Registro mensaje en el onDestroy
        Log.d(TAG, "onDestroy llamado");
        Toast.makeText(this, "onDestroy llamado", Toast.LENGTH_SHORT).show();
    }

    /*
    en el logat
    pon tag:CicleDeVida

    ---------------------------- PROCESS STARTED (5316) for package dam.pmdm.uf3_p1_ciclosdevida ----------------------------
2024-11-25 13:28:49.628  5316-5316  CicleDeVida             dam.pmdm.uf3_p1_ciclosdevida         D  onCreate llamado
2024-11-25 13:28:49.740  5316-5316  CicleDeVida             dam.pmdm.uf3_p1_ciclosdevida         D  onStart llamado
2024-11-25 13:28:49.759  5316-5316  CicleDeVida             dam.pmdm.uf3_p1_ciclosdevida         D  onResumellamado
2024-11-25 13:29:01.915  5316-5316  CicleDeVida             dam.pmdm.uf3_p1_ciclosdevida         D  onPause llamado
2024-11-25 13:29:02.002  5316-5316  CicleDeVida             dam.pmdm.uf3_p1_ciclosdevida         D  onStop llamado
2024-11-25 13:29:44.149  5316-5316  CicleDeVida             dam.pmdm.uf3_p1_ciclosdevida         D  onStart llamado
2024-11-25 13:29:44.165  5316-5316  CicleDeVida             dam.pmdm.uf3_p1_ciclosdevida         D  onResumellamado
2024-11-25 13:29:50.353  5316-5316  CicleDeVida             dam.pmdm.uf3_p1_ciclosdevida         D  onPause llamado
2024-11-25 13:29:50.362  5316-5316  CicleDeVida             dam.pmdm.uf3_p1_ciclosdevida         D  onStop llamado
    ---------------------------- PROCESS ENDED (5316) for package dam.pmdm.uf3_p1_ciclosdevida ----------------------------

     */

}