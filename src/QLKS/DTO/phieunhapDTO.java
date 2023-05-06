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
public class phieunhapDTO {

    int id;
    String maMH;
    String tenMH;
    int gia;
    int soluong;
    String ncc;
    int tongtien;

    public phieunhapDTO() {
    }

    public phieunhapDTO(int id, String maMH, String tenMH, int gia, int soluong, String ncc, int tongtien) {
        this.id = id;
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.gia = gia;
        this.soluong = soluong;
        this.ncc = ncc;
        this.tongtien = tongtien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNcc() {
        return ncc;
    }

    public void setNcc(String ncc) {
        this.ncc = ncc;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

}
