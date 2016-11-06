/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.stationReports.beans;

import com.geolookup.beans.Station;
import java.util.List;



public class TAF {

    private String raw_text;
    private Station station;
    private String issue_time;
    private String bulletin_time;
    private String valid_time_from;
    private String valid_time_to;
    private List<TAForecast> tforecastList;

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

    public String getIssue_time() {
        return issue_time;
    }

    public void setIssue_time(String issue_time) {
        this.issue_time = issue_time;
    }

    public String getBulletin_time() {
        return bulletin_time;
    }

    public void setBulletin_time(String bulletin_time) {
        this.bulletin_time = bulletin_time;
    }

    public String getValid_time_from() {
        return valid_time_from;
    }

    public void setValid_time_from(String valid_time_from) {
        this.valid_time_from = valid_time_from;
    }

    public String getValid_time_to() {
        return valid_time_to;
    }

    public void setValid_time_to(String valid_time_to) {
        this.valid_time_to = valid_time_to;
    }

    public List<TAForecast> getTforecastList() {
        return tforecastList;
    }

    public void setTforecastList(List<TAForecast> tforecastList) {
        this.tforecastList = tforecastList;
    }

    @Override
    public String toString() {
        return "Taf{" + "raw_text=" + raw_text + ", station=" + station + ", issue_time=" + issue_time + ", bulletin_time=" + bulletin_time + ", valid_time_from=" + valid_time_from + ", valid_time_to=" + valid_time_to + ", tforecastList=" + tforecastList + '}';
    }
    
}
