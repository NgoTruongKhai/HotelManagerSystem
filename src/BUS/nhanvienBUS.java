/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import QLKS.DAL.nhanvienDAL;
import QLKS.DTO.nhanvienDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class nhanvienBUS {

    public static ArrayList<nhanvienDTO> nvList;

    public void dsnv() throws Exception {
        nhanvienDAL nv = new nhanvienDAL();
        if (nvList == null) {
            nvList = new ArrayList<>();
        }
        nvList = nv.findall();
    }

    public String newma_nv() throws Exception {
        String ma_nv = null;
        nhanvienBUS nv = new nhanvienBUS();
        if (nv.nvList == null) {
            nv.dsnv();
        }
        int index = nv.nvList.size() - 1;
        int x = Integer.valueOf(nvList.get(index).getMa_nv());
        x++;
        ma_nv = String.valueOf(x);
        return ma_nv;
    }

    public boolean insert(nhanvienDTO nv) throws Exception {
        if (nv.getDiachi().equalsIgnoreCase("") || nv.getHo().equalsIgnoreCase("") || nv.getSdt().equalsIgnoreCase("") || nv.getTen().equalsIgnoreCase("") || nv.getGioitinh().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thong tin !!");
            return false;
        }
        nhanvienDAL nvdal = new nhanvienDAL();
        nvdal.insert(nv);
        return true;
    }

    public boolean update(nhanvienDTO nv) throws Exception {

        if (nv.getDiachi().equalsIgnoreCase("") || nv.getHo().equalsIgnoreCase("") || nv.getSdt().equalsIgnoreCase("") || nv.getTen().equalsIgnoreCase("") || nv.getGioitinh().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thong tin !!");
            return false;
        }
        nhanvienDAL nvdal = new nhanvienDAL();
        nvdal.update(nv);
        return true;
    }

    public boolean delete(int id) throws Exception {
        if (id < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần xóa!!");
            return false;
        }
        nhanvienDAL nvdal = new nhanvienDAL();
        nvdal.delete(id);
        return true;
    }

}
