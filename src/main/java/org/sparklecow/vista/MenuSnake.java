package org.sparklecow.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSnake extends JFrame implements ActionListener {

    private JButton btnIniciar, btnVerPuntaje;
    public MenuSnake(){
        this.setTitle("Snake");
        this.setLayout(null);
        this.setVisible(true);
        getContentPane().setBackground(Color.GRAY);
        this.setSize(815, 840);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        iniciarElementos();
    }

    public void iniciarElementos(){

        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0, 250, 840);
        panel1.setBackground(new Color(220, 255, 182));
        panel1.setLayout(null);
        this.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBounds(250, 0, 590, 840);
        panel2.setBackground(new Color(165, 204, 122));
        panel2.setLayout(null);
        this.add(panel2);

        btnIniciar = new JButton("Iniciar juego");
        btnVerPuntaje = new JButton("Ver mejor puntaje");
        panel1.add(btnVerPuntaje);
        panel1.add(btnIniciar);
        btnIniciar.setBounds(50, 275, 150, 70);
        btnVerPuntaje.setBounds(50, 400, 150, 70);
        btnIniciar.addActionListener(this);
        btnVerPuntaje.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnVerPuntaje){
            System.exit(1);
        }if(e.getSource() == btnIniciar){
            this.dispose();
            PrimerMapa primerMapa = new PrimerMapa();
        }
    }
}
