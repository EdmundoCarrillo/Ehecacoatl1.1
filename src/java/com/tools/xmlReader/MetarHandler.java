/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tools.xmlReader;

import com.geolookup.beans.Station;
import com.stationReports.beans.Metar;
import com.stationReports.beans.SkyCondition;
import com.stationReports.beans.WxSymbol;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MetarHandler extends DefaultHandler {

    private final List<SkyCondition> skyConditionList = new ArrayList();
    private final StringBuilder buffer = new StringBuilder();
    private List<Metar> metarList = new ArrayList();
    private SkyCondition skyCondition;
    private int noResultados;
    private Station station;
    private Metar metar;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "METAR":
                setMissingFields(metar);
                break;
            case "raw_text":
                metar.setRaw_text(buffer.toString());
                break;
            case "station_id":
                station.setStation_id(buffer.toString());
//                metar.setStation(station);
                break;
            case "latitude":
                station.setLatitude(Double.parseDouble(buffer.toString()));
//                metar.setStation(station);
                break;
            case "longitude":
                station.setLongitude(Double.parseDouble(buffer.toString()));
                metar.setStation(station);
                break;
            case "elevation_m":
                station.setElevation_m(Float.parseFloat(buffer.toString()));
                metar.setStation(station);
                break;
            case "observation_time":
                metar.setObservation_time(buffer.toString());
                break;
            case "temp_c":
                metar.setTemperature_c(Float.parseFloat(buffer.toString()));
                break;
            case "dewpoint_c":
                metar.setDewpoint(Float.parseFloat(buffer.toString()));
                break;
            case "wind_dir_degrees":
                metar.setWind_dir_degrees(Float.parseFloat(buffer.toString()));
                break;
            case "wind_speed_kt":
                metar.setWind_speed_kt(Float.parseFloat(buffer.toString()));
                break;
            case "visibility_statute_mi":
                metar.setVisibility_mi(Float.parseFloat(buffer.toString()));
                break;
            case "altim_in_hg":
                metar.setAltimeter_in_hg(Double.parseDouble(buffer.toString()));
                break;
            case "sea_level_pressure_mb":
                metar.setSea_level_pressure_mb(Double.parseDouble(buffer.toString()));
                break;
            case "wx_string":
                metar.setWx_string(buffer.toString());
                WxSymbol wx = new WxSymbol(buffer.toString());
                wx.fillWxSymbol(metar);
                break;

        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        switch (qName) {
            case "response":
                metar = new Metar();
                break;
            case "METAR":
                metarList.add(metar);
                break;
            case "station_id":
                station = new Station();
                buffer.delete(0, buffer.length());
                break;
            case "raw_text":
            case "observation_time":
            case "latitude":
            case "longitude":
            case "temp_c":
            case "dewpoint_c":
            case "wind_dir_degrees":
            case "wind_speed_kt":
            case "visibility_statute_mi":
            case "altim_in_hg":
            case "sea_level_pressure_mb":
            case "wx_string":
            case "elevation_m":
                buffer.delete(0, buffer.length());
                break;
            case "sky_condition":

//         Debido a que este elemento (sky_condition) guarda su valores en forma de atributos 
//        (<sky_condition sky_cover="FEW" cloud_base_ft_agl="12000"/>) puede darse el caso que alguno no 
//         exista para el reporte consultado por eso se necesita verificar para no generar una excepción 
//         de tipo NumberFormatException: null.
                skyCondition = new SkyCondition();
                if (attributes.getValue("sky_cover") == null) {
                    skyCondition.setSky_cover("Condición del cielo no disponible.");

                } else {
                    skyCondition.setSky_cover(attributes.getValue("sky_cover"));
                    skyCondition.parseSkyConditions();
                }

                if (attributes.getValue("cloud_base_ft_agl") == null) {
                    skyCondition.setCloud_base_ft_agl(0);
                } else {

                    skyCondition.setCloud_base_ft_agl(Integer.parseInt(attributes.getValue("cloud_base_ft_agl")));
                }

                skyConditionList.add(skyCondition);
                metar.setSkyConditionList(skyConditionList);
                buffer.delete(0, buffer.length());
                break;
            case "data":
                noResultados = Integer.parseInt(attributes.getValue("num_results"));
                metar.setNum_result(noResultados);
                //borrar
                metarList.add(metar);

//                metar = new Metar();
//                metarList.add(metar);
//                if (num_result == 0) {
//
//                }
                break;

        }
    }

    public void setMissingFields(Metar metar) {
        if (metar.getWxSymbolList() == null) {
            List<WxSymbol> wxList = new ArrayList();
            wxList.add(new WxSymbol("NWS", "Sin tiempo de importancia", "/file"));
            metar.setWxSymbolList(wxList);
        }
    }

    public List<Metar> getMetarList() {
        return metarList;
    }

    public void setMetarList(List<Metar> metarList) {
        this.metarList = metarList;
    }

    public Metar getMetar() {
        return metar;
    }

    public void setMetar(Metar metar) {
        this.metar = metar;
    }

}
