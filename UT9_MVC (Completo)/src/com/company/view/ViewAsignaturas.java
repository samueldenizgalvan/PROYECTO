package com.company.view;

import com.company.controladores.ControladorPanelAsignaturas;
import com.company.database.ConectionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ViewAsignaturas extends JFrame {

    private final DefaultTableModel defaultTableModel = new DefaultTableModel();

    private final ConectionBD conectionBD;
    private final ControladorPanelAsignaturas controlador;
    private final MenuPrincipalView MenuPrincipalView;


    private JTextField busquedaPorID; //
    private JButton btnGuardar; // es para cambiar de nombre esos textfields  me leiste antes?
    private JButton btnEliminar;
    private JPanel panelEntrada;
    private JButton btnNuevo;
    private JTable tablaDatos;
    private JButton button3;


    public ViewAsignaturas(ConectionBD conectionBD, MenuPrincipalView MenuPrincipalView) {
        super("Asignaturas");
        this.conectionBD = conectionBD;
        controlador = new ControladorPanelAsignaturas(conectionBD);
        this.MenuPrincipalView = MenuPrincipalView;
        setContentPane(panelEntrada);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int halfScreenWidth = screenSize.width / 2;
        setSize(halfScreenWidth, screenSize.height);
        setLocationRelativeTo(null);
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);
        tablaDatos.setModel(controlador.cargarDatos(defaultTableModel));
        tablaDatos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addMouseClickedEventTable(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipalView MenuPrincipalView = new MenuPrincipalView(conectionBD);
                dispose();
            }
        });
    }


    private void btnNuevoActionPerformed(ActionEvent e) {

    }

    private void btnGuardarActionPerformed(ActionEvent e) {

    }

    private void btnEliminarActionPerformed(ActionEvent e) {

    }

    private void addMouseClickedEventTable(MouseEvent e){
        e.consume();
    }

}