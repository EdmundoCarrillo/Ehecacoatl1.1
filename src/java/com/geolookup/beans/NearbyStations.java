/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.geolookup.beans;

public class NearbyStations {

    private Airport airport;
    private Pws pws;

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Pws getPws() {
        return pws;
    }

    public void setPws(Pws pws) {
        this.pws = pws;
    }

    @Override
    public String toString() {
        return "Nearby_weather_stations{" + "airport=" + airport + ", pws=" + pws + '}';
    }
    
}
