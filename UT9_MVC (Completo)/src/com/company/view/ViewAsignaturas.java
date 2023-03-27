package com.company.view;

import com.company.controladores.ControladorPanelAsignaturas;
import com.company.crud.QueryPossibilitiesAsignaturas;
import com.company.database.ConectionBD;
import com.company.model.Asignatura;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ViewAsignaturas extends JFrame {
    private final Map<String, QueryPossibilitiesAsignaturas> posibilidadesBusqueda = new HashMap<String, QueryPossibilitiesAsignaturas>();

    private final DefaultTableModel defaultTableModel = new DefaultTableModel();

    private final ConectionBD conectionBD;
    private final ControladorPanelAsignaturas controlador;
    private final MenuPrincipalView MenuPrincipalView;


    private JTextField busquedaPorID;
    private JButton btnEliminar;
    private JPanel panelEntrada;
    private JButton btnNuevo;
    private JTable tablaDatos;
    private JButton button3;
    private JComboBox comboBox1;
    private JButton editarButton;
    private int row;
    private String id;


    public ViewAsignaturas(ConectionBD conectionBD, MenuPrincipalView MenuPrincipalView) {
        super("Asignaturas");
        this.conectionBD = conectionBD;
        controlador = new ControladorPanelAsignaturas(conectionBD);
        this.MenuPrincipalView = MenuPrincipalView;
        loadComboBox();
        cargarDatos();
        setContentPane(panelEntrada);
        setSize(1500,500);
        setLocationRelativeTo(null);
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);
        editarButton.addActionListener(this::btnEditarActionPerformed);
        editarButton.setText("Editar");
        tablaDatos.setModel(controlador.cargarDatos(defaultTableModel));
        tablaDatos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addMouseClickedEventTable(e);
            }
        });
        button3.addActionListener(this::button3ActionPerformed);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        busquedaPorID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                busquedaGeneralKeyEvent(e);
            }
        });
    }
    private void btnEditarActionPerformed(ActionEvent e) {
        if (id.isBlank() || id == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna asignatura");
            return;
        }

        Optional<Asignatura> asignatura = controlador.buscarPorId(Integer.parseInt(id));

        if (asignatura.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se ha encontrado la asignatura");
            return;
        }

        FichaAsignatura fichaAsignatura = new FichaAsignatura(this, true, conectionBD, controlador, "Editar Asignatura",asignatura.get());
        fichaAsignatura.setVisible(true);
    }




    private void btnNuevoActionPerformed(ActionEvent e) {
        FichaAsignatura fichaAsignatura = new FichaAsignatura(this, true, conectionBD, controlador, "Nueva asignatura");
        fichaAsignatura.setVisible(true);
    }
    private void button3ActionPerformed(ActionEvent e) {
        MenuPrincipalView MenuPrincipalView = new MenuPrincipalView(conectionBD);
        dispose();
    }

    private void btnEliminarActionPerformed(ActionEvent e) {
        if (id.isBlank() || id == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna asignatura");
            return;
        }
        if (JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar la asignatura seleccionada?", "Eliminar asignatura", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            controlador.eliminarAsignaturaPorId(Integer.parseInt(id));
            tablaDatos.setModel(controlador.cargarDatos(defaultTableModel));
            btnEliminar.setEnabled(false);
        }

    }
    private void addMouseClickedEventTable(MouseEvent e){
        row = tablaDatos.rowAtPoint(e.getPoint());
        id = tablaDatos.getValueAt(row, 0).toString();
        btnEliminar.setEnabled(true);
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

        QueryPossibilitiesAsignaturas QueryPossibilitiesAsignaturas = posibilidadesBusqueda.get(selectedItem);
        tablaDatos.setModel(controlador.cargarDatosPorCaracteristicas(defaultTableModel, QueryPossibilitiesAsignaturas, texto));
    }
    private void loadComboBox() {
        for (QueryPossibilitiesAsignaturas QueryPossibilitiesAsignaturas : QueryPossibilitiesAsignaturas.values()) {
            posibilidadesBusqueda.put(QueryPossibilitiesAsignaturas.getNombre(), QueryPossibilitiesAsignaturas);
            comboBox1.addItem(QueryPossibilitiesAsignaturas.getNombre());
        }

    }
    public void cargarDatos(){
        tablaDatos.setModel(controlador.cargarDatos(defaultTableModel));
    }

}