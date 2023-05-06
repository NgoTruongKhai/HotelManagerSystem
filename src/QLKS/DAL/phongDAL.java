/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DAL;

import QLKS.DTO.phongDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class phongDAL {

    public static ArrayList<phongDTO> findAll() throws Exception {
        ArrayList<phongDTO> phList = new ArrayList<>();
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");

        String query = "SELECT * From phong";

        ResultSet rs = conn.excuteQuery(query);
        while (rs.next()) {
            phongDTO ph = new phongDTO(rs.getString("ma_phong"), rs.getInt("loai_phong"), rs.getInt("trang_thai"));
            phList.add(ph);
        }
        conn.Close();
        return phList;
    }

    public static void updatephong(String ma_phong, int x) throws Exception {
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");

        String query = "UPDATE phong set trang_thai="
                + x + " WHERE ma_phong='"
                + ma_phong + "' ";

        conn.excuteUpdate(query);
        conn.Close();
    }

}
