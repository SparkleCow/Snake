package org.sparklecow.modelo;

import java.util.Arrays;
import java.util.List;

public class GestionarComida {


    private int cantidad;
    public int[] manzana;
    private List<int[]> snake;
    private boolean exist = true;

    public GestionarComida(int cantidad){
        this.cantidad = cantidad;
        manzana = new int[]{(int) (Math.random() * cantidad), (int) (Math.random() * cantidad)};
    }

    public void generarManzana(List<int[]> snake){
        this.snake = snake;
        if(!exist){
            int a = (int) (Math.random()*cantidad);
            int b = (int) (Math.random()*cantidad);
            manzana[0]=a;
            manzana[1]=b;
            for(int[] parte : snake){
                if(manzana[0]==parte[0] && manzana[1]==parte[1]){
                    generarManzana(snake);
                }
            }
            exist = true;
        }
    }

    public void cambiarEstado(){
        exist=false;
    }
}
