/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.GUI;

import BUS.chitiethoadonBUS;
import static BUS.chitiethoadonBUS.cthdList;
import BUS.hoadonBUS;
import static BUS.hoadonBUS.hdList;
import QLKS.DTO.chitiethoadonDTO;
import QLKS.DTO.hoadonDTO;
import Report.ExcelReport;
import Report.ReportPDF;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Quan_Li_Hoa_Don {

    DefaultTableModel tablemodel;
    DefaultTableModel tablemodel1;

    public Quan_Li_Hoa_Don(JPanel p) throws Exception {
        init(p);
        tablemodel = (DefaultTableModel) tb.getModel();
        tablemodel1 = (DefaultTableModel) tb1.getModel();
        showtable();
        eventTable();
    }

    public void showtable() throws Exception {
//        ArrayList<hoadonDTO> hdList = hoadonDAL.findall();
        hoadonBUS hd = new hoadonBUS();
        hd.dshd();
        tablemodel.setRowCount(0);
        for (int i = 0; i < hdList.size(); i++) {
            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hdList.get(i).getMa_hd(), hdList.get(i).getMa_kh(), hdList.get(i).getMa_khuyen_mai(), hdList.get(i).getMa_nv(), hdList.get(i).getNgaylap(), hdList.get(i).getTongtien(), hdList.get(i).getTien_khuyen_mai(), hdList.get(i).getThienthuc()});
        }
    }

    private void eventTable() {
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    chitiethoadonBUS cthd = new chitiethoadonBUS();
                    cthd.dscthd();
                    int selectedIndex = tb.getSelectedRow();
                    hd = new hoadonDTO();
                    hd = hdList.get(selectedIndex);
//                    ArrayList<hoadonDTO> hdList = hoadonDAL.findall();
                    hoadonBUS hd = new hoadonBUS();
                    hd.dshd();
                    for (int i = 0; i < cthdList.size(); i++) {
                        if (cthdList.get(i).getMa_hd() == hdList.get(selectedIndex).getMa_hd()) {
                            tablemodel1.setRowCount(0);
                            tablemodel1.addRow(new Object[]{tablemodel1.getRowCount() + 1, cthdList.get(i).getMa_hd(), cthdList.get(i).getMa_phong(), cthdList.get(i).getTien_phong(), cthdList.get(i).getTong_ngay_o(), cthdList.get(i).getMa_dv(), cthdList.get(i).getTien_dich_vu(), cthdList.get(i).getThanh_tien(), cthdList.get(i).getTien_khuyen_mai()});
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Hoa_Don.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void init(JPanel p) {
        p.setLayout(new BorderLayout(0, 0));
        p_top_hoadon = new JPanel();
        p_top_hoadon.setPreferredSize(new Dimension(1200, 100));
        p_top_hoadon.setLayout(null);
        p_top_hoadon.setBackground(new Color(102, 217, 255));

        l_title_hoadon = new JLabel("Quản Lí Hóa Đơn");
        l_title_hoadon.setFont(new Font("", Font.CENTER_BASELINE, 22));
        l_title_hoadon.setBounds(475, 10, 250, 25);
        p_top_hoadon.add(l_title_hoadon);

        btn_timkiem = new JButton("Tìm Kiếm");
        btn_timkiem.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_timkiem.setBackground(new Color(0, 164, 128));
        btn_timkiem.setBounds(30, 50, 120, 40);
        p_top_hoadon.add(btn_timkiem);

        btnin = new JButton("IN");
        btnin.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btnin.setBackground(new Color(0, 164, 128));
        btnin.setBounds(170, 50, 120, 40);
        p_top_hoadon.add(btnin);

//        l_ngaynhan = new JLabel("Ngày Nhận :");
//        l_ngaynhan.setBounds(155, 50, 100, 40);
//        p_top_hoadon.add(l_ngaynhan);
//        jDateChooser1 = new JDateChooser();
//        jDateChooser1.setDateFormatString("dd-mm-yyyy");
//        jDateChooser1.setBounds(230, 55, 150, 30);
//        jDateChooser1.setLocale(Locale.forLanguageTag("vi-VN"));
//        p_top_hoadon.add(jDateChooser1);
        l_ngaytra = new JLabel("Ngày lập hóa đơn :");
        l_ngaytra.setBounds(345, 50, 150, 40);
        p_top_hoadon.add(l_ngaytra);

        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser2.setDateFormatString("dd-mm-yyyy");
        jDateChooser2.setBounds(460, 55, 150, 30);
        jDateChooser2.setLocale(Locale.forLanguageTag("vi-VN"));
        p_top_hoadon.add(jDateChooser2);

//       jDateChooser2.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                try {
//                    jDateChooser2(e);
//                } catch (Exception ex) {
//                    Logger.getLogger(Quan_Li_Hoa_Don.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
        addMouseListenerRecrusively(jDateChooser2);
        l_ma = new JLabel("Mã(Ma_HD-MaKH-MaNV) :");
        l_ma.setBounds(620, 50, 150, 40);
        p_top_hoadon.add(l_ma);

        txtma = new JTextField();
        txtma.setBounds(775, 55, 120, 30);
        p_top_hoadon.add(txtma);
        txtma.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    txtma(e);
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Hoa_Don.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        l_tongtien = new JLabel("Tổng tiền :");
        l_tongtien.setBounds(900, 50, 100, 40);
        p_top_hoadon.add(l_tongtien);

        rd_thap = new JRadioButton("Thấp");
        rd_thap.setBackground(new Color(102, 217, 255));
        rd_thap.setBounds(965, 55, 55, 30);
        p_top_hoadon.add(rd_thap);

        rd_cao = new JRadioButton("Cao");
        rd_cao.setBackground(new Color(102, 217, 255));
        rd_cao.setBounds(1020, 55, 50, 30);
        p_top_hoadon.add(rd_cao);

        btngroup = new ButtonGroup();
        btngroup.add(rd_cao);
        btngroup.add(rd_thap);

        txttongtien = new JTextField();
        txttongtien.setBounds(1070, 55, 100, 30);
        p_top_hoadon.add(txttongtien);

        txttongtien.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    txttongtien(e);
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Hoa_Don.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        pmain = new JPanel();
        pmain.setPreferredSize(new Dimension(1200, 470));
        pmain.setBackground(Color.PINK);
        pmain.setLayout(new BorderLayout(0, 0));

        phoadon = new JPanel();
        phoadon.setPreferredSize(new Dimension(1200, 320));
        phoadon.setBackground(Color.ORANGE);
        phoadon.setLayout(new BorderLayout(0, 0));
        pmain.add(phoadon, BorderLayout.NORTH);

        pcthoadon = new JPanel();
        pcthoadon.setPreferredSize(new Dimension(1200, 150));
        pcthoadon.setBackground(Color.YELLOW);
        pcthoadon.setLayout(new BorderLayout(0, 0));
        pmain.add(pcthoadon, BorderLayout.SOUTH);

        String[][] data = {
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null}
//            {"1", "123456789", "123", "456", "2-2-2021", "10-2-2021", "10000", ""},
        };
        String[] title_table = {"STT", "MaHD", "MaKH", "MaKM", "MaNv", "Ngày lập", "Tổng tiền", "Tiền kM", "Tiền thực"};

        tb = new JTable();
        tb.setModel(new javax.swing.table.DefaultTableModel(data, title_table) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
//        tb.setBounds(10, 110, 1180, 350);
        tb.getColumnModel().getColumn(0).setPreferredWidth(50);
        tb.getColumnModel().getColumn(1).setPreferredWidth(150);
        tb.getColumnModel().getColumn(2).setPreferredWidth(150);
        tb.getColumnModel().getColumn(3).setPreferredWidth(150);
        tb.getColumnModel().getColumn(4).setPreferredWidth(150);
        tb.getColumnModel().getColumn(5).setPreferredWidth(150);
        tb.getColumnModel().getColumn(6).setPreferredWidth(200);
        tb.getColumnModel().getColumn(7).setPreferredWidth(300);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < 7; i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        s = new JScrollPane();
        s.setViewportView(tb);

        phoadon.add(s);

        String[][] data1 = {
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null}, //            {"1","2","A304","120000","15","DV1","120000","120000","3222"}
        };
        String[] title_data1 = {"STT", "MaHD", "MaPhong", "Giá phòng", "Số ngày ở", "MaDv", "Giá dịch vụ", "Thành tiền", "Tiền khuyến mãi"};
        tb1 = new JTable();
        tb1.setModel(new javax.swing.table.DefaultTableModel(data1, title_data1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        s1 = new JScrollPane();
        s1.setViewportView(tb1);
        pcthoadon.add(s1);
        Chitiethoadon = new JPanel();
        Chitiethoadon.setPreferredSize(new Dimension(1080, 30));
        lcthd = new JLabel("Chi ciết hóa đơn");
        lcthd.setHorizontalAlignment(JLabel.CENTER);
        lcthd.setVerticalAlignment(JLabel.CENTER);
        Chitiethoadon.add(lcthd);
        pcthoadon.add(Chitiethoadon, BorderLayout.NORTH);

        p.add(p_top_hoadon, BorderLayout.NORTH);
        p.add(pmain, BorderLayout.SOUTH);

        btnin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                tablemodel1 = (DefaultTableModel) tb1.getModel();
                if (tablemodel1.getRowCount() == 6) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đon cần in !!");
                } else {
                    try {
                        ReportPDF pdf = new ReportPDF(hd.getMa_hd());
                    } catch (Exception ex) {
                        Logger.getLogger(Quan_Li_Hoa_Don.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    private void txtma(KeyEvent e) throws Exception {

        hoadonBUS hd = new hoadonBUS();
        hd.dshd();
        tablemodel = (DefaultTableModel) tb.getModel();
        tablemodel.setRowCount(0);
        for (hoadonDTO hd1 : hd.hdList) {
            if (txtma.getText().equalsIgnoreCase("")) {
                showtable();
            } else {
                if (hd1.getMa_hd() == Integer.valueOf(txtma.getText()) || hd1.getMa_kh().contains(txtma.getText()) || hd1.getMa_kh().contains(txtma.getText())) {
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd1.getMa_hd(), hd1.getMa_kh(), hd1.getMa_khuyen_mai(), hd1.getMa_nv(), hd1.getNgaylap(), hd1.getTongtien(), hd1.getTien_khuyen_mai(), hd1.getThienthuc()});
                }
            }
        }
    }

    private void txttongtien(KeyEvent e) throws Exception {

        hoadonBUS hd = new hoadonBUS();
        hd.dshd();
        tablemodel = (DefaultTableModel) tb.getModel();
        tablemodel.setRowCount(0);
        for (hoadonDTO hd1 : hd.hdList) {

            if (rd_cao.isSelected() == false && rd_thap.isSelected() == false) {
                if (txttongtien.getText().equalsIgnoreCase("")) {
                    showtable();
                } else {
                    if (hd1.getTongtien() == Double.valueOf(txttongtien.getText())) {
                        tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd1.getMa_hd(), hd1.getMa_kh(), hd1.getMa_khuyen_mai(), hd1.getMa_nv(), hd1.getNgaylap(), hd1.getTongtien(), hd1.getTien_khuyen_mai(), hd1.getThienthuc()});
                    }
                }

            }
            if (rd_cao.isSelected() == true) {
                if (txttongtien.getText().equalsIgnoreCase("")) {
                    showtable();
                } else {
                    if (hd1.getTongtien() >= Double.valueOf(txttongtien.getText())) {
                        tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd1.getMa_hd(), hd1.getMa_kh(), hd1.getMa_khuyen_mai(), hd1.getMa_nv(), hd1.getNgaylap(), hd1.getTongtien(), hd1.getTien_khuyen_mai(), hd1.getThienthuc()});
                    }
                }
            }
            if (rd_thap.isSelected() == true) {
                if (txttongtien.getText().equalsIgnoreCase("")) {
                    showtable();
                } else {
                    if (hd1.getTongtien() <= Double.valueOf(txttongtien.getText())) {
                        tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd1.getMa_hd(), hd1.getMa_kh(), hd1.getMa_khuyen_mai(), hd1.getMa_nv(), hd1.getNgaylap(), hd1.getTongtien(), hd1.getTien_khuyen_mai(), hd1.getThienthuc()});
                    }
                }
            }
        }
    }

    JPanel p_top_hoadon;
    JLabel l_title_hoadon;
//JLabel l_ngaynhan;
    JButton btn_timkiem;
    JLabel l_ngaytra;
    JLabel l_ma;
    JLabel l_tongtien;
    ButtonGroup btngroup;
    JTextField txtma;
    JRadioButton rd_thap;
    JRadioButton rd_cao;
//JDateChooser jDateChooser1;
    JDateChooser jDateChooser2;
    JTextField txttongtien;
    JTable tb;
    JTable tb1;
    JScrollPane s;
    JScrollPane s1;
    JPanel pmain;
    JPanel phoadon;
    JPanel pcthoadon;
    JPanel Chitiethoadon;
    JLabel lcthd;
    JButton btnin;
    DateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
    hoadonDTO hd;

    private void addMouseListenerRecrusively(Container container) {

        for (Component component : container.getComponents()) {
            if (component instanceof Container) {
                addMouseListenerRecrusively((Container) component);
            }
        }

        container.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String date = formatter1.format(jDateChooser2.getDate());
                hoadonBUS hd = new hoadonBUS();
                try {
                    hd.dshd();
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Hoa_Don.class.getName()).log(Level.SEVERE, null, ex);
                }
                tablemodel = (DefaultTableModel) tb.getModel();
                tablemodel.setRowCount(0);
                for (hoadonDTO hd1 : hd.hdList) {
                    if (hd1.getNgaylap().equalsIgnoreCase(date)) {
                        tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd1.getMa_hd(), hd1.getMa_kh(), hd1.getMa_khuyen_mai(), hd1.getMa_nv(), hd1.getNgaylap(), hd1.getTongtien(), hd1.getTien_khuyen_mai(), hd1.getThienthuc()});

                    }
                }
            }
        });

    }
}
