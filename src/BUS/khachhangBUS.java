/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import QLKS.DAL.khachhangDAL;
import QLKS.DTO.khachhangDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class khachhangBUS {

    public static ArrayList<khachhangDTO> khList;

    public void dskh() throws Exception {
        khachhangDAL data = new khachhangDAL();
        if (khList == null) {
            khList = new ArrayList<>();
        }
        khList = data.findall();
    }

    public boolean delete(String temp) throws Exception {
        khachhangDAL data = new khachhangDAL();
        if (temp.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chon khách hàng cần xóa !1");
            return false;
        }
        data.delete(temp);
        return true;
    }

    public boolean insert(khachhangDTO kh) throws Exception {
        khachhangDAL data = new khachhangDAL();
        if (kh.getDiachi().equalsIgnoreCase("") || kh.getHo().equalsIgnoreCase("") || kh.getMa_kh().equalsIgnoreCase("") || kh.getSdt().equalsIgnoreCase("") || kh.getTen().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !!");
            return false;
        }
        data.insert(kh);
        return true;
    }

    public boolean update(khachhangDTO kh, String temp) throws Exception {
        khachhangDAL data = new khachhangDAL();
        if (kh.getDiachi().equalsIgnoreCase("") || kh.getHo().equalsIgnoreCase("") || kh.getMa_kh().equalsIgnoreCase("") || kh.getSdt().equalsIgnoreCase("") || kh.getTen().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !!");
            return false;
        }
        data.update(kh, temp);
        return true;

    }

}
