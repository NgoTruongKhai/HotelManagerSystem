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
public class phongDTO {

    String ma_phong;
    int ma_loai;
    int trang_thai;

    public phongDTO() {
    }

    public phongDTO(String ma_phong, int ma_loai, int trang_thai) {
        this.ma_phong = ma_phong;
        this.ma_loai = ma_loai;
        this.trang_thai = trang_thai;
    }

    public String getMa_phong() {
        return ma_phong;
    }

    public void setMa_phong(String ma_phong) {
        this.ma_phong = ma_phong;
    }

    public int getMa_loai() {
        return ma_loai;
    }

    public void setMa_loai(int ma_loai) {
        this.ma_loai = ma_loai;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }

}
