/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DAL;

import QLKS.DTO.khuyenmaiDTO;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class khuyenmaiDAL {

    public static ArrayList<khuyenmaiDTO> findall() throws Exception {
        ArrayList<khuyenmaiDTO> kmList = new ArrayList<>();
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "SELECT * From khuyen_mai";
        ResultSet rs = conn.excuteQuery(query);
        while (rs.next()) {
            khuyenmaiDTO km = new khuyenmaiDTO(rs.getInt("id"), rs.getString("ma_khuyen_mai"), rs.getString("noi_dung"), rs.getInt("phan_tram_khuyen_mai"));
            kmList.add(km);
        }
        conn.Close();
        return kmList;
    }

    public static void insert(khuyenmaiDTO km) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "insert into khuyen_mai(ma_khuyen_mai,phan_tram_khuyen_mai,noi_dung) value('" + km.getMa_km() + "','" + km.getTienkm() + "','" + km.getNoidung() + "')";
        conn.excuteUpdate(query);
        conn.Close();
    }

    public void update(khuyenmaiDTO km) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "Update khuyen_mai set ma_khuyen_mai='" + km.getMa_km() + "',noi_dung='" + km.getNoidung() + "',phan_tram_khuyen_mai='" + km.getTienkm() + "' where id='" + km.getId() + "'";
        conn.excuteUpdate(query);
        conn.Close();
    }

    public void delete(int id) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "Delete From khuyen_mai Where id='" + id + "'";
        conn.excuteUpdate(query);
        conn.Close();
    }

}
