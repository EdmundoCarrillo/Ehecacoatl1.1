/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.geolookup.beans;

import java.util.List;

public class Pws {

    private List<Station> station;

    public List<Station> getStation() {
        return station;
    }

    public void setStation(List<Station> station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "Pws{" + "station=" + station + '}';
    }

}
