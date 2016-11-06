/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.services.handler;

import com.geolookup.beans.Location;
import com.stationReports.beans.Metar;
import com.stationReports.beans.TAF;
import com.tools.Url.DataSource;
import com.tools.Url.URLCreator;
import com.tools.xmlReader.BestForecastHandler;
import com.tools.xmlReader.GeolookupHandler;
import com.tools.xmlReader.MetarHandler;
import com.tools.xmlReader.ObservationHandler;
import com.tools.xmlReader.TAFHandler;
import com.weatherConditions.beans.BestForecast;
import com.weatherConditions.beans.CurrentObservation;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ServiceResponse {

    URLCreator urlCreator = new URLCreator();
    XMLReader xmlReader;

    public ServiceResponse() {
    }

    public Location getNearbyStations(Double latitude, Double longitude) throws SAXException, MalformedURLException, IOException {
        xmlReader = XMLReaderFactory.createXMLReader();
        GeolookupHandler geoHandler = new GeolookupHandler();
        urlCreator = new URLCreator();
        xmlReader.setContentHandler(geoHandler);
        xmlReader.parse(new InputSource(urlCreator.getSurroundingStations(latitude, longitude).openStream()));
        return geoHandler.getLocation();
    }

    public List<Metar> getMetarReport(String idStation) throws SAXException, IOException {
        xmlReader = XMLReaderFactory.createXMLReader();
        MetarHandler metarHandler = new MetarHandler();
        urlCreator = new URLCreator();
        xmlReader.setContentHandler(metarHandler);
        xmlReader.parse(new InputSource(urlCreator.getMostRecentAirportReport(idStation, DataSource.METAR).openStream()));
        return metarHandler.getMetarList();
    }

    public List<TAF> getTAFReport(String idStation) throws SAXException, IOException {
        xmlReader = XMLReaderFactory.createXMLReader();
        TAFHandler tafHandler = new TAFHandler();
        urlCreator = new URLCreator();
        xmlReader.setContentHandler(tafHandler);
        xmlReader.parse(new InputSource(urlCreator.getMostRecentAirportReport(idStation, DataSource.TAF).openStream()));
        return tafHandler.getTafList();
    }

    public CurrentObservation getPwsConditions(String idStation) throws SAXException, IOException {
        xmlReader = XMLReaderFactory.createXMLReader();
        ObservationHandler obHandler = new ObservationHandler();
        urlCreator = new URLCreator();
        xmlReader.setContentHandler(obHandler);
        xmlReader.parse(new InputSource(urlCreator.getMostRecentPwsReport(idStation, DataSource.BFCONDITIONS).openStream()));
        return obHandler.getCurrentObservation();
    }

    public BestForecast getPwsForecast(String idStation) throws SAXException, IOException {
        xmlReader = XMLReaderFactory.createXMLReader();
        BestForecastHandler bfHandler = new BestForecastHandler();
        urlCreator = new URLCreator();
        xmlReader.setContentHandler(bfHandler);
        xmlReader.parse(new InputSource(urlCreator.getMostRecentPwsReport(idStation, DataSource.BFORECAST).openStream()));
        return bfHandler.getBestForecast();
    }
}
