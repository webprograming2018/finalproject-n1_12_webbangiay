/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thuy Tran
 */
public class danhmuc {
    private long IdDM;
    private String TenDM;
    private boolean TrangThai;
    private String NgayTao;

    public long getIdDM() {
        return IdDM;
    }

    public void setIdDM(long IdDM) {
        this.IdDM = IdDM;
    }

    public String getTenDM() {
        return TenDM;
    }

    public void setTenDM(String TenDM) {
        this.TenDM = TenDM;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public danhmuc(long IdDM, String TenDM) {
        this.IdDM = IdDM;
        this.TenDM = TenDM;
        //this.TrangThai = TrangThai;
        //this.NgayTao = NgayTao;
    }

    public danhmuc() {
    }
    
}
