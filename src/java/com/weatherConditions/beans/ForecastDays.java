/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.weatherConditions.beans;

import java.util.List;

public class ForecastDays {

    private List<ForecastDay> forecastday;

    public List<ForecastDay> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<ForecastDay> forecastday) {
        this.forecastday = forecastday;
    }

    @Override
    public String toString() {
        return "ForecastDays{" + "forecastday=" + forecastday + '}';
    }

 

}
