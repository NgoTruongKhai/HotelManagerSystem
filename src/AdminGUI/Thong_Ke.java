/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminGUI;

import BUS.hoadonBUS;
import BUS.khachhangBUS;
import BUS.nhanvienBUS;
import BUS.phieunhaphangBUS;
import QLKS.DTO.hoadonDTO;
import QLKS.DTO.khachhangDTO;
import QLKS.DTO.nhanvienDTO;
import QLKS.DTO.phieunhapDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public final class Thong_Ke extends JPanel {

    private javax.swing.JPanel cardpanel;
    CardLayout cardLayout;

    public Thong_Ke() throws Exception {
        init();
        cardLayout = (CardLayout) (cardpanel.getLayout());
        showtbnv();
        setltong();
    }

    public void init() {
        this.setLayout(new BorderLayout(0, 0));
        this.setSize(1200, 570);

        ptop = new JPanel();
        ptop.setPreferredSize(new Dimension(1200, 270));
        ptop.setBackground(new Color(102, 217, 255));
        ptop.setLayout(null);

        pmain = new JPanel();
        pmain.setPreferredSize(new Dimension(1200, 300));
//        pmain.setBackground(Color.GREEN);
        ltitle = new JLabel("Thống kê");
        ltitle.setBounds(550, 5, 100, 40);
        ltitle.setFont(new Font("", Font.BOLD, 20));
        ptop.add(ltitle);

        ptknv = new JPanel();
        ptknv.setBounds(50, 50, 200, 200);
        ptknv.setBackground(new Color(0, 172, 230));
        ptknv.setLayout(null);
        ptop.add(ptknv);
        ptknv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ptknv(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        pmain.setLayout(new BoxLayout(pmain, BoxLayout.X_AXIS));
        ptkdt = new JPanel();
        ptkdt.setBounds(260, 50, 200, 200);
        ptkdt.setBackground(new Color(0, 172, 230));
        ptkdt.setLayout(null);
        ptop.add(ptkdt);
        ptkdt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ptkdt(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        ptkkh = new JPanel();
        ptkkh.setBounds(470, 50, 200, 200);
        ptkkh.setBackground(new Color(0, 172, 230));
        ptkkh.setLayout(null);
        ptkkh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ptkkh(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        ptkchi = new JPanel();
        ptkchi.setBounds(680, 50, 200, 200);
        ptkchi.setBackground(new Color(0, 172, 230));
        ptkchi.setLayout(null);
        ptop.add(ptkchi);
        ptkchi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ptkchi(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        ltktongdt = new JLabel("Tổng doanh thu");
        ltktongkh = new JLabel("Tổng khách hàng");
        ltktongnv = new JLabel("Tổng nhân viên");
        ltktongchi = new JLabel("Tổng chi");

        ltongdt = new JLabel();
        ltongkh = new JLabel();
        ltongnv = new JLabel();
        ltongchi = new JLabel();

        ltktongdt.setBounds(25, 0, 150, 30);
        ltktongkh.setBounds(15, 0, 160, 30);
        ltktongnv.setBounds(25, 0, 150, 30);
        ltktongchi.setBounds(25, 0, 150, 30);

        ltongdt.setBounds(10, 160, 190, 40);
        ltongkh.setBounds(10, 160, 190, 40);
        ltongnv.setBounds(10, 160, 190, 40);
        ltongchi.setBounds(10, 160, 190, 40);

        ltktongdt.setFont(new Font("", Font.BOLD, 18));
        ltktongkh.setFont(new Font("", Font.BOLD, 18));
        ltktongnv.setFont(new Font("", Font.BOLD, 18));
        ltktongchi.setFont(new Font("", Font.BOLD, 18));

        ltongdt.setFont(new Font("", Font.BOLD, 16));
        ltongkh.setFont(new Font("", Font.BOLD, 16));
        ltongnv.setFont(new Font("", Font.BOLD, 16));
        ltongchi.setFont(new Font("", Font.BOLD, 16));

        ptkdt.add(ltktongdt);
        ptkkh.add(ltktongkh);
        ptknv.add(ltktongnv);
        ptkchi.add(ltktongchi);

        ptkdt.add(ltongdt);
        ptkkh.add(ltongkh);
        ptknv.add(ltongnv);
        ptkchi.add(ltongchi);

        ptop.add(ptkkh);
        cardpanel = new javax.swing.JPanel();
        cardpanel.setName("");
        cardpanel.setLayout(new java.awt.CardLayout());

        p3 = new JPanel();
        p3.setPreferredSize(new Dimension(1200, 300));
        p3.setLayout(new BorderLayout(0, 0));
//        p3.setBackground(Color.BLUE);

        cardpanel.add(p3, "cart");
        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(1200, 300));
        p1.setLayout(new BorderLayout(0, 0));
//        p1.setBackground(Color.CYAN);
        cardpanel.add(p1, "cart1");

        p2 = new JPanel();
        p2.setPreferredSize(new Dimension(1200, 300));
        p2.setLayout(new BorderLayout(0, 0));
//        p2.setBackground(Color.GREEN);
        cardpanel.add(p2, "cart2");

        p4 = new JPanel();
        p4.setPreferredSize(new Dimension(1200, 300));
        p4.setLayout(new BorderLayout(0, 0));
//        p4.setBackground(Color.GREEN);
        cardpanel.add(p4, "cart3");

//        p2.add(s2);
//        s.setViewportView(tbnv);
//        pmain.add(s);
//         s1=new JScrollPane();
//        s1.setViewportView(tbdt);
//        pmain.add(s1);
//         s2=new JScrollPane();
//        s2.setViewportView(tbkh);
//        pmain.add(s2);
//        
        String[][] datanv = {
            {null, null, null, null, null}, null};
        String[] title_tablenv = {"STT", "MaNV", "Họ và Tên", "Số điện thoại", "Lương", "chức vụ"};
        tbnv = new JTable();
        tbnv.setPreferredScrollableViewportSize(new Dimension(1200, 300));
        tbnv.setModel(new javax.swing.table.DefaultTableModel(datanv, title_tablenv) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        s = new JScrollPane();
        s.setViewportView(tbnv);
        p3.add(s);

        String[][] datadt = {
            {null, null, null, null, null, null},};
        String[] title_tabledt = {"STT", "MaHD", "MaNV", "MaKH", "ngày lập", "Tổng tiền"};
        tbdt = new JTable();
        tbdt.setPreferredScrollableViewportSize(new Dimension(1200, 300));
        tbdt.setModel(new javax.swing.table.DefaultTableModel(datadt, title_tabledt) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        s1 = new JScrollPane();
        s1.setViewportView(tbdt);
        p1.add(s1);

        String[][] datakh = {
            {null, null, null, null, null},};
        String[] title_tablekh = {"STT", "MaKh", "Họ và Tên", "Số điện thoại", "Tổng tiền"};
        tbkh = new JTable();
        tbkh.setPreferredScrollableViewportSize(new Dimension(1200, 300));
        tbkh.setModel(new javax.swing.table.DefaultTableModel(datakh, title_tablekh) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        s2 = new JScrollPane();
        s2.setViewportView(tbkh);
        p2.add(s2);

        String[][] datachi = {
            {null, null, null, null, null, null, null},};
        String[] title_tablechi = {"STT", "MAhang", "Tên mặt hàng", "Đơn giá", "Số lượng", "Nhà cung cấp", "Tổng tiền"};
        tbchi = new JTable();
        tbchi.setPreferredScrollableViewportSize(new Dimension(1200, 300));
        tbchi.setModel(new javax.swing.table.DefaultTableModel(datachi, title_tablechi) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        s3 = new JScrollPane();
        s3.setViewportView(tbchi);
        p4.add(s3);

        pmain.add(cardpanel);

        this.add(ptop, BorderLayout.NORTH);
        this.add(pmain, BorderLayout.SOUTH);

        ptimkiemnangcao = new JPanel();
        ptimkiemnangcao.setBounds(890, 50, 300, 200);
        ptimkiemnangcao.setBackground(new Color(102, 217, 255));
        ptimkiemnangcao.setLayout(null);
        ptop.add(ptimkiemnangcao);

        txttiemkiem = new JTextField();
        txttiemkiem.setBounds(0, 50, 200, 30);
        ptimkiemnangcao.add(txttiemkiem);

        DefaultComboBoxModel cityName = new DefaultComboBoxModel();
        cityName.addElement("MãNV");
        cityName.addElement("TênNV");
        cityName.addElement("SDT");
        cb = new JComboBox(cityName);
        cb.setBounds(210, 50, 90, 30);
        ptimkiemnangcao.add(cb);

        txtluong = new JTextField();
        txtluong.setBounds(0, 90, 200, 30);
        ptimkiemnangcao.add(txtluong);

        DefaultComboBoxModel cityName1 = new DefaultComboBoxModel();
        cityName1.addElement("Thấp hơn");
        cityName1.addElement("Cao hơn");
        cityName1.addElement("Bằng");

        cbluong = new JComboBox(cityName1);
        cbluong.setBounds(210, 90, 90, 30);
        ptimkiemnangcao.add(cbluong);

        DefaultComboBoxModel cityName2 = new DefaultComboBoxModel();
        cityName2.addElement("Tạp vụ");
        cityName2.addElement("Bảo vệ");
        cityName2.addElement("Phục vụ");
        cityName2.addElement("Tài xế");
        cityName2.addElement("Thu ngân");

        cbcv = new JComboBox(cityName2);
        cbcv.setBounds(0, 130, 200, 30);

        cbcv.addItemListener(new ItemChangeListener() {
            public void itemStateChanged(ItemEvent arg0) {
                try {
                    cbcv(arg0);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        ptimkiemnangcao.add(cbcv);
        ltimkiem = new JLabel("Tìm Kiếm");
        ltimkiem.setBounds(20, 0, 100, 30);
        ltimkiem.setFont(new Font("", Font.BOLD, 18));
        ptimkiemnangcao.add(ltimkiem);
        txttiemkiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    txttiemkiemnv(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        txtluong.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    txtluongnv(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

    }

    private void ptknv(MouseEvent e) throws Exception {
        ptimkiemnangcao.removeAll();
        ptimkiemnangcao.setBounds(890, 50, 300, 200);
        ptimkiemnangcao.setBackground(new Color(102, 217, 255));
        ptimkiemnangcao.setLayout(null);
        ptimkiemnangcao.add(ltimkiem);
        ptimkiemnangcao.add(cbcv);
        ptimkiemnangcao.add(cbluong);
        ptimkiemnangcao.add(txtluong);
        txttiemkiem = new JTextField();
        txttiemkiem.setBounds(0, 50, 200, 30);
        ptimkiemnangcao.add(txttiemkiem);
        DefaultComboBoxModel cityName = new DefaultComboBoxModel();
        cityName.addElement("MãNV");
        cityName.addElement("TênNV");
        cityName.addElement("SDT");
        cb = new JComboBox(cityName);
        cb.setBounds(210, 50, 90, 30);
        ptimkiemnangcao.add(cb);
        txttiemkiem.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    txttiemkiemnv(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        txtluong.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    txtluongnv(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        cbcv.addItemListener(new ItemChangeListener() {
            public void itemStateChanged(ItemEvent arg0) {
                try {
                    cbcv(arg0);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        ptimkiemnangcao.repaint();
//        pmain.add(s);
        cardLayout.show(cardpanel, "cart");
        showtbnv();
    }

    private void ptkdt(MouseEvent e) throws Exception {
        ptimkiemnangcao.removeAll();
        ptimkiemnangcao.setBounds(890, 50, 300, 200);
        ptimkiemnangcao.setBackground(new Color(102, 217, 255));
        ptimkiemnangcao.setLayout(null);
        txttiemkiem = new JTextField();
        txttiemkiem.setBounds(0, 50, 200, 30);
        ptimkiemnangcao.add(ltimkiem);
        ptimkiemnangcao.add(txttiemkiem);
        ptimkiemnangcao.add(cbluong);

        DefaultComboBoxModel cityName = new DefaultComboBoxModel();
        cityName.addElement("MaHD");
        cityName.addElement("MaNV");
        cityName.addElement("MaKH");
        cb = new JComboBox(cityName);
        cb.setBounds(210, 50, 90, 30);

        ptimkiemnangcao.add(txtluong);
        ptimkiemnangcao.add(cb);
        txtluong.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {

                try {
                    txtluongdt(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        txttiemkiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    txttiemkiemdt(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        jDateChooser1 = new JDateChooser();
        jDateChooser1.setBounds(0, 130, 200, 30);
        jDateChooser1.setDateFormatString("dd-MM-yyyy");
        jDateChooser1.setLocale(Locale.forLanguageTag("vi-VN"));
        ptimkiemnangcao.add(jDateChooser1);
        addMouseListenerRecrusively(jDateChooser1);
        ptimkiemnangcao.repaint();
        cardLayout.show(cardpanel, "cart1");
        showtbdt();
    }

    private void ptkkh(MouseEvent e) throws Exception {
        ptimkiemnangcao.removeAll();
        ptimkiemnangcao.setBounds(890, 50, 300, 200);
        ptimkiemnangcao.setBackground(new Color(102, 217, 255));
        ptimkiemnangcao.setLayout(null);
        txttiemkiem = new JTextField();
        txttiemkiem.setBounds(0, 50, 200, 30);

        txttiemkiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    txttiemkiemkh(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        DefaultComboBoxModel cityName = new DefaultComboBoxModel();
        cityName.addElement("MaKH");
        cityName.addElement("SĐT");
        cityName.addElement("TênKH");
        cb = new JComboBox(cityName);
        cb.setBounds(210, 50, 90, 30);

        ptimkiemnangcao.add(ltimkiem);
        ptimkiemnangcao.add(txttiemkiem);
        ptimkiemnangcao.add(cb);
        ptimkiemnangcao.repaint();
        cardLayout.show(cardpanel, "cart2");
        showtbkh();
    }

    private void ptkchi(MouseEvent e) throws Exception {
        ptimkiemnangcao.removeAll();
        ptimkiemnangcao.setBounds(890, 50, 300, 200);
        ptimkiemnangcao.setBackground(new Color(102, 217, 255));
        ptimkiemnangcao.setLayout(null);
        txttiemkiem = new JTextField();
        txttiemkiem.setBounds(0, 50, 200, 30);
        ptimkiemnangcao.add(ltimkiem);
        ptimkiemnangcao.add(txttiemkiem);
//        ptimkiemnangcao.add(cbluong);
        txttiemkiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    txttiemkiemchi(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void txttiemkiemchi(KeyEvent e) throws Exception {
                phieunhaphangBUS pnbus = new phieunhaphangBUS();
                pnbus.dspn();
                tablemodel = (DefaultTableModel) tbnv.getModel();
                tablemodel.setRowCount(0);
                if (cb.getSelectedItem().equals("Mahang")) {
                    for (phieunhapDTO pn : pnbus.pnList) {
                        if (pn.getMaMH().contains(txttiemkiem.getText())) {
                            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, pn.getMaMH(), pn.getTenMH(), pn.getGia(), pn.getSoluong(), pn.getNcc(), pn.getTongtien()});
                        }
                    }
                }
                if (cb.getSelectedItem().equals("Tên Hàng")) {
                    for (phieunhapDTO pn : pnbus.pnList) {
                        if (pn.getMaMH().contains(txttiemkiem.getText())) {
                            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, pn.getMaMH(), pn.getTenMH(), pn.getGia(), pn.getSoluong(), pn.getNcc(), pn.getTongtien()});
                        }
                    }
                }
                if (cb.getSelectedItem().equals("NCC")) {
                    for (phieunhapDTO pn : pnbus.pnList) {
                        if (pn.getNcc().contains(txttiemkiem.getText())) {
                            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, pn.getMaMH(), pn.getTenMH(), pn.getGia(), pn.getSoluong(), pn.getNcc(), pn.getTongtien()});
                        }
                    }
                }
            }
        });
        DefaultComboBoxModel cityName = new DefaultComboBoxModel();
        cityName.addElement("Mahang");
        cityName.addElement("Tên Hàng");
        cityName.addElement("NCC");
        cb = new JComboBox(cityName);
        cb.setBounds(210, 50, 90, 30);

        ptimkiemnangcao.add(cb);

        DefaultComboBoxModel cityName1 = new DefaultComboBoxModel();
        cityName1.addElement("Đơn giá");
        cityName1.addElement("Lớn hơn");
        cityName1.addElement("Nhỏ hơn");
        cbluong = new JComboBox(cityName1);
        cbluong.setBounds(210, 50, 90, 30);
        ptimkiemnangcao.add(txtluong);

        cbluong.setBounds(210, 90, 90, 30);
        ptimkiemnangcao.add(cb);
        ptimkiemnangcao.add(cbluong);

        txtluong.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {

                try {
                    txtluongchi(e);
                } catch (Exception ex) {
                    Logger.getLogger(Thong_Ke.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private void txtluongchi(KeyEvent e) throws Exception {
                phieunhaphangBUS pnbus = new phieunhaphangBUS();
                pnbus.dspn();
                tablemodel = (DefaultTableModel) tbchi.getModel();
                tablemodel.setRowCount(0);

                if (cbluong.getSelectedItem().equals("Đơn giá")) {
                    for (phieunhapDTO pn : pnbus.pnList) {
                        double dongia = 0;
                        if (txtluong.getText().equalsIgnoreCase("")) {
                            dongia = 0;
                        } else {
                            dongia = Double.valueOf(txtluong.getText());
                        }
                        if (pn.getGia() == dongia) {
                            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, pn.getMaMH(), pn.getTenMH(), pn.getGia(), pn.getSoluong(), pn.getNcc(), pn.getTongtien()});

                        }
                    }
                }
                if (cbluong.getSelectedItem().equals("Lớn hơn")) {
                    for (phieunhapDTO pn : pnbus.pnList) {
                        double dongia = 0;
                        if (txtluong.getText().equalsIgnoreCase("")) {
                            dongia = 0;
                        } else {
                            dongia = Double.valueOf(txtluong.getText());
                        }
                        if (pn.getGia() > dongia) {
                            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, pn.getMaMH(), pn.getTenMH(), pn.getGia(), pn.getSoluong(), pn.getNcc(), pn.getTongtien()});

                        }
                    }

                }
                if (cbluong.getSelectedItem().equals("Nhỏ hơn")) {
                    for (phieunhapDTO pn : pnbus.pnList) {
                        double dongia = 0;
                        if (txtluong.getText().equalsIgnoreCase("")) {
                            dongia = 0;
                        } else {
                            dongia = Double.valueOf(txtluong.getText());
                        }
                        if (pn.getGia() < dongia) {
                            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, pn.getMaMH(), pn.getTenMH(), pn.getGia(), pn.getSoluong(), pn.getNcc(), pn.getTongtien()});

                        }
                    }
                }
            }

        });
        ptimkiemnangcao.repaint();
        cardLayout.show(cardpanel, "cart3");
        showtbchi();
    }

    private void setltong() throws Exception {
        khachhangBUS khbus = new khachhangBUS();
        khbus.dskh();
        ltongkh.setText(String.valueOf(khbus.khList.size()));
        nhanvienBUS nvbus = new nhanvienBUS();
        nvbus.dsnv();
        ltongnv.setText(String.valueOf(nvbus.nvList.size()));
        hoadonBUS hdbus = new hoadonBUS();
        hdbus.dshd();
        long tong = 0;
        for (hoadonDTO hd : hdbus.hdList) {
            tong += hd.getThienthuc();
        }
        ltongdt.setText(String.valueOf(tong));
        int tongchi = 0;
        phieunhaphangBUS pnbus = new phieunhaphangBUS();
        pnbus.dspn();
        for (phieunhapDTO pn : pnbus.pnList) {
            tongchi += pn.getTongtien();
        }
        ltongchi.setText(String.valueOf(tongchi));
    }

    public void showtbnv() throws Exception {

        nhanvienBUS nvbus = new nhanvienBUS();
        nvbus.dsnv();
        tablemodel = (DefaultTableModel) tbnv.getModel();
        tablemodel.setRowCount(0);

        nvbus.nvList.forEach(nv -> {
            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, nv.getMa_nv(), nv.getHo() + " " + nv.getTen(), nv.getSdt(), nv.getLuong(), nv.getChucvu()});
        });
    }

    public void showtbkh() throws Exception {
        khachhangBUS khbus = new khachhangBUS();
        khbus.dskh();
        tablemodel = (DefaultTableModel) tbkh.getModel();
        tablemodel.setRowCount(0);

        for (khachhangDTO kh : khbus.khList) {
            double tongtien = 0;
            hoadonBUS hdbus = new hoadonBUS();
            hdbus.dshd();
            for (hoadonDTO hd : hdbus.hdList) {
                if (kh.getMa_kh().equalsIgnoreCase(hd.getMa_kh())) {
                    tongtien = tongtien + hd.getThienthuc();
                }
            }
            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, kh.getMa_kh(), kh.getHo() + " " + kh.getTen(), kh.getSdt(), tongtien});
        }

    }

    public void showtbdt() throws Exception {
        hoadonBUS hdbus = new hoadonBUS();
        hdbus.dshd();
        tablemodel = (DefaultTableModel) tbdt.getModel();
        tablemodel.setRowCount(0);
        hdbus.hdList.forEach(hd -> {
            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd.getMa_hd(), hd.getMa_nv(), hd.getMa_kh(), hd.getNgaylap(), (long)hd.getThienthuc()});
        });
    }

    private void showtbchi() throws Exception {
        phieunhaphangBUS pnhbus = new phieunhaphangBUS();
        pnhbus.dspn();
        tablemodel = (DefaultTableModel) tbchi.getModel();
        tablemodel.setRowCount(0);
        for (phieunhapDTO pn : pnhbus.pnList) {
            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, pn.getMaMH(), pn.getTenMH(), pn.getGia(), pn.getSoluong(), pn.getNcc(), pn.getTongtien()});
        }

    }

    private void txttiemkiemnv(KeyEvent e) throws Exception {
        nhanvienBUS nvbus = new nhanvienBUS();
        nvbus.dsnv();
        tablemodel = (DefaultTableModel) tbnv.getModel();
        tablemodel.setRowCount(0);
        if (cb.getSelectedItem().equals("MãNV")) {
            for (nhanvienDTO nv : nvbus.nvList) {
                if (nv.getMa_nv().contains(txttiemkiem.getText())) {
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, nv.getMa_nv(), nv.getHo() + " " + nv.getTen(), nv.getSdt(), nv.getLuong(), nv.getChucvu()});
                }
            }
        }
        if (cb.getSelectedItem().equals("TênNV")) {
            int index = 0;
            tablemodel = (DefaultTableModel) tbnv.getModel();
            tablemodel.setRowCount(0);
            for (nhanvienDTO nv : nvbus.nvList) {
                if (nv.getHo().contains(txttiemkiem.getText()) || nv.getTen().contains(txttiemkiem.getText())) {
                    index++;
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, nv.getMa_nv(), nv.getHo() + " " + nv.getTen(), nv.getSdt(), nv.getLuong(), nv.getChucvu()});
                }
                tablemodel.addRow(new Object[]{"Tổng nhân viên ", "---", "---", "---", "---", index});
            }
        }
        if (cb.getSelectedItem().equals("SDT")) {
            tablemodel = (DefaultTableModel) tbnv.getModel();
            tablemodel.setRowCount(0);
            for (nhanvienDTO nv : nvbus.nvList) {
                if (nv.getSdt().contains(txttiemkiem.getText())) {
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, nv.getMa_nv(), nv.getHo() + " " + nv.getTen(), nv.getSdt(), nv.getLuong(), nv.getChucvu()});
                }
            }
        }
    }

    private void txtluongnv(KeyEvent e) throws Exception {
        nhanvienBUS nvbus = new nhanvienBUS();
        nvbus.dsnv();
        tablemodel = (DefaultTableModel) tbnv.getModel();
        tablemodel.setRowCount(0);

        if (cbluong.getSelectedItem().equals("Thấp hơn")) {
            int index = 0;
            for (nhanvienDTO nv : nvbus.nvList) {
                double luong = 0;
                if (txtluong.getText().equalsIgnoreCase("")) {
                    luong = 0;
                } else {
                    luong = Double.valueOf(txtluong.getText());
                }
                if (nv.getLuong() < luong) {
                    index++;
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, nv.getMa_nv(), nv.getHo() + " " + nv.getTen(), nv.getSdt(), nv.getLuong(), nv.getChucvu()});
                }
            }
            tablemodel.addRow(new Object[]{"Tổng nhân viên ", "---", "---", "---", "---", index});
        }
        if (cbluong.getSelectedItem().equals("Cao hơn")) {
            int index = 0;
            for (nhanvienDTO nv : nvbus.nvList) {
                double luong = 0;
                if (txtluong.getText().equalsIgnoreCase("")) {
                    luong = 0;
                } else {
                    luong = Double.valueOf(txtluong.getText());
                }
                if (nv.getLuong() > luong) {
                    index++;
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, nv.getMa_nv(), nv.getHo() + " " + nv.getTen(), nv.getSdt(), nv.getLuong(), nv.getChucvu()});
                }
            }
            tablemodel.addRow(new Object[]{"Tổng nhân viên ", "---", "---", "---", "---", index});
        }
        if (cbluong.getSelectedItem().equals("Bằng")) {
            int index = 0;
            for (nhanvienDTO nv : nvbus.nvList) {
                double luong = 0;
                if (txtluong.getText().equalsIgnoreCase("")) {
                    luong = 0;
                } else {
                    luong = Double.valueOf(txtluong.getText());
                }
                if (nv.getLuong() == luong) {
                    index++;
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, nv.getMa_nv(), nv.getHo() + " " + nv.getTen(), nv.getSdt(), nv.getLuong(), nv.getChucvu()});
                }
            }
            tablemodel.addRow(new Object[]{"Tổng nhân viên ", "---", "---", "---", "---", index});
        }

    }

    private void cbcv(ItemEvent arg0) throws Exception {
        nhanvienBUS nvbus = new nhanvienBUS();
        nvbus.dsnv();
        tablemodel = (DefaultTableModel) tbnv.getModel();
        tablemodel.setRowCount(0);
        double tong = 0;
        for (nhanvienDTO nv : nvbus.nvList) {
            if (cbcv.getSelectedItem().equals(nv.getChucvu())) {
                tong++;
                tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, nv.getMa_nv(), nv.getHo() + " " + nv.getTen(), nv.getSdt(), nv.getLuong(), nv.getChucvu()});
            }
        }
        tablemodel.addRow(new Object[]{"Tông nhân viên", "---", "---", "---", "---", tong});
    }

    private void txttiemkiemdt(KeyEvent e) throws Exception {
        hoadonBUS hdbus = new hoadonBUS();
        hdbus.dshd();
        tablemodel = (DefaultTableModel) tbdt.getModel();
        tablemodel.setRowCount(0);
        if (cb.getSelectedItem().equals("MaHD")) {
            for (hoadonDTO hd : hdbus.hdList) {
                int index = 0;
                if (txttiemkiem.getText().equalsIgnoreCase("")) {
                    index = 0;
                } else {
                    index = Integer.valueOf(txttiemkiem.getText());
                }
                if (hd.getMa_hd() == index) {
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd.getMa_hd(), hd.getMa_nv(), hd.getMa_kh(), hd.getNgaylap(), hd.getThienthuc()});
                }
            }
        }
        if (cb.getSelectedItem().equals("MaNV")) {
            double tong = 0;
            int index = 0;
            for (hoadonDTO hd : hdbus.hdList) {
                if (hd.getMa_nv().contains(txttiemkiem.getText())) {
                    index++;
                    tong += hd.getThienthuc();
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd.getMa_hd(), hd.getMa_nv(), hd.getMa_kh(), hd.getNgaylap(), hd.getThienthuc()});
                }
            }
            tablemodel.addRow(new Object[]{"--", "Tổng số hóa đơn :" + index, "---", "---", "---", "Tổng tiền :" + tong});
        }
        
        if (cb.getSelectedItem().equals("MaKH")) {
            int index = 0;
            double tong = 0;
            for (hoadonDTO hd : hdbus.hdList) {
                if (hd.getMa_kh().contains(txttiemkiem.getText())) {
                    index++;
                    tong += hd.getThienthuc();
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd.getMa_hd(), hd.getMa_nv(), hd.getMa_kh(), hd.getNgaylap(), hd.getThienthuc()});
                }
            }
            tablemodel.addRow(new Object[]{"--", "Tổng số hóa đơn :" + index, "---", "---", "---", "Tổng tiền " + tong});

        }

    }

    private void txtluongdt(KeyEvent e) throws Exception {
        hoadonBUS hdbus = new hoadonBUS();
        hdbus.dshd();
        tablemodel = (DefaultTableModel) tbdt.getModel();
        tablemodel.setRowCount(0);

        if (cbluong.getSelectedItem().equals("Thấp hơn")) {
            int index = 0;
            double tongtien = 0;
            for (hoadonDTO hd : hdbus.hdList) {
                if (hd.getTongtien() < Double.valueOf(txtluong.getText())) {
                    index++;
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd.getMa_hd(), hd.getMa_nv(), hd.getMa_kh(), hd.getNgaylap(), hd.getTongtien()});
                    tongtien += hd.getTongtien();
                }
            }
            tablemodel.addRow(new Object[]{"---", "Tổng hóa đơn : " + index, "---", "---", "---", "Tổng tiền :" + tongtien});

        }
        if (cbluong.getSelectedItem().equals("Cao hơn")) {
            int index = 0;
            double tongtien = 0;
            for (hoadonDTO hd : hdbus.hdList) {
                if (hd.getTongtien() > Double.valueOf(txtluong.getText())) {
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd.getMa_hd(), hd.getMa_nv(), hd.getMa_kh(), hd.getNgaylap(), hd.getTongtien()});
                    tongtien += hd.getTongtien();
                    index++;
                }
            }
            tablemodel.addRow(new Object[]{"---", "Tổng hóa đơn : " + index, "---", "---", "---", "Tổng tiền :" + tongtien});

        }
        if (cbluong.getSelectedItem().equals("Bằng")) {
            double tongtien = 0;
            int index = 0;
            for (hoadonDTO hd : hdbus.hdList) {
                if (hd.getTongtien() == Double.valueOf(txtluong.getText())) {
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd.getMa_hd(), hd.getMa_nv(), hd.getMa_kh(), hd.getNgaylap(), hd.getTongtien()});
                    tongtien += hd.getTongtien();
                    index++;
                }
            }
            tablemodel.addRow(new Object[]{"---", "Tổng hóa đơn : " + index, "---", "---", "---", "Tổng tiền :" + tongtien});

        }

    }

    private void txttiemkiemkh(KeyEvent e) throws Exception {

        khachhangBUS khbus = new khachhangBUS();
        khbus.dskh();
        tablemodel = (DefaultTableModel) tbkh.getModel();
        tablemodel.setRowCount(0);
        if (cb.getSelectedItem().equals("MaKH")) {
            for (khachhangDTO kh : khbus.khList) {
                if (kh.getMa_kh().contains(txttiemkiem.getText())) {
                    double tongtien = 0;
                    hoadonBUS hdbus = new hoadonBUS();
                    hdbus.dshd();
                    for (hoadonDTO hd : hdbus.hdList) {
                        if (kh.getMa_kh().equalsIgnoreCase(hd.getMa_kh())) {
                            tongtien = tongtien + hd.getThienthuc();
                        }
                    }
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, kh.getMa_kh(), kh.getHo() + " " + kh.getTen(), kh.getSdt(), tongtien});
                }
            }
        }
        if (cb.getSelectedItem().equals("SĐT")) {
            for (khachhangDTO kh : khbus.khList) {
                if (kh.getSdt().contains(txttiemkiem.getText())) {
                    double tongtien = 0;
                    hoadonBUS hdbus = new hoadonBUS();
                    hdbus.dshd();
                    for (hoadonDTO hd : hdbus.hdList) {
                        if (kh.getMa_kh().equalsIgnoreCase(hd.getMa_kh())) {
                            tongtien = tongtien + hd.getThienthuc();
                        }
                    }
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, kh.getMa_kh(), kh.getHo() + " " + kh.getTen(), kh.getSdt(), tongtien});
                }
            }
        }
        if (cb.getSelectedItem().equals("TênKH")) {
            for (khachhangDTO kh : khbus.khList) {
                if (kh.getHo().contains(txttiemkiem.getText()) || kh.getTen().contains(txttiemkiem.getText())) {
                    double tongtien = 0;
                    hoadonBUS hdbus = new hoadonBUS();
                    hdbus.dshd();
                    for (hoadonDTO hd : hdbus.hdList) {
                        if (kh.getMa_kh().equalsIgnoreCase(hd.getMa_kh())) {
                            tongtien = tongtien + hd.getThienthuc();
                        }
                    }
                    tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, kh.getMa_kh(), kh.getHo() + " " + kh.getTen(), kh.getSdt(), tongtien});
                }
            }
        }

    }

    private void addMouseListenerRecrusively(Container container) {

        for (Component component : container.getComponents()) {
            if (component instanceof Container) {
                addMouseListenerRecrusively((Container) component);
            }
        }

        container.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String date = formatter1.format(jDateChooser1.getDate());
                hoadonBUS hdbus = new hoadonBUS();
                try {
                    hdbus.dshd();
                } catch (Exception ex) {
                }
                tablemodel = (DefaultTableModel) tbdt.getModel();
                tablemodel.setRowCount(0);
                int index = 0;
                double tongtien = 0;
                for (hoadonDTO hd : hdbus.hdList) {
                    if (hd.getNgaylap().equalsIgnoreCase(date)) {
                        tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, hd.getMa_hd(), hd.getMa_nv(), hd.getMa_kh(), hd.getNgaylap(), hd.getTongtien()});
                        index++;
                        tongtien += hd.getThienthuc();
                    }
                }
                tablemodel.addRow(new Object[]{"---", "Tổng hóa đơn : " + index, "---", "---", "---", "Tổng tiền :" + tongtien});

            }
        });

    }

    JPanel ptop;
    JPanel pmain;
    JLabel ltitle;
    JPanel ptknv;
    JPanel ptkdt;
    JPanel ptkkh;
    JPanel ptkchi;
    JLabel ltktongkh;
    JLabel ltktongnv;
    JLabel ltktongdt;
    JLabel ltktongchi;
    JTable tbkh;
    JTable tbnv;
    JTable tbdt;
    JTable tbchi;
    JScrollPane s;
    JScrollPane s1;
    JScrollPane s2;
    JScrollPane s3;
    JPanel p4;
    JPanel p1;
    JPanel p2;
    JPanel p3;
    JLabel ltongchi;
    JLabel ltongkh;
    JLabel ltongdt;
    JLabel ltongnv;
    DefaultTableModel tablemodel;

    JPanel ptimkiemnangcao;

    JTextField txttiemkiem;
    JTextField txtluong;
    JComboBox cbluong;

    JComboBox cb;
    JComboBox cbcv;
    JLabel ltimkiem;
    JDateChooser jDateChooser1;
    DateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
}
