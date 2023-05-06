/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import QLKS.DAL.phieudangkiDAL;
import QLKS.DTO.khachhangDTO;
import QLKS.DTO.phieudangkiDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class phieudangkiBUS {

    public static ArrayList<phieudangkiDTO> pdkList;

    public void dspdk() throws Exception {
        phieudangkiDAL pdk = new phieudangkiDAL();
        if (pdkList == null) {
            pdkList = new ArrayList<>();
        }
        pdkList = pdk.findall();
    }

    public void updatetrangthai(int x, int i) throws Exception {
        phieudangkiDAL pdk = new phieudangkiDAL();
        pdk.updatetrangthai(x, i);
    }

    public void updatengay(int x, String format) throws Exception {
        phieudangkiDAL pdk = new phieudangkiDAL();
        pdk.updatengay(x, format);

    }

    public void update(phieudangkiDTO dk) throws Exception {
        phieudangkiDAL pdk = new phieudangkiDAL();
        pdk.update(dk);
    }

    public boolean insert(phieudangkiDTO dk, khachhangDTO kh) throws Exception {
        phieudangkiDAL pdk = new phieudangkiDAL();
        if (kh.getDiachi().equalsIgnoreCase("") || kh.getHo().equalsIgnoreCase("") || kh.getMa_kh().equalsIgnoreCase("") || kh.getSdt().equalsIgnoreCase("") || kh.getTen().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Mở phòng không thàng công !!");
            return false;
        }
        if (dk.getMa_khach_hang().equalsIgnoreCase("")) {
            return false;
        }
        pdk.insert(dk);
        return true;
    }

    public void delete(int x) throws Exception {
        phieudangkiDAL pdk = new phieudangkiDAL();
        pdk.delete(x);
    }

}
