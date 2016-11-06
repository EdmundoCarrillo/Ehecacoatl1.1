/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.weatherConditions.beans;

import com.geolookup.beans.Station;
import com.stationReports.beans.Metar;
import com.stationReports.beans.TAF;

public class Weather {

    private BestForecast bestForecast;
    private CurrentObservation bestObservation;
    private Station stationSource;
    private Metar metar;
    private TAF taf;

    
    private boolean error;
    private String queryError;
    private boolean airportSource = false;
    private boolean pwsSource = false;

    public boolean isAirportSource() {
        return airportSource;
    }

    public void setAirportSource(boolean airportSource) {
        this.airportSource = airportSource;
    }

    public boolean isPwsSource() {
        return pwsSource;
    }

    public void setPwsSource(boolean pwsSource) {
        this.pwsSource = pwsSource;
    }

    public BestForecast getBestForecast() {
        return bestForecast;
    }

    public void setBestForecast(BestForecast bestForecast) {
        this.bestForecast = bestForecast;
    }

    public CurrentObservation getBestObservation() {
        return bestObservation;
    }

    public void setBestObservation(CurrentObservation bestObservation) {
        this.bestObservation = bestObservation;
    }

    public Metar getMetar() {
        return metar;
    }

    public void setMetar(Metar metar) {
        this.metar = metar;
    }

    public TAF getTaf() {
        return taf;
    }

    public void setTaf(TAF taf) {
        this.taf = taf;
    }

    public Station getStationSource() {
        return stationSource;
    }

    public void setStationSource(Station stationSource) {
        this.stationSource = stationSource;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getQueryError() {
        return queryError;
    }

    public void setQueryError(String queryError) {
        this.queryError = queryError;
    }

}
