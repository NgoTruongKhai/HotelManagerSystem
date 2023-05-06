/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DAL;

import QLKS.DTO.chitiethoadonDTO;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class chitiethoadonDAL {

    public static ArrayList<chitiethoadonDTO> findall() throws Exception {
        ArrayList<chitiethoadonDTO> cthdList = new ArrayList<>();
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "Select * FROM chi_tiet_hoa_don";
        ResultSet rs = conn.excuteQuery(query);
        while (rs.next()) {
            chitiethoadonDTO cthd = new chitiethoadonDTO(rs.getInt("id"), rs.getString("ma_phong"), rs.getDouble("tien_phong"), rs.getInt("tong_ngay_o"), rs.getString("ma_dich_vu"), rs.getDouble("tien_dich_vu"), rs.getDouble("thanh_tien"), rs.getDouble("tien_khuyen_mai"));
            cthdList.add(cthd);
        }
        conn.Close();
        return cthdList;
    }

    public static void insert(chitiethoadonDTO cthd) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "INSERT INTO chi_tiet_hoa_don(id, thanh_tien, tien_khuyen_mai, tien_dich_vu, tien_phong, ma_phong, tong_ngay_o, ma_dich_vu) "
                + "VALUES ('" + cthd.getMa_hd() + "','" + cthd.getThanh_tien() + "','" + cthd.getTien_khuyen_mai() + "','" + cthd.getTien_dich_vu() + "','" + cthd.getTien_phong() + "','" + cthd.getMa_phong() + "','" + cthd.getTong_ngay_o() + "','" + cthd.getMa_dv() + "')";
        conn.excuteUpdate(query);
        conn.Close();
    }
}
