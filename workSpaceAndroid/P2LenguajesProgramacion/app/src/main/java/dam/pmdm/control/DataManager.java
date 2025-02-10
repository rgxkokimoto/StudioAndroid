package dam.pmdm.control;

import java.util.ArrayList;
import java.util.List;

import dam.pmdm.pojo.Lenguaje;

public class DataManager {

    private List<Lenguaje> lenguajes;
    private int currentIndex;

    public DataManager() {
        lenguajes = new ArrayList<>();
        lenguajes.add(new Lenguaje("Java", "Java es un lenguaje " +
                "de programación orientado a objetos... "));
        lenguajes.add(new Lenguaje("Python", "Python es un lenguaje " +
                "de programación interpretado...")); lenguajes.add(new Lenguaje("C++", "C++ es un lenguaje "
                +  "de propósito general..."));
        lenguajes.add(new Lenguaje("JavaScript", "JavaScript es un lenguaje de programación usado para la web..."));

        lenguajes.add(new Lenguaje("Kotlin", "Kotlin es el lenguaje " +
                "moderno recomendado para Android."));

        currentIndex = 0; // ?
    }

    public Lenguaje getLenguajeActual() {
        return lenguajes.get(currentIndex);
    }

    public void siguienteLenguaje() {
        currentIndex = (currentIndex + 1) % lenguajes.size();
    }


}
