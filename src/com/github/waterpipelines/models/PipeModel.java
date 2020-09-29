package com.github.waterpipelines.models;

public class PipeModel {
    private String idX;
    private String idY;
    private Integer distance;

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistance() {
        return distance;
    }

    public String getIdX() {
        return idX;
    }

    public String getIdY() {
        return idY;
    }

    public void setIdX(String idX) {
        this.idX = idX;
    }

    public void setIdY(String idY) {
        this.idY = idY;
    }
}
