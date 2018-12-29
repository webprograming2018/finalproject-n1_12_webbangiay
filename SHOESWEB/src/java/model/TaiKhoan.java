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
public class TaiKhoan {
    private long idTK;
    private String username;
    private String password;
    private int level;
    private String NgayTao;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public long getIdTK() {
        return idTK;
    }

    public void setIdTK(long idTK) {
        this.idTK = idTK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public TaiKhoan(long idTK, String username, String password, int level, String NgayTao) {
        this.idTK = idTK;
        this.username = username;
        this.password = password;
        this.level = level;
        this.NgayTao = NgayTao;
    }

    public TaiKhoan() {
    }
    
    
}
