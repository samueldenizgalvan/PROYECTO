package com.company.controladores;

import com.company.crud.CRUDAsignatura;
import com.company.crud.QueryPossibilitiesAsignaturas;
import com.company.database.ConectionBD;
import com.company.model.Asignatura;

import javax.swing.table.DefaultTableModel;
import java.util.Optional;

public class ControladorPanelAsignaturas {

    private final CRUDAsignatura crudAsignaturas;

    public ControladorPanelAsignaturas(ConectionBD conectionBD) {
        this.crudAsignaturas = new CRUDAsignatura(conectionBD);
    }

    public DefaultTableModel cargarDatos(DefaultTableModel defaultTableModel) {
        String[] titulos = {"ID","Nombre", "creditos", "tipo", "Curso", "cuatrimestre", "id_profesor", "id_grado"};
        defaultTableModel = new DefaultTableModel(null, titulos);
        for (Asignatura asignatura : crudAsignaturas.obtenerTodos()) {
            String[] fila = new String[10];
            fila[0] = String.valueOf(asignatura.getId());
            fila[1] = asignatura.getNombre();
            fila[2] = asignatura.getcreditos();
            fila[3] = asignatura.gettipo();
            fila[4] = asignatura.getcurso();
            fila[5] = asignatura.getcuatrimestre();
            fila[6] = asignatura.getid_profesor();
            fila[7] = asignatura.getid_grado();
            defaultTableModel.addRow(fila);
        }
        return defaultTableModel;
    }
    public Asignatura crearAsignatura(Asignatura asignatura){
        return crudAsignaturas.guardarAsignatura(asignatura);
    }
    public Optional<Asignatura> buscarPorId(int id) {
        return Optional.ofNullable(crudAsignaturas.buscarPorId(id));
    }

    public void eliminarAsignaturaPorId(int id) {
        crudAsignaturas.eliminarAsignaturaPorID(id);
    }
    public DefaultTableModel cargarDatosPorCaracteristicas(DefaultTableModel defaultTableModel, QueryPossibilitiesAsignaturas QueryPossibilitiesAsignaturas, String valor) {
        String[] titulos = {"nombre", "creditos", "tipo", "curso", "cuatrimestre", "id_profesor", "id_grado"};
        defaultTableModel = new DefaultTableModel(null, titulos);
        for (Asignatura asignatura : crudAsignaturas.obtenerAsignaturaPorSusCaracteristicas(QueryPossibilitiesAsignaturas, valor)) {
            String[] fila = new String[10];
            fila[1] = asignatura.getNombre();
            fila[2] = asignatura.getCreditos();
            fila[3] = asignatura.getTipo();
            fila[4] = asignatura.getCurso();
            fila[5] = asignatura.getCuatrimestre();
            fila[6] = asignatura.getId_profesor();
            fila[7] = asignatura.getId_grado();
            defaultTableModel.addRow(fila);
        }
        return defaultTableModel;
    }
}