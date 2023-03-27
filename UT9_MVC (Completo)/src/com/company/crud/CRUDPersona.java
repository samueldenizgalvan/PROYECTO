package com.company.crud;

import com.company.model.Sexo;
import com.company.model.Persona;
import com.company.database.ConectionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CRUDPersona {

    private Statement statement;
    private ConectionBD connection;

    public CRUDPersona(ConectionBD connection) {
        this.connection = connection;
        try {
            this.statement = connection.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Persona> obtenerTodos(){
        List<Persona> personas = new ArrayList<>();
        try
                (ResultSet resultSet = statement.executeQuery("SELECT * FROM persona")){
            while (resultSet.next()){
                Persona persona = getPersona(resultSet);
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personas;
    }


    public Persona buscarPorId(int id){
        String consulta = "SELECT * FROM persona WHERE id = '" + id + "'";
        try(PreparedStatement preparedStatement = connection.getConnection().prepareStatement(consulta)){
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return getPersona(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Persona buscarPorNIF(String NIF){
        String consulta = "SELECT * FROM persona WHERE nif = '" + NIF + "'";
        try
            (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(consulta)){
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return getPersona(resultSet);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Persona guardarPersona(Persona persona){

        String consulta = "INSERT INTO persona (nif,nombre,apellido1,apellido2,ciudad,direccion,telefono,fecha_nacimiento,sexo,tipo) VALUES (?,?,?,?,?,?,?,?,?,?)";

        if (persona.getId() > 0){
            consulta = "UPDATE persona SET nif = ?,nombre = ?,apellido1 = ?,apellido2 = ?,ciudad = ?,direccion = ?,telefono = ?,fecha_nacimiento = ?,sexo = ?,tipo = ? WHERE id = '" + persona.getId() + "'";
        }

        try(PreparedStatement preparedStatement = connection.getConnection().prepareStatement(consulta)){

            preparedStatement.setString(1,persona.getNIF());
            preparedStatement.setString(2,persona.getNombre());
            preparedStatement.setString(3,persona.getApellidoPaterno());
            preparedStatement.setString(4,persona.getApellidoMaterno());
            preparedStatement.setString(5,persona.getCiudad());
            preparedStatement.setString(6,persona.getDireccion());
            preparedStatement.setString(7,persona.getTelefono());
            preparedStatement.setString(8,persona.getFechaNacimiento().toString());
            preparedStatement.setString(9,persona.getGenero().name());
            preparedStatement.setString(10,persona.getTipo());


            preparedStatement.executeUpdate();

            if (persona.getId() == 0){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()){
                    persona.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return persona;
    }

    public void eliminarPersonaPorID(int id){
        try(PreparedStatement preparedStatement = connection.getConnection().prepareStatement("DELETE FROM persona WHERE id = '" + id + "'")){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPersonaPorNIF(String nif){
        try(PreparedStatement preparedStatement = connection.getConnection().prepareStatement("DELETE FROM persona WHERE nif = '" + nif + "'")){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Persona> obtenerPersonaPorSusCaracteristicas(QueryPossibilities queryPossibilities, String valor){
        List<Persona> personas = new ArrayList<>();
        String consulta = "SELECT * FROM persona WHERE "+ queryPossibilities.getNombreColumna() +" LIKE '%" + valor + "%'";
        try(PreparedStatement preparedStatement = connection.getConnection().prepareStatement(consulta)){
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Persona persona = getPersona(resultSet);
                    personas.add(persona);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return personas;
    }

    private Persona getPersona(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nif = resultSet.getString("nif");
        String nombre = resultSet.getString("nombre");
        String apellidoPaterno = resultSet.getString("apellido1");
        String apellidoMaterno = resultSet.getString("apellido2");
        String ciudad = resultSet.getString("ciudad");
        String direccion = resultSet.getString("direccion");
        String telefono = resultSet.getString("telefono");
        String fechaNacimiento = resultSet.getString("fecha_nacimiento");
        String genero = resultSet.getString("sexo");
        String tipo = resultSet.getString("tipo");

        Sexo sexoEnum = Sexo.MASCULINO;
        if (genero.equalsIgnoreCase("F")){
            sexoEnum = Sexo.FEMENINO;
        }
        //Fecha Formaato 2020-12-12
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNacimientoLocalDate = LocalDate.parse(fechaNacimiento,dateTimeFormatter);
        Persona persona = new Persona(nif,nombre,apellidoPaterno,apellidoMaterno,ciudad,direccion,telefono,fechaNacimientoLocalDate, sexoEnum,tipo);
        persona.setId(id);
        return persona;
    }
}
