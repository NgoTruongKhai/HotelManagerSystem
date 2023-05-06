/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.DAL;

import QLKS.DTO.dichvuDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class dichvuDAL {

    public static ArrayList<dichvuDTO> findall() throws Exception {
        ArrayList<dichvuDTO> dvList = new ArrayList<>();

        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "Select * from dich_vu";
        ResultSet rs = conn.excuteQuery(query);
        while (rs.next()) {
            dichvuDTO dv = new dichvuDTO(rs.getString("ma_dv"), rs.getString("ten_dv"), rs.getDouble("gia_dv"));
            dvList.add(dv);
        }
        return dvList;
    }
}
