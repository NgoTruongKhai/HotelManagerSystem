/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import QLKS.DAL.taikhoanDAL;
import QLKS.DTO.taikhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class taikhoanBUS {

    public static ArrayList<taikhoanDTO> taikhoanList;

    public void dstk() throws Exception {
        taikhoanDAL tk = new taikhoanDAL();
        if (taikhoanList == null) {
            taikhoanList = new ArrayList<>();
        }
        taikhoanList = tk.findAll();
    }

}
