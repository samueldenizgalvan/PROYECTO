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
            statement.close();
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
                    statement.close(); //TODO: Verificar que no afecte en la consulta y no tire error
                    return getAsignatura(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Asignatura guardarAsignatura(Asignatura asignatura) {

        String consulta = "INSERT INTO asignatura (id,nombre,creditos,tipo,curso,cuatrimestre,id_profesor,id_grado) VALUES (?,?,?,?,?,?,?,?,?,?)";

        if (asignatura.getId() > 0) {
            consulta = "UPDATE asignatura SET id = ?,nombre = ?,creditos = ?,tipo = ?,curso = ?,cuatrimestre = ?,id_profesor = ?,id_grado = ? WHERE id = '" + asignatura.getId() + "'";
        }

        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement(consulta)) {

            preparedStatement.setInt(1, asignatura.getId());
            preparedStatement.setString(2, asignatura.getNombre());
            preparedStatement.setString(3, asignatura.getCreditos());
            preparedStatement.setString(4, asignatura.getTipo());
            preparedStatement.setString(5, asignatura.getCurso());
            preparedStatement.setString(6, asignatura.getCuatrimestre());
            preparedStatement.setString(7, asignatura.getId_profesor());
            preparedStatement.setString(8, asignatura.getId_grado());
            preparedStatement.setString(9, asignatura.getTipo());


            preparedStatement.executeUpdate();

            if (asignatura.getId() == 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    asignatura.setId(resultSet.getInt(1));
                }
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return asignatura;
    }

    public void eliminarAsignaturaPorID(int id) {
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement("DELETE FROM asignatura WHERE id = '" + id + "'")) {
            preparedStatement.executeUpdate();
            statement.close();
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
}
