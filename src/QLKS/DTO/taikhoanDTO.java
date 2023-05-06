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
public class taikhoanDTO {

    int id;
    String ma_nv;
    String ma_khkau;
    int level;

    public taikhoanDTO() {
    }

    public taikhoanDTO(int id, String ma_nv, String ma_khkau, int level) {
        this.id = id;
        this.ma_nv = ma_nv;
        this.ma_khkau = ma_khkau;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa_nv() {
        return ma_nv;
    }

    public void setMa_nv(String ma_nv) {
        this.ma_nv = ma_nv;
    }

    public String getMa_khkau() {
        return ma_khkau;
    }

    public void setMa_khkau(String ma_khkau) {
        this.ma_khkau = ma_khkau;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
