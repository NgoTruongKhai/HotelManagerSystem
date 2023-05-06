/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DTO;

/**
 *
 * @author ASUS
 */
public class phieudangkiDTO {

    int ma_phieu;
    String ma_khach_hang;
    String ma_nv;
    String ma_phong;
    String ngaynhanphong;
    String ngaytraphong;
    String ngaydatphong;
    int trangthai;
    String ma_dv;
    String ma_km;

    public phieudangkiDTO() {

    }
    public phieudangkiDTO(int ma_phieu, String ma_khach_hang, String ma_nv, String ma_phong, String ngaynhanphong, String ngaytraphong, String ngaydatphong, int trangthai, String ma_dv, String ma_km) {
        this.ma_phieu = ma_phieu;
        this.ma_khach_hang = ma_khach_hang;
        this.ma_nv = ma_nv;
        this.ma_phong = ma_phong;
        this.ngaynhanphong = ngaynhanphong;
        this.ngaytraphong = ngaytraphong;
        this.ngaydatphong = ngaydatphong;
        this.trangthai = trangthai;
        this.ma_dv = ma_dv;
        this.ma_km = ma_km;
    }

    public int getMa_phieu() {
        return ma_phieu;
    }

    public void setMa_phieu(int ma_phieu) {
        this.ma_phieu = ma_phieu;
    }

    public String getMa_khach_hang() {
        return ma_khach_hang;
    }

    public void setMa_khach_hang(String ma_khach_hang) {
        this.ma_khach_hang = ma_khach_hang;
    }

    public String getMa_nv() {
        return ma_nv;
    }

    public void setMa_nv(String ma_nv) {
        this.ma_nv = ma_nv;
    }

    public String getMa_phong() {
        return ma_phong;
    }

    public void setMa_phong(String ma_phong) {
        this.ma_phong = ma_phong;
    }

    public String getNgaynhanphong() {
        return ngaynhanphong;
    }

    public void setNgaynhanphong(String ngaynhanphong) {
        this.ngaynhanphong = ngaynhanphong;
    }

    public String getNgaytraphong() {
        return ngaytraphong;
    }

    public void setNgaytraphong(String ngaytraphong) {
        this.ngaytraphong = ngaytraphong;
    }

    public String getNgaydatphong() {
        return ngaydatphong;
    }

    public void setNgaydatphong(String ngaydatphong) {
        this.ngaydatphong = ngaydatphong;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public void setMa_dv(String ma_dv) {
        this.ma_dv = ma_dv;
    }

    public String getMa_dv() {
        return ma_dv;
    }

    public void setMa_km(String ma_km) {
        this.ma_km = ma_km;
    }

    public String getMa_km() {
        return ma_km;
    }

}
