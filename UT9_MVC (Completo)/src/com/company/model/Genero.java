package com.company.model;

public enum Genero
{

    MASCULINO("Masculino"),
    FEMENINO("Feminino");

    private String descripcion;

    Genero(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescricao()
    {
        return descripcion;
    }

}
