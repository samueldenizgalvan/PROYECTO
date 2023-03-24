package com.company.crud;

public enum QueryPossibilities {

    NIF(2, "NIF", "nif", "NIF"),
    NOMBRE(3, "Nombre", "nombre", "NOMBRE"),
    APELLIDO_PATERNO(4,"Apellido Paterno", "apellido1", "APELLIDO_PATERNO"),
    APELLIDO_MATERNO(5, "Apellido Materno", "apellido2", "APELLIDO_MATERNO"),
    CIUDAD(6, "Ciudad", "ciudad", "CIUDAD"),
    DIRECCION(7, "Direccion", "direccion", "DIRECCION"),
    TELEFONO(8, "Telefono", "telefono", "TELEFONO"),
    FECHA_NACIMIENTO(9, "Fecha de Nacimiento", "fecha_nacimiento", "FECHA_NACIMIENTO"),
    GENERO(10, "Genero", "sexo", "GENERO"),
    TIPO(11, "Tipo", "tipo", "TIPO");


    private final int numeroColumna;
    private final String nombre;
    private final String nombreColumna;
    private final String nombreEnum;

    QueryPossibilities(int numeroColumna, String nombre, String nombreColumna, String nombreEnum) {
        this.numeroColumna = numeroColumna;
        this.nombre = nombre;
        this.nombreColumna = nombreColumna;
        this.nombreEnum = nombreEnum;
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

    public String getNombreEnum() {
        return nombreEnum;
    }
}
