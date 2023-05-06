/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import QLKS.DAL.loaiphongDAL;
import QLKS.DTO.loaiphongDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class loaiphongBUS {

    public static ArrayList<loaiphongDTO> lpList;

    public void dslp() throws Exception {
        loaiphongDAL lp = new loaiphongDAL();
        if (lpList == null) {
            lpList = new ArrayList<>();
        }
        lpList = lp.findall();
    }
;

}
