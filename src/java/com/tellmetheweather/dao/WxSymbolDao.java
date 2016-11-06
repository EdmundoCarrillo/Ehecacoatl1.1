/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tellmetheweather.dao;

import com.stationReports.beans.WxSymbol;
import java.sql.SQLException;

public class WxSymbolDao extends ConnectionDB {

    public WxSymbol selectOne(String wxCode) throws SQLException {
        WxSymbol wxSymbol = new WxSymbol();
        try {
            connection = getConnection();
            prStatement = connection.prepareStatement(properties.getString("tt.tellMeTheWeather.selectone.glosarioClima.st"));
            prStatement.setString(1, wxCode);
            resultSet = prStatement.executeQuery();

            while (resultSet.next()) {
                wxSymbol.setWxCode(resultSet.getString("codigo_clima"));
                wxSymbol.setWxDescription(resultSet.getString("significado"));
                wxSymbol.setFilePath(resultSet.getString("ruta_icono"));
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        } finally {
            closeResources(resultSet, prStatement, connection);
        }
        return wxSymbol;
    }

//    public static void main(String[] args) throws SQLException {
//        WxSymbolDao wxSymbolDao = new WxSymbolDao();
//        WxSymbol wx = wxSymbolDao.selectOne("AS BC");
//        System.out.println(wx.toString());
//    }
}
