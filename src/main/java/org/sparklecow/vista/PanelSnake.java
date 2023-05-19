package org.sparklecow.vista;

import org.sparklecow.modelo.CrecerSerpiente;
import org.sparklecow.modelo.GestionarComida;
import org.sparklecow.modelo.GestionarSerpiente;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelSnake extends JPanel implements Runnable{

    private Thread hilo;
    private GestionarComida gestionarComida;
    private PrimerMapa primerMapa;
    private VentanaMuerte ventanaMuerte;
    public GestionarSerpiente moverSerpiente;
    private CrecerSerpiente crecerSerpiente;
    private int tamaño, tamañoUnidad, cantidad;
    public int velocidad = 150;
    public String direccion = "right";
    public String proximaDireccion = "right";


    public PanelSnake(int tamaño, int cantidad, PrimerMapa primerMapa) {

        this.primerMapa = primerMapa;
        this.tamaño = tamaño;
        this.cantidad = cantidad;
        this.setOpaque(false);
        this.tamañoUnidad = tamaño / cantidad;
        List<int[]> snake = new ArrayList<>();
        this.moverSerpiente = new GestionarSerpiente(cantidad, this);
        this.gestionarComida = new GestionarComida(cantidad);
        this.crecerSerpiente = new CrecerSerpiente(moverSerpiente, gestionarComida);

        hilo = new Thread(this);
        hilo.start();
    }

    public void modificarProximaDireccion(String direccion){
        if((proximaDireccion.equals("right") || proximaDireccion.equals("left")) && (direccion.equals("up")||direccion.equals("down"))){
            this.proximaDireccion = direccion;
        }if((proximaDireccion.equals("up")||proximaDireccion.equals("down")) && (direccion.equals("right")||direccion.equals("left"))){
            this.proximaDireccion = direccion;
        }
    }

    public void cambiarDireccion(){
        this.direccion=proximaDireccion;
    }

    public void getVentanaMuerte(){
        if(moverSerpiente.muerto){
            ventanaMuerte = new VentanaMuerte(primerMapa);
            ventanaMuerte.setVisible(true);
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(new Color(255, 160, 64));
        for (int[] ints : moverSerpiente.snake) {
            g.fillRect(ints[0] * tamañoUnidad, ints[1] * tamañoUnidad, tamañoUnidad - 1, tamañoUnidad - 1);
        }
        g.setColor(new Color(23, 165, 137 ));
        g.fillRect(gestionarComida.manzana[0]*tamañoUnidad, gestionarComida.manzana[1]*tamañoUnidad, tamañoUnidad-1, tamañoUnidad-1);
    }

    @Override
    public void run() {
        while(!moverSerpiente.muerto){
            int sleep = velocidad;
            moverSerpiente.avanzar();
            crecerSerpiente.crecerSerpiente();
            repaint();
            getVentanaMuerte();
            gestionarComida.generarManzana(moverSerpiente.snake);

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

