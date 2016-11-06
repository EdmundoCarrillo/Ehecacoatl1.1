/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tools.xmlReader;

import com.geolookup.beans.Station;
import com.stationReports.beans.SkyCondition;
import com.stationReports.beans.TAForecast;
import com.stationReports.beans.TAF;
import com.stationReports.beans.WxSymbol;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TAFHandler extends DefaultHandler {

    private final List<SkyCondition> skyConditionList = new ArrayList();
    private final List<TAForecast> taForecastList = new ArrayList();
    private final StringBuilder buffer = new StringBuilder();
    private List<TAF> tafList = new ArrayList();
    private SkyCondition skyCondition;
    private TAForecast taForecast;
    private Station station;
    private TAF taf;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "raw_text":
                taf.setRaw_text(buffer.toString());
                break;
            case "station_id":
                station.setStation_id(buffer.toString());
                break;
            case "latitude":
                station.setLatitude(Double.parseDouble(buffer.toString()));
                break;
            case "longitude":
                station.setLongitude(Double.parseDouble(buffer.toString()));
                taf.setStation(station);
                break;
            case "elevation_m":
                station.setElevation_m(Float.parseFloat(buffer.toString()));
                taf.setStation(station);
                break;
            case "issue_time":
                taf.setIssue_time(buffer.toString());
                break;
            case "bulletin_time":
                taf.setBulletin_time(buffer.toString());
                break;
            case "valid_time_from":
                taf.setValid_time_from(buffer.toString());
            case "valid_time_to":
                taf.setValid_time_to(buffer.toString());
                break;
            case "fcst_time_from":
                taForecast.setFcst_time_from(buffer.toString());
                break;
            case "fcst_time_to":
                taForecast.setFcst_time_to(buffer.toString());
                break;
            case "wind_dir_degrees":
                taForecast.setWind_dir_degrees(Float.parseFloat(buffer.toString()));
                break;
            case "wind_speed_kt":
                taForecast.setWind_speed_kt(Float.parseFloat(buffer.toString()));
                break;
            case "visibility_statute_mi":
                taForecast.setVisibility_mi(Float.parseFloat(buffer.toString()));
                break;
            case "wx_string":
                taForecast.setWx_string(buffer.toString());
                WxSymbol wx = new WxSymbol(buffer.toString());
                wx.fillWxSymbol(taForecast);
                break;

            case "altim_in_hg":
                taForecast.setAltimeter_in_hg(Double.parseDouble(buffer.toString()));
                break;
            case "max_temp_c":
                taForecast.setMax_temp_c(Float.parseFloat(buffer.toString()));
                break;
            case "min_temp_c":
                taForecast.setMin_temp_c(Float.parseFloat(buffer.toString()));
                break;
            case "forecast":
                setMissingFields(taForecast);
                taForecastList.add(taForecast);
                taf.setTforecastList(taForecastList);
                break;

        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "TAF":
                taf = new TAF();
                tafList.add(taf);
                buffer.delete(0, buffer.length());
                break;
            case "station_id":
                station = new Station();
                buffer.delete(0, buffer.length());
                break;
            case "raw_text":
            case "issue_time":
            case "bulletin_time":
            case "valid_time_from":
            case "valid_time_to":
            case "latitude":
            case "longitude":
            case "elevation_m":
            case "wind_dir_degrees":
            case "wind_speed_kt":
            case "visibility_statute_mi":
            case "wx_string":
            case "altim_in_hg":
            case "max_temp_c":
            case "min_temp_c":
                buffer.delete(0, buffer.length());
                break;
            case "forecast":
                taForecast = new TAForecast();
                buffer.delete(0, buffer.length());
                break;
            case "sky_condition":
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
                taForecast.setSkyConditionList(skyConditionList);
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public void setMissingFields(TAForecast taf) {
        if (taf.getWxSymbolList() == null) {
            List<WxSymbol> wxList = new ArrayList();
            wxList.add(new WxSymbol("NWS", "Sin tiempo de importancia", "/file"));
            taf.setWxSymbolList(wxList);
        }
    }

    public List<TAF> getTafList() {
        return tafList;
    }

    public void setTafList(List<TAF> tafList) {
        this.tafList = tafList;
    }

}
