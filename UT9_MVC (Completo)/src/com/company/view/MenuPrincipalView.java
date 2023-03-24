package com.company.view;

import com.company.database.ConectionBD;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MenuPrincipalView extends JFrame {

    private ConectionBD conectionBD;

    public MenuPrincipalView(ConectionBD conectionBD) {
        super("Mi menu princip");
        this.conectionBD = conectionBD;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image imagen = Toolkit.getDefaultToolkit().getImage("bienvenido.jpg");
        // Crea un JLabel con la imagen y lo agrega al centro del JFrame
        // Carga la imagen desde un archivo
        getContentPane().add(new MiJLabel(new ImageIcon(imagen)), BorderLayout.CENTER);

        // Crea un JPanel para los botones
        JPanel panelBotones = new JPanel();
        // Crea los botones y los agrega al panel
        JButton boton1 = new JButton("Personas");
        JButton boton2 = new JButton("Asignaturas");
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        boton1.addActionListener(this::jButton1ActionPerformed);


        // Agrega el panel de botones al sur del JFrame
        getContentPane().add(panelBotones, BorderLayout.SOUTH);

        // Ajusta el tamaño del JFrame y lo hace visible
        pack();
        setVisible(true);

        boton2.addActionListener(this::jButton2ActionPerformed);
    }

    public static void main(String[] args) {
        ConectionBD conectionBD;
        try {
            conectionBD = new ConectionBD();
            MenuPrincipalView MenuPrincipalView = new MenuPrincipalView(conectionBD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        ViewPersonas viewPersonas = new ViewPersonas(conectionBD, this);
        viewPersonas.setVisible(true);
        this.dispose();
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        ViewAsignaturas ViewAsignaturas = new ViewAsignaturas(conectionBD, this);
        ViewAsignaturas.setVisible(true);
        this.dispose();
    }

}

class MiJLabel extends javax.swing.JLabel {
    public MiJLabel(ImageIcon icon) {
        super(icon);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getIcon().getIconWidth(), getIcon().getIconHeight());
    }
}


