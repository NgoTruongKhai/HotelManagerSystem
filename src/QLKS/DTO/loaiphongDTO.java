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
public class loaiphongDTO {

    int ma_loai_phong;
    double gialoaiphong;
    int soluongnguoi;

    public loaiphongDTO() {
    }

    public loaiphongDTO(int ma_loai_phong, double gialoaiphong, int soluongnguoi) {
        this.ma_loai_phong = ma_loai_phong;
        this.gialoaiphong = gialoaiphong;
        this.soluongnguoi = soluongnguoi;
    }

    public int getMa_loai_phong() {
        return ma_loai_phong;
    }

    public void setMa_loai_phong(int ma_loai_phong) {
        this.ma_loai_phong = ma_loai_phong;
    }

    public double getGialoaiphong() {
        return gialoaiphong;
    }

    public void setGialoaiphong(double gialoaiphong) {
        this.gialoaiphong = gialoaiphong;
    }

    public int getSoluongnguoi() {
        return soluongnguoi;
    }

    public void setSoluongnguoi(int soluongnguoi) {
        this.soluongnguoi = soluongnguoi;
    }

}
