package com.company.crud;

import com.company.database.ConectionBD;
import com.company.model.Asignatura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CRUDAsignatura {

    private Statement statement;
    private ConectionBD connection;

    public CRUDAsignatura(ConectionBD connection) {
        this.connection = connection;
        try {
            this.statement = connection.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Asignatura> obtenerTodos() {
        List<Asignatura> asignaturas = new ArrayList<>();
        try(ResultSet resultSet = statement.executeQuery("SELECT * FROM asignatura")) {
            while (resultSet.next()) {
                Asignatura asignatura = getAsignatura(resultSet);
                asignaturas.add(asignatura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return asignaturas;
    }


    public Asignatura buscarPorId(int id) {
        String consulta = "SELECT * FROM asignatura WHERE id = '" + id + "'";
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(consulta)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return getAsignatura(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Asignatura guardarAsignatura(Asignatura asignatura) {

        String consulta = "INSERT INTO asignatura (nombre,creditos,tipo,curso,cuatrimestre,id_profesor,id_grado) VALUES (?,?,?,?,?,?,?)";

        if (asignatura.getId() > 0) {
            consulta = "UPDATE asignatura SET nombre = ?,creditos = ?,tipo = ?,curso = ?,cuatrimestre = ?,id_profesor = ?,id_grado = ? WHERE id = '" + asignatura.getId() + "'";
        }

        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(consulta)) {
            preparedStatement.setString(1, asignatura.getNombre());
            preparedStatement.setString(2, asignatura.getCreditos());
            preparedStatement.setString(3, asignatura.getTipo());
            preparedStatement.setString(4, asignatura.getCurso());
            preparedStatement.setString(5, asignatura.getCuatrimestre());
            preparedStatement.setString(6, asignatura.getId_profesor());
            preparedStatement.setString(7, asignatura.getId_grado());


            preparedStatement.executeUpdate();

            if (asignatura.getId() == 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    asignatura.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return asignatura;
    }

    public void eliminarAsignaturaPorID(int id) {
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement("DELETE FROM asignatura WHERE id = '" + id + "'")) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Asignatura getAsignatura(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nombre = resultSet.getString("nombre");
        String creditos = resultSet.getString("creditos");
        String tipo = resultSet.getString("tipo");
        String curso = resultSet.getString("curso");
        String cuatrimestre = resultSet.getString("cuatrimestre");
        String id_profesor = resultSet.getString("id_profesor");
        String id_grado = resultSet.getString("id_grado");

        Asignatura asignatura = new Asignatura(nombre, creditos, tipo, curso, cuatrimestre, id_profesor, id_grado);
        asignatura.setId(id);
        return asignatura;
    }
    public List<Asignatura> obtenerAsignaturaPorSusCaracteristicas(QueryPossibilitiesAsignaturas QueryPossibilitiesAsignaturas, String valor){
        List<Asignatura> asignaturas = new ArrayList<>();
        String consulta = "SELECT * FROM asignatura WHERE "+ QueryPossibilitiesAsignaturas.getNombreColumna() +" LIKE '%" + valor + "%'";
        try(PreparedStatement preparedStatement = connection.getConnection().prepareStatement(consulta)){
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Asignatura asignatura = getAsignatura(resultSet);
                    asignaturas.add(asignatura);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return asignaturas;
    }
}
