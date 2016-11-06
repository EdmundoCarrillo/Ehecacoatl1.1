/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tools.geography;

public class GeographicDistance {

    private final double EARTH_EQUATORIAL_RADIUS = 6378.1370D;
    private final double CONVERT_DEGREES_TO_RADIANS = Math.PI / 180D;
    private final double CONVERT_KM_TO_MILES = 0.621371;
    private double deltaLat, deltaLon, a, c, distance;

    public GeographicDistance() {
    }

    // Haversine formula
    public double measureDistanceKm(double latitude1, double longitude1, double latitude2, double longitude2) {
        deltaLat = latitude2 * CONVERT_DEGREES_TO_RADIANS - latitude1 * CONVERT_DEGREES_TO_RADIANS;
        deltaLon = longitude2 * CONVERT_DEGREES_TO_RADIANS - longitude1 * CONVERT_DEGREES_TO_RADIANS;
        a = Math.pow(Math.sin(deltaLat / 2.0), 2.0) + (Math.cos(latitude1) * Math.cos(latitude2)
                * Math.pow(Math.sin(deltaLon / 2.0), 2.0));
        c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        distance = EARTH_EQUATORIAL_RADIUS * c;
        return round(distance);
    }

    public double measureDistanceMi(double latitude1, double longitude1, double latitude2, double longitude2) {
        return round(measureDistanceKm(latitude1, longitude1, latitude2, longitude2) * CONVERT_KM_TO_MILES);
    }

//Reduce los decimales del resultado a 3 digitos.
    public double round(double distancia) {
        return Math.round(distancia * 1000.0) / 1000.0;
    }

//    public static void main(String[] args) {
//        GeographicDistance geo = new GeographicDistance();
//        System.out.println(geo.measureDistanceKm(19.43000031, -99.09999847, 19.436111, -99.071944));
//        System.out.println(geo.measureDistanceMi(18.92187618976372, -99.21066284179688, 18.91265, -99.22219));
//    }
}
