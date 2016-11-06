/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tools.xmlReader;

import com.geolookup.beans.*;
import com.tools.geography.GeographicDistance;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GeolookupHandler extends DefaultHandler {
    
    private final GeographicDistance geoDistance = new GeographicDistance();
    private final StringBuilder buffer = new StringBuilder();
    private final List<Station> airportList = new ArrayList();
    private final List<Station> pwsList = new ArrayList();
    private NearbyStations nearbyStations;
    private Location location;
    private Airport airport;
    private Station station;
    private Pws pws;

    //Para manejar los elementos iguales en diferentes clases.
    private boolean bAirport = false;
    private boolean bStation = false;
    private boolean bPws = false;
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        /*    
        Caso de error: EL servicio geolookup del BestForecast devuelve un xml con estaciones vacías.
        Tipo de error: java.lang.NumberFormatException: empty String
        Causa: No se puede realizar la conversión de una cadena vacía a un tipo Float o Double para 
               setear longitud-latitud y calcular la distancia.
        Ejemplo:
                <station>
                    <city/>
                    <state/>
                    <country/>
                    <icao/>
                    <lat/>
                    <lon/>
                </station>
         */
        
        if (buffer.toString() == null || buffer.toString().isEmpty()) {
            buffer.delete(0, buffer.length());
            buffer.append("1000");
        }
        switch (qName) {
            case "location":
                location.setNearby_weather_stations(nearbyStations);
                break;
            case "nearby_weather_stations":
                nearbyStations.setAirport(airport);
                nearbyStations.setPws(pws);
                break;
            case "airport":
                airport.setStation(airportList);
                bAirport = false;
                break;
            case "pws":
                pws.setStation(pwsList);
                bPws = false;
                break;
            case "station":
                bStation = false;
                station.setDistance_km((float) geoDistance.measureDistanceKm(station.getLatitude(), station.getLongitude(), location.getLatitude(), location.getLongitude()));
                station.setDistance_mi((float) geoDistance.measureDistanceMi(station.getLatitude(), station.getLongitude(), location.getLatitude(), location.getLongitude()));
                if (bAirport) {
                    airportList.add(station);
                    
                } else if (bPws) {
                    pwsList.add(station);
                }
                break;
            case "lon":
                if (bStation) {
                    station.setLongitude(Double.parseDouble(buffer.toString()));
                } else {
                    location.setLongitude(Float.parseFloat(buffer.toString()));
                }
                break;
            case "lat":
                if (bStation) {
                    station.setLatitude(Double.parseDouble(buffer.toString()));
                } else {
                    location.setLatitude(Float.parseFloat(buffer.toString()));
                }
                break;
            case "country_iso3166":
                location.setCountry_iso3166(buffer.toString());
                break;
            case "zip":
                location.setZip(buffer.toString());
                break;
            case "tz_short":
                location.setTz_short(buffer.toString());
                break;
            case "tz_long":
                location.setTz_long(buffer.toString());
                break;
            case "country_name":
                location.setCountry_name(buffer.toString());
                break;
            case "icao":
                station.setStation_id(buffer.toString());
                break;
            case "id":
                station.setStation_id(buffer.toString());
                break;
            case "city":
                if (bStation) {
                    station.setCity(buffer.toString());
                } else {
                    location.setCity(buffer.toString());
                }
                break;
            case "state":
                if (bStation) {
                    station.setState(buffer.toString());
                } else {
                    location.setState(buffer.toString());
                }
                break;
            case "country":
                if (bStation) {
                    station.setCountry(buffer.toString());
                } else {
                    location.setCountry(buffer.toString());
                }
                
                break;
            case "neighborhood":
                station.setNeighborhood(buffer.toString());
                break;
            case "error":
                location.setQueryError(true);
                break;
            case "description":
                location.setErrorDescription(buffer.toString());
                break;
//            case "distance_km":
//                station.setDistance_km(Float.parseFloat(buffer.toString()));
//                break;
//            case "distance_mi":
//                station.setDistance_mi(Float.parseFloat(buffer.toString()));
//                break;
        }
        
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            
            case "location":
                location = new Location();
                
                break;
            case "nearby_weather_stations":
                nearbyStations = new NearbyStations();
                
                break;
            case "airport":
                airport = new Airport();
                bAirport = true;
                
                break;
            case "pws":
                pws = new Pws();
                bPws = true;
                break;
            
            case "lon":
            case "lat":
            case "state":
            case "city":
            case "country":
            case "country_name":
            case "country_iso3166":
            case "zip":
            case "tz_short":
            case "tz_long":
            case "neighborhood":
//            case "distance_km":
//            case "distance_mi":
            case "icao":
            case "id":
            case "description":
                buffer.delete(0, buffer.length());
                break;
            
            case "station":
                station = new Station();
                bStation = true;
                buffer.delete(0, buffer.length());
                break;
            case "error":
                location = new Location();
                buffer.delete(0, buffer.length());
                break;
            
        }
        
    }
    
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
}
