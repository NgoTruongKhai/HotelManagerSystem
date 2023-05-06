/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminGUI;

import BUS.khuyenmaiBUS;
import static BUS.khuyenmaiBUS.kmList;
import QLKS.DTO.khuyenmaiDTO;
import QLKS.DTO.nhanvienDTO;
import QLKS.GUI.phieu_dang_ki;
import Report.ExcelReport;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Quan_Li_Khuyen_mai extends JPanel {

    public Quan_Li_Khuyen_mai() {

        this.setSize(1200, 570);
        this.setBackground(Color.BLUE);
        this.setLayout(new BorderLayout(0, 0));
//        this.setUndecorated(true);
//        this.setLocationRelativeTo(null);

        p_top_qlkm = new JPanel();
        p_top_qlkm.setPreferredSize(new Dimension(1200, 100));
        p_top_qlkm.setBackground(new Color(102, 217, 255));
        p_top_qlkm.setLayout(null);

        l_title_qlkm = new JLabel("Quản Lí Khuyến mãi");
        l_title_qlkm.setFont(new Font("", Font.CENTER_BASELINE, 22));
        l_title_qlkm.setBounds(475, 10, 250, 25);
        p_top_qlkm.add(l_title_qlkm);

//        ImageIcon icon_them=new ImageIcon("src/img/them.png");
        btn_them = new JButton();
//        btn_them.setIcon(icon_them);
//        btn_them.setIconTextGap(2);
        btn_them.setText("Thêm");
        btn_them.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_them.setBackground(new Color(0, 164, 128));
        btn_them.setBounds(50, 50, 140, 40);
        p_top_qlkm.add(btn_them);

//        ImageIcon icon_sua=new ImageIcon("src/img/chinhsua.png");
        btn_sua = new JButton();
//        btn_sua.setIcon(icon_sua);
//        btn_sua.setIconTextGap(2);
        btn_sua.setText("Sửa");
        btn_sua.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_sua.setBackground(new Color(0, 164, 128));
        btn_sua.setBounds(200, 50, 140, 40);
        p_top_qlkm.add(btn_sua);

//        ImageIcon icon_xoa=new ImageIcon("src/img/xoa.png");
        btn_xoa = new JButton();
//        btn_xoa.setIcon(icon_them);
//        btn_xoa.setIconTextGap(2);
        btn_xoa.setText("Xóa");
        btn_xoa.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_xoa.setBackground(new Color(0, 164, 128));
        btn_xoa.setBounds(350, 50, 140, 40);
        p_top_qlkm.add(btn_xoa);

        btn_reset = new JButton();
        btn_reset.setText("reset");
        btn_reset.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_reset.setBackground(new Color(0, 164, 128));
        btn_reset.setBounds(500, 50, 140, 40);
        p_top_qlkm.add(btn_reset);

        txttimkiem = new JTextField();
        txttimkiem.setBounds(700, 55, 200, 30);
        p_top_qlkm.add(txttimkiem);
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

        btn_timkiem = new JButton();
        btn_timkiem.setText("Tìm kiếm");
        btn_timkiem.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_timkiem.setBackground(new Color(0, 164, 128));
        btn_timkiem.setBounds(900, 55, 130, 30);
        p_top_qlkm.add(btn_timkiem);

        btn_in = new JButton("In");
        btn_in.setFont(new Font("", Font.CENTER_BASELINE, 18));
        btn_in.setBackground(new Color(0, 164, 128));
        btn_in.setBounds(1040, 55, 100, 30);
        p_top_qlkm.add(btn_in);
        btn_in.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ExcelReport exel = new ExcelReport();

                exel.ExportExcel("DSNhanvien", tb);
            }
        });
        String[][] data = {
            {null, null, null, null, null, null},};
        String[] title_table = {"STT", "MãKM", "Phần trăm khuyến mãi", "Nội dung khuyến mãi"};
        tb = new JTable();
        tb.setModel(new javax.swing.table.DefaultTableModel(data, title_table) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        s = new JScrollPane();
        s.setViewportView(tb);

        tb.setPreferredScrollableViewportSize(new Dimension(700, 470));
        pcontent = new JPanel();
        pcontent.setPreferredSize(new Dimension(1200, 470));
        pcontent.setLayout(new BorderLayout(0, 0));
        pcontent.add(s, BorderLayout.EAST);
        pcontent.repaint();

        pform = new JPanel();
        pform.setPreferredSize(new Dimension(500, 470));
        pform.setLayout(null);

        ltitle = new JLabel("Khuyến mãi");
        ltitle.setBounds(175, 10, 150, 40);
        ltitle.setFont(new Font("", Font.BOLD, 18));
        pform.add(ltitle);

        lmaKm = new JLabel("Mã khuyến mãi :");
        lptkm = new JLabel("Phần trăm KM :");
        lnoidung = new JLabel("Nội dung :");

        lmaKm.setBounds(50, 70, 150, 30);
        lmaKm.setFont(new Font("", Font.BOLD, 16));
        lptkm.setBounds(50, 110, 150, 30);
        lptkm.setFont(new Font("", Font.BOLD, 16));
        lnoidung.setBounds(50, 150, 150, 30);
        lnoidung.setFont(new Font("", Font.BOLD, 16));

        txtmakm = new JTextField();
        txtptkm = new JTextField("0");
        txtnd = new JTextArea();

        txtmakm.setBounds(210, 70, 250, 30);
        txtptkm.setBounds(210, 110, 250, 30);
        txtnd.setBounds(50, 190, 410, 200);

        btn_them.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    btn_them(e);
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Khuyen_mai.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        btn_sua.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    btn_sua(e);
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Khuyen_mai.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        btn_xoa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    btn_xoa(e);
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Khuyen_mai.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        btn_reset.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btn_reset(e);
            }

        });

        btnnhaplai = new JButton("Nhập lại");
        btnnhaplai.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btnnhaplai(e);
            }

        });

        btnnhaplai.setBounds(170, 400, 145, 40);

        btnnhaplai.setFont(new Font("", Font.BOLD, 16));

        btnnhaplai.setBackground(new Color(0, 164, 128));

        pform.add(btnnhaplai);
        pform.add(txtmakm);
        pform.add(txtnd);
        pform.add(txtptkm);
        pform.add(lmaKm);
        pform.add(lnoidung);
        pform.add(lptkm);

        pcontent.add(pform, BorderLayout.WEST);

        this.add(pcontent, BorderLayout.SOUTH);
        this.add(p_top_qlkm, BorderLayout.NORTH);
        show();
        eventtb();
    }

    private void txttimkiem(KeyEvent e) throws Exception {
        khuyenmaiBUS kmbus = new khuyenmaiBUS();
        kmbus.dskm();

        tablemodel = (DefaultTableModel) tb.getModel();
        tablemodel.setRowCount(0);
        for (khuyenmaiDTO km : kmbus.kmList) {
            if (km.getMa_km().contains(txttimkiem.getText()) || km.getNoidung().contains(txttimkiem.getText())) {
                tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, km.getMa_km(), km.getTienkm(), km.getNoidung()});
            }
        }
    }

    private void btn_them(MouseEvent e) throws Exception {
        khuyenmaiDTO km = new khuyenmaiDTO();
        km.setMa_km(txtmakm.getText());
        km.setNoidung(txtnd.getText());
        km.setTienkm(Integer.valueOf(txtptkm.getText()));
        khuyenmaiBUS kmbus = new khuyenmaiBUS();
        if (kmbus.insert(km) == true) {
            JOptionPane.showMessageDialog(null, "Thêm Thàng Công !!");
        } else {
            JOptionPane.showMessageDialog(null, "Thêm Không Thành Công !!");
        }
        show();
        reset1();
    }

    private void btn_sua(MouseEvent e) throws Exception {
        khuyenmaiDTO km = new khuyenmaiDTO();
        km.setMa_km(txtmakm.getText());
        km.setNoidung(txtnd.getText());
        km.setTienkm(Integer.valueOf(txtptkm.getText()));
        km.setId(id);
        khuyenmaiBUS kmbus = new khuyenmaiBUS();
        if (kmbus.update(km) == true) {
            JOptionPane.showMessageDialog(null, "Sửa Thàng Công !!");
        } else {
            JOptionPane.showMessageDialog(null, "Sửa Không Thành Công !!");
        }
        show();
        reset1();
    }

    private void btn_xoa(MouseEvent e) throws Exception {
        khuyenmaiBUS km1 = new khuyenmaiBUS();
        if (km1.delete(id) == true) {
            JOptionPane.showMessageDialog(null, "Xóa Thàng Công !!");
        } else {
            JOptionPane.showMessageDialog(null, "Xóa không Thàng Công !!");
        }
        show();
        reset1();
    }

    private void btn_reset(MouseEvent e) {
        reset1();
    }

    private void reset1() {
        id = 0;
        txtmakm.setText("");
        txtnd.setText("");
        txtptkm.setText("0");
    }

    private void btnnhaplai(MouseEvent e) {
        reset1();
    }

    public void show() {
        khuyenmaiBUS km1 = new khuyenmaiBUS();
        try {
            km1.dskm();
        } catch (Exception ex) {
            Logger.getLogger(Quan_Li_Khuyen_mai.class.getName()).log(Level.SEVERE, null, ex);
        }
        tablemodel = (DefaultTableModel) tb.getModel();
        tablemodel.setRowCount(0);
        for (khuyenmaiDTO km : km1.kmList) {
            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, km.getMa_km(), km.getTienkm(), km.getNoidung()});
        }
    }

    public void eventtb() {
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                khuyenmaiBUS kmbus = new khuyenmaiBUS();
                try {
                    kmbus.dskm();
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Nhan_Vien.class.getName()).log(Level.SEVERE, null, ex);
                }

                int selectedIndex = tb.getSelectedRow();
                khuyenmaiDTO km = kmList.get(selectedIndex);
                txtmakm.setText(km.getMa_km());
                txtnd.setText(km.getNoidung());
                txtptkm.setText(String.valueOf(km.getTienkm()));
                id = km.getId();
            }
        });
    }

    public static void main(String[] args) {
        new Quan_Li_Khuyen_mai().setVisible(true);
    }

    JPanel p_top_qlkm;
    JLabel l_title_qlkm;
    JButton btn_them;
    JButton btn_sua;
    JButton btn_in;
    JButton btn_reset;
    JButton btn_xoa;
    JTextField txttimkiem;
    JButton btn_timkiem;
    JPanel pcontent;
    JScrollPane s;
    JTable tb;

    JPanel pform;

    JTextField txtmakm;
    JTextField txtptkm;
    JTextArea txtnd;

    JLabel ltitle;
    JLabel lmaKm;
    JLabel lptkm;
    JLabel lnoidung;
    DefaultTableModel tablemodel;
    JButton btnnhaplai;
    int id;
}
