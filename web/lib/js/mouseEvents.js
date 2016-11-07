/* 
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
var xWp; //Coordenada x donde se encuentra el puntero.
var yWp; //Coordenada y donde se encuentra el puntero.
var ref2;
var objRef; //Objeto auxiliar para funcionalidades del menu-sc, copia de feature(marcador).
var xhr; // Objeto XMLHttpRequest (ajax).
var vientoIMG = "lib/icons/windbarb0.svg";

//Estilo del marcador
var icon_style = new ol.style.Style({
    image: new ol.style.Icon({
        anchor: [0.5, 30],
        anchorXUnits: 'fraction',
        anchorYUnits: 'pixels',
        src: '/Ehecacoatl1.1/lib/img/marker2.png'
    })
});

// Funciones principales 
function mostrarMenuPrincipal(event) {
    xWp = event.clientX;
    yWp = event.clientY;
    document.getElementById("menu-pr").style.display = "block";
    var anchoM = 150 * 1;
    var altoM = 200 * 1;
    var xPan = window.innerWidth;
    var yPan = window.innerHeight;

    var xStr = "";
    var yStr = "";
    var x = 1 * 1;
    var y = 1 * 1;
    if (xWp + anchoM >= xPan) {
        x = xPan - anchoM - 10;
    } else {
        x = xWp;
    }
    if (yWp + altoM > yPan) {
        y = yPan - altoM - 30;
    } else {
        y = yWp;
    }
    xStr = x + "px";
    yStr = y + "px";
    document.getElementById("menu-pr").style.left = xStr;
    document.getElementById("menu-pr").style.top = yStr;
}

function mostrarMenuSecundario(event) {
    xWp = event.clientX;
    yWp = event.clientY;
    document.getElementById("menu-sc").style.display = "block";
    var anchoM = 150 * 1;
    var altoM = 200 * 1;
    var xPan = window.innerWidth;
    var yPan = window.innerHeight;

    var xStr = "";
    var yStr = "";
    var x = 1 * 1;
    var y = 1 * 1;
    if (xWp + anchoM >= xPan) {
        x = xPan - anchoM - 10;
    } else {
        x = xWp;
    }
    if (yWp + altoM > yPan) {
        y = yPan - altoM - 30;
    } else {
        y = yWp;
    }
    xStr = x + "px";
    yStr = y + "px";
    document.getElementById("menu-sc").style.left = xStr;
    document.getElementById("menu-sc").style.top = yStr;

}
function agregarMarcador() {
    // alert(xWp + "," + yWp);
    var coordWP = map.getCoordinateFromPixel([xWp, yWp]);
    var lonlat = ol.proj.transform(coordWP, 'EPSG:3857', 'EPSG:4326');
    ref2 = coordWP;

    var icon_feature = new ol.Feature({
        geometry: new ol.geom.Point(coordWP),
        coorXY: [xWp, yWp], // para saber donde pocionar el menu secundario 
        coordenada: [lonlat[0], lonlat[1]], //Para mandar lat y lon al server
        pos: coordWP,
        type: 'icon'
    });

    icon_feature.setStyle(icon_style);
    icon_layer.getSource().addFeature(icon_feature);


    ocultarMenuPrincipal();
}
function eliminarMarcador() {
    icon_layer.getSource().removeFeature(objRef);
    ocultarMenuSecundario();
}

function ocultarMenuPrincipal() {
    document.getElementById("menu-pr").style.display = "none";
}
function ocultarMenuSecundario() {
    document.getElementById("menu-sc").style.display = "none";
}

function mostrarMenuDatos(event) {

    mandarCoordenadas();
    //alert(objRef.get('coorXY')[0] + "," + objRef.get('coorXY')[1]);
    limpiarTabla();
    limpiarImgViento();
    var xMd = objRef.get('coorXY')[0];
    var yMd = objRef.get('coorXY')[1];
    var anchoM = 150 * 1;
    var altoM = 200 * 1;
    var xPan = window.innerWidth;
    var yPan = window.innerHeight;

    var xStr = "";
    var yStr = "";
    var x = 1 * 1;
    var y = 1 * 1;
    if (xMd + anchoM >= xPan) {
        x = xPan - anchoM - 10;
    } else {
        x = xMd;
    }
    if (yMd + altoM > yPan) {
        y = yPan - altoM - 30;
    } else {
        y = yMd;
    }
    xStr = x + "px";
    yStr = y + "px";
    document.getElementById('myPopup').style.display = "block";
    document.getElementById("myPopup").style.left = xStr;
    document.getElementById("myPopup").style.top = yStr;
    // document.getElementById("menuDatos").style.left = xStr;
    // document.getElementById("menuDatos").style.top = yStr;
    ocultarMenuSecundario();
}
function cerrarMenuDatos() {
    document.getElementById('myPopup').style.display = "none";

}

function mostrarForecast() {
    document.getElementById("forecast").style.display = "block";

}

function cerrarForecast() {
    document.getElementById("forecast").style.display = "none";

}

function limpiarTabla() {
    // var table = document.getElementById("tablaNubes");
    // if (table.rows.length === 0) {

    //} else {
    //  for (var i = 0; i < table.rows.length; i++) {
    //    document.getElementById("tablaNubes").deleteRow(i);
    //}
    //}

    var table = document.getElementById("tablaNubes");
    table.innerHTML = "";


}

function limpiarImgViento() {

    if (document.getElementById("barW")) {
        var icono = document.getElementById("barW");
        icono.parentNode.removeChild(icono);
    }
}

//Cambiar el tipo de cursor
var element = document.getElementById('popup');
var popup = new ol.Overlay({
    element: element,
    positioning: 'bottom-center',
    stopEvent: false
});
map.addOverlay(popup);


//mostrar el menu secundario 
map.on("click", function (evt) {
    var map = evt.map;
    var feature = map.forEachFeatureAtPixel(
            evt.pixel, function (feature, layer) {
                return feature;
            }
    );
    if (feature) {
        // alert(feature.get('coordenada')[0]+ "," + feature.get('coordenada')[1]);
        mostrarMenuSecundario(event);

        if (feature.get('type') === "icon") {
            objRef = feature;


        }

    } else {
        //$(element).popover('destroy');
    }
});


map.on('pointermove', function (e) {
    ocultarMenuSecundario();
    if (e.dragging) {
        //$(element).popover('destroy');
        return;
    }
    //var pixel = map.getEventPixel(e.originalEvent);
    //var hit = map.hasFeatureAtPixel(pixel);
    // map.getTargetElement().style.cursor = hit ? 'pointer' : '';
});


function mandarCoordenadas() {
    ocultarMenuSecundario();

    //Envia las coordenas al servidor para buscar el clima.
    if (window.ActiveXObject) {
        xhr = new ActiveXObject("Microsoft.XMLHttp");
    } else if ((window.XMLHttpRequest) || (typeof XMLHttpRequest) !== undefined) {
        xhr = new XMLHttpRequest();
    } else {
        alert("Su navegador no tiene soporte para Ajax. ");
        return;
    }
    xhr.open("GET", "/Ehecacoatl1.1/climaController.jsp?lat=" + objRef.get('coordenada')[1] + "&lon=" + objRef.get('coordenada')[0], true);
    xhr.onreadystatechange = procesaDatos;
    xhr.send(null);

}
/*Función para probar contenido dinamico en la tablas
 function llenarT() {
 var tabla = document.getElementById("tablaNubes");
 tabla.insertAdjacentHTML('afterend', '<tr><td class="colorT">Cielo Quebradizo a 2000 ft</td><td>fileimg</td></tr>');
 //var contenido = document.createTextNode("<tr><td class='colorT'>Cielo Quebradizo a 2000 ft</td><td>fileimg</td></tr>");
 //tabla.appendChild(contenido);
 }*/

