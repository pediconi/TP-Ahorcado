package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Contenedor {

    private List<String> lista;
    private final Random aleatorio = new Random();
    private boolean ocupado = Boolean.FALSE;


    public Contenedor() {
        this.lista = new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
    }

    public List<String> getLista() {
        return lista;
    }

    public synchronized String getLetra()
    {
        String letra = "";

        while(ocupado) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ocupado = true;
        if (!lista.isEmpty())
            letra = this.lista.remove(aleatorio.nextInt(this.lista.size()));

        //index =  (index == lista.size()) ? index-1 : index;
        ocupado = false;
        notify();
        return letra;

    }


}