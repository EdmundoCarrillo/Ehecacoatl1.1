/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tools.xmlReader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;
import com.weatherConditions.beans.*;

public class BestForecastHandler extends DefaultHandler {
    
    private final StringBuilder buffer = new StringBuilder();
    private final List<ForecastDay> forecastDayList = new ArrayList();
    private final List<SimpleForecastDay> simpleForecastDayList = new ArrayList();
    
    private BestForecast bestForecast;
    
    private SimpleForecast simpleForecast;
    private SimpleForecastDays simpleForecastDays;
    private SimpleForecastDay simpleForecastDay;
    
    private TxtForecast txt_forecast;
    private ForecastDays forecastDays;
    private ForecastDay forecastDay;

    //Para manejar los elementos iguales en diferentes clases.
    private boolean btxt_forecast = false;
    private boolean bsimpleforecast = false;
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "forecast":
                bestForecast.setTxt_forecast(txt_forecast);
                bestForecast.setSimple_forecast(simpleForecast);
                break;
            case "txt_forecast":
                txt_forecast.setForecastdays(forecastDays);
                btxt_forecast = false;
                break;
            case "simpleforecast":
                simpleForecast.setSimpleForecastdays(simpleForecastDays);
                bsimpleforecast = false;
                break;
            case "forecastdays":
                if (btxt_forecast) {
                    forecastDays.setForecastday(forecastDayList);
                } else if (bsimpleforecast) {
                    simpleForecastDays.setSimpleForecastDay(simpleForecastDayList);
                }
                break;
            case "forecastday":
                if (btxt_forecast) {
                    forecastDayList.add(forecastDay);
                } else if (bsimpleforecast) {
                    simpleForecastDayList.add(simpleForecastDay);
                }
                break;
            case "period":
                if (btxt_forecast) {
                    forecastDay.setPeriod(buffer.toString());
                } else if (bsimpleforecast) {
                    simpleForecastDay.setPeriod(buffer.toString());
                }
                break;
            case "icon":
                if (btxt_forecast) {
                    forecastDay.setIcon(buffer.toString());
                } else if (bsimpleforecast) {
                    simpleForecastDay.setIcon(buffer.toString());
                }
                break;
            case "icon_url":
              if (btxt_forecast) {
                    forecastDay.setIcon_url(buffer.toString());
                } else if (bsimpleforecast) {
                    simpleForecastDay.setIcon_url(buffer.toString());
                }
                break;
            case "title":
                forecastDay.setTitle(buffer.toString());
                break;
            case "fcttext":
                forecastDay.setFcttext(buffer.toString());
                break;
            case "fcttext_metric":
                forecastDay.setFcttext_metric(buffer.toString());
                break;
            case "pop":
               if (btxt_forecast) {
                    forecastDay.setPop(buffer.toString());
                } else if (bsimpleforecast) {
                    simpleForecastDay.setPop(buffer.toString());
                }
                break;
            
        }
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "forecast":
                bestForecast = new BestForecast();
                buffer.delete(0, buffer.length());
                break;
            case "txt_forecast":
                txt_forecast = new TxtForecast();
                buffer.delete(0, buffer.length());
                btxt_forecast = true;
                break;
            case "simpleforecast":
                simpleForecast = new SimpleForecast();
                buffer.delete(0, buffer.length());
                bsimpleforecast = true;
                break;
            case "forecastdays":
                if (btxt_forecast) {
                    forecastDays = new ForecastDays();
                } else if (bsimpleforecast) {
                    simpleForecastDays = new SimpleForecastDays();
                }
                buffer.delete(0, buffer.length());
                break;
            case "forecastday":
                if (btxt_forecast) {
                    forecastDay = new ForecastDay();
                } else if (bsimpleforecast) {
                    simpleForecastDay = new SimpleForecastDay();
                }
                buffer.delete(0, buffer.length());
                break;
            case "period":
            case "icon":
            case "icon_url":
            case "title":
            case "fcttext":
            case "fcttext_metric":
            case "pop":
            case "date":
                buffer.delete(0, buffer.length());
                break;
            
        }
    }
    
    public BestForecast getBestForecast() {
        return bestForecast;
    }
    
    public void setBestForecast(BestForecast bestForecast) {
        this.bestForecast = bestForecast;
    }
}
