package dam.pmdm.pt4apchechoscuriosos3;

import android.graphics.Color;

import java.util.Random;

public class ColoresFondo {

    private String[] colores = {
            "#39add1", "#3079ab", "#c25975", "#e15258", "#f9845b",
            "#838cc7", "#7d669e", "#53bbb4", "#51b46d", "#e0ab18"
    };

    public int getColorAleatorio() {
        // otra forma de hacer un random
        Random random = new Random();
        int randomIndex = random.nextInt(colores.length);
        return Color.parseColor(colores[randomIndex]);

        /* int randomIndex = (int) (Math.random() * colores.length);
        return Color.parseColor(colores[randomIndex]); */

    }

}
