package com.company.model;

public class Asignatura{

    private int id;
    private String nombre;
    private String creditos;
    private String tipo;
    private String curso;
    private String cuatrimestre;
    private String id_profesor;
    private String id_grado;

    public Asignatura(String nombre, String creditos, String tipo, String curso, String cuatrimestre, String idProfesor, String idGrado) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.tipo = tipo;
        this.curso = curso;
        this.cuatrimestre = cuatrimestre;
        this.id_profesor = idProfesor;
        this.id_grado = idGrado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public String getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getId_grado() {
        return id_grado;
    }

    public void setId_grado(String id_grado) {
        this.id_grado = id_grado;
    }

    public int getid() {
        return id;
    }

    public String getcreditos() {
        return creditos;
    }

    public String gettipo() {
        return tipo;
    }

    public String getcurso() {
        return curso;
    }
    public String getcuatrimestre() {
        return cuatrimestre;
    }

    public String getid_profesor() {
        return id_profesor;
    }
    public String getid_grado() {
        return id_grado;
    }
}