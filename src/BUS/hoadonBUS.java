/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import QLKS.DAL.hoadonDAL;
import QLKS.DTO.hoadonDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class hoadonBUS {

    public static ArrayList<hoadonDTO> hdList;

    private static void rerad() throws Exception {
        hoadonBUS hd = new hoadonBUS();
        hd.dshd();
    }

    public void dshd() throws Exception {
        hoadonDAL hd = new hoadonDAL();
        if (hdList == null) {
            hdList = new ArrayList<>();
        }
        hdList = hd.findall();
    }

    public void insert(hoadonDTO hd) throws Exception {
        hoadonDAL hdbus = new hoadonDAL();
        hdbus.insert(hd);
    }
}
