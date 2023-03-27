package com.company.view;

import com.company.controladores.ControladorPanelAsignaturas;
import com.company.controladores.ControladorPanelPersonas;
import com.company.database.ConectionBD;
import com.company.model.Asignatura;
import com.company.model.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FichaAsignatura extends JDialog {
    private final ConectionBD conectionBD;
    private final ControladorPanelAsignaturas controlador;
    private final ViewAsignaturas viewAsignaturas;
    private String titulo;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nombreTextField;
    private JTextField creditosTextField;
    private JTextField tipoTextField;
    private JTextField cursoTextField;
    private JTextField cuatrimestreTextField;
    private JTextField IDDelProfesorTextField;
    private JTextField IDDelGradoTextField;
    private Asignatura asignatura;

    public FichaAsignatura(Frame owner, boolean modal, ConectionBD conectionBD, ControladorPanelAsignaturas controlador, String titulo, Asignatura asignatura) {
        this(owner, modal, conectionBD, controlador, titulo);
        this.asignatura = asignatura;
        this.nombreTextField.setText(asignatura.getNombre());
        this.creditosTextField.setText(asignatura.getcreditos());
        this.tipoTextField.setText(asignatura.getTipo());
        this.cursoTextField.setText(asignatura.getCurso());
        this.cuatrimestreTextField.setText(asignatura.getCuatrimestre());
        this.IDDelProfesorTextField.setText(asignatura.getid_profesor());
        this.IDDelGradoTextField.setText(asignatura.getId_grado());
    }

    public FichaAsignatura(Frame owner, boolean modal,ConectionBD conectionBD ,ControladorPanelAsignaturas controlador, String titulo) {
        super(owner, modal);
        this.conectionBD = conectionBD;
        this.controlador = controlador;
        this.viewAsignaturas = (ViewAsignaturas) owner;
        this.titulo = titulo;
        setTitle(titulo);
        buttonOK.setText(titulo);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(400,700);

        buttonOK.addActionListener(this::btnOkActionPerformed);

        buttonCancel.addActionListener(this::btnCancelActionPerformed);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void btnOkActionPerformed(ActionEvent e) {
                if (!validarCampos()) {
                    return;
                }
                String nombre = nombreTextField.getText();
                String creditos = creditosTextField.getText();
                String tipo = tipoTextField.getText();
                String curso = cursoTextField.getText();
                String cuatrimestre = cuatrimestreTextField.getText();
                String IDDelProfesor = IDDelProfesorTextField.getText();
                String IDDelGrado = IDDelGradoTextField.getText();
        Asignatura asignatura = new Asignatura(nombre, creditos, tipo, curso, cuatrimestre, IDDelProfesor, IDDelGrado);

        if (titulo.equalsIgnoreCase("Editar Asignatura")){
            asignatura.setId(this.asignatura.getId());
            controlador.crearAsignatura(asignatura);
            viewAsignaturas.cargarDatos();
            dispose();
            return;
        }

        controlador.crearAsignatura(asignatura);
        viewAsignaturas.cargarDatos();
        dispose();
    }

    private void btnCancelActionPerformed(ActionEvent e) {
        dispose();
    }

    private boolean validarCampos() {
        if (nombreTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacio");
            return false;
        }
        if (creditosTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Este campo no puede estar vacio");
            return false;
        }
        if (tipoTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Este campo no puede estar vacio");
            return false;
        }
        if (cursoTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Este campo no puede estar vacio");
            return false;
        }
        if (cuatrimestreTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Este campo no puede estar vacio");
            return false;
        }
        if (IDDelProfesorTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Este campo no puede estar vacio");
            return false;
        }
        if (IDDelGradoTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Este campo no puede estar vacio");
            return false;
        }
        return true;
    }
}