function agregarIconos() {

    var coordWP = map.getCoordinateFromPixel([xWp, yWp]);
    var lonlat = ol.proj.transform(coordWP, 'EPSG:3857', 'EPSG:4326');
    var tempFeature = new ol.Feature({
        geometry: new ol.geom.Point(coordWP),
        coorXY: [xWp, yWp],
        coordenada: [lonlat[0], lonlat[1]],
        type: 'weather'
    });
    tempFeature.setStyle(tempStyle);
    icon_layer.getSource().addFeature(tempFeature);
}

function procesaDatos() {
    //tratamineto de la respuesta
    if (xhr.readyState === 4) {
        var response = JSON.parse(xhr.responseText);
        document.getElementById("coorResumen").innerHTML = response.coordenadas;
        document.getElementById("coorRe").innerHTML = response.coordenadas;
        document.getElementById("temperatura").innerHTML = response.temperatura;
        document.getElementById("altimetro").innerHTML = response.altimetro;
        document.getElementById("puntoRocio").innerHTML = response.puntoRocio;
        document.getElementById("visibilidad").innerHTML = response.visibilidad;
        document.getElementById("dirViento").innerHTML = response.dirViento;
        document.getElementById("velViento").innerHTML = response.velViento;
        document.getElementById("presionMar").innerHTML = response.presionMar;
        var tabla = document.getElementById("tablaNubes");
        tabla.insertAdjacentHTML('afterbegin', response.skyCover);
        document.getElementById("hora").innerHTML = response.hora;
        // document.getElementById("distancia").innerHTML = response.distancia;
        document.getElementById("id").innerHTML = response.id;
        document.getElementById("raw").innerHTML = response.raw;
        document.getElementById("lluvia").innerHTML = response.lluvia;
        document.getElementById("humedad").innerHTML = response.humedad;
        var tablaFore = document.getElementById("tableForecast");
        tablaFore.insertAdjacentHTML('afterend', response.forecastDay);




        var imgViento = document.getElementById("iconoViento");
        var speed = response.velViento;
        if (speed >= 48) {
            imgViento.insertAdjacentHTML('afterend', '<td id="barW" rowspan="2" colspan="2" style="text-align:center;" > <img src="lib/icons/windbarb50.svg" alt="" style="width: 50px; height: 50px; \n\
                                            -webkit-transform: rotate(' + response.dirViento + 'deg);"/></td>');
            vientoIMG = "lib/icons/windbarb50.svg";
        } else if (speed >= 43) {
            imgViento.insertAdjacentHTML('afterend', '<td id="barW" rowspan="2" colspan="2" style="text-align:center;" > <img src="lib/icons/windbarb45.svg" alt="" style="width: 50px; height: 50px; \n\
                                            -webkit-transform: rotate(' + response.dirViento + 'deg);"/></td>');
            vientoIMG = "lib/icons/windbarb45.svg";
        } else if (speed >= 38) {
            imgViento.insertAdjacentHTML('afterend', '<td id="barW" rowspan="2" colspan="2" style="text-align:center;" > <img src="lib/icons/windbarb40.svg" alt="" style="width: 50px; height: 50px; \n\
                                            -webkit-transform: rotate(' + response.dirViento + 'deg);"/></td>');
            vientoIMG = "lib/icons/windbarb40.svg";
        } else if (speed >= 33) {
            imgViento.insertAdjacentHTML('afterend', '<td id="barW" rowspan="2" colspan="2" style="text-align:center;" > <img src="lib/icons/windbarb35.svg" alt="" style="width: 50px; height: 50px; \n\
                                            -webkit-transform: rotate(' + response.dirViento + 'deg);"/></td>');
            vientoIMG = "lib/icons/windbarb35.svg";
        } else if (speed >= 28) {
            imgViento.insertAdjacentHTML('afterend', '<td id="barW" rowspan="2" colspan="2" style="text-align:center;" > <img src="lib/icons/windbarb30.svg" alt="" style="width: 50px; height: 50px; \n\
                                            -webkit-transform: rotate(' + response.dirViento + 'deg);"/></td>');
            vientoIMG = "lib/icons/windbarb30.svg";
        } else if (speed >= 23) {
            imgViento.insertAdjacentHTML('afterend', '<td id="barW" rowspan="2" colspan="2" style="text-align:center;" > <img src="lib/icons/windbarb25.svg" alt="" style="width: 50px; height: 50px; \n\
                                            -webkit-transform: rotate(' + response.dirViento + 'deg);"/></td>');
            vientoIMG = "lib/icons/windbarb25.svg";

        } else if (speed >= 18) {
            imgViento.insertAdjacentHTML('afterend', '<td id="barW" rowspan="2" colspan="2" style="text-align:center;" > <img src="lib/icons/windbarb20.svg" alt="" style="width: 50px; height: 50px; \n\
                                            -webkit-transform: rotate(' + response.dirViento + 'deg);"/></td>');
            vientoIMG = "lib/icons/windbarb20.svg";

        } else if (speed >= 13) {
            imgViento.insertAdjacentHTML('afterend', '<td id="barW" rowspan="2" colspan="2" style="text-align:center;" > <img src="lib/icons/windbarb15.svg" alt="" style="width: 50px; height: 50px; \n\
                                            -webkit-transform: rotate(' + response.dirViento + 'deg);"/></td>');
            vientoIMG = "lib/icons/windbarb15.svg";
        } else if (speed >= 8) {
            imgViento.insertAdjacentHTML('afterend', '<td id="barW" rowspan="2" colspan="2" style="text-align:center;" > <img src="lib/icons/windbarb10.svg" alt="" style="width: 50px; height: 50px; \n\
                                            -webkit-transform: rotate(' + response.dirViento + 'deg);"/></td>');
            vientoIMG = "lib/icons/windbarb10.svg";
        } else if (speed >= 3) {
            imgViento.insertAdjacentHTML('afterend', '<td id="barW" rowspan="2" colspan="2" style="text-align:center;" > <img src="lib/icons/windbarb5.svg" alt="" style="width: 50px; height: 50px; \n\
                                            -webkit-transform: rotate(' + response.dirViento + 'deg);"/></td>');
            vientoIMG = "lib/icons/windbarb5.svg";
        } else {
            imgViento.insertAdjacentHTML('afterend', '<td id="barW" rowspan="2" colspan="2" style="text-align:center;" > <img src="lib/icons/windbarb0.svg" alt="" style="width: 50px; height: 50px; \n\
                                            -webkit-transform: rotate(' + response.dirViento + 'deg);"/></td>');
            vientoIMG = "lib/icons/windbarb0.svg";
        }
    }
    agregarMarcador2(response.temperatura, response.altimetro, vientoIMG, response.dirViento);

}


