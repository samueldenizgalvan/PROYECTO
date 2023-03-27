package com.company.view;

import com.company.controladores.ControladorPanelPersonas;
import com.company.crud.QueryPossibilities;
import com.company.database.ConectionBD;
import com.company.model.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ViewPersonas extends JFrame {

    private final Map<String, QueryPossibilities> posibilidadesBusqueda = new HashMap<>();
    private final DefaultTableModel defaultTableModel = new DefaultTableModel();

    private final ConectionBD conectionBD;
    private final ControladorPanelPersonas controlador;
    private final MenuPrincipalView menuPrincipalView;


    private JTextField busquedaPorID; //
    private JButton btnEditar; //
    private JButton btnEliminar;
    private JPanel panelEntrada;
    private JButton btnNuevo;
    private JTable tablaDatos;
    private JButton button3;
    private JComboBox comboBox1;

    private int row;
    private String id;


    public ViewPersonas(ConectionBD conectionBD, MenuPrincipalView menuPrincipalView) {
        super("Personas");
        this.conectionBD = conectionBD;
        this.controlador = new ControladorPanelPersonas(conectionBD);
        this.menuPrincipalView = menuPrincipalView;
        loadComboBox();
        btnEliminar.setEnabled(false);
        setContentPane(panelEntrada);
        setSize(1500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnEditar.addActionListener(this::btnEditarActionPerformed);
        btnEditar.setText("Editar");
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);
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
    private void btnEditarActionPerformed(ActionEvent e) {
        if (id.isBlank() || id == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna persona");
            return;
        }

        Optional<Persona> persona = controlador.buscarPorId(Integer.parseInt(id));

        if (persona.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se ha encontrado la persona");
            return;
        }

        FichaPersona fichaPersona = new FichaPersona(this, true, conectionBD, controlador, "Editar Cliente",persona.get());
        fichaPersona.setVisible(true);
    }


    private void btnNuevoActionPerformed(ActionEvent e) {
        FichaPersona fichaPersona = new FichaPersona(this, true, conectionBD, controlador, "Nuevo Cliente");
        fichaPersona.setVisible(true);
    }

    private void btnEliminarActionPerformed(ActionEvent e) {
        if (id.isBlank() || id == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna persona");
            return;
        }
            if (JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar a la persona seleccionada?", "Eliminar persona", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                controlador.eliminarPersonaPorId(Integer.parseInt(id));
                tablaDatos.setModel(controlador.cargarDatos(defaultTableModel));
                btnEliminar.setEnabled(false);
            }

    }

    private void addMouseClickedEventTable(MouseEvent e){
        row = tablaDatos.rowAtPoint(e.getPoint());
        id = tablaDatos.getValueAt(row, 0).toString();
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

        String selectedItem = comboBox1.getSelectedItem().toString();

        if (selectedItem.isBlank() || selectedItem == null) {
            tablaDatos.setModel(controlador.cargarDatos(defaultTableModel));
            return;
        }

        QueryPossibilities queryPossibilities = posibilidadesBusqueda.get(selectedItem);
        tablaDatos.setModel(controlador.cargarDatosPorCaracteristicas(defaultTableModel, queryPossibilities, texto));
    }

    private void loadComboBox() {
        for (QueryPossibilities queryPossibilities : QueryPossibilities.values()) {
            posibilidadesBusqueda.put(queryPossibilities.getNombre(), queryPossibilities);
            comboBox1.addItem(queryPossibilities.getNombre());
        }

    }

    public void cargarDatos(){
        tablaDatos.setModel(controlador.cargarDatos(defaultTableModel));
    }
}
