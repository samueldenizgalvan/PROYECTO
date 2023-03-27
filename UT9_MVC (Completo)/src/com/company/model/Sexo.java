package com.company.model;

public enum Sexo
{

    MASCULINO("Masculino"),
    FEMENINO("Femenino");

    private String descripcion;

    Sexo(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescricao()
    {
        return descripcion;
    }

}
