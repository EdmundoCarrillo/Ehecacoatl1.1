<%-- 
    Document   : climaController
    Created on : 24/10/2016, 02:35:28 PM
    Author     : Edmundo Carrillo
--%>

<%@page import="com.weatherConditions.beans.ForecastDay"%>
<%@page import="com.stationReports.beans.SkyCondition"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.geolookup.beans.Station"%>
<%@page import="com.geolookup.beans.Location"%>
<%@page import="com.weatherConditions.beans.Weather"%>
<%@page import="com.weatherConditions.controller.WeatherStationController"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    JSONObject obj = new JSONObject();
    JSONArray skyCover = new JSONArray();
    DecimalFormat decimalFormat = new DecimalFormat("#.000000");
    DecimalFormat decimal2 = new DecimalFormat("#.00");
    Double lat = Double.valueOf(decimalFormat.format(Double.parseDouble(request.getParameter("lat"))));
    Double lon = Double.valueOf(decimalFormat.format(Double.parseDouble(request.getParameter("lon"))));
    System.out.print(lat + " " + lon);
    obj.put("coordenadas", lon + " , " + lat);

    WeatherStationController wsc = new WeatherStationController(lat, lon);
    Weather weather = wsc.weatherCheck();
    Location location = wsc.getLocation();
    Station station = weather.getStationSource();

    if (weather.isError()) {

    } else if (weather.isAirportSource()) {
        obj.put("temperatura", weather.getMetar().getTemperature_c());
        obj.put("altimetro", Double.valueOf(decimal2.format(weather.getMetar().getAltimeter_in_hg())));
        obj.put("puntoRocio", weather.getMetar().getDewpoint());
        obj.put("visibilidad", weather.getMetar().getVisibility_mi());
        obj.put("dirViento", weather.getMetar().getWind_dir_degrees());
        obj.put("velViento", weather.getMetar().getWind_speed_kt());
        obj.put("presionMar", weather.getMetar().getSea_level_pressure_mb());
        obj.put("img", weather.getMetar().getSkyConditionList().get(0).getFilePath());
        for (SkyCondition sk : weather.getMetar().getSkyConditionList()) {
            skyCover.add("<tr><td class=\"colorT\">(" + sk.getSky_cover() + ") " + sk.getSky_cover_description() + " a " + sk.getCloud_base_ft_agl()
                    + " ft</td><td><img src=\"" + sk.getFilePath() + "\" style=\"width:30px;height:30px;border:0;\"> </td></tr>");
        }
        obj.put("skyCover", skyCover);
        obj.put("hora", weather.getMetar().getObservation_time());
        obj.put("distancia", station.getDistance_km());
        obj.put("id", weather.getMetar().getStation().getStation_id());
        obj.put("raw", weather.getMetar().getRaw_text());
        obj.put("humedad", "N/A");
        obj.put("lluvia", "N/A");
        obj.put("imgTipo", 0);
    } else if (weather.isPwsSource()) {
        JSONArray forecastDay = new JSONArray();
        obj.put("temperatura", weather.getBestObservation().getFeelslike_c());
        obj.put("altimetro", weather.getBestObservation().getPressure_in());
        obj.put("puntoRocio", weather.getBestObservation().getDewpoint_c());
        obj.put("visibilidad", weather.getBestObservation().getVisibility_km());
        obj.put("humedad", weather.getBestObservation().getRelative_humidity());
        obj.put("lluvia", weather.getBestObservation().getPrecip_today_string());
        obj.put("dirViento", weather.getBestObservation().getWind_degrees());
        obj.put("velViento", Double.valueOf(decimal2.format(weather.getBestObservation().getWind_mph() * 0.539957)));
        //System.out.print(weather.getBestObservation().getWind_mph() * 0.539957);
        obj.put("presionMar", "N/A");
        obj.put("hora", weather.getBestObservation().getObservation_time());
        obj.put("distancia", station.getDistance_km());
        obj.put("id", station.getStation_id());
        obj.put("raw", "N/A");
        obj.put("img", weather.getBestObservation().getIcon_url());
        obj.put("imgTipo", 1);
        skyCover.add("<tr><td class=\"colorT\">" + weather.getBestObservation().getWeather() + "</td><td><img src=\"" + weather.getBestObservation().getIcon_url() + "\" style=\"width:40px;height:40px;border:0;\"></td></tr>");
        obj.put("skyCover", skyCover);
        //obj.put("iconCoor","<strong>moemoemv<strong>");
        forecastDay.add("<tr ><td colspan=\"4\"><img src=\"lib/img/marker2.png\"  style=\"width:16px;height:16px;border:0;\"><span class=\"color1\" id=\"\"><strong>" + lon + "," + lat + "</strong></span>&nbsp;</td></tr>");
        for (ForecastDay fr : weather.getBestForecast().getTxt_forecast().getForecastdays().getForecastday()) {
            forecastDay.add("<tr><td class=\"titulo\" COLSPAN=\"2\"><strong>" + fr.getTitle() + "</strong></td></tr>"
                    + "<tr style=\"border-bottom:1px solid black;\"><td><img src=\"" + fr.getIcon_url() + "\"/></td><td class=\"descrip\"><strong>"
                    + fr.getFcttext() + "</strong></td></tr>");
            System.out.println(fr.getTitle());
        }
        obj.put("forecastDay", forecastDay);
    }

    PrintWriter writer = response.getWriter();
    writer.println(obj);
    writer.flush();
    writer.close();
%>
