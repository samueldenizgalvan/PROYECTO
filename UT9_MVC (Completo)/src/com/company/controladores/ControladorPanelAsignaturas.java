package com.company.controladores;

import com.company.crud.CRUDAsignatura;
import com.company.database.ConectionBD;
import com.company.model.Asignatura;

import javax.swing.table.DefaultTableModel;

public class ControladorPanelAsignaturas {

    private final CRUDAsignatura crudAsignaturas;

    public ControladorPanelAsignaturas(ConectionBD conectionBD) {
        this.crudAsignaturas = new CRUDAsignatura(conectionBD);
    }

    public DefaultTableModel cargarDatos(DefaultTableModel defaultTableModel) {
        String[] titulos = {"Nombre", "creditos", "tipo", "Curso", "cuatrimestre", "id_profesor", "id_grado"};
        defaultTableModel = new DefaultTableModel(null, titulos);
        for (Asignatura asignatura : crudAsignaturas.obtenerTodos()) {
            String[] fila = new String[10];
            fila[0] = asignatura.getNombre();
            fila[1] = asignatura.getcreditos();
            fila[2] = asignatura.gettipo();
            fila[3] = asignatura.getcurso();
            fila[4] = asignatura.getcuatrimestre();
            fila[5] = asignatura.getid_profesor();
            fila[6] = asignatura.getid_grado();
            defaultTableModel.addRow(fila);
        }
        return defaultTableModel;
    }
}