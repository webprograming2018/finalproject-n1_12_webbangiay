/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Thuy Tran
 */
public class BillLocationShip {
    long idBLS;
    long idBill;
    long idShip;
    double lastLat;
    double lastLng;
    double lat;
    double lng;
    Timestamp updateTime;

    public BillLocationShip() {
    }

    public BillLocationShip(long idBLS) {
        this.idBLS = idBLS;
    }

    public long getIdBLS() {
        return idBLS;
    }

    public void setIdBLS(long idBLS) {
        this.idBLS = idBLS;
    }

    public long getIdBill() {
        return idBill;
    }

    public void setIdBill(long idBill) {
        this.idBill = idBill;
    }

    public long getIdShip() {
        return idShip;
    }

    public void setIdShip(long idShip) {
        this.idShip = idShip;
    }

    public double getLastLat() {
        return lastLat;
    }

    public void setLastLat(double lastLat) {
        this.lastLat = lastLat;
    }

    public double getLastLng() {
        return lastLng;
    }

    public void setLastLng(double lastLng) {
        this.lastLng = lastLng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
    
    
}
