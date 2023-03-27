package com.company.view;

import com.company.controladores.ControladorPanelPersonas;
import com.company.database.ConectionBD;
import com.company.model.Sexo;
import com.company.model.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FichaPersona extends JDialog {

    private final ConectionBD conectionBD;
    private final ControladorPanelPersonas controlador;
    private final ViewPersonas viewPersonas;

    private String titulo;

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField NIFTextField;
    private JTextField nombreTextField;
    private JTextField primerApellidoTextField;
    private JTextField segundoApellidoTextField;
    private JTextField ciudadTextField;
    private JTextField direccionTextField;
    private JTextField telefonoTextField;
    private JTextField fechaDeNacimientoTextField;
    private JTextField generoTextField;
    private JTextField tipoTextField;

    private Persona persona;

    public FichaPersona(Frame owner, boolean modal, ConectionBD conectionBD, ControladorPanelPersonas controlador, String titulo, Persona persona){
        this(owner, modal, conectionBD, controlador, titulo);
        this.persona = persona;
        this.NIFTextField.setText(persona.getNIF());
        this.nombreTextField.setText(persona.getNombre());
        this.primerApellidoTextField.setText(persona.getApellidoPaterno());
        this.segundoApellidoTextField.setText(persona.getApellidoMaterno());
        this.ciudadTextField.setText(persona.getCiudad());
        this.direccionTextField.setText(persona.getDireccion());
        this.telefonoTextField.setText(persona.getTelefono());
        this.fechaDeNacimientoTextField.setText(persona.getFechaNacimiento().toString());
        this.generoTextField.setText(persona.getGenero().toString());
        this.tipoTextField.setText(persona.getTipo());
    }

    public FichaPersona(Frame owner, boolean modal,ConectionBD conectionBD ,ControladorPanelPersonas controlador, String titulo) {
        super(owner, modal);
        this.conectionBD = conectionBD;
        this.controlador = controlador;
        this.viewPersonas = (ViewPersonas) owner;
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
        if (!validarCampos()){
            return;
        }

        String NIF = NIFTextField.getText();
        String nombre = nombreTextField.getText();
        String primerApellido = primerApellidoTextField.getText();
        String segundoApellido = segundoApellidoTextField.getText();
        String ciudad = ciudadTextField.getText();
        String direccion = direccionTextField.getText();
        String telefono = telefonoTextField.getText();
        String fechaDeNacimiento = fechaDeNacimientoTextField.getText();
        String genero = generoTextField.getText();

        String tipo = tipoTextField.getText();

        Sexo sexoEnum = Sexo.MASCULINO;

        if (genero.equalsIgnoreCase("M")){
            sexoEnum = Sexo.FEMENINO;
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNacimientoLocalDate = LocalDate.parse(fechaDeNacimiento,dateTimeFormatter);
        Persona persona = new Persona(NIF, nombre, primerApellido, segundoApellido, ciudad, direccion, telefono, fechaNacimientoLocalDate, sexoEnum,tipo);

        if (titulo.equalsIgnoreCase("Editar Cliente")){
            persona.setId(this.persona.getId());
            controlador.crearPersona(persona);
            viewPersonas.cargarDatos();
            dispose();
            return;
        }

        controlador.crearPersona(persona);
        viewPersonas.cargarDatos();
        dispose();
    }

    private void btnCancelActionPerformed(ActionEvent e) {
        dispose();
    }


    private boolean validarCampos(){
        if (NIFTextField.getText().isBlank() || NIFTextField.getText().length() != 9){
            JOptionPane.showMessageDialog(this, "El NIF debe tener 9 caracteres o no puede estar vacio");
            return false;
        }
        if (nombreTextField.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacio");
            return false;
        }
        if (primerApellidoTextField.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "El primer apellido no puede estar vacio");
            return false;
        }
        if (segundoApellidoTextField.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "El segundo apellido no puede estar vacio");
            return false;
        }
        if (ciudadTextField.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "La ciudad no puede estar vacia");
            return false;
        }
        if (direccionTextField.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "La direccion no puede estar vacia");
            return false;
        }
        if (telefonoTextField.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "El telefono no puede estar vacio");
            return false;
        }
        if (fechaDeNacimientoTextField.getText().isBlank() && !fechaDeNacimientoTextField.getText().matches("yyyy-MM-dd")){
            JOptionPane.showMessageDialog(this, "La fecha de nacimiento no puede estar vacia o no tiene el formato correcto yyyy-MM-dd");
            return false;
        }
        if (generoTextField.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "El genero no puede estar vacio");
            return false;
        }
        if (tipoTextField.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "El tipo no puede estar vacio");
            return false;
        }
        return true;
    }

}



