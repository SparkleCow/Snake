package org.sparklecow.vista;

import javax.swing.*;
import java.awt.*;

public class PanelTablero extends JPanel {

    private int tamaño, tamañoUnidad, cantidad;
    public PanelTablero(int tamaño, int cantidad){
        this.tamaño = tamaño;
        this.cantidad = cantidad;
        this.tamañoUnidad = tamaño/cantidad;
        System.out.println(tamañoUnidad);
        this.setBackground(Color.GRAY);
    }

    @Override
    public void paint(Graphics gr){
        super.paint(gr);
        gr.setColor(Color.BLACK);
        for(int i=0; i<cantidad; i++){
            for(int j=0; j<cantidad; j++){
                gr.fillRect(i*tamañoUnidad, j*tamañoUnidad, tamañoUnidad-1,tamañoUnidad-1);
            }
        }
    }
}
