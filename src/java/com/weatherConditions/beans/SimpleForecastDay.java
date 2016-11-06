/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.weatherConditions.beans;

public class SimpleForecastDay {

    private String period;
    private String icon_url;
    private String icon;
    private String pop;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    @Override
    public String toString() {
        return "SimpleForecastDay{" + "period=" + period + ", icon_url=" + icon_url + ", icon=" + icon + ", pop=" + pop + '}';
    }
    
    

}
