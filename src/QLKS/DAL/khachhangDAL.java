/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DAL;

import QLKS.DTO.khachhangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class khachhangDAL {

    public static ArrayList<khachhangDTO> findall() throws Exception {
        ArrayList<khachhangDTO> khList = new ArrayList<>();
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");

        String query = "SELECT * FROM khach_hang";

        ResultSet rs = conn.excuteQuery(query);
        while (rs.next()) {
            khachhangDTO kh = new khachhangDTO(rs.getString("ma_kh"), rs.getString("ho"), rs.getString("ten"), rs.getString("sodienthoai"), rs.getString("ngaysinh"), rs.getString("diachi"), rs.getString("gioitinh"));
            khList.add(kh);
        }
        conn.Close();

        return khList;

    }

    public static void insert(khachhangDTO kh) throws SQLException, Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "Insert into khach_hang (ma_kh,ho,ten,gioitinh,ngaysinh,sodienthoai,diachi) value ('" + kh.getMa_kh() + "','" + kh.getHo() + "','" + kh.getTen() + "','" + kh.getGioitinh() + "','" + kh.getNgaysinh() + "','" + kh.getSdt() + "','" + kh.getDiachi() + "')";
        conn.excuteUpdate(query);
        conn.Close();
    }

    public static void delete(String ma_kh) throws Exception {

        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "DELETE FROM khach_hang WHERE ma_kh='" + ma_kh + "'";
        conn.excuteUpdate(query);
        conn.Close();
    }

    public static void update(khachhangDTO kh, String makh) throws SQLException, Exception {

        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "UPDATE khach_hang set ma_kh='"
                + kh.getMa_kh() + "',ho='"
                + kh.getHo() + "',ten='"
                + kh.getTen() + "',gioitinh='"
                + kh.getGioitinh() + "',ngaysinh ='"
                + kh.getNgaysinh() + "',diachi='"
                + kh.getDiachi() + "',sodienthoai='"
                + kh.getSdt() + "' WHERE ma_kh='"
                + makh + "' ";
        conn.excuteUpdate(query);
        conn.Close();
    }

}
