package org.sparklecow.modelo;

public class CrecerSerpiente {

    private GestionarComida gestionarComida;
    private GestionarSerpiente gestionarSerpiente;
    public CrecerSerpiente(GestionarSerpiente gestionarSerpiente, GestionarComida gestionarComida){
        this.gestionarSerpiente = gestionarSerpiente;
        this.gestionarComida = gestionarComida;
    }

    public void crecerSerpiente(){
        int[] snakeHead = gestionarSerpiente.snake.get(gestionarSerpiente.snake.size()-1);
        if(snakeHead[0]==gestionarComida.manzana[0] && snakeHead[1]== gestionarComida.manzana[1]){
            gestionarSerpiente.snake.add(snakeHead);
            gestionarComida.cambiarEstado();
        }
    }
}
