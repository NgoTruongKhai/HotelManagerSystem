/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import QLKS.DAL.phieunhaphangDAL;
import QLKS.DTO.phieunhapDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class phieunhaphangBUS {

    public static ArrayList<phieunhapDTO> pnList;

    public phieunhaphangBUS() {

    }

    public boolean insert(phieunhapDTO pn) throws Exception {
        phieunhaphangDAL pnbus = new phieunhaphangDAL();
        if (pn.getTenMH().equalsIgnoreCase("") || pn.getNcc().equalsIgnoreCase("") || pn.getMaMH().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Vui long nhập đầy đủ thongin");
            return false;
        }
        pnbus.insert(pn);
        return true;
    }

    public void dspn() throws Exception {
        phieunhaphangDAL pn = new phieunhaphangDAL();
        if (pnList == null) {
            pnList = new ArrayList<>();
        }
        pnList = pn.findall();
    }

    public boolean update(phieunhapDTO pn) throws Exception {
        phieunhaphangDAL pnbus = new phieunhaphangDAL();
        if (pn.getTenMH().equalsIgnoreCase("") || pn.getNcc().equalsIgnoreCase("") || pn.getMaMH().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Vui long nhập đầy đủ thongin");
            return false;
        }
        pnbus.insert(pn);
        return true;
    }

    public boolean delete(int x) throws Exception {
        phieunhaphangDAL pnbus = new phieunhaphangDAL();
        if (x <= 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu cần xóa !!");
            return false;
        }
        pnbus.delete(x);
        return true;
    }

}
