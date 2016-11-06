/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.weatherConditions.beans;

public class SimpleForecast {

    private SimpleForecastDays simpleForecastdays;

    public SimpleForecastDays getSimpleForecastdays() {
        return simpleForecastdays;
    }

    public void setSimpleForecastdays(SimpleForecastDays simpleForecastdays) {
        this.simpleForecastdays = simpleForecastdays;
    }

    @Override
    public String toString() {
        return "SimpleForecast{" + "simpleForecastdays=" + simpleForecastdays + '}';
    }

}
