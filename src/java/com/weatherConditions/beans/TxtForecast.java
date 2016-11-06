/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.weatherConditions.beans;

public class TxtForecast {

    private ForecastDays forecastdays;
    private String date;

    public ForecastDays getForecastdays() {
        return forecastdays;
    }

    public void setForecastdays(ForecastDays forecastdays) {
        this.forecastdays = forecastdays;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Txt_forecast{" + "forecastdays=" + forecastdays + ", date=" + date + '}';
    }
    
    
}
