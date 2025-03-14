package dam.pmdm.pt4apchechoscuriosos3;


public class ListaHechos {
    private String [] hechos = {
            "Las hormigas se estiran cuando se despiertan por la mañana.",
            "Las avestruces pueden correr más rápido que los caballos.",
            "Las medallas de oro de los juegos olímpicos están hechas de plata.",
            "Naciste con 300 huesos pero en la edad adulta tendrás solo 206.",
            "Toma unos 8 minutos en llegar la luz del sol a la tierra.",
            "Algunas plantas de bambú pueden crecer hasta un metro al día.",
            "Los 10 trabajos más demandados en 2010 no existían en 2004.",
            "Algunos pingüinos pueden saltar de 2 a 3 metros por encima del agua.",
            "De media se tarda 66 días en tomar un nuevo hábito.",
            "Los mamuts seguían caminando sobre la tierra en la época en que se construyeron las grandes pirámides."
    };

    //Metodo para obtener un hecho aleatorio
    public String getHechoAleatorio(){
        //Generar un numero aleatorio entre 0 y el numero de hechos
        int randomIndex = (int) (Math.random() * hechos.length);
        return hechos[randomIndex];
    }
}
