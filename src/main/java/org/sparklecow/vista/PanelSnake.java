package org.sparklecow.vista;

import org.sparklecow.modelo.GestionarComida;
import org.sparklecow.modelo.MovimientoSerpiente;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelSnake extends JPanel implements Runnable{

    private Thread hilo;
    private GestionarComida gestionarComida;
    private PrimerMapa primerMapa;
    private VentanaMuerte ventanaMuerte;
    private boolean muerto = false;
    private int tamaño, tamañoUnidad, cantidad;
    public String direccion = "right";
    public String proximaDireccion = "right";
    public MovimientoSerpiente moverSerpiente;
    //private List<int[]> snake = new ArrayList<>();

    public PanelSnake(int tamaño, int cantidad, PrimerMapa primerMapa) {

        this.primerMapa = primerMapa;
        this.tamaño = tamaño;
        this.cantidad = cantidad;
        this.setOpaque(false);
        this.tamañoUnidad = tamaño / cantidad;
        this.moverSerpiente = new MovimientoSerpiente(cantidad);
        this.gestionarComida = new GestionarComida(moverSerpiente.snake, cantidad);

        /*int[] a = {cantidad / 2 - 1, cantidad / 2 - 1};
        int[] b = {cantidad / 2, cantidad / 2 - 1};
        snake.add(a);
        snake.add(b);*/

        hilo = new Thread(this);
        hilo.start();
    }

    public void goAhead(){
        cambiarDireccion();
        int[] lastPart = snake.get(snake.size()-1);
        int moveX=lastPart[0];
        int moveY=lastPart[1];
        switch(direccion){
            case "right": moveX+=1; break;
            case "down": moveY+=1; break;
            case "left": moveX-=1; break;
            case "up": moveY-=1; break;
        }
        int[] snakeHead = {Math.floorMod(moveX, cantidad), Math.floorMod(moveY, cantidad)};
        for (int[] parte : snake) {
            if (snakeHead[0] == parte[0] && snakeHead[1] == parte[1]) {
                muerto = true;
                break;
            }
        }
        if(snakeHead[0]== gestionarComida.manzana[0] && snakeHead[1]== gestionarComida.manzana[1]){
            snake.add(snakeHead);
            gestionarComida.cambiarEstado();
        }
        snake.remove(0);
        snake.add(snakeHead);
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
        if(muerto){
            ventanaMuerte = new VentanaMuerte(primerMapa);
            ventanaMuerte.setVisible(true);
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(new Color(255, 160, 64));
        for (int[] ints : snake) {
            g.fillRect(ints[0] * tamañoUnidad, ints[1] * tamañoUnidad, tamañoUnidad - 1, tamañoUnidad - 1);
        }
        g.setColor(new Color(23, 165, 137 ));
        g.fillRect(gestionarComida.manzana[0]*tamañoUnidad, gestionarComida.manzana[1]*tamañoUnidad, tamañoUnidad-1, tamañoUnidad-1);
    }

    @Override
    public void run() {
        while(!muerto){
            goAhead();
            repaint();
            getVentanaMuerte();
            gestionarComida.generarManzana();

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

