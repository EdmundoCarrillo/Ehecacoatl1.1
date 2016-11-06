/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package test;

import com.geolookup.beans.Location;
import com.geolookup.beans.NearbyStations;
import com.geolookup.beans.Station;
import com.weatherConditions.beans.ForecastDay;
import com.weatherConditions.beans.Weather;
import com.weatherConditions.controller.WeatherStationController;
import java.io.IOException;
import java.util.List;
import org.xml.sax.SAXException;

public class mainTest1 {

    public static void main(String[] args) throws SAXException, IOException {
        WeatherStationController wsc = new WeatherStationController(19.436111,-99.071944);
        Weather weather = wsc.weatherCheck();
        Location location = wsc.getLocation();
        Station station = weather.getStationSource();

        if (weather.isError()) {
            System.out.println("ERROR:");
            System.out.println(weather.getQueryError());
        } else {
            System.out.println("PUNTO DE INTERÉS:");
            System.out.println("Latitude: " + location.getLatitude());
            System.out.println("Longitude: " + location.getLongitude());
            System.out.println("Country: " + location.getCountry());
            System.out.println("Country_iso3166: " + location.getCountry_iso3166());
            System.out.println("Country_name: " + location.getCountry_name());
            System.out.println("State: " + location.getState());
            System.out.println("City: " + location.getCity());
            System.out.println("TimeZone: " + location.getTz_long());

            NearbyStations nb = location.getNearby_weather_stations();
            List<Station> a = nb.getAirport().getStation();
            List<Station> b = nb.getPws().getStation();

            System.out.println("\nLista de aeropuertos cercanos:");
            for (Station st : a) {
                System.out.println("Neighborhood:" + st.getNeighborhood());
                System.out.println("City:" + st.getCity());
                System.out.println("State:" + st.getState());
                System.out.println("Country:" + st.getCountry());
                System.out.println("Station_id:" + st.getStation_id());
                System.out.println("Latitude:" + st.getLatitude());
                System.out.println("Longitude:" + st.getLongitude());
                System.out.println("Elevation_m:" + st.getElevation_m());
                System.out.println("Distance_km:" + st.getDistance_km());
                System.out.println("Distance_mi:" + st.getDistance_mi());
                System.out.println("\n");
            }

            System.out.println("\nLista de pws cercanos:");
            for (Station st : b) {
                System.out.println("Neighborhood:" + st.getNeighborhood());
                System.out.println("City:" + st.getCity());
                System.out.println("State:" + st.getState());
                System.out.println("Country:" + st.getCountry());
                System.out.println("Station_id:" + st.getStation_id());
                System.out.println("Latitude:" + st.getLatitude());
                System.out.println("Longitude:" + st.getLongitude());
                System.out.println("Elevation_m:" + st.getElevation_m());
                System.out.println("Distance_km:" + st.getDistance_km());
                System.out.println("Distance_mi:" + st.getDistance_mi());
                System.out.println("\n");
            }
            System.out.println("\nESTACIÓN MÁS CERCANA:");
            System.out.println("Station_id: " + station.getStation_id());
            System.out.println("Latitude: " + station.getLatitude());
            System.out.println("Longitude: " + station.getLongitude());
            System.out.println("Elevation_m: " + station.getElevation_m());
            System.out.println("Country: " + station.getCountry());
            System.out.println("State: " + station.getState());
            System.out.println("City: " + station.getCity());
            System.out.println("Neighborhood: " + station.getNeighborhood());
            System.out.println("Distance_km: " + station.getDistance_km());

            if (weather.isAirportSource()) {
                System.out.println("\nTIMEPO ACTUAL:");

                System.out.println("Raw_text: " + weather.getMetar().getRaw_text());
                System.out.println("Station_id: " + weather.getMetar().getStation().getStation_id());
                System.out.println("Distance_km: " + weather.getMetar().getStation().getDistance_km());
                System.out.println("Observation_time: " + weather.getMetar().getObservation_time());
                System.out.println("Temperature_c: " + weather.getMetar().getTemperature_c());
                System.out.println("Dewpoint: " + weather.getMetar().getDewpoint());
                System.out.println("Wind_dir_degrees: " + weather.getMetar().getWind_dir_degrees());
                System.out.println("Wind_speed_kt: " + weather.getMetar().getWind_speed_kt());
                System.out.println("Visibility_mi: " + weather.getMetar().getVisibility_mi());
                System.out.println("Altimeter_in_hg: " + weather.getMetar().getAltimeter_in_hg());
                System.out.println("Sea_level_pressure_mb: " + weather.getMetar().getSea_level_pressure_mb());
                System.out.println("Wx_string: " + weather.getMetar().getWx_string());
                System.out.println("SkyConditionList: " + weather.getMetar().getSkyConditionList().toString());
                System.out.println("WxSymbolList:" + weather.getMetar().getWxSymbolList().toString());

                System.out.println("\nPRONOSTICO:");
                System.out.println("Raw_text: " + weather.getTaf().getRaw_text());
                System.out.println("Station_id: " + weather.getTaf().getStation().getStation_id());
                System.out.println("Distance_km: " + weather.getTaf().getStation().getDistance_km());
                System.out.println("Valid_time_from: " + weather.getTaf().getValid_time_from());
                System.out.println("Valid_time_to: " + weather.getTaf().getValid_time_to());
                System.out.println("Valid_time_to: " + weather.getTaf().getTforecastList().toString());
              
                
                System.out.println("\n");
            } else if (weather.isPwsSource()) {
                System.out.println("\nTIMEPO ACTUAL:");
                System.out.println("Observation_time: " + weather.getBestObservation().getObservation_time());
                System.out.println("Weather: " + weather.getBestObservation().getWeather());
                System.out.println("Dewpoint: " + weather.getBestObservation().getDewpoint_string());
                System.out.println("Feelslike: " + weather.getBestObservation().getFeelslike_string());
                System.out.println("Precip_today: " + weather.getBestObservation().getPrecip_today_string());
                System.out.println("Temperature:" + weather.getBestObservation().getTemperature_string());
                System.out.println("Relative_humidity :" + weather.getBestObservation().getRelative_humidity());
                System.out.println("Visibility_km: " + weather.getBestObservation().getVisibility_km());
                System.out.println("Wind: " + weather.getBestObservation().getWind_string());
                System.out.println("Pressure_in:" + weather.getBestObservation().getPressure_in());
                System.out.println("\nPRONOSTICO:");
                List<ForecastDay> pr = weather.getBestForecast().getTxt_forecast().getForecastdays().getForecastday();
                for (ForecastDay fr : pr) {
                    System.out.println("Period: " + fr.getPeriod());
                    System.out.println("Title: " + fr.getTitle());
                    System.out.println("Probabilidad de lluvia: " + fr.getPop());
                    System.out.println("Forecast: " + fr.getFcttext());
                    System.out.println("\n");
                }
            }

        }
    }
}
