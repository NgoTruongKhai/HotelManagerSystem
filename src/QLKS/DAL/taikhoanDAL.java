/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DAL;

import QLKS.DTO.taikhoanDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class taikhoanDAL {

    public static ArrayList<taikhoanDTO> findAll() throws Exception {

        ArrayList<taikhoanDTO> taikhoanList = new ArrayList<>();

        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");

        String query = "SELECT * FROM tai_khoan";

        ResultSet rs = conn.excuteQuery(query);
        while (rs.next()) {
            taikhoanDTO user = new taikhoanDTO(rs.getInt("id"), rs.getString("tai_khoan"), rs.getString("mat_khau"), rs.getInt("level"));
            taikhoanList.add(user);
        }
        conn.Close();
        return taikhoanList;
    }

}
