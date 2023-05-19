package org.sparklecow.vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class MenuSnake extends JFrame{

    //private JButton btnIniciar, btnVerPuntaje;
    private URL fondo;
    private Image icon;
    private JPanel panel_1;
    public MenuSnake(){
        this.setTitle("Snake");
        this.setLayout(null);
        this.setVisible(true);
        getContentPane().setBackground(new Color(165, 204, 122));
        this.setSize(815, 840);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(0,0, 815, 840);
        panel.setBackground(new Color(220, 255, 182));
        panel.setLayout(null);
        this.add(panel);

        JPanel btnIniciar = new JPanel();
        btnIniciar.setBounds(50, 275, 150, 70);
        btnIniciar.setBackground(new Color(240, 215, 182));
        btnIniciar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                MenuSnake.this.dispose();
                VentanaJuego ventanaJuego = new VentanaJuego();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnIniciar.setBackground(Color.red);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnIniciar.setBackground(Color.white);
            }

        });
        panel.add(btnIniciar);

        JPanel btnCerrar = new JPanel();
        btnCerrar.setBounds(50, 400, 150, 70);
        btnCerrar.setBackground(new Color(240, 215, 182));
        btnCerrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                MenuSnake.this.dispose();
                VentanaJuego ventanaJuego = new VentanaJuego();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCerrar.setBackground(Color.red);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnCerrar.setBackground(Color.white);
            }

        });
        panel.add(btnIniciar);
        panel.add(btnCerrar);

        panel_1 = new JPanel();
        panel_1.setBounds(300, 300, 300, 300);
        panel_1.setBackground(new Color(255, 127, 80));
        panel.add(panel_1);
        panel_1.setLayout(null);

        fondo = this.getClass().getResource("/imagenes/qqq.jpg");
        assert fondo != null;
        icon = new ImageIcon(fondo).getImage();
    }

    public void paintComponent(Graphics g){
        g.drawImage(icon, 0,0, panel_1.getWidth(), panel_1.getHeight(), null );

    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnVerPuntaje){
            System.exit(1);
        }if(e.getSource() == btnIniciar){

        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        final String nombre = "";
    }*/
}
