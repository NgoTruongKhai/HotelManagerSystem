/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import QLKS.DAL.khuyenmaiDAL;
import QLKS.DTO.khuyenmaiDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

/**
 *
 * @author ASUS
 */
public class khuyenmaiBUS {

    public static ArrayList<khuyenmaiDTO> kmList;

    public void dskm() throws Exception {
        khuyenmaiDAL km = new khuyenmaiDAL();
        if (kmList == null) {
            kmList = new ArrayList<>();
        }
        kmList = km.findall();
    }

    public boolean insert(khuyenmaiDTO km) throws Exception {
        if (km.getMa_km().equalsIgnoreCase("") || km.getNoidung().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Đủ thông tin !!");
            return false;
        }
        khuyenmaiDAL kmdal = new khuyenmaiDAL();
        kmdal.insert(km);

        return true;
    }

    public boolean update(khuyenmaiDTO km) throws Exception {
        if (km.getMa_km().equalsIgnoreCase("") || km.getNoidung().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Đủ thông tin !!");
            return false;
        }
        khuyenmaiDAL kmdal = new khuyenmaiDAL();
        kmdal.update(km);
        return true;
    }

    public boolean delete(int id) throws Exception {
        if (id < 0) {
            JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Nội Dung cần Xóa !!");
            return false;
        }
        khuyenmaiDAL kmdal = new khuyenmaiDAL();
        kmdal.delete(id);
        return true;
    }

}
