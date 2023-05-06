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
public class nhanvienDTO {

    int id;
    String ma_nv;
    String ho;
    String ten;
    String sdt;
    String diachi;
    String ngaysinh;
    String gioitinh;
    String chucvu;
    int luong;

    public nhanvienDTO() {
    }

    public nhanvienDTO(int id, String ma_nv, String ho, String ten, String sdt, String diachi, String ngaysinh, String gioitinh, String chucvu, int luong) {
        this.id = id;
        this.ma_nv = ma_nv;
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.chucvu = chucvu;
        this.luong = luong;
    }

    public nhanvienDTO(String ma_nv, String ho, String ten, String sdt, String diachi, String ngaysinh, String gioitinh, String chucvu, int luong) {
        this.ma_nv = ma_nv;
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.chucvu = chucvu;
        this.luong = luong;
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

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

}
