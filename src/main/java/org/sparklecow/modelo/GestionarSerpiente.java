package org.sparklecow.modelo;

import org.sparklecow.vista.PanelSnake;

import java.util.ArrayList;
import java.util.List;

public class GestionarSerpiente {

    public  List<int[]> snake = new ArrayList<>();
    public boolean muerto = false;
    private PanelSnake panel;
    private int cantidad;
    public int velocidad = 1;

    public GestionarSerpiente(int cantidad, PanelSnake panel){

        this.panel = panel;
        this.cantidad = cantidad;

        int[] a = {cantidad / 2 - 1, cantidad / 2 - 1};
        int[] b = {cantidad / 2, cantidad / 2 - 1};
        snake.add(a);
        snake.add(b);
    }

    public void avanzar(){
        panel.cambiarDireccion();
        int[] lastPart = snake.get(snake.size()-1);
        int moveX=lastPart[0];
        int moveY=lastPart[1];
        switch(panel.direccion){
            case "right": moveX+=velocidad; break;
            case "down": moveY+=velocidad; break;
            case "left": moveX-=velocidad; break;
            case "up": moveY-=velocidad; break;
        }
        int[] snakeHead = {Math.floorMod(moveX, cantidad), Math.floorMod(moveY, cantidad)};
        for (int[] parte : snake) {
            if (snakeHead[0] == parte[0] && snakeHead[1] == parte[1]) {
                cambiarEstadoMuerto();
                break;
            }
        }
        snake.remove(0);
        snake.add(snakeHead);
    }

    public void cambiarEstadoMuerto(){
        muerto=true;
    }

}
