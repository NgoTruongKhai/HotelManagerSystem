/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DAL;

import QLKS.DTO.phieunhapDTO;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class phieunhaphangDAL {

    public static ArrayList<phieunhapDTO> findall() throws Exception {
        ArrayList<phieunhapDTO> pnList = new ArrayList<>();
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "SELECT * from nhap_hang";
        ResultSet rs = conn.excuteQuery(query);
        while (rs.next()) {
            phieunhapDTO pn = new phieunhapDTO(rs.getInt("id"), rs.getString("Ma_hang"), rs.getString("Ten_hang"), rs.getInt("gia_tien"), rs.getInt("so_luong"), rs.getString("ncc"), rs.getInt("tongtien"));
            pnList.add(pn);
        }
        conn.Close();
        return pnList;
    }

    public static void insert(phieunhapDTO pn) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "Insert into nhap_hang(Ma_hang, Ten_hang, gia_tien, so_luong, ncc, tongtien) value('" + pn.getMaMH() + "','" + pn.getTenMH() + "','" + pn.getGia() + "','" + pn.getSoluong() + "','" + pn.getNcc() + "','" + pn.getTongtien() + "')";
        conn.excuteUpdate(query);
        conn.Close();
    }

    public static void update(phieunhapDTO pn) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "update nhap_hang set "
                + "Ma_hang='" + pn.getMaMH() + "',Ten_hang='" + pn.getTenMH() + "',gia_tien='" + pn.getGia() + "',so_luong='" + pn.getSoluong() + "',ncc='" + pn.getNcc() + "',tongtien='" + pn.getTongtien() + "' where id='" + pn.getId() + "'";
        conn.excuteUpdate(query);
        conn.Close();
    }

    public static void delete(int id) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "Delete from nhap_hang where id='" + id + "'";
        conn.excuteUpdate(query);
        conn.Close();
    }
}
