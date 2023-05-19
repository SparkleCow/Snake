package org.sparklecow.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PrimerMapa extends JFrame implements KeyListener{

    private final PanelTablero panelTablero;
    private final PanelSnake panelSnake;
    public PrimerMapa(){

        this.setTitle("Snake");
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(815, 840);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setFocusable(true);
        this.addKeyListener(this);
        getContentPane().setBackground(Color.GRAY);

        this.panelSnake = new PanelSnake(800, 20, this);
        panelSnake.setBounds(0, 0, 800, 800);
        this.add(panelSnake);

        this.panelTablero = new PanelTablero(800, 20);
        panelTablero.setBounds(0, 0, 800, 800);
        this.add(panelTablero);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'd', 'D' -> {
                panelSnake.modificarProximaDireccion("right");
            }
            case 'w', 'W' -> {
                panelSnake.modificarProximaDireccion("up");
            }
            case 's', 'S' -> {
                panelSnake.modificarProximaDireccion("down");
            }
            case 'a', 'A' -> {
                panelSnake.modificarProximaDireccion("left");
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            panelSnake.velocidad = 50;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            panelSnake.velocidad = 150;
        }
    }
}
