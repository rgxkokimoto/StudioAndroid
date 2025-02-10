package dam.pmdm.p14_pract6_enbuscadelintentperdido;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {

    Button btnBackKey;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnBackKey = findViewById(R.id.btnBackKey);
        btnBack = findViewById(R.id.btnBack);

        // Vuelve sin la llave
        btnBack.setOnClickListener(
                view -> {
                    //Intent intent = new Intent(); no hace falta un intent
                    setResult(RESULT_CANCELED); //(RESULT_CANCELED,intent)
                    finish();
                }
        );

        // Vuelve con la llave
        btnBackKey.setOnClickListener(
                view -> {
                    // Intent intent = new Intent();
                    setResult(RESULT_OK);
                    finish();
                }
        );

    }

}