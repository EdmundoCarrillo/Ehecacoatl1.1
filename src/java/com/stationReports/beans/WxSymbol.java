/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.stationReports.beans;

import com.tellmetheweather.dao.WxSymbolDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WxSymbol implements Serializable {

    private String wxCode;
    private String wxDescription;
    private String filePath;

    public WxSymbol() {
    }

    public WxSymbol(String wxCode) {
        this.wxCode = wxCode;
    }

    public WxSymbol(String wxCode, String wxDescription, String filePath) {
        this.wxCode = wxCode;
        this.wxDescription = wxDescription;
        this.filePath = filePath;
    }

    public String getWxCode() {
        return wxCode;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }

    public String getWxDescription() {
        return wxDescription;
    }

    public void setWxDescription(String wxDescription) {
        this.wxDescription = wxDescription;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "WxSymbol{" + "wxCode=" + wxCode + ", wxDescription=" + wxDescription + ", filePath=" + filePath + '}';
    }

    private List<WxSymbol> parseWxSymbol() {
        WxSymbolDao wxDao = new WxSymbolDao();
        List<WxSymbol> wxList = new ArrayList();
        String[] wxSplit = wxCode.split("\\s");
        for (String st : wxSplit) {
            try {
                wxList.add(wxDao.selectOne(st));
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return wxList;
    }

    public void fillWxSymbol(Metar metar) {
        WxSymbol wx = new WxSymbol(wxCode);
        List<WxSymbol> list = wx.parseWxSymbol();
        metar.setWxSymbolList(list);
    }

    public void fillWxSymbol(TAForecast taf) {
        WxSymbol wx = new WxSymbol(wxCode);
        List<WxSymbol> list = wx.parseWxSymbol();
        taf.setWxSymbolList(list);
    }

//    public static void main(String[] args) throws SQLException {
//        WxSymbol wx = new WxSymbol("BL BR");
//        Metar metar = new Metar();
//        wx.fillWxSymbol(metar);
//        System.out.println(metar.getWxSymbolList().toString());
//    }
}
