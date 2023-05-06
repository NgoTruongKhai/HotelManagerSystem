/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import QLKS.DAL.dichvuDAL;
import QLKS.DTO.dichvuDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class dichvuBUS {

    public static ArrayList<dichvuDTO> dvList;

    public void dsdv() throws Exception {
        dichvuDAL dv = new dichvuDAL();
        if (dvList == null) {
            dvList = new ArrayList<>();
        }
        dvList = dv.findall();
    }
}
