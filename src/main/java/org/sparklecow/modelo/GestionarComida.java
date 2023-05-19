package org.sparklecow.modelo;

import java.util.List;

public class GestionarComida {

    public int[] manzana = new int[2];
    private int cantidad;
    private List<int[]> snake;
    private boolean exist = true;

    public GestionarComida(List<int[]> snake, int cantidad){
        this.snake = snake;
        this.cantidad = cantidad;
    }

    public void generarManzana(){
        if(!exist){
            int a = (int) (Math.random()*cantidad);
            int b = (int) (Math.random()*cantidad);
            manzana[0]=a;
            manzana[1]=b;
            for(int[] parte : snake){
                if(manzana[0]==parte[0] && manzana[1]==parte[1]){
                    generarManzana();
                }
            }
            exist = true;
        }
    }

    public void cambiarEstado(){
        exist=false;
    }
}
