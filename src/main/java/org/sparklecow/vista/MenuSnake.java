package org.sparklecow.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class MenuSnake extends JFrame{

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
        btnIniciar.setBounds(75, 295, 150, 70);
        btnIniciar.setBackground(new Color(255, 127, 80));
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
                btnIniciar.setBackground(new Color(255, 127, 80));
            }

        });
        JLabel iniciar = new JLabel("Iniciar juego");
        iniciar.setHorizontalAlignment(SwingConstants.CENTER);
        iniciar.setBounds(0, 0, 150, 70);
        iniciar.setForeground(new Color(240, 248, 255));
        iniciar.setFont(new Font("Roboto", Font.PLAIN, 16));
        btnIniciar.add(iniciar);

        panel.add(btnIniciar);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel btnCerrar = new JPanel();
        btnCerrar.setBounds(75, 420, 150, 70);
        btnCerrar.setBackground(new Color(255, 127, 80));
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
                btnCerrar.setBackground(new Color(255, 127, 80));
            }

        });
        JLabel Cerrar = new JLabel("Ver puntaje");
        Cerrar.setHorizontalAlignment(SwingConstants.CENTER);
        Cerrar.setBounds(50, 450, 150, 70);
        Cerrar.setForeground(new Color(240, 248, 255));
        Cerrar.setFont(new Font("Roboto", Font.PLAIN, 16));
        btnCerrar.add(Cerrar);

        btnIniciar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnCerrar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(btnIniciar);
        panel.add(btnCerrar);

        panel_1 = new JPanel();
        panel_1.setBounds(300, 0, 515, 840);
        panel_1.setBackground(new Color(255, 127, 80));
        panel.add(panel_1);
        panel_1.setLayout(null);
        panel_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel titulo = new JLabel("<< SNAKE >>");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(0, 50, 515, 50);
        titulo.setForeground(new Color(240, 248, 255));
        titulo.setFont(new Font("Roboto", Font.PLAIN, 20));
        panel_1.add(titulo);

        JLabel titulo2 = new JLabel("INSTRUCCIONES");
        titulo2.setHorizontalAlignment(SwingConstants.CENTER);
        titulo2.setBounds(0, 350, 515, 50);
        titulo2.setForeground(new Color(240, 248, 255));
        titulo2.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel_1.add(titulo2);

        JLabel texto = new JLabel("Para moverse, use las teclas W, S, A, D");
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setBounds(50, 420, 415, 30);
        texto.setForeground(new Color(240, 248, 255));
        texto.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel_1.add(texto);

        JLabel texto2 = new JLabel("Para acelerar, presione 'Espacio'");
        texto2.setHorizontalAlignment(SwingConstants.CENTER);
        texto2.setBounds(50, 450, 415, 30);
        texto2.setForeground(new Color(240, 248, 255));
        texto2.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel_1.add(texto2);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(new Color(220, 255, 182));
        g.fillRect(500, 200, 60, 30);
        g.setColor(Color.black);
        g.drawRect(500, 200, 60, 30);
        g.drawLine(460, 130, 670, 130 );
        g.setColor(new Color(220, 255, 182));
        g.fillRect(650, 300, 90, 30);
        g.setColor(Color.black);
        g.drawRect(650, 300, 90, 30);
    }
}
