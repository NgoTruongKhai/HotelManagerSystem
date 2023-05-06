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
public class chitiethoadonDTO {

    int ma_hd;
    String ma_phong;
    double tien_phong;
    int tong_ngay_o;
    String ma_dv;
    double tien_dich_vu;
    double thanh_tien;
    double tien_khuyen_mai;

    public chitiethoadonDTO() {
    }

    public chitiethoadonDTO(int ma_hd, String ma_phong, double tien_phong, int tong_ngay_o, String ma_dv, double tien_dich_vu, double thanh_tien, double tien_khuyen_mai) {
        this.ma_hd = ma_hd;
        this.ma_phong = ma_phong;
        this.tien_phong = tien_phong;
        this.tong_ngay_o = tong_ngay_o;
        this.ma_dv = ma_dv;
        this.tien_dich_vu = tien_dich_vu;
        this.thanh_tien = thanh_tien;
        this.tien_khuyen_mai = tien_khuyen_mai;
    }

    public int getMa_hd() {
        return ma_hd;
    }

    public void setMa_hd(int ma_hd) {
        this.ma_hd = ma_hd;
    }

    public String getMa_phong() {
        return ma_phong;
    }

    public void setMa_phong(String ma_phong) {
        this.ma_phong = ma_phong;
    }

    public double getTien_phong() {
        return tien_phong;
    }

    public void setTien_phong(double tien_phong) {
        this.tien_phong = tien_phong;
    }

    public int getTong_ngay_o() {
        return tong_ngay_o;
    }

    public void setTong_ngay_o(int tong_ngay_o) {
        this.tong_ngay_o = tong_ngay_o;
    }

    public String getMa_dv() {
        return ma_dv;
    }

    public void setMa_dv(String ma_dv) {
        this.ma_dv = ma_dv;
    }

    public double getTien_dich_vu() {
        return tien_dich_vu;
    }

    public void setTien_dich_vu(double tien_dich_vu) {
        this.tien_dich_vu = tien_dich_vu;
    }

    public double getThanh_tien() {
        return thanh_tien;
    }

    public void setThanh_tien(double thanh_tien) {
        this.thanh_tien = thanh_tien;
    }

    public double getTien_khuyen_mai() {
        return tien_khuyen_mai;
    }

    public void setTien_khuyen_mai(double tien_khuyen_mai) {
        this.tien_khuyen_mai = tien_khuyen_mai;
    }

}
