/* 
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */

//Controles del mapa.
var mousePositionControl = new ol.control.MousePosition({
    coordinateFormat: ol.coordinate.createStringXY(5),
    projection: 'EPSG:4326'
});
var scaleLine = new ol.control.ScaleLine({minWidth: 80});

var icon_layer = new ol.layer.Vector({
    source: new ol.source.Vector(),
    title: "Icons"
});

var map_layer = new ol.layer.Tile({
    source: new ol.source.OSM({
        wrapDateLine: false,
        wrapX: false,
        noWrap: true})
});

var center = ol.proj.transform([-99.071944, 19.436111], 'EPSG:4326', 'EPSG:3857');
var view = new ol.View({
    center: center,
    zoom: 6,
    minZoom: 3,
    maxZoom: 25});

var map = new ol.Map({
    layers: [map_layer, icon_layer],
    controls: [],
    target: 'map',
    view: view
});
map.addControl(mousePositionControl);
map.addControl(scaleLine);


