/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.stationReports.beans;

import java.util.List;

public class TAForecast {

    private String fcst_time_from;
    private String fcst_time_to;
    private float wind_dir_degrees;
    private float wind_speed_kt;
    private float visibility_mi;
    private String wx_string;
    private List<SkyCondition> skyConditionList;
    private List<WxSymbol> wxSymbolList;
    private double altimeter_in_hg;
    private float max_temp_c;
    private float min_temp_c;

    public List<WxSymbol> getWxSymbolList() {
        return wxSymbolList;
    }

    public void setWxSymbolList(List<WxSymbol> wxSymbolList) {
        this.wxSymbolList = wxSymbolList;
    }

    public String getFcst_time_from() {
        return fcst_time_from;
    }

    public void setFcst_time_from(String fcst_time_from) {
        this.fcst_time_from = fcst_time_from;
    }

    public String getFcst_time_to() {
        return fcst_time_to;
    }

    public void setFcst_time_to(String fcst_time_to) {
        this.fcst_time_to = fcst_time_to;
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

    public double getAltimeter_in_hg() {
        return altimeter_in_hg;
    }

    public void setAltimeter_in_hg(double altimeter_in_hg) {
        this.altimeter_in_hg = altimeter_in_hg;
    }

    public float getMax_temp_c() {
        return max_temp_c;
    }

    public void setMax_temp_c(float max_temp_c) {
        this.max_temp_c = max_temp_c;
    }

    public float getMin_temp_c() {
        return min_temp_c;
    }

    public void setMin_temp_c(float min_temp_c) {
        this.min_temp_c = min_temp_c;
    }

    @Override
    public String toString() {
        return "TAForecast{" + "fcst_time_from=" + fcst_time_from + ", fcst_time_to=" + fcst_time_to + ", wind_dir_degrees=" + wind_dir_degrees + ", wind_speed_kt=" + wind_speed_kt + ", visibility_mi=" + visibility_mi + ", wx_string=" + wx_string + ", skyConditionList=" + skyConditionList + ", wxSymbolList=" + wxSymbolList + ", altimeter_in_hg=" + altimeter_in_hg + ", max_temp_c=" + max_temp_c + ", min_temp_c=" + min_temp_c + '}';
    }

}
