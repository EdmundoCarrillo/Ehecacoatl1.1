/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.weatherConditions.beans;

import com.geolookup.beans.Station;

public class BestForecast {

//    private Station station;
    private TxtForecast txt_forecast;
    private SimpleForecast simple_forecast;

    public TxtForecast getTxt_forecast() {
        return txt_forecast;
    }

    public void setTxt_forecast(TxtForecast txt_forecast) {
        this.txt_forecast = txt_forecast;
    }

    public SimpleForecast getSimple_forecast() {
        return simple_forecast;
    }

    public void setSimple_forecast(SimpleForecast simple_forecast) {
        this.simple_forecast = simple_forecast;
    }

    
//    public Station getStation() {
//        return station;
//    }
//
////    public void setStation(Station station) {
////        this.station = station;
//    }

//    @Override
//    public String toString() {
//        return "BestForecast{" + "station=" + station + ", txt_forecast=" + txt_forecast + ", simple_forecast=" + simple_forecast + '}';
//    }
//    

    @Override
    public String toString() {
        return "BestForecast{" + "txt_forecast=" + txt_forecast + ", simple_forecast=" + simple_forecast + '}';
    }
    

}
