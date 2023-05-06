/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import QLKS.DAL.chitiethoadonDAL;
import QLKS.DTO.chitiethoadonDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class chitiethoadonBUS {

    public static ArrayList<chitiethoadonDTO> cthdList;

    public void dscthd() throws Exception {
        chitiethoadonDAL cthd = new chitiethoadonDAL();
        if (cthdList == null) {
            cthdList = new ArrayList<>();
        }
        cthdList = cthd.findall();
    }

    public void insert(chitiethoadonDTO cthd) throws Exception {
        chitiethoadonDAL cthdbus = new chitiethoadonDAL();
        cthdbus.insert(cthd);
    }

}
