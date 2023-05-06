/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DTO;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class hoadonDTO {

    int ma_hd;
    String ma_kh;
    String ma_nv;
    String ngaylap;
    String ma_khuyen_mai;
    double tongtien;
    double tien_khuyen_mai;
    double tienthuc;
    int trang_thai;

    public hoadonDTO() {
    }

    public hoadonDTO(int ma_hd, String ma_kh, String ma_nv, String ngaylap, String ma_khuyen_mai, double tongtien, double tien_khuyen_mai, double tienthuc, int trang_thai) {
        this.ma_hd = ma_hd;
        this.ma_kh = ma_kh;
        this.ma_nv = ma_nv;
        this.ngaylap = ngaylap;
        this.ma_khuyen_mai = ma_khuyen_mai;
        this.tongtien = tongtien;
        this.tien_khuyen_mai = tien_khuyen_mai;
        this.tienthuc = tienthuc;
        this.trang_thai = trang_thai;
    }

    public int getMa_hd() {
        return ma_hd;
    }

    public void setMa_hd(int ma_hd) {
        this.ma_hd = ma_hd;
    }

    public String getMa_kh() {
        return ma_kh;
    }

    public void setMa_kh(String ma_kh) {
        this.ma_kh = ma_kh;
    }

    public String getMa_nv() {
        return ma_nv;
    }

    public void setMa_nv(String ma_nv) {
        this.ma_nv = ma_nv;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getMa_khuyen_mai() {
        return ma_khuyen_mai;
    }

    public void setMa_khuyen_mai(String ma_khuyen_mai) {
        this.ma_khuyen_mai = ma_khuyen_mai;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public double getTien_khuyen_mai() {
        return tien_khuyen_mai;
    }

    public void setTien_khuyen_mai(double tien_khuyen_mai) {
        this.tien_khuyen_mai = tien_khuyen_mai;
    }

    public double getThienthuc() {
        return tienthuc;
    }

    public void setThienthuc(double thienthuc) {
        this.tienthuc = thienthuc;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }

}
