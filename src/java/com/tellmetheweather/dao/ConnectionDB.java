/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tellmetheweather.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionDB {

    PreparedStatement prStatement;
    ResourceBundle properties;
    Connection connection;
    ResultSet resultSet;

    public Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        connection = null;
        resultSet = null;
        prStatement = null;
        properties = ResourceBundle.getBundle("DataConnection");
        Class.forName(properties.getString("tt.tellMeTheWeather.class.forname")).newInstance();
        connection = DriverManager.getConnection(
                properties.getString("tt.tellMeTheWeather.url"),
                properties.getString("tt.tellMeTheWeather.usuario"),
                properties.getString("tt.tellMeTheWeather.password"));

        return connection;
    }

    public void closeResources(ResultSet resultSet, PreparedStatement prStatement, Connection connection) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (prStatement != null) {
            prStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

}
