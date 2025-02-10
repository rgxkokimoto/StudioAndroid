package dam.pmdm.uf3_p4_fragments7_9tras;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "cicleView";

    // El main esta vez no tiene casi codigo se encargan de ello los propios fragmentos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart(){
        super.onStart();
        // Registro mensaje en el onStart
        Log.d(TAG, "onStart llamado");
    }

    @Override
    protected void onResume(){
        super.onResume();
        // Registro mensaje en el onStart
        Log.d(TAG, "onResumellamado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Registro mensaje en el onPause
        Log.d(TAG, "onPause llamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Registro mensaje en el onStop
        Log.d(TAG, "onStop llamado");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        // Registro mensaje en el onDestroy
        Log.d(TAG, "onDestroy llamado");
    }

}