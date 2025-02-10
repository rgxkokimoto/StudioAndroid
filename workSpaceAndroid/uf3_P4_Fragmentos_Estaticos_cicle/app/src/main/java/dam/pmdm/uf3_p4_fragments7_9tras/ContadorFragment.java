package dam.pmdm.uf3_p4_fragments7_9tras;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContadorFragment extends Fragment {

    private static final String TAG = "cicleView_Fc";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private EditText etTexto;
    private TextView tvLetras;
    private Button btnCalcular;


    public ContadorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView llamado");
        View view = inflater.inflate(R.layout.fragment_contador, container, false);
        etTexto = view.findViewById(R.id.etTexto);
        tvLetras = view.findViewById(R.id.tvLetras);
        btnCalcular = view.findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }

        });

        return view;

    }

    private void calcular() {
        String texto = etTexto.getText().toString();
        int numLetras = texto.length();
        tvLetras.setText("Número de letras: " + numLetras);
    }

    // Evitar que se valla la info al rotar
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // guardar el texto creado en un Bundle
        Log.d(TAG, "onSaveInstanceState llamado guardando variable texto");
        outState.putString("texto", tvLetras.getText().toString());
    }

    // Lo recuperamos
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, "onSaveInstanceState llamado recuperando variable texto");
        if (savedInstanceState != null) {
            tvLetras.setText(savedInstanceState.getString("texto"));
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach llamado");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate llamado");
    }

    // Luego va el onCreateView()


    // Esta deprecado
    /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated llamado");
    } */

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart llamado");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume llamado");
    }

    // --------------------------

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause llamado");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop llamado");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView llamado");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy llamado");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach llamado");
    }

}

