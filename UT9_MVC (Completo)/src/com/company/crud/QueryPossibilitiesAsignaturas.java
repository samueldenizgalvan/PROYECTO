package com.company.crud;

public enum QueryPossibilitiesAsignaturas {
    NOMBRE(2, "Nombre", "Nombre"),
    CREDITOS(3, "Creditos", "creditos"),
    TIPO(3, "TIPO", "tipo"),
    CURSO(4, "CURSO", "Curso"),
    Cuatrimestre(5, "Cuatrimestre", "Cuatrimestre"),
    IDDelProfesor(6, "IDDelProfesor", "id_profesor"),
    IDDelGrado(7, "IDDelGrado", "id_grado");
    private final int numeroColumna;
    private final String nombre;
    private final String nombreColumna;
    QueryPossibilitiesAsignaturas(int numeroColumna, String nombre, String nombreColumna) {
        this.numeroColumna = numeroColumna;
        this.nombre = nombre;
        this.nombreColumna = nombreColumna;
    }
    public int getNumeroColumna() {
        return numeroColumna;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreColumna() {
        return nombreColumna;
    }

}
