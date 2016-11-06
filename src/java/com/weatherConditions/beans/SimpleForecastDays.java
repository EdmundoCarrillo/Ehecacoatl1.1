/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */

package com.weatherConditions.beans;

import java.util.List;


public class SimpleForecastDays {
private List<SimpleForecastDay> SimpleForecastDay;

    public List<SimpleForecastDay> getSimpleForecastDay() {
        return SimpleForecastDay;
    }

    public void setSimpleForecastDay(List<SimpleForecastDay> SimpleForecastDay) {
        this.SimpleForecastDay = SimpleForecastDay;
    }

    @Override
    public String toString() {
        return "SimpleForecastDays{" + "SimpleForecastDay=" + SimpleForecastDay + '}';
    }


}
