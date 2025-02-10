package dam.pmdm.p12_intententsimpcamarasygaleria;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private ImageView ivImagenTomada;

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

        ivImagenTomada = findViewById(R.id.ivImagenTomada);
    }

    // Configuracion del activity  result launcher para manejar la camara y traer la imagen de vuelta.
    private final ActivityResultLauncher<Intent> cameraLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if ( result.getResultCode() == RESULT_OK && result.getData() != null) {

                    Bitmap imageBitmap = (Bitmap) result.getData().getExtras().get("data");
                    // Mostrar la imagen en el ImageView
                    ivImagenTomada.setImageBitmap(imageBitmap);

                }
            }
    );


    // Configuarcion del activity result launcher para manaejar el acceso de la galeria y traer la imagen de vuelta
    private final ActivityResultLauncher<Intent> galleryLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if ( result.getResultCode() == RESULT_OK && result.getData() != null) {

                   Uri selecImage = result.getData().getData();
                   if (selecImage != null) {
                       ivImagenTomada.setImageURI(selecImage);
                   } else {
                       Toast.makeText(this, "No se selecciono ninguna imagen", Toast.LENGTH_SHORT).show();
                   }

                }
            }
    );
    // Configuracion del activity result launcher para manejar el acceso de la galeria y traer la imagen de vuelta
    private final ActivityResultLauncher<Intent> contentLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if ( result.getResultCode() == RESULT_OK && result.getData() != null) {

                    Uri selectedImageUri = result.getData().getData();
                    if (selectedImageUri != null) {
                        ivImagenTomada.setImageURI(selectedImageUri);
                    } else {
                        Toast.makeText(this, "No se selecciono ninguna imagen", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "No se selecciono ninguna imagen", Toast.LENGTH_SHORT).show();
                }
            }
    );

    public void openCamara(android.view.View view) {
        Intent takePicutureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            cameraLauncher.launch(takePicutureIntent);
        } catch (ActivityNotFoundException e)  {
            Toast.makeText(this, "No se encontro una app para abrir la camara", Toast.LENGTH_SHORT).show();
        }
    }

    // METODO para lanzar intent de la camara
    public  void openImage(android.view.View view) {
        // TODO
        Intent selectPictureIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        try {
            galleryLauncher.launch(selectPictureIntent);
        } catch (ActivityNotFoundException e)  {
            Toast.makeText(this, "No se encontro una app para abrir la galeria", Toast.LENGTH_SHORT).show();
        }

    }

    // METODO para lanzar intent de  selacion de almacenamiento
    public  void onGetContentClick(android.view.View view) {
        Intent getContentIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getContentIntent.setType("image/*"); // Especficar las que queremos
        try {
            contentLauncher.launch(getContentIntent);
        } catch (ActivityNotFoundException e)  {
            Toast.makeText(this, "No se encontro una app para abrir la galeria", Toast.LENGTH_SHORT).show();
        }
    }

}