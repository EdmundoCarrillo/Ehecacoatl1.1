/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tools.xmlReader;

import com.weatherConditions.beans.CurrentObservation;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ObservationHandler extends DefaultHandler {

    private final StringBuilder buffer = new StringBuilder();
    private CurrentObservation currentObservation;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        if (buffer.toString().matches("-9999|-9999.0|-999.0")) {
//            buffer.delete(0, buffer.length());
//            buffer.append("-");
//            System.out.println("YES2");
//        }

        switch (qName) {
            case "current_observation":
                break;

            case "observation_time":
                currentObservation.setObservation_time(buffer.toString());
                break;
            case "observation_time_rfc822":
                currentObservation.setObservation_time_rfc822(buffer.toString());
                break;
            case "weather":
                currentObservation.setWeather(buffer.toString());
                break;
            case "temperature_string":
                currentObservation.setTemperature_string(buffer.toString());
                break;
            case "temp_f":
                currentObservation.setTemp_f(Float.parseFloat(buffer.toString()));
                break;
            case "temp_c":
                currentObservation.setTemp_c(Float.parseFloat(buffer.toString()));
                break;
            case "relative_humidity":
                currentObservation.setRelative_humidity(buffer.toString());
                break;
            case "wind_string":
                currentObservation.setWind_string(buffer.toString());
                break;
            case "wind_dir":
                currentObservation.setWind_dir(buffer.toString());
                break;
            case "wind_degrees":
                currentObservation.setWind_degrees(buffer.toString());
                break;
            case "wind_mph":
                currentObservation.setWind_mph(Float.parseFloat(buffer.toString()));
                break;
            case "wind_kph":
                currentObservation.setWind_kph(Float.parseFloat(buffer.toString()));
                break;
            case "wind_gust_mph":
                currentObservation.setWind_gust_mph(Float.parseFloat(buffer.toString()));
                break;
            case "wind_gust_kph":
                currentObservation.setWind_gust_kph(Float.parseFloat(buffer.toString()));
                break;
            case "pressure_in":
                currentObservation.setPressure_in(Float.parseFloat(buffer.toString()));
                break;
            case "pressure_mb":
                currentObservation.setPressure_mb(Float.parseFloat(buffer.toString()));
                break;
            case "dewpoint_string":
                currentObservation.setDewpoint_string(buffer.toString());
                break;
            case "dewpoint_c":
                currentObservation.setDewpoint_c(Float.parseFloat(buffer.toString()));
                break;
            case "dewpoint_f":
                currentObservation.setDewpoint_f(Float.parseFloat(buffer.toString()));
                break;
            case "feelslike_string":
                currentObservation.setFeelslike_string(buffer.toString());
                break;
            case "feelslike_f":
                currentObservation.setFeelslike_f(Float.parseFloat(buffer.toString()));
                break;
            case "feelslike_c":
                currentObservation.setFeelslike_c(Float.parseFloat(buffer.toString()));
                break;
            case "visibility_mi":
                currentObservation.setVisibility_mi(Float.parseFloat(buffer.toString()));
                break;
            case "visibility_km":
                currentObservation.setVisibility_km(Float.parseFloat(buffer.toString()));
                break;
            case "precip_today_string":
                currentObservation.setPrecip_today_string(buffer.toString());
                break;
            case "icon":
                currentObservation.setIcon(buffer.toString());
                break;
            case "icon_url":
                currentObservation.setIcon_url(buffer.toString());
                break;
//            case "heat_index_f":
//                currentObservation.setHeat_index_f(Float.parseFloat(buffer.toString()));
//                break;

        }

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        switch (qName) {
            case "current_observation":
                currentObservation = new CurrentObservation();
                buffer.delete(0, buffer.length());
                break;
            case "observation_time":
            case "observation_time_rfc822":
            case "weather":
            case "temperature_string":
            case "temp_f":
            case "temp_c":
            case "relative_humidity":
            case "wind_string":
            case "wind_dir":
            case "wind_degrees":
            case "wind_mph":
            case "wind_kph":
            case "wind_gust_mph":
            case "wind_gust_kph":
            case "pressure_in":
            case "pressure_mb":
            case "dewpoint_string":
            case "dewpoint_c":
            case "dewpoint_f":
            case "feelslike_string":
            case "feelslike_f":
            case "feelslike_c":
            case "visibility_mi":
            case "visibility_km":
            case "precip_today_string":
            case "icon":
            case "icon_url":
//            case "heat_index_f":
                buffer.delete(0, buffer.length());
                break;

        }

    }

    public CurrentObservation getCurrentObservation() {
        return currentObservation;
    }

    public void setCurrentObservation(CurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
    }

}
