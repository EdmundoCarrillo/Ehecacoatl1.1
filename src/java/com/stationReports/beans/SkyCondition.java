/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.stationReports.beans;

import java.util.ArrayList;
import java.util.List;

public class SkyCondition {

    private String sky_cover;
    private Integer cloud_base_ft_agl;
    private String sky_cover_description;
    private String filePath;

    public SkyCondition() {
    }

    public SkyCondition(String sky_cover) {
        this.sky_cover = sky_cover;
    }

    private SkyCondition(String sky_cover, Integer cloud_base_ft_agl, String sky_cover_description, String filePath) {
        this.sky_cover = sky_cover;
        this.cloud_base_ft_agl = cloud_base_ft_agl;
        this.sky_cover_description = sky_cover_description;
        this.filePath = filePath;
    }

    public String getSky_cover() {
        return sky_cover;
    }

    public void setSky_cover(String sky_cover) {
        this.sky_cover = sky_cover;
    }

    public Integer getCloud_base_ft_agl() {
        return cloud_base_ft_agl;
    }

    public void setCloud_base_ft_agl(Integer cloud_base_ft_agl) {
        this.cloud_base_ft_agl = cloud_base_ft_agl;
    }

    public String getSky_cover_description() {
        return sky_cover_description;
    }

    public void setSky_cover_description(String sky_cover_description) {
        this.sky_cover_description = sky_cover_description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "SkyCondition{" + "sky_cover=" + sky_cover + ", cloud_base_ft_agl=" + cloud_base_ft_agl + ", sky_cover_description=" + sky_cover_description + ", filePath=" + filePath + '}';
    }

    public void parseSkyConditions() {
        switch (sky_cover) {
            case "BKN":
                this.setSky_cover_description("Cielo Quebradizo");
                this.setFilePath("lib/icons/BKN.png");
                break;
            case "CAVOK":
                this.setSky_cover_description("Techo y visibilidad OK");
                this.setFilePath("");
                break;
            case "CLR":
                this.setSky_cover_description("Cielo Despejado");
                this.setFilePath("lib/icons/CLR.png");
                break;
            case "FEW":
                this.setSky_cover_description("Nubes Escasas");
                this.setFilePath("lib/icons/FEW.png");
                break;
            case "OVC":
                this.setSky_cover_description("Cielo Cubierto");
                this.setFilePath("lib/icons/OVC.png");
                break;
            case "SCT":
                this.setSky_cover_description("Nubes Dispersas");
                this.setFilePath("lib/icons/SCT.png"); 
                break;
            case "SKC":
                this.setSky_cover_description("Cielo Despejado");
                this.setFilePath("lib/icons/SKC.png");
                break;
            case "TCU":
                this.setSky_cover_description("Desarrollándose Cumulonimbus");
                this.setFilePath("");
                break;
            case "NSC":
                this.setSky_cover_description("No hay nubes significativas");
                this.setFilePath("");
                break;
            case "OVX":
                this.setSky_cover_description("Cielo indefinido");
                this.setFilePath("lib/icons/OVX.png");
                break;
        }

    }
}
