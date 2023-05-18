package org.sparklecow.vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelSnake extends JPanel implements Runnable{

    private Thread hilo;
    private PrimerMapa primerMapa;
    private VentanaMuerte ventanaMuerte;
    private boolean exist = false;
    private boolean execute = true;
    private boolean muerto = false;
    private int tamaño, tamañoUnidad, cantidad;
    public String direccion = "right";
    private List<int[]> snake = new ArrayList<>();
    private int[] apple = new int[2];
    private int[] comprobacionMuerte = new int[2];

    public PanelSnake(int tamaño, int cantidad, PrimerMapa primerMapa) {

        this.primerMapa = primerMapa;
        this.tamaño = tamaño;
        this.cantidad = cantidad;
        this.setOpaque(false);
        this.tamañoUnidad = tamaño / cantidad;

        int[] a = {cantidad / 2 - 1, cantidad / 2 - 1};
        int[] b = {cantidad / 2, cantidad / 2 - 1};
        snake.add(a);
        snake.add(b);

        hilo = new Thread(this);
        hilo.start();
    }

    /**
     * Lo podemos mover xd
     */

    public void generarComida(){
        if(!exist){
            int a = (int) (Math.random()*cantidad);
            int b = (int) (Math.random()*cantidad);
            apple[0]=a;
            apple[1]=b;
            for(int[] parte : snake){
                if(apple[0]==parte[0] && apple[1]==parte[1]){
                    generarComida();
                }
            }
            exist = true;
        }
    }

    public void goAhead(){
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

        if(snakeHead[0]==apple[0] && snakeHead[1]==apple[1]){
            snake.add(snakeHead);
            exist = false;
        }

        snake.remove(0);
        snake.add(snakeHead);
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
        g.setColor(new Color(165, 204, 122));
        for (int[] ints : snake) {
            g.fillRect(ints[0] * tamañoUnidad, ints[1] * tamañoUnidad, tamañoUnidad - 1, tamañoUnidad - 1);
        }
        g.setColor(Color.RED);
        g.fillRect(apple[0]*tamañoUnidad, apple[1]*tamañoUnidad, tamañoUnidad, tamañoUnidad);
    }

    @Override
    public void run() {
        while(execute && !muerto){
            repaint();
            goAhead();
            getVentanaMuerte();
            generarComida();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void stop(){
        execute = false;
    }

    public void start(){
        execute = true;
    }
}

