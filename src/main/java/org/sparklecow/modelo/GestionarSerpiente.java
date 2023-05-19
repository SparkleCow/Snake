package org.sparklecow.modelo;

import org.sparklecow.vista.PanelSnake;
import org.sparklecow.vista.VentanaJuego;
import org.sparklecow.vista.VentanaMuerte;

import java.util.ArrayList;
import java.util.List;

public class GestionarSerpiente {

    public  List<int[]> snake = new ArrayList<>();
    public boolean muerto = false;
    private PanelSnake panel;
    private int cantidad;
    public String direccion = "right";
    public String proximaDireccion = "right";

    public GestionarSerpiente(int cantidad, PanelSnake panel){
        this.panel = panel;
        this.cantidad = cantidad;
        int[] a = {cantidad / 2 - 1, cantidad / 2 - 1};
        int[] b = {cantidad / 2, cantidad / 2 - 1};
        snake.add(a);
        snake.add(b);
    }

    public void avanzar(){
        cambiarDireccion();
        int[] lastPart = snake.get(snake.size()-1);
        int moveX=lastPart[0];
        int moveY=lastPart[1];
        switch (direccion) {
            case "right" -> moveX++;
            case "down" -> moveY++;
            case "left" -> moveX--;
            case "up" -> moveY--;
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

    public void modificarProximaDireccion(String direccion){
        if((proximaDireccion.equals("right") || proximaDireccion.equals("left")) && (direccion.equals("up")||direccion.equals("down"))){
            this.proximaDireccion = direccion;
        }if((proximaDireccion.equals("up")||proximaDireccion.equals("down")) && (direccion.equals("right")||direccion.equals("left"))){
            this.proximaDireccion = direccion;
        }
    }

    public void getVentanaMuerte(VentanaJuego ventanaJuego){
        if(muerto){
            VentanaMuerte ventanaMuerte = new VentanaMuerte(ventanaJuego);
            ventanaMuerte.setVisible(true);
        }
    }

    public void cambiarDireccion(){
        this.direccion=proximaDireccion;
    }

    public void cambiarEstadoMuerto(){
        muerto=true;
    }

}
