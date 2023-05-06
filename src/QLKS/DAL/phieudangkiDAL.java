/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DAL;

import QLKS.DTO.phieudangkiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class phieudangkiDAL {

    public static ArrayList<phieudangkiDTO> findall() throws Exception {
        ArrayList<phieudangkiDTO> pdkList = new ArrayList<>();
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "SELECT * FROM phieu_dang_ki";
        ResultSet rs = conn.excuteQuery(query);
        while (rs.next()) {
            phieudangkiDTO pdk = new phieudangkiDTO(rs.getInt("ma_phieu"), rs.getString("ma_khach_hang"), rs.getString("ma_nhan_vien"), rs.getString("ma_phong"), rs.getString("ngay_nhan_phong"), rs.getString("ngay_tra_phong"), rs.getString("ngay_dat_phong"), rs.getInt("trang_thai"), rs.getString("ma_dv"), rs.getString("ma_km"));
            pdkList.add(pdk);
        }
        conn.Close();
        return pdkList;
    }

    public static void insert(phieudangkiDTO pdk) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "insert into phieu_dang_ki(ma_khach_hang,ngay_nhan_phong,ngay_dat_phong,ngay_tra_phong,ma_phong,ma_nhan_vien,trang_thai,ma_dv,ma_km) value('" + pdk.getMa_khach_hang() + "','" + pdk.getNgaynhanphong() + "','" + pdk.getNgaydatphong() + "','" + pdk.getNgaytraphong() + "','" + pdk.getMa_phong() + "','" + pdk.getMa_nv() + "','" + pdk.getTrangthai() + "','" + pdk.getMa_dv() + "','" + pdk.getMa_km() + "')";
        conn.excuteUpdate(query);
        conn.Close();
    }

    public static void update(phieudangkiDTO pdk) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "Update phieu_dang_ki set "
                + "ma_khach_hang='" + pdk.getMa_khach_hang()
                + "',ma_nhan_vien='" + pdk.getMa_nv()
                + "',ma_phong='" + pdk.getMa_phong()
                + "',ngay_nhan_phong='" + pdk.getNgaynhanphong()
                + "',ngay_tra_phong='" + pdk.getNgaytraphong()
                + "',ngay_dat_phong='" + pdk.getNgaydatphong()
                + "',trang_thai='" + pdk.getTrangthai()
                + "' where ma_phieu='" + pdk.getMa_phieu() + "'";
//        System.out.println(query);
        conn.excuteUpdate(query);
        conn.Close();
    }

    public static void updatengay(int ma_phieu, String ngay) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "Update phieu_dang_ki set "
                + "ngay_tra_phong='" + ngay
                + "' where ma_phieu='" + ma_phieu + "'";
//        System.out.println(query);
        conn.excuteUpdate(query);
        conn.Close();
    }

    public static void delete(int ma_phieu) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "Delete FROM phieu_dang_ki where ma_phieu='" + ma_phieu + "'";
        conn.excuteUpdate(query);
        conn.Close();
    }

    public static void updatetrangthai(int ma_phieu, int trangthai) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "Update phieu_dang_ki set "
                + "trang_thai='" + trangthai
                + "' where ma_phieu='" + ma_phieu + "'";
//        System.out.println(query);
        conn.excuteUpdate(query);
        conn.Close();
    }

}
