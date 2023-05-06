package QLKS.DAL;

import QLKS.DAL.mysqlConnection;
import QLKS.DTO.loaiphongDTO;
import java.util.ArrayList;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class loaiphongDAL {

    public static ArrayList<loaiphongDTO> findall() throws Exception {
        ArrayList<loaiphongDTO> lpList = new ArrayList<>();
        mysqlConnection conn = new mysqlConnection("localhost", "root", "", "quan_li_khach_san_db");
        String query = "SElECT * FROM loai_phong";
        ResultSet rs = conn.excuteQuery(query);
        while (rs.next()) {
            loaiphongDTO lp = new loaiphongDTO(rs.getInt("ma_loai"), rs.getDouble("gia_loai_phong"), rs.getInt("so_luong_nguoi"));
            lpList.add(lp);
        }
        conn.Close();
        return lpList;
    }
}
