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
        getContentPane().add(new MiJLabel(new ImageIcon(imagen)), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton boton1 = new JButton("Personas");
        JButton boton2 = new JButton("Asignaturas");
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        boton1.addActionListener(this::jButton1ActionPerformed);
        boton2.addActionListener(this::jButton2ActionPerformed);

        getContentPane().add(panelBotones, BorderLayout.SOUTH);

        pack();
        setVisible(true);


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


