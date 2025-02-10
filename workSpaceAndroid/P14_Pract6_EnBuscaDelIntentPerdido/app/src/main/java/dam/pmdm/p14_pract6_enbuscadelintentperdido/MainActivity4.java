package dam.pmdm.p14_pract6_enbuscadelintentperdido;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    private Button btnOpenDoor;
    private Button btnPickKey;
    private TextView tvBienvenida;
    private static boolean llave;

    private final ActivityResultLauncher<Intent> keyLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult()
            , result -> {
                if (result.getResultCode() == RESULT_OK) {
                    llave = true;
                }
                // No hace falta poner un else si por defacto ya esta en false.
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Pon el booleano aqui para asegurarse de que se asigne a false siempre
        llave = false;

        Resources res = getResources();
        String name = ((ClasseApplicacionNombre) getApplicationContext()).getNombre();
        // String name = getIntent().getStringExtra("name");
        btnOpenDoor = findViewById(R.id.btnOpenDoor);
        btnPickKey = findViewById(R.id.btnPickKey);
        tvBienvenida = findViewById(R.id.tvName);

        tvBienvenida.setText(String.format(res.getString(R.string.Name), name));

        btnOpenDoor.setOnClickListener(
                view -> {

                    if (llave) {
                        Intent intent = new Intent(MainActivity4.this, MainActivity6.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "No tienes la llave :(", Toast.LENGTH_SHORT).show();
                    }

                }
        );

        btnPickKey.setOnClickListener(
                view -> {
                    Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                    keyLauncher.launch(intent);
                }
        );

    }

}