/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DAL;

import QLKS.DTO.hoadonDTO;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class hoadonDAL {

    public static ArrayList<hoadonDTO> findall() throws Exception {
        ArrayList<hoadonDTO> hdList = new ArrayList<>();
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "SELECT * From hoa_don";
        ResultSet rs = conn.excuteQuery(query);
        while (rs.next()) {
            hoadonDTO hd = new hoadonDTO(rs.getInt("id"), rs.getString("ma_khach_hang"), rs.getString("ma_nhan_vien"), rs.getString("ngay_lap_hoa_don"), rs.getString("ma_khuyen_mai"), rs.getDouble("tong_tien"), rs.getDouble("tien_khuyen_mai"), rs.getDouble("tien_thuc"), rs.getInt("trang_thai"));
            hdList.add(hd);
        }
        conn.Close();
        return hdList;
    }

    public static void insert(hoadonDTO hd) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "INSERT INTO hoa_don(id, ma_khach_hang, ma_nhan_vien, ngay_lap_hoa_don, ma_khuyen_mai, tong_tien, tien_thuc, tien_khuyen_mai, trang_thai) VALUES ('" + hd.getMa_hd() + "','" + hd.getMa_kh() + "','" + hd.getMa_nv() + "','" + hd.getNgaylap() + "','" + hd.getMa_khuyen_mai() + "','" + hd.getTongtien() + "','" + hd.getThienthuc() + "','" + hd.getTien_khuyen_mai() + "','" + hd.getTrang_thai() + "')";
        conn.excuteUpdate(query);
        conn.Close();
    }

}
