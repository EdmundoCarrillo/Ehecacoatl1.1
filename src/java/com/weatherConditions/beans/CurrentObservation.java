/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.weatherConditions.beans;

//import com.geolookup.beans.Station;

public class CurrentObservation {

//    private Station station;
    private String observation_time;
    private String observation_time_rfc822;
    private String weather;

    private String temperature_string;
    private Float temp_f;
    private Float temp_c;
    private String relative_humidity;

    private String wind_string;
    private String wind_dir;
    private String wind_degrees;
    private Float wind_mph;
    private Float wind_kph;
    private Float wind_gust_mph;
    private Float wind_gust_kph;

    private Float pressure_in;
    private Float pressure_mb;

    private String dewpoint_string;
    private Float dewpoint_c;
    private Float dewpoint_f;

//    private String heat_index_string;
//    private Float heat_index_f;
//    private Float heat_index_c;
    private String feelslike_string;
    private Float feelslike_f;
    private Float feelslike_c;

    private Float visibility_mi;
    private Float visibility_km;

    private String precip_today_string;

    private String icon_url;
    private String icon;

    public String getObservation_time() {
        return observation_time;
    }

    public void setObservation_time(String observation_time) {
        this.observation_time = observation_time;
    }

    public String getObservation_time_rfc822() {
        return observation_time_rfc822;
    }

    public void setObservation_time_rfc822(String observation_time_rfc822) {
        this.observation_time_rfc822 = observation_time_rfc822;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature_string() {
        return temperature_string;
    }

    public void setTemperature_string(String temperature_string) {
        this.temperature_string = temperature_string;
    }

    public Float getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(Float temp_f) {
        this.temp_f = temp_f;
    }

    public Float getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(Float temp_c) {
        this.temp_c = temp_c;
    }

    public String getRelative_humidity() {
        return relative_humidity;
    }

    public void setRelative_humidity(String relative_humidity) {
        this.relative_humidity = relative_humidity;
    }

    public String getWind_string() {
        return wind_string;
    }

    public void setWind_string(String wind_string) {
        this.wind_string = wind_string;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getWind_degrees() {
        return wind_degrees;
    }

    public void setWind_degrees(String wind_degrees) {
        this.wind_degrees = wind_degrees;
    }

    public Float getWind_mph() {
        return wind_mph;
    }

    public void setWind_mph(Float wind_mph) {
        this.wind_mph = wind_mph;
    }

    public Float getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(Float wind_kph) {
        this.wind_kph = wind_kph;
    }

    public Float getWind_gust_mph() {
        return wind_gust_mph;
    }

    public void setWind_gust_mph(Float wind_gust_mph) {
        this.wind_gust_mph = wind_gust_mph;
    }

    public Float getWind_gust_kph() {
        return wind_gust_kph;
    }

    public void setWind_gust_kph(Float wind_gust_kph) {
        this.wind_gust_kph = wind_gust_kph;
    }

    public Float getPressure_in() {
        return pressure_in;
    }

    public void setPressure_in(Float pressure_in) {
        this.pressure_in = pressure_in;
    }

    public Float getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(Float pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public String getDewpoint_string() {
        return dewpoint_string;
    }

    public void setDewpoint_string(String dewpoint_string) {
        this.dewpoint_string = dewpoint_string;
    }

    public Float getDewpoint_c() {
        return dewpoint_c;
    }

    public void setDewpoint_c(Float dewpoint_c) {
        this.dewpoint_c = dewpoint_c;
    }

    public Float getDewpoint_f() {
        return dewpoint_f;
    }

    public void setDewpoint_f(Float dewpoint_f) {
        this.dewpoint_f = dewpoint_f;
    }

//    public String getHeat_index_string() {
//        return heat_index_string;
//    }
//
//    public void setHeat_index_string(String heat_index_string) {
//        this.heat_index_string = heat_index_string;
//    }
//
//    public Float getHeat_index_f() {
//        return heat_index_f;
//    }
//
//    public void setHeat_index_f(Float heat_index_f) {
//        this.heat_index_f = heat_index_f;
//    }
//
//    public Float getHeat_index_c() {
//        return heat_index_c;
//    }
//
//    public void setHeat_index_c(Float heat_index_c) {
//        this.heat_index_c = heat_index_c;
//    }
    public String getFeelslike_string() {
        return feelslike_string;
    }

    public void setFeelslike_string(String feelslike_string) {
        this.feelslike_string = feelslike_string;
    }

    public Float getFeelslike_f() {
        return feelslike_f;
    }

    public void setFeelslike_f(Float feelslike_f) {
        this.feelslike_f = feelslike_f;
    }

    public Float getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(Float feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public Float getVisibility_mi() {
        return visibility_mi;
    }

    public void setVisibility_mi(Float visibility_mi) {
        this.visibility_mi = visibility_mi;
    }

    public Float getVisibility_km() {
        return visibility_km;
    }

    public void setVisibility_km(Float visibility_km) {
        this.visibility_km = visibility_km;
    }

    public String getPrecip_today_string() {
        return precip_today_string;
    }

    public void setPrecip_today_string(String precip_today_string) {
        this.precip_today_string = precip_today_string;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "CurrentObservation{" + "observation_time=" + observation_time + ", observation_time_rfc822="
                + observation_time_rfc822 + ", weather=" + weather + ", temperature_string=" + temperature_string
                + ", temp_f=" + temp_f + ", temp_c=" + temp_c + ", relative_humidity=" + relative_humidity
                + ", wind_string=" + wind_string + ", wind_dir=" + wind_dir + ", wind_degrees=" + wind_degrees
                + ", wind_mph=" + wind_mph + ", wind_kph=" + wind_kph + ", wind_gust_mph=" + wind_gust_mph
                + ", wind_gust_kph=" + wind_gust_kph + ", pressure_in=" + pressure_in + ", pressure_mb=" + pressure_mb
                + ", dewpoint_string=" + dewpoint_string + ", dewpoint_c=" + dewpoint_c + ", dewpoint_f=" + dewpoint_f
                + ", feelslike_string=" + feelslike_string + ", feelslike_f=" + feelslike_f + ", feelslike_c=" + feelslike_c
                + ", visibility_mi=" + visibility_mi + ", visibility_km=" + visibility_km + ", precip_today_string="
                + precip_today_string + ", icon_url=" + icon_url + ", icon=" + icon + '}';
    }

//    public Station getStation() {
//        return station;
//    }
//
//    public void setStation(Station station) {
//        this.station = station;
//    }

}
