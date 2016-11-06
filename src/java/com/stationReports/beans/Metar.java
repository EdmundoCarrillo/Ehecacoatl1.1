/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.stationReports.beans;

import com.geolookup.beans.Station;
import java.util.List;

public class Metar {

    private String raw_text;
    private Station station;
    private String observation_time;
    private float temperature_c;
    private float dewpoint;
    private float wind_dir_degrees;
    private float wind_speed_kt;
    private float visibility_mi;
    private double altimeter_in_hg;
    private double sea_level_pressure_mb;
    private String wx_string;
    private Integer num_result;
    private List<SkyCondition> skyConditionList;
    private List<WxSymbol> wxSymbolList;

    public String getRaw_text() {
        return raw_text;
    }

    public void setRaw_text(String raw_text) {
        this.raw_text = raw_text;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getObservation_time() {
        return observation_time;
    }

    public void setObservation_time(String observation_time) {
        this.observation_time = observation_time;
    }

    public float getTemperature_c() {
        return temperature_c;
    }

    public void setTemperature_c(float temperature_c) {
        this.temperature_c = temperature_c;
    }

    public float getDewpoint() {
        return dewpoint;
    }

    public void setDewpoint(float dewpoint) {
        this.dewpoint = dewpoint;
    }

    public float getWind_dir_degrees() {
        return wind_dir_degrees;
    }

    public void setWind_dir_degrees(float wind_dir_degrees) {
        this.wind_dir_degrees = wind_dir_degrees;
    }

    public float getWind_speed_kt() {
        return wind_speed_kt;
    }

    public void setWind_speed_kt(float wind_speed_kt) {
        this.wind_speed_kt = wind_speed_kt;
    }

    public float getVisibility_mi() {
        return visibility_mi;
    }

    public void setVisibility_mi(float visibility_mi) {
        this.visibility_mi = visibility_mi;
    }

    public double getAltimeter_in_hg() {
        return altimeter_in_hg;
    }

    public void setAltimeter_in_hg(double altimeter_in_hg) {
        this.altimeter_in_hg = altimeter_in_hg;
    }

    public double getSea_level_pressure_mb() {
        return sea_level_pressure_mb;
    }

    public void setSea_level_pressure_mb(double sea_level_pressure_mb) {
        this.sea_level_pressure_mb = sea_level_pressure_mb;
    }

    public String getWx_string() {
        return wx_string;
    }

    public void setWx_string(String wx_string) {
        this.wx_string = wx_string;
    }

    public List<SkyCondition> getSkyConditionList() {
        return skyConditionList;
    }

    public void setSkyConditionList(List<SkyCondition> skyConditionList) {
        this.skyConditionList = skyConditionList;
    }

    public Integer getNum_result() {
        return num_result;
    }

    public void setNum_result(Integer num_result) {
        this.num_result = num_result;
    }

    public List<WxSymbol> getWxSymbolList() {
        return wxSymbolList;
    }

    public void setWxSymbolList(List<WxSymbol> wxSymbolList) {
        this.wxSymbolList = wxSymbolList;
    }

    @Override
    public String toString() {
        return "Metar{" + "raw_text=" + raw_text + ", station=" + station + ", observation_time=" + observation_time + ", temperature_c=" + temperature_c + ", dewpoint=" + dewpoint + ", wind_dir_degrees=" + wind_dir_degrees + ", wind_speed_kt=" + wind_speed_kt + ", visibility_mi=" + visibility_mi + ", altimeter_in_hg=" + altimeter_in_hg + ", sea_level_pressure_mb=" + sea_level_pressure_mb + ", wx_string=" + wx_string + ", num_result=" + num_result + ", skyConditionList=" + skyConditionList + ", wxSymbolList=" + wxSymbolList + '}';
    }

}
