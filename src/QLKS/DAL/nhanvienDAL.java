/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DAL;

import QLKS.DTO.nhanvienDTO;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class nhanvienDAL {

    public static ArrayList<nhanvienDTO> findall() throws Exception {
        ArrayList<nhanvienDTO> nvList = new ArrayList<>();

        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "Select * from nhan_vien";
        ResultSet rs = conn.excuteQuery(query);
        while (rs.next()) {
            nhanvienDTO nv = new nhanvienDTO();
            nv.setHo(rs.getString("ho"));
            nv.setChucvu(rs.getString("chuc_vu"));
            nv.setDiachi(rs.getString("diachi"));
            nv.setGioitinh(rs.getString("Gioi_tinh"));
            nv.setTen(rs.getString("ten"));
            nv.setId(rs.getInt("id"));
            nv.setLuong(rs.getInt("luong"));
            nv.setMa_nv(rs.getString("ma_nhan_vien"));
            nv.setNgaysinh(rs.getNString("ngaysinh"));
            nv.setSdt(rs.getString("sodienthoai"));
            nvList.add(nv);
        }

        conn.Close();
        return nvList;
    }

    public static void insert(nhanvienDTO nv) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "INSERT INTO nhan_vien(ma_nhan_vien, ho, ten, Gioi_tinh, ngaysinh, chuc_vu, sodienthoai, diachi, luong) "
                + "VALUES ('" + nv.getMa_nv() + "','" + nv.getHo() + "','" + nv.getTen() + "','" + nv.getGioitinh() + "','" + nv.getNgaysinh() + "','" + nv.getChucvu() + "','" + nv.getSdt() + "','" + nv.getDiachi() + "','" + nv.getLuong() + "')";
        conn.excuteUpdate(query);
        conn.Close();
    }

    public static void delete(int id) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "DELETE From nhan_vien where id='" + id + "'";
        conn.excuteUpdate(query);
        conn.Close();
    }

    public static void update(nhanvienDTO nv) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "UPDATE nhan_vien SET ma_nhan_vien='" + nv.getMa_nv() + "',ho='" + nv.getHo() + "',ten='" + nv.getTen() + "',Gioi_tinh='" + nv.getGioitinh() + "',ngaysinh='" + nv.getNgaysinh() + "',chuc_vu='" + nv.getChucvu() + "',sodienthoai='" + nv.getSdt() + "',diachi='" + nv.getDiachi() + "',luong='" + nv.getLuong() + "' WHERE id='" + nv.getId() + "'";
        conn.excuteUpdate(query);
        conn.Close();
    }

}
