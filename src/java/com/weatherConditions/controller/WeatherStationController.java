/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.weatherConditions.controller;

import com.geolookup.beans.Location;
import com.geolookup.beans.Station;
import com.services.handler.ServiceResponse;
import com.stationReports.beans.Metar;
import com.stationReports.beans.TAF;
import com.weatherConditions.beans.BestForecast;
import com.weatherConditions.beans.CurrentObservation;
import com.weatherConditions.beans.Weather;
import java.io.IOException;
import java.util.List;
import org.xml.sax.SAXException;

public class WeatherStationController {
    
    private final ServiceResponse service = new ServiceResponse();
    private Station airportStation, pwsStation;
    private List airportList, pwsList;
    private final Double longitude;
    private final Double latitude;
    private Location location;
    private Weather weather;
    
    public WeatherStationController(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public Weather weatherCheck() throws SAXException, IOException {
        
        weather = new Weather();
        
        location = service.getNearbyStations(latitude, longitude);
// Validamos que la locación sea valida, si no lo fuera no existirán estaciones cercanas.     
        if (location.isQueryError()) {
            weather.setError(true);
            weather.setQueryError(location.getErrorDescription());
        } else {
            airportList = location.getNearby_weather_stations().getAirport().getStation();
            pwsList = location.getNearby_weather_stations().getPws().getStation();
            airportStation = distanceCheck(airportList);
            pwsStation = distanceCheck(pwsList);
            
            if (airportStation.getDistance_km() < pwsStation.getDistance_km()) {
                Metar metar = service.getMetarReport(airportStation.getStation_id()).get(0);
                if (metar.getNum_result() == 0) {
                    usePwsStationService();
                } else {
//El aeródromo esta linea, se procede a solicitar el pronostico.
                    useAirportStationService(metar);
                }
            } else if (pwsStation.getDistance_km() < airportStation.getDistance_km()) {
                usePwsStationService();
            }
        }
        return weather;
    }
    
    private Station distanceCheck(List<Station> stationList) {
        Station auxStation = stationList.get(0);
        for (Station st : stationList) {
            if (st.getDistance_km() < auxStation.getDistance_km()) {
                auxStation = st;
            }
        }
        return auxStation;
    }
    
    private void usePwsStationService() throws SAXException, IOException {
        CurrentObservation bfObservation = service.getPwsConditions(pwsStation.getStation_id());
        BestForecast bestForecast = service.getPwsForecast(pwsStation.getStation_id());
        weather.setBestObservation(bfObservation);
        weather.setBestForecast(bestForecast);
        weather.setStationSource(pwsStation);
        weather.setPwsSource(true);
    }
    
    private void useAirportStationService(Metar metar) throws SAXException, IOException {
        TAF taf = service.getTAFReport(airportStation.getStation_id()).get(0);
        weather.setStationSource(airportStation);
        weather.setAirportSource(true);
        weather.setMetar(metar);
        weather.setTaf(taf);
//        weather.getMetar().setStation(airportStation);
//        weather.getTaf().setStation(airportStation);
    }
    
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
}
