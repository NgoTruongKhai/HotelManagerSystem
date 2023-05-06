/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import QLKS.DAL.phongDAL;
import QLKS.DTO.phongDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class phongBUS {

    public static ArrayList<phongDTO> phongList;

    public void dsphong() throws Exception {
        phongDAL phong = new phongDAL();
        if (phongList == null) {
            phongList = new ArrayList<>();
        }
        phongList = phong.findAll();
    }

    public void updatephong(String ma_phong, int i) throws Exception {
        phongDAL phong = new phongDAL();
        phong.updatephong(ma_phong, i);
    }

}