function agregarMarcador2(tempe, alt, viento, grados) {
   
    var tempStyle = new ol.style.Style({
        text: new ol.style.Text({
            font: 'Normal 18px Arial',
            text: tempe + '°',
            fill: new ol.style.Fill({
                color: '#000'
            }),
            stroke: new ol.style.Stroke({
                color: '#FF0000',
                width: 1
            }),
            offsetX: -2,
            offsetY: -40,
            rotation: 0
        })
    });
    var tempFeature = new ol.Feature({
        geometry: new ol.geom.Point(objRef.get('pos'))
    });

    //viento
    var iconWindStyle = new ol.style.Style({
        image: new ol.style.Icon(/** @type {olx.style.IconOptions} */ {
            //scale: .15,
            anchor: [.5, .8],
            rotation: grados * 0.0174533,
            src: viento,
            scale: .15


        })
    });
    var windFeature = new ol.Feature({
        geometry: new ol.geom.Point(objRef.get('pos'))
    });

    //Altimetro
    var altStyle = new ol.style.Style({
        text: new ol.style.Text({
            font: 'Normal 18px Arial',
            text: alt + '',
            fill: new ol.style.Fill({
                color: '#000'
            }),
            stroke: new ol.style.Stroke({
                color: '#002bff',
                width: 1
            }),
            offsetX: 40,
            offsetY: -20,
            rotation: 0
        })
    });
    var altFeature = new ol.Feature({
        geometry: new ol.geom.Point(objRef.get('pos'))
    });


    //clima

    var weatherStyle = new ol.style.Style({
        image: new ol.style.Icon({
            anchor: [1.7, 1.2],
            src: '/Ehecacoatl1.1/lib/icons/OVX.svg',
            scale: .1

        })
    });
    var weatherFeature = new ol.Feature({
        geometry: new ol.geom.Point(objRef.get('pos'))
    });


    tempFeature.setStyle(tempStyle);
    icon_layer.getSource().addFeature(tempFeature);

    windFeature.setStyle(iconWindStyle);
    icon_layer.getSource().addFeature(windFeature);

    altFeature.setStyle(altStyle);
    icon_layer.getSource().addFeature(altFeature);

    weatherFeature.setStyle(weatherStyle);
    icon_layer.getSource().addFeature(weatherFeature);

}