package com.company.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionBD {

    private static final String URL = "jdbc:mysql://localhost";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DATABASE_NAME = "universidad";

    public Connection connection;


    public ConectionBD() throws Exception{
        connect();
    }

    private void connect() throws SQLException, ClassNotFoundException{
    Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL+":"+PORT+"/"+DATABASE_NAME, USER, PASSWORD);
    }

    public Connection getConnection(){
        return connection;
    }

}

