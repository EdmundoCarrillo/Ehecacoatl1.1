/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.geolookup.beans;

public class Station {

    private Double latitude;
    private Double longitude;
    private float elevation_m;
    private String station_id;
    private String state;
    private String city;
    private String country;
    private String neighborhood;
    private float distance_km;
    private float distance_mi;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public float getDistance_km() {
        return distance_km;
    }

    public void setDistance_km(float distance_km) {
        this.distance_km = distance_km;
    }

    public float getDistance_mi() {
        return distance_mi;
    }

    public void setDistance_mi(float distance_mi) {
        this.distance_mi = distance_mi;
    }

    public float getElevation_m() {
        return elevation_m;
    }

    public void setElevation_m(float elevation_m) {
        this.elevation_m = elevation_m;
    }

    @Override
    public String toString() {
        return "Station{" + "latitude=" + latitude + ", longitude=" + longitude + ", elevation_m=" + elevation_m + ", station_id=" + station_id + ", state=" + state + ", city=" + city + ", country=" + country + ", neighborhood=" + neighborhood + ", distance_km=" + distance_km + ", distance_mi=" + distance_mi + '}';
    }

}
