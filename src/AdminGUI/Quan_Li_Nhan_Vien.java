/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminGUI;

import BUS.nhanvienBUS;
import static BUS.nhanvienBUS.nvList;
import QLKS.DAL.khachhangDAL;
import QLKS.DTO.khachhangDTO;
import QLKS.DTO.nhanvienDTO;
import QLKS.GUI.Quan_Li_Khach_Hang;
import QLKS.GUI.phieu_dang_ki;
import Report.ExcelReport;
import Report.importExel;
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
public final class Quan_Li_Nhan_Vien extends JPanel {

    public Quan_Li_Nhan_Vien() throws Exception {
        this.setPreferredSize(new Dimension(1200, 570));
        this.setBackground(Color.BLUE);
        this.setLayout(new BorderLayout(0, 0));

        p_top_qlnv = new JPanel();
        p_top_qlnv.setPreferredSize(new Dimension(1200, 100));
        p_top_qlnv.setBackground(new Color(102, 217, 255));
        p_top_qlnv.setLayout(null);

        l_title_qlnv = new JLabel("Quản Lí Nhân Viên");
        l_title_qlnv.setFont(new Font("", Font.CENTER_BASELINE, 22));
        l_title_qlnv.setBounds(475, 10, 250, 25);
        p_top_qlnv.add(l_title_qlnv);

//        ImageIcon icon_them=new ImageIcon("src/img/them.png");
        btn_them = new JButton();
//        btn_them.setIcon(icon_them);
//        btn_them.setIconTextGap(2);
        btn_them.setText("Thêm");
        btn_them.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_them.setBackground(new Color(0, 164, 128));
        btn_them.setBounds(50, 50, 140, 40);
        p_top_qlnv.add(btn_them);

//        ImageIcon icon_sua=new ImageIcon("src/img/chinhsua.png");
        btn_sua = new JButton();
//        btn_sua.setIcon(icon_sua);
//        btn_sua.setIconTextGap(2);
        btn_sua.setText("Sửa");
        btn_sua.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_sua.setBackground(new Color(0, 164, 128));
        btn_sua.setBounds(200, 50, 140, 40);
        p_top_qlnv.add(btn_sua);

//        ImageIcon icon_xoa=new ImageIcon("src/img/xoa.png");
        btn_xoa = new JButton();
//        btn_xoa.setIcon(icon_them);
//        btn_xoa.setIconTextGap(2);
        btn_xoa.setText("Xóa");
        btn_xoa.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_xoa.setBackground(new Color(0, 164, 128));
        btn_xoa.setBounds(350, 50, 140, 40);
        p_top_qlnv.add(btn_xoa);

        btn_reset = new JButton();
        btn_reset.setText("reset");
        btn_reset.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_reset.setBackground(new Color(0, 164, 128));
        btn_reset.setBounds(500, 50, 140, 40);
        p_top_qlnv.add(btn_reset);

        txttimkiem = new JTextField();
        txttimkiem.setBounds(650, 55, 200, 30);
        p_top_qlnv.add(txttimkiem);

        btn_timkiem = new JButton();
        btn_timkiem.setText("Tìm kiếm");
        btn_timkiem.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_timkiem.setBackground(new Color(0, 164, 128));
        btn_timkiem.setBounds(850, 55, 130, 30);
        p_top_qlnv.add(btn_timkiem);

        btn_in = new JButton("Export");
        btn_in.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_in.setBackground(new Color(0, 164, 128));
        btn_in.setBounds(990, 55, 100, 30);
        p_top_qlnv.add(btn_in);

        btnimport = new JButton("Import");
        btnimport.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btnimport.setBackground(new Color(0, 164, 128));
        btnimport.setBounds(1100, 55, 100, 30);
        p_top_qlnv.add(btnimport);

        btnimport.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                importExel exel = new importExel();
                try {
                    exel.importNv();
                    show();
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Nhan_Vien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btn_in.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ExcelReport exel = new ExcelReport();

                exel.ExportExcel("DSNhanvien", tb);
            }
        });

        String[][] data = {
            {null, null, null, null, null, null},};
        String[] title_table = {"STT", "MãNV", "HỌ và Tên", "GIỚI TÍNH", "NGÀY SINH", "SỐ ĐIỆN THOẠI", "ĐỊA CHỈ", "Chức vụ", "Lương"};
        tb = new JTable();
        tb.setModel(new javax.swing.table.DefaultTableModel(data, title_table) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        show();
        eventTable();
        tb.setBounds(0, 0, 1200, 450);
        tb.getColumnModel().getColumn(0).setPreferredWidth(40);
        tb.getColumnModel().getColumn(1).setPreferredWidth(100);
        tb.getColumnModel().getColumn(2).setPreferredWidth(150);
        tb.getColumnModel().getColumn(3).setPreferredWidth(80);
        tb.getColumnModel().getColumn(4).setPreferredWidth(80);
        tb.getColumnModel().getColumn(5).setPreferredWidth(150);
        tb.getColumnModel().getColumn(6).setPreferredWidth(500);
        tb.getColumnModel().getColumn(7).setPreferredWidth(100);
        tb.getColumnModel().getColumn(8).setPreferredWidth(150);

        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < 7; i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        s = new JScrollPane();
        s.setViewportView(tb);

        pcontent = new JPanel();
        pcontent.setPreferredSize(new Dimension(1200, 470));
        pcontent.setLayout(new BorderLayout(0, 0));
        pcontent.add(s);
        pcontent.repaint();
        this.add(pcontent, BorderLayout.SOUTH);
        this.add(p_top_qlnv, BorderLayout.NORTH);

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
                try {
                    xoa(e);
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Nhan_Vien.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        nhanvienBUS nv = new nhanvienBUS();
        if (nv.nvList == null) {
            nv.dsnv();
        }

        tablemodel = (DefaultTableModel) tb.getModel();
        tablemodel.setRowCount(0);
        for (nhanvienDTO nv1 : nv.nvList) {
            if (nv1.getMa_nv().contains(txttimkiem.getText()) || nv1.getHo().contains(txttimkiem.getText()) || nv1.getTen().contains(txttimkiem.getText()) || nv1.getSdt().contains(txttimkiem.getText()) || nv1.getDiachi().contains(txttimkiem.getText()) || nv1.getNgaysinh().contains(txttimkiem.getText()) || txttimkiem.getText().equalsIgnoreCase(nv1.getHo() + " " + nv1.getTen())) {
                tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, nv1.getMa_nv(), nv1.getHo() + " " + nv1.getTen(), nv1.getGioitinh(), nv1.getNgaysinh(), nv1.getSdt(), nv1.getDiachi(), nv1.getChucvu(), nv1.getLuong()});

            }
        }
    }

    private void txttimkiem(KeyEvent evt) throws Exception {
        nhanvienBUS nv = new nhanvienBUS();
        if (nv.nvList == null) {
            nv.dsnv();
        }

        tablemodel = (DefaultTableModel) tb.getModel();
        tablemodel.setRowCount(0);
        for (nhanvienDTO nv1 : nv.nvList) {
            if (nv1.getMa_nv().contains(txttimkiem.getText()) || nv1.getHo().contains(txttimkiem.getText()) || nv1.getTen().contains(txttimkiem.getText()) || nv1.getSdt().contains(txttimkiem.getText()) || nv1.getDiachi().contains(txttimkiem.getText()) || nv1.getNgaysinh().contains(txttimkiem.getText())) {
                tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, nv1.getMa_nv(), nv1.getHo() + " " + nv1.getTen(), nv1.getGioitinh(), nv1.getNgaysinh(), nv1.getSdt(), nv1.getDiachi(), nv1.getChucvu(), nv1.getLuong()});

            }
        }
    }

    private void them(MouseEvent e) {
        nhanvien nv = new nhanvien();
        pcontent.removeAll();
        pcontent.setPreferredSize(new Dimension(1200, 470));
        pcontent.setLayout(new BorderLayout(0, 0));
        lback = new JLabel("Trở lại");
        lback.setPreferredSize(new Dimension(50, 20));
        lback.setBackground(Color.YELLOW);
        lback.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                lback(e);
            }

        });

        lback.setFont(new Font("", Font.BOLD, 16));
        pcontent.add(lback, BorderLayout.WEST);
        pcontent.add(nv);
        pcontent.repaint();
        nv.revalidate();
        nv.repaint();
    }

    private void lback(MouseEvent e) {
        pcontent.removeAll();
        pcontent.setPreferredSize(new Dimension(1200, 470));
        pcontent.setLayout(new BorderLayout(0, 0));
        show();
        pcontent.add(s);
        pcontent.repaint();
    }

    public void show() {
        nhanvienBUS nv = new nhanvienBUS();
        try {
            nv.dsnv();
        } catch (Exception ex) {
            Logger.getLogger(Quan_Li_Nhan_Vien.class.getName()).log(Level.SEVERE, null, ex);
        }
        tablemodel = (DefaultTableModel) tb.getModel();
        tablemodel.setRowCount(0);
        for (nhanvienDTO nv1 : nv.nvList) {
            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, nv1.getMa_nv(), nv1.getHo() + " " + nv1.getTen(), nv1.getGioitinh(), nv1.getNgaysinh(), nv1.getSdt(), nv1.getDiachi(), nv1.getChucvu(), nv1.getLuong()});
        }
    }

    private void eventTable() {
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                nhanvienBUS nvbus = new nhanvienBUS();
                try {
                    nvbus.dsnv();
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Nhan_Vien.class.getName()).log(Level.SEVERE, null, ex);
                }

                int selectedIndex = tb.getSelectedRow();
                nhanvienDTO kh = nvList.get(selectedIndex);
                nv.setall(kh);
                id = kh.getId();
            }
        });
    }
    int id;
    nhanvien nv = new nhanvien();

    private void sua(MouseEvent e) {
        nv.setbtnluu("Lưu");
        pcontent.removeAll();
        pcontent.setPreferredSize(new Dimension(1200, 470));
        pcontent.setLayout(new BorderLayout(0, 0));
        lback = new JLabel("Trở lại");
        lback.setPreferredSize(new Dimension(50, 20));
        lback.setBackground(Color.YELLOW);
        lback.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                lback(e);
            }

        });
        lback.setFont(new Font("", Font.BOLD, 16));
        pcontent.add(lback, BorderLayout.WEST);
        pcontent.add(nv);
        pcontent.repaint();
        nv.revalidate();
        nv.repaint();
    }

    private void xoa(MouseEvent e) throws Exception {
        nhanvienBUS nvbus = new nhanvienBUS();
        if (nvbus.delete(id) == true) {
            JOptionPane.showMessageDialog(null, "xóa thàng công!!");
            pcontent.removeAll();
            pcontent.setPreferredSize(new Dimension(1200, 470));
            pcontent.setLayout(new BorderLayout(0, 0));
            show();
            pcontent.add(s);
            pcontent.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "xóa không thàng công!!");
        }
    }

    private void reset(MouseEvent e) {
        pcontent.removeAll();
        pcontent.setPreferredSize(new Dimension(1200, 470));
        pcontent.setLayout(new BorderLayout(0, 0));
        show();
        pcontent.add(s);
        pcontent.repaint();
    }

    public void reload() {
        pcontent.removeAll();
        pcontent.setPreferredSize(new Dimension(1200, 470));
        pcontent.setLayout(new BorderLayout(0, 0));
        pcontent.add(s);
        pcontent.repaint();
    }

    JPanel p_top_qlnv;
    JLabel l_title_qlnv;
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
    DefaultTableModel tablemodel;
    JTable tb;
    JPanel pcontent;
    JLabel lback;
    public static Quan_Li_Nhan_Vien qlnv;
}
