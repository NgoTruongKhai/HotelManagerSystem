/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DTO;

import java.util.Date;

public class khuyenmaiDTO {

    int id;
    String ma_km;
    String noidung;
    int tienkm;

    public khuyenmaiDTO() {
    }

    public khuyenmaiDTO(int id, String ma_km, String noidung, int tienkm) {
        this.id = id;
        this.ma_km = ma_km;
        this.noidung = noidung;
        this.tienkm = tienkm;
    }

    public String getMa_km() {
        return ma_km;
    }

    public void setMa_km(String ma_km) {
        this.ma_km = ma_km;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getTienkm() {
        return tienkm;
    }

    public void setTienkm(int tienkm) {
        this.tienkm = tienkm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
