/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.geolookup.beans;

public class Location {

    private NearbyStations nearby_weather_stations;
    private float longitude;
    private float latitude;
    private String state;
    private String city;
    private String country;
    private String country_name;
    private String country_iso3166;
    private String zip;
    private String tz_short;
    private String tz_long;
    private boolean queryError;
    private String errorDescription;

    public NearbyStations getNearby_weather_stations() {
        return nearby_weather_stations;
    }

    public void setNearby_weather_stations(NearbyStations nearby_weather_stations) {
        this.nearby_weather_stations = nearby_weather_stations;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
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

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_iso3166() {
        return country_iso3166;
    }

    public void setCountry_iso3166(String country_iso3166) {
        this.country_iso3166 = country_iso3166;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTz_short() {
        return tz_short;
    }

    public void setTz_short(String tz_short) {
        this.tz_short = tz_short;
    }

    public String getTz_long() {
        return tz_long;
    }

    public void setTz_long(String tz_long) {
        this.tz_long = tz_long;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Location{" + "nearby_weather_stations=" + nearby_weather_stations + ", longitude=" + longitude + ", latitude=" + latitude + ", state=" + state + ", city=" + city + ", country=" + country + ", country_name=" + country_name + ", country_iso3166=" + country_iso3166 + ", zip=" + zip + ", tz_short=" + tz_short + ", tz_long=" + tz_long + '}';
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public boolean isQueryError() {
        return queryError;
    }

    public void setQueryError(boolean queryError) {
        this.queryError = queryError;
    }

}
