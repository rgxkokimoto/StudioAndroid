package dam.pmdm.uf3_p5_fragments_dinamicos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Intervent_Frag extends Fragment {

    // Metodo para instancia
    // tiene  cada una de las intervenciones de los perros

    public static Intervent_Frag newInstance(Intervencion inter) {

        // Método fabrica
        Intervent_Frag fabrica_Fragmento = new Intervent_Frag();

        // bundle para guardar los datos
        Bundle data = new Bundle();

        // TODO boss no estan los gets necesarios
        data.putString("fecha", inter.getFecha());
        data.putString("motivo", inter.getMotivo());
        data.putString("observaciones", inter.getObservacion());

        fabrica_Fragmento.setArguments(data);

        return fabrica_Fragmento;
    }

    // Inflar vista


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_intervent_, container, false);

        // Recuperar datos del Bundle al fragmento
        String fecha = getArguments().getString("fecha");
        String motivo = getArguments().getString("motivo");
        String observaciones = getArguments().getString("observaciones");

        // Actualizar la vista con los datos recuperados
        TextView tvFecha = view.findViewById(R.id.tvFecha);
        TextView tvMotivo = view.findViewById(R.id.tvMotivo);
        TextView tvObservaciones = view.findViewById(R.id.tvObservaciones);


        // Mostrar los valores en cada fragmento
        tvFecha.setText("Fecha: " + fecha);
        tvMotivo.setText("Motivo: " + motivo);
        tvObservaciones.setText("Observaciones: " + observaciones);

        return view;
    }
}