/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.GUI;

import BUS.phieunhaphangBUS;
import static BUS.phieunhaphangBUS.pnList;
import QLKS.DTO.phieunhapDTO;
import Report.ExcelReport;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
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
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Phieu_Nhap extends JFrame {

    DefaultTableModel tablemodel;

    public Phieu_Nhap(JPanel p) throws HeadlessException, Exception {
        init(p);
        tablemodel = (DefaultTableModel) tb.getModel();
        showtable();
        eventtable();
    }
    int id;

    public void showtable() throws Exception {
//        ArrayList<phieunhapDTO> pnList=phieunhaphangDAL.findall();
        phieunhaphangBUS pnhbus = new phieunhaphangBUS();
        pnhbus.dspn();
        tablemodel.setRowCount(0);
        for (int i = 0; i < pnList.size(); i++) {
            tablemodel.addRow(new Object[]{tablemodel.getRowCount() + 1, pnList.get(i).getMaMH(), pnList
                .get(i).getTenMH(), pnList.get(i).getGia(), pnList.get(i).getSoluong(), pnList.get(i).getNcc(), pnList.get(i).getTongtien()});
        }
    }

    private void eventtable() {
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    phieunhaphangBUS pnhbus = new phieunhaphangBUS();
                    pnhbus.dspn();
                } catch (Exception ex) {
                    Logger.getLogger(Phieu_Nhap.class.getName()).log(Level.SEVERE, null, ex);
                }
                int selectedIndex = tb.getSelectedRow();
                txtgiaMH.setText(String.valueOf(pnList.get(selectedIndex).getGia()));
                txtmaMH.setText(pnList.get(selectedIndex).getMaMH());
                txtnccMH.setText(pnList.get(selectedIndex).getNcc());
                txtsoluongMH.setText(String.valueOf(pnList.get(selectedIndex).getSoluong()));
                txttenMH.setText(pnList.get(selectedIndex).getTenMH());
                id = pnList.get(selectedIndex).getId();
            }

        });
    }

    public void init(JPanel p) {
        this.setSize(1200, 570);
        p.setLayout(new BorderLayout(0, 0));
        ptop = new JPanel();
        ptop.setPreferredSize(new Dimension(1200, 70));
        ptop.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        ptop.setBackground(new Color(102, 217, 255));
//        ptop.setBackground(Color.red);
        ptop.setLayout(null);
        ltitle = new JLabel("Phiếu Nhập Hàng");
        ltitle.setFont(new Font("", Font.CENTER_BASELINE, 22));
        ltitle.setBounds(475, 5, 250, 25);
        ptop.add(ltitle);
        pmain = new JPanel();
        pmain.setPreferredSize(new Dimension(1200, 500));
        pmain.setLayout(new BorderLayout(0, 0));
//        pmain.setBackground(Color.LIGHT_GRAY);

        pleft = new JPanel();
        pleft.setLayout(null);
//        pleft.setBackground(Color.PINK);
        pleft.setPreferredSize(new Dimension(400, 500));
        pleft.setBorder(new MatteBorder(0, 0, 0, 1, Color.BLACK));
        pmain.add(pleft, BorderLayout.WEST);
        pmain.setBorder(new MatteBorder(1, 0, 0, 0, Color.BLACK));
        pright = new JPanel();
        pright.setPreferredSize(new Dimension(800, 500));
        pright.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
//        pright.setBackground(Color.YELLOW);
        pmain.add(pright, BorderLayout.EAST);

        lphieu = new JLabel("Thông tin nhập hàng");
        MaMH = new JLabel("Mã mặt hàng:");
        TenMH = new JLabel("Tên mặt hàng :");
        GiaMH = new JLabel("Giá tiền :");
        Soluong = new JLabel("Số Lượng :");
        Ncc = new JLabel("Nhà cung cấp :");

        lphieu.setBounds(125, 10, 200, 30);
        MaMH.setBounds(10, 50, 120, 30);
        TenMH.setBounds(10, 90, 120, 30);
        GiaMH.setBounds(10, 130, 120, 30);
        Soluong.setBounds(10, 170, 120, 30);
        Ncc.setBounds(10, 210, 120, 30);

        MaMH.setFont(new Font("", Font.BOLD, 16));
        TenMH.setFont(new Font("", Font.BOLD, 16));
        GiaMH.setFont(new Font("", Font.BOLD, 16));
        Soluong.setFont(new Font("", Font.BOLD, 16));
        Ncc.setFont(new Font("", Font.BOLD, 16));
        lphieu.setFont(new Font("", Font.BOLD, 18));

        pleft.add(MaMH);
        pleft.add(TenMH);
        pleft.add(GiaMH);
        pleft.add(Soluong);
        pleft.add(Ncc);
        pleft.add(lphieu);

        txtmaMH = new JTextField();
        txttenMH = new JTextField();
        txtgiaMH = new JTextField("0");
        txtsoluongMH = new JTextField("0");
        txtnccMH = new JTextField();

        txtmaMH.setBounds(130, 50, 200, 30);
        txttenMH.setBounds(130, 90, 200, 30);
        txtgiaMH.setBounds(130, 130, 200, 30);
        txtsoluongMH.setBounds(130, 170, 200, 30);
        txtnccMH.setBounds(130, 210, 200, 30);

        pleft.add(txtmaMH);
        pleft.add(txttenMH);
        pleft.add(txtgiaMH);
        pleft.add(txtsoluongMH);
        pleft.add(txtnccMH);

        btnthem = new JButton("Thêm");
        btnsua = new JButton("Sửa");
        btnxoa = new JButton("Xóa");
        btnin = new JButton("In");

        btnthem.setBounds(5, 270, 190, 40);
        btnsua.setBounds(205, 270, 190, 40);
        btnxoa.setBounds(5, 320, 190, 40);
        btnin.setBounds(205, 320, 190, 40);

        btnthem.setBackground(new Color(0, 164, 128));
        btnsua.setBackground(new Color(0, 164, 128));
        btnxoa.setBackground(new Color(0, 164, 128));
        btnin.setBackground(new Color(0, 164, 128));

        pleft.add(btnthem);
        pleft.add(btnsua);
        pleft.add(btnxoa);
        pleft.add(btnin);
        String[][] data = {
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null}
        };
        String[] title_data = {"STT", "Mã hàng", "Tên hàng", "Đơn giá", "Số lượng", "Nhầ cung cấp", "Tổng tiền"};
        tb = new JTable();
        tb.setModel(new javax.swing.table.DefaultTableModel(data, title_data) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tb.setPreferredScrollableViewportSize(new Dimension(800, 500));
        s = new JScrollPane();
        s.setViewportView(tb);
        pright.add(s);
        p.add(pmain, BorderLayout.SOUTH);
        p.add(ptop, BorderLayout.NORTH);
        btnthem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    them(e); //To change body of generated methods, choose Tools | Templates.
                } catch (Exception ex) {
                    Logger.getLogger(Phieu_Nhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnsua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    sua(e); //To change body of generated methods, choose Tools | Templates.
                } catch (Exception ex) {
                    Logger.getLogger(Phieu_Nhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnxoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    xoa(e); //To change body of generated methods, choose Tools | Templates.
                } catch (Exception ex) {
                    Logger.getLogger(Phieu_Nhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                in(e); //To change body of generated methods, choose Tools | Templates.
            }
        });

    }

    private void them(MouseEvent e) throws Exception {
        phieunhapDTO pn = new phieunhapDTO();
        pn.setMaMH(txtmaMH.getText());
        pn.setTenMH(txttenMH.getText());
        pn.setGia(Integer.valueOf(txtgiaMH.getText()));
        pn.setSoluong(Integer.valueOf(txtsoluongMH.getText()));
        pn.setNcc(txtnccMH.getText());
        int tong = Integer.valueOf(txtgiaMH.getText()) * Integer.valueOf(txtsoluongMH.getText());
        pn.setTongtien(tong);
        phieunhaphangBUS pnh = new phieunhaphangBUS();
        if (pnh.insert(pn) == true) {
            JOptionPane.showMessageDialog(null, "Thêm thành công !!");
            showtable();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm không thành công !!");
        }

    }

    void reset() {
        txtgiaMH.setText("0");
        txtmaMH.setText("");
        txtnccMH.setText("");
        txtsoluongMH.setText("0");
        txttenMH.setText("");
    }

    private void sua(MouseEvent e) throws Exception {
        phieunhapDTO pn = new phieunhapDTO();
        pn.setMaMH(txtmaMH.getText());
        pn.setTenMH(txttenMH.getText());
        pn.setGia(Integer.valueOf(txtgiaMH.getText()));
        pn.setSoluong(Integer.valueOf(txtsoluongMH.getText()));
        pn.setNcc(txtnccMH.getText());
        int tong = Integer.valueOf(txtgiaMH.getText()) * Integer.valueOf(txtsoluongMH.getText());
        pn.setTongtien(tong);
        pn.setId(id);
        phieunhaphangBUS pnhbus = new phieunhaphangBUS();
        if (pnhbus.update(pn) == true) {
            JOptionPane.showMessageDialog(null, "Sửa thành công !!");
            showtable();
        } else {
            JOptionPane.showMessageDialog(null, "Sửa không thành công !!");
        }

    }

    private void xoa(MouseEvent e) throws Exception {
        phieunhaphangBUS pnhbus = new phieunhaphangBUS();
        if (pnhbus.delete(id) == true) {
            JOptionPane.showMessageDialog(null, "Xóa thành công !!");
            showtable();
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thành công !!");
        }

        reset();
    }

    private void in(MouseEvent e) {
        tablemodel = (DefaultTableModel) tb.getModel();
        if (tablemodel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đon cần in !!");
        } else {
            ExcelReport exel = new ExcelReport();
            exel.ExportExcel("DSkhachhang", tb);
        }
    }

    JPanel ptop;
    JLabel ltitle;
    JPanel pmain;
    JPanel pleft;
    JPanel pright;

    JLabel MaMH;
    JLabel TenMH;
    JLabel GiaMH;
    JLabel Soluong;
    JLabel Ncc;

    JTextField txtmaMH;
    JTextField txttenMH;
    JTextField txtgiaMH;
    JTextField txtsoluongMH;
    JTextField txtnccMH;

    JButton btnthem;
    JButton btnsua;
    JButton btnxoa;
    JButton btnin;

    JTable tb;
    JScrollPane s;
    JLabel lphieu;
}
