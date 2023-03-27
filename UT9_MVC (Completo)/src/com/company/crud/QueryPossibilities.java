package com.company.crud;

public enum QueryPossibilities {

    NIF(2, "NIF", "nif"),
    NOMBRE(3, "Nombre", "nombre"),
    APELLIDO_PATERNO(4,"Apellido Paterno", "apellido1"),
    APELLIDO_MATERNO(5, "Apellido Materno", "apellido2"),
    CIUDAD(6, "Ciudad", "ciudad"),
    DIRECCION(7, "Direccion", "direccion"),
    TELEFONO(8, "Telefono", "telefono"),
    FECHA_NACIMIENTO(9, "Fecha de Nacimiento", "fecha_nacimiento"),
    SEXO(10, "Sexo FE / MA", "sexo"),
    TIPO(11, "Tipo", "tipo");


    private final int numeroColumna;
    private final String nombre;
    private final String nombreColumna;

    QueryPossibilities(int numeroColumna, String nombre, String nombreColumna) {
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
