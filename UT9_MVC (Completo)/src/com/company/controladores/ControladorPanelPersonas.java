package com.company.controladores;

import com.company.crud.CRUDPersona;
import com.company.crud.QueryPossibilities;
import com.company.database.ConectionBD;
import com.company.model.Persona;

import javax.swing.table.DefaultTableModel;

public class ControladorPanelPersonas {

    private final CRUDPersona crudPersona;

    public ControladorPanelPersonas(ConectionBD conectionBD) {
        this.crudPersona = new CRUDPersona(conectionBD);
    }

    public DefaultTableModel cargarDatos(DefaultTableModel defaultTableModel) {
        String[] titulos = {"NIF", "Nombre", "Apellido Paterno", "Apellido Materno", "Ciudad", "Dirección", "Teléfono", "Fecha Nacimiento", "Sexo", "Tipo"};
        defaultTableModel = new DefaultTableModel(null, titulos);
        for (Persona persona : crudPersona.obtenerTodos()) {
            String[] fila = new String[10];
            fila[0] = persona.getNIF();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellidoPaterno();
            fila[3] = persona.getApellidoMaterno();
            fila[4] = persona.getCiudad();
            fila[5] = persona.getDireccion();
            fila[6] = persona.getTelefono();
            fila[7] = persona.getFechaNacimiento().toString();
            fila[8] = persona.getGenero().getDescricao();
            fila[9] = persona.getTipo();
            defaultTableModel.addRow(fila);
        }
        return defaultTableModel;
    }

    public Persona crearPersona(Persona persona){
        return crudPersona.guardarPersona(persona);
    }

    public Persona buscarPorNIF(String nif){
        return crudPersona.buscarPorNIF(nif);
    }

    public void eliminarPersona(String nif) {
        crudPersona.eliminarPersonaPorNIF(nif);
    }

    public DefaultTableModel cargarDatosPorCaracteristicas(DefaultTableModel defaultTableModel, QueryPossibilities queryPossibilities, String valor) {
        String[] titulos = {"NIF", "Nombre", "Apellido Paterno", "Apellido Materno", "Ciudad", "Dirección", "Teléfono", "Fecha Nacimiento", "Sexo", "Tipo"};
        defaultTableModel = new DefaultTableModel(null, titulos);
        for (Persona persona : crudPersona.obtenerPersonaPorSusCaracteristicas(queryPossibilities, valor)) {
            String[] fila = new String[10];
            fila[0] = persona.getNIF();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellidoPaterno();
            fila[3] = persona.getApellidoMaterno();
            fila[4] = persona.getCiudad();
            fila[5] = persona.getDireccion();
            fila[6] = persona.getTelefono();
            fila[7] = persona.getFechaNacimiento().toString();
            fila[8] = persona.getGenero().getDescricao();
            fila[9] = persona.getTipo();
            defaultTableModel.addRow(fila);
        }
        return defaultTableModel;
    }
}
