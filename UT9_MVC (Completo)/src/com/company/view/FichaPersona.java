package com.company.view;

import javax.swing.*;
import java.awt.event.*;

public class FichaPersona extends JDialog {
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

    public FichaPersona() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        FichaPersona dialog = new FichaPersona();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
