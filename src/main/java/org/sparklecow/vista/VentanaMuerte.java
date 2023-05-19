package org.sparklecow.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMuerte extends JDialog implements ActionListener {

    private JButton btnRegreso, btnVolverIntentar;
    private PrimerMapa primerMapa;
    public VentanaMuerte(PrimerMapa primerMapa) {
        this.primerMapa = primerMapa;
        this.setTitle("Snake");
        this.setLayout(null);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setModal(true);
        this.setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        iniciarElementos();
    }

    public void iniciarElementos(){
        btnRegreso = new JButton("Regresar");
        btnVolverIntentar = new JButton("Volver a intentar");
        this.add(btnVolverIntentar);
        this.add(btnRegreso);
        btnRegreso.setBounds(30, 75, 150, 50);
        btnVolverIntentar.setBounds(205, 75, 150, 50);
        btnVolverIntentar.addActionListener(this);
        btnRegreso.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnRegreso){
            primerMapa.dispose();
            this.dispose();
            MenuSnake menu = new MenuSnake();
        }if(e.getSource() == btnVolverIntentar){
            this.dispose();
            primerMapa.dispose();
            primerMapa = new PrimerMapa();
        }
    }
}