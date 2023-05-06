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
public class dichvuDTO {

    String ma_dv;
    String ten_dv;
    double gia_dv;

    public dichvuDTO() {
    }

    public dichvuDTO(String ma_dv, String ten_dv, double gia_dv) {
        this.ma_dv = ma_dv;
        this.ten_dv = ten_dv;
        this.gia_dv = gia_dv;
    }

    public String getMa_dv() {
        return ma_dv;
    }

    public void setMa_dv(String ma_dv) {
        this.ma_dv = ma_dv;
    }

    public String getTen_dv() {
        return ten_dv;
    }

    public void setTen_dv(String ten_dv) {
        this.ten_dv = ten_dv;
    }

    public double getGia_dv() {
        return gia_dv;
    }

    public void setGia_dv(double gia_dv) {
        this.gia_dv = gia_dv;
    }

}
