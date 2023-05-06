/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.GUI;

import BUS.khachhangBUS;
import static BUS.khachhangBUS.khList;
import QLKS.DTO.khachhangDTO;
import Report.ExcelReport;
import Report.importExel;
//import Report.importexel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public final class Quan_Li_Khach_Hang extends JFrame {

    DefaultTableModel tablemodel;
    JTable tb = new JTable();
    thongtin tt = new thongtin();
    String temp;

    public Quan_Li_Khach_Hang(JPanel p) throws Exception {
        init(p);
        tablemodel = (DefaultTableModel) tb.getModel();
        showtable();
        eventTable();
    }

    private void eventTable() {
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    khachhangBUS khbus = new khachhangBUS();
                    khbus.dskh();
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Khach_Hang.class.getName()).log(Level.SEVERE, null, ex);
                }
                int selectedIndex = tb.getSelectedRow();

                khachhangDTO kh = khList.get(selectedIndex);

                tt.setTxtcmnd(kh.ma_kh);
                tt.setTxtho(kh.ho);
                tt.setTxtten(kh.ten);
                tt.setTxtdiachi(kh.diachi);
                tt.setTxtdienthoai(kh.sdt);
                if (kh.gioitinh.equalsIgnoreCase("Nam")) {
                    tt.setRdnam(kh.gioitinh);
                }
                if (kh.gioitinh.equalsIgnoreCase("Nữ")) {
                    tt.setRdnu(kh.gioitinh);
                }
                if (kh.gioitinh.equalsIgnoreCase("Khác")) {
                    tt.setRdkhac(kh.gioitinh);
                }
                temp = kh.ma_kh;
                tt.gettxt();
            }

        });
    }

    public void showtable() throws Exception {
        khachhangBUS khbus = new khachhangBUS();
        khbus.dskh();
        tablemodel.setRowCount(0);
        for (int i = 0; i < khList.size(); i++) {
            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, khList.get(i).getMa_kh(), khList.get(i).getHo() + " " + khList.get(i).getTen(), khList.get(i).getGioitinh(), khList.get(i).getNgaysinh(), khList.get(i).getSdt(), khList.get(i).getDiachi()});
        }

    }

    public void init(JPanel p) {

        p.setLayout(new BorderLayout(0, 0));

        p_top_qlkh = new JPanel();
        p_top_qlkh.setPreferredSize(new Dimension(1200, 100));
        p_top_qlkh.setBackground(new Color(102, 217, 255));
        p_top_qlkh.setLayout(null);

        l_title_qlkh = new JLabel("Quản Lí khách hàng");
        l_title_qlkh.setFont(new Font("", Font.CENTER_BASELINE, 22));
        l_title_qlkh.setBounds(475, 10, 250, 25);
        p_top_qlkh.add(l_title_qlkh);

//        ImageIcon icon_them=new ImageIcon("src/img/them.png");
        btn_them = new JButton();
//        btn_them.setIcon(icon_them);
//        btn_them.setIconTextGap(2);
        btn_them.setText("Thêm");
        btn_them.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_them.setBackground(new Color(0, 164, 128));
        btn_them.setBounds(50, 50, 140, 40);
        p_top_qlkh.add(btn_them);

//        ImageIcon icon_sua=new ImageIcon("src/img/chinhsua.png");
        btn_sua = new JButton();
//        btn_sua.setIcon(icon_sua);
//        btn_sua.setIconTextGap(2);
        btn_sua.setText("Sửa");
        btn_sua.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_sua.setBackground(new Color(0, 164, 128));
        btn_sua.setBounds(200, 50, 140, 40);
        p_top_qlkh.add(btn_sua);

//        ImageIcon icon_xoa=new ImageIcon("src/img/xoa.png");
        btn_xoa = new JButton();
//        btn_xoa.setIcon(icon_them);
//        btn_xoa.setIconTextGap(2);
        btn_xoa.setText("Xóa");
        btn_xoa.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_xoa.setBackground(new Color(0, 164, 128));
        btn_xoa.setBounds(350, 50, 140, 40);
        p_top_qlkh.add(btn_xoa);

        btn_reset = new JButton();
        btn_reset.setText("reset");
        btn_reset.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_reset.setBackground(new Color(0, 164, 128));
        btn_reset.setBounds(500, 50, 140, 40);
        p_top_qlkh.add(btn_reset);

        txttimkiem = new JTextField();
        txttimkiem.setBounds(650, 55, 200, 30);
        p_top_qlkh.add(txttimkiem);

        btn_timkiem = new JButton();
//        btn_xoa.setIcon(icon_them);
//        btn_xoa.setIconTextGap(2);
        btn_timkiem.setText("Tìm kiếm");
        btn_timkiem.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_timkiem.setBackground(new Color(0, 164, 128));
        btn_timkiem.setBounds(850, 55, 130, 30);
        p_top_qlkh.add(btn_timkiem);

        btn_in = new JButton("Export ");
        btn_in.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_in.setBackground(new Color(0, 164, 128));
        btn_in.setBounds(990, 55, 100, 30);
        p_top_qlkh.add(btn_in);

        btnimport = new JButton("Import");
        btnimport.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btnimport.setBackground(new Color(0, 164, 128));
        btnimport.setBounds(1100, 55, 100, 30);
        p_top_qlkh.add(btnimport);

        btnimport.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                importExel exel = new importExel();
                try {
                    exel.importkh();
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Khach_Hang.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    showtable();
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Khach_Hang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btn_in.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ExcelReport exel = new ExcelReport();

                exel.ExportExcel("DSkhachhang", tb);
            }
        });

