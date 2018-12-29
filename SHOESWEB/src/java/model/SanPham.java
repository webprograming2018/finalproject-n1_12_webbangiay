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
public class SanPham {
    private long IdSP;
    private long IdDM;
    private String TenSP;
    private String SPimage;
    private double DonGia;
    private Timestamp NgayTao;
    private boolean TrangThai;

    public long getIdSP() {
        return IdSP;
    }

    public void setIdSP(long IdSP) {
        this.IdSP = IdSP;
    }

    public long getIdDM() {
        return IdDM;
    }

    public void setIdDM(long IdDM) {
        this.IdDM = IdDM;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getSPimage() {
        return SPimage;
    }

    public void setSPimage(String SPimage) {
        this.SPimage = SPimage;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public Timestamp getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Timestamp NgayTao) {
        this.NgayTao = NgayTao;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public SanPham(long IdSP, long IdDM, String TenSP, String SPimage, double DonGia, Timestamp NgayTao, boolean TrangThai) {
        this.IdSP = IdSP;
        this.IdDM = IdDM;
        this.TenSP = TenSP;
        this.SPimage = SPimage;
        this.DonGia = DonGia;
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
    }

    public SanPham() {
    }
    
}
