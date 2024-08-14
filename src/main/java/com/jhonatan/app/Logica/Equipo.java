package com.jhonatan.app.Logica;
/**
 *
 * @author Jhonatan
 */
import java.util.Observable;

public class Equipo extends Observable implements Runnable {

    private String nombre;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        int porcentaje = 0;
        int numeroAleatorio;
        try {
            while (porcentaje <= 100) {
                numeroAleatorio = generarNumeroAleatorio(1, 20);
                System.out.println("Equipo " + nombre + " aumentado en " + numeroAleatorio);
                porcentaje += numeroAleatorio;
                this.setChanged();
                this.notifyObservers(porcentaje);
                this.clearChanged();
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("error al sacar el porcentaje: " + e.getMessage());
        }
    }

    public static int generarNumeroAleatorio(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

}
