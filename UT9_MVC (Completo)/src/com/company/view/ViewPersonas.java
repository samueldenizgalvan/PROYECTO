package com.company.view;

import com.company.controladores.ControladorPanelPersonas;
import com.company.crud.QueryPossibilities;
import com.company.database.ConectionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class ViewPersonas extends JFrame {

    private final Map<String, QueryPossibilities> posibilidadesBusqueda = new HashMap<>();
    private final DefaultTableModel defaultTableModel = new DefaultTableModel();

    private final ConectionBD conectionBD;
    private final ControladorPanelPersonas controlador;
    private final MenuPrincipalView menuPrincipalView;


    private JTextField busquedaPorID; //
    private JButton btnGuardar; //
    private JButton btnEliminar;
    private JPanel panelEntrada;
    private JButton btnNuevo;
    private JTable tablaDatos;
    private JTextField busquedaPorNif;
    private JButton button3;

    private int row;
    private String nif;


    public ViewPersonas(ConectionBD conectionBD, MenuPrincipalView menuPrincipalView) {
        super("Personas");
        this.conectionBD = conectionBD;
        this.controlador = new ControladorPanelPersonas(conectionBD);
        this.menuPrincipalView = menuPrincipalView;
        btnEliminar.setEnabled(false);
        setContentPane(panelEntrada);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int halfScreenWidth = screenSize.width / 2;
        setSize(halfScreenWidth, screenSize.height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);
        tablaDatos.setModel(controlador.cargarDatos(defaultTableModel));
        tablaDatos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addMouseClickedEventTable(e);
            }
        });
        button3.addActionListener(this::button3ActionPerformed);
        busquedaPorID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                busquedaGeneralKeyEvent(e);
            }
        });
    }


    private void btnNuevoActionPerformed(ActionEvent e) {
        //TODO: Generar nueva ventana para añadir personas
    }

    private void btnGuardarActionPerformed(ActionEvent e) {

    }

    private void btnEliminarActionPerformed(ActionEvent e) {
        if (nif.isBlank() || nif == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna persona");
            return;
        }
            if (JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar a la persona seleccionada?", "Eliminar persona", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                controlador.eliminarPersona(nif);
                tablaDatos.setModel(controlador.cargarDatos(defaultTableModel));
                btnEliminar.setEnabled(false);
            }

    }

    private void addMouseClickedEventTable(MouseEvent e){
        row = tablaDatos.rowAtPoint(e.getPoint());
        nif = tablaDatos.getValueAt(row, 0).toString();

        btnEliminar.setEnabled(true);
    }

    private void button3ActionPerformed(ActionEvent e) {
        MenuPrincipalView MenuPrincipalView = new MenuPrincipalView(conectionBD);
        dispose();
    }

    private void busquedaGeneralKeyEvent(KeyEvent e) {
        String texto = busquedaPorID.getText();
        if (texto.isBlank() || texto == null) {
            tablaDatos.setModel(controlador.cargarDatos(defaultTableModel));
            return;
        }
        QueryPossibilities queryPossibilities = posibilidadesBusqueda.get("NIF");
        tablaDatos.setModel(controlador.cargarDatosPorCaracteristicas(defaultTableModel, queryPossibilities, texto));
    }

    private void loadComboBox() {

        for (QueryPossibilities queryPossibilities : QueryPossibilities.values()) {
            posibilidadesBusqueda.put(queryPossibilities.getNombreEnum(), queryPossibilities);
            //TODO: Añadir al comboBox las posibilidades de búsqueda de la base de datos y crear el comboBox
        }

    }

}