//        JLabel l_ngaysinh=new JLabel("Ngày sinh:");
//        l_ngaysinh.setFont(new Font("", Font.CENTER_BASELINE, 18));
//        l_ngaysinh.setBackground(new Color(0, 164, 128));
//        l_ngaysinh.setBounds(915, 55, 130, 30);
//        p_thongtin.add(l_ngaysinh);
        String[][] data = {
            {null, null, null, null, null, null}, //            {"2","12","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"3","123","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"4","1234","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"5","12345","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"6","123456","Ngô Trường Khải","Nữ","??-??-????","***********","HCM"},
        //            {"7","1234567","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"8","12345678","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"9","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"10","16789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"11","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"12","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"13","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"14","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"15","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"16","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"17","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"18","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"19","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"20","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"21","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"22","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"23","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"24","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"25","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"26","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"27","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"28","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"28","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"30","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        //            {"31","123456789","Ngô Trường Khải","Nam","??-??-????","***********","HCM"},
        };
        String[] title_table = {"STT", "CMND", "HỌ và Tên", "GIỚI TÍNH", "NGÀY SINH", "SỐ ĐIỆN THOẠI", "ĐỊA CHỈ"};
        tb.setModel(new javax.swing.table.DefaultTableModel(data, title_table) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

//        for(int i=0;i<31;i++){
//            khachhangDTO kh=new khachhangDTO();
//            kh.ma_kh=(String) tb.getModel().getValueAt(i,1);
//            kh.ho=(String) tb.getModel().getValueAt(i,2);
//            kh.gioitinh=(String) tb.getModel().getValueAt(i,3);
////            kh.ngaysinh=  (Date) tb.getModel().getValueAt(i,4);
//            kh.sdt=(String) tb.getModel().getValueAt(i,5);
//            kh.diachi=(String) tb.getModel().getValueAt(i,6);            
//            
//            khList.add(kh);
//            
//        }
        tb.setBounds(10, 110, 1180, 450);
        tb.getColumnModel().getColumn(0).setPreferredWidth(40);
        tb.getColumnModel().getColumn(1).setPreferredWidth(150);
        tb.getColumnModel().getColumn(2).setPreferredWidth(200);
        tb.getColumnModel().getColumn(3).setPreferredWidth(80);
        tb.getColumnModel().getColumn(4).setPreferredWidth(100);
        tb.getColumnModel().getColumn(5).setPreferredWidth(150);
        tb.getColumnModel().getColumn(6).setPreferredWidth(500);

        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < 6; i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        s = new JScrollPane();
        s.setViewportView(tb);

        p.add(s);
        p.add(p_top_qlkh, BorderLayout.NORTH);

        btn_them.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                them(e);
            }

        });
        btn_sua.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                sua(e);
            }

        });

        btn_xoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xoa(e);
            }

        });

        btn_reset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset(e);
            }

        });
        btn_timkiem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String a = txttimkiem.getText();
                try {
                    timkiem(a);
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Khach_Hang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        txttimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                try {
                    txttimkiem(evt);
                } catch (Exception ex) {
                    Logger.getLogger(phieu_dang_ki.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void timkiem(String txttiemkiem) throws Exception {
        khachhangBUS khbus = new khachhangBUS();
        khbus.dskh();
        tablemodel = (DefaultTableModel) tb.getModel();
        tablemodel.setRowCount(0);
        for (int i = 0; i < khList.size(); i++) {
            if (khList.get(i).getMa_kh().contains(txttiemkiem) || khList.get(i).getHo().contains(txttiemkiem) || khList.get(i).getTen().contains(txttiemkiem) || khList.get(i).getSdt().contains(txttiemkiem) || khList.get(i).getDiachi().contains(txttiemkiem) || khList.get(i).getNgaysinh().contains(txttiemkiem)) {
                khachhangDTO kh = khList.get(i);
                tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, kh.getMa_kh(), kh.getHo() + " " + kh.getTen(), kh.getGioitinh(), kh.getNgaysinh(), kh.getSdt(), kh.getDiachi()});

            }
        }
    }

    private void txttimkiem(KeyEvent evt) throws Exception {
        khachhangBUS khbus = new khachhangBUS();
        khbus.dskh();
        tablemodel = (DefaultTableModel) tb.getModel();
        tablemodel.setRowCount(0);
        for (int i = 0; i < khList.size(); i++) {
            if (khList.get(i).getMa_kh().contains(txttimkiem.getText()) || khList.get(i).getHo().contains(txttimkiem.getText()) || khList.get(i).getTen().contains(txttimkiem.getText()) || khList.get(i).getSdt().contains(txttimkiem.getText()) || khList.get(i).getDiachi().contains(txttimkiem.getText()) || khList.get(i).getNgaysinh().contains(txttimkiem.getText())) {
                khachhangDTO kh = khList.get(i);
                tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, kh.getMa_kh(), kh.getHo() + " " + kh.getTen(), kh.getGioitinh(), kh.getNgaysinh(), kh.getSdt(), kh.getDiachi()});

            }
        }
    }

    private void them(MouseEvent e) {
        tt.setVisible(true);
        tt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tt.setbtnluu("Thêm");
        tt.reset();
    }

    private void sua(MouseEvent e) {
        tt.setVisible(true);
        tt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tt.setbtnluu("Lưu");
    }

    private void xoa(MouseEvent e) {
        try {
            khachhangBUS khbus = new khachhangBUS();
            if (khbus.delete(temp) == true) {
                JOptionPane.showMessageDialog(null, "Xóa thàng công !!");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa không thàng công !!");
            }

        } catch (Exception ex) {
            Logger.getLogger(Quan_Li_Khach_Hang.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            showtable();
        } catch (Exception ex) {
            Logger.getLogger(Quan_Li_Khach_Hang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void reset(MouseEvent e) {
        try {
            showtable();
        } catch (Exception ex) {
            Logger.getLogger(Quan_Li_Khach_Hang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    JPanel p_top_qlkh;
    JLabel l_title_qlkh;
    JButton btn_them;
    JButton btn_sua;
    JButton btn_in;
    JButton btn_reset;
    JButton btn_xoa;
    JTextField txttimkiem;
    JButton btn_timkiem;
    JScrollPane s;
    JButton btnimport;
    DefaultTableCellRenderer centerRenderer;
}
