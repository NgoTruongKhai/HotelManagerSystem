/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.GUI;

import BUS.khachhangBUS;
import QLKS.DTO.khachhangDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author ASUS
 */
public class thongtin extends JFrame {

    String temp;

    public thongtin() throws HeadlessException {
        init();
        applicationcenter(true);
    }

    private void applicationcenter(boolean x) {
        if (x == true) {
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int w = this.getWidth();
            int h = this.getHeight() + 100;
            int a = (dim.width - w) / 2;
            int b = (dim.height - h) / 2;
            this.setLocation(a, b);
        }
    }

    private void init() {

        this.setSize(510, 450);
        this.setBackground(Color.yellow);
        this.setUndecorated(true);

        JPanel pcontainer = new JPanel();
        pcontainer.setPreferredSize(new Dimension(510, 450));
        pcontainer.setLayout(null);
        pcontainer.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        l_title = new JLabel("THÔNG TIN KHÁCH HÀNG");
        l_ho = new JLabel("Họ :");
        l_ten = new JLabel("Tên :");
        l_maKH = new JLabel("CMND :");
        l_gioitinh = new JLabel("Giới tính :");
        l_ngaysinh = new JLabel("Ngày sinh :");
        l_dienthoai = new JLabel("Điện thoại :");
        l_diachi = new JLabel("Địa chỉ :");

        txtho = new JTextField();
        txtten = new JTextField();
        txtcmnd = new JTextField();
        txtdienthoai = new JTextField();
        txtdiachi = new JTextField();

        rdnam = new JRadioButton("Nam");
        rdnu = new JRadioButton("Nữ");
        rdkhac = new JRadioButton("Khác");

        btngrgioitinh = new ButtonGroup();
        btnluu = new JButton("Thêm");
        btnhuy = new JButton("Hủy");
        btnnhaplai = new JButton("Nhập lại");

        jDateChooser1 = new JDateChooser();

        l_title.setFont(new Font("", Font.BOLD, 18));
        l_ho.setFont(new Font("", Font.BOLD, 16));
        l_ten.setFont(new Font("", Font.BOLD, 16));
        l_maKH.setFont(new Font("", Font.BOLD, 16));
        l_gioitinh.setFont(new Font("", Font.BOLD, 16));
        l_title.setBounds(140, 0, 250, 40);
        l_ngaysinh.setFont(new Font("", Font.BOLD, 16));
        l_dienthoai.setFont(new Font("", Font.BOLD, 16));
        l_diachi.setFont(new Font("", Font.BOLD, 16));

        btnluu.setFont(new Font("", Font.BOLD, 18));
        btnhuy.setFont(new Font("", Font.BOLD, 18));
        btnnhaplai.setFont(new Font("", Font.BOLD, 18));

        l_ho.setBounds(50, 60, 40, 30);
        l_ten.setBounds(260, 70, 40, 30);
        l_maKH.setBounds(50, 110, 60, 30);
        l_gioitinh.setBounds(50, 150, 80, 30);
        l_ngaysinh.setBounds(50, 190, 90, 30);
        l_dienthoai.setBounds(50, 230, 90, 30);
        l_diachi.setBounds(50, 270, 90, 30);

        txtho.setBounds(145, 73, 100, 25);
        txtten.setBounds(345, 73, 100, 25);
        txtcmnd.setBounds(145, 115, 300, 25);
        txtdienthoai.setBounds(145, 233, 300, 25);
        txtdiachi.setBounds(145, 273, 300, 25);

        jDateChooser1.setBounds(145, 193, 200, 25);

        rdnam.setBounds(145, 150, 60, 30);
        rdnu.setBounds(210, 150, 60, 30);
        rdkhac.setBounds(275, 150, 60, 30);

        btnluu.setBounds(50, 320, 190, 40);
        btnhuy.setBounds(250, 320, 190, 40);
        btnnhaplai.setBounds(150, 370, 190, 40);

        btngrgioitinh.add(rdnam);
        btngrgioitinh.add(rdnu);
        btngrgioitinh.add(rdkhac);

        rdnam.setSelected(true);

        btnluu.setBackground(new Color(0, 164, 128));
        btnhuy.setBackground(new Color(0, 164, 128));
        btnnhaplai.setBackground(new Color(0, 164, 128));

        jDateChooser1.setDateFormatString("dd-MM-yyyy");
        jDateChooser1.setLocale(Locale.forLanguageTag("vi-VN"));

        btnluu.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    btn_luu(evt);
                } catch (Exception ex) {
                    Logger.getLogger(thongtin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnhuy.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_huy(evt);
            }
        });

        btnnhaplai.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nhaplai(evt);
            }

        });

        pcontainer.add(l_title);
        pcontainer.add(l_ho);
        pcontainer.add(l_ten);
        pcontainer.add(l_maKH);
        pcontainer.add(l_gioitinh);
        pcontainer.add(l_ngaysinh);
        pcontainer.add(l_dienthoai);
        pcontainer.add(l_diachi);

        pcontainer.add(txtho);
        pcontainer.add(txtten);
        pcontainer.add(txtcmnd);
        pcontainer.add(txtdienthoai);
        pcontainer.add(txtdiachi);

        pcontainer.add(rdkhac);
        pcontainer.add(rdnu);
        pcontainer.add(rdnam);

        pcontainer.add(btnnhaplai);
        pcontainer.add(btnhuy);
        pcontainer.add(btnluu);

        pcontainer.add(jDateChooser1);

        this.add(pcontainer);

    }

    ;

    private void btn_luu(MouseEvent evt) throws Exception {
        khachhangBUS khbus = new khachhangBUS();
        khachhangDTO kh = new khachhangDTO();
        kh.ho = txtho.getText();
        kh.ten = txtten.getText();
        kh.ma_kh = txtcmnd.getText();
        if (rdnam.isSelected()) {
            kh.gioitinh = rdnam.getText();
        }
        if (rdnu.isSelected()) {
            kh.gioitinh = rdnu.getText();
        }
        if (rdkhac.isSelected()) {
            kh.gioitinh = rdkhac.getText();
        }
        DateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
        kh.ngaysinh = formatter1.format(jDateChooser1.getDate());

        kh.sdt = txtdienthoai.getText();
        kh.diachi = txtdiachi.getText();

        if (btnluu.getText().equalsIgnoreCase("Thêm")) {
            if (khbus.insert(kh) == true) {
                JOptionPane.showMessageDialog(null, "Thêm thàng công !!");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm không thàng công !!");
            }
        }
        if (btnluu.getText().equalsIgnoreCase("Lưu")) {
            if (khbus.update(kh, temp) == true) {
                JOptionPane.showMessageDialog(null, "Sửa thàng công !!");
            } else {
                JOptionPane.showMessageDialog(null, "Sửa không thàng công !!");
            }

        }
        this.dispose();

    }

    private void btn_huy(MouseEvent evt) {
//        this.setVisible(false);
        this.dispose();
    }

    private void btn_nhaplai(MouseEvent evt) {
        reset();
    }

    void reset() {
        txtho.setText("");
        txtten.setText("");
        txtcmnd.setText("");
        txtdiachi.setText("");
        txtdienthoai.setText("");
        rdkhac.setSelected(false);
        rdnu.setSelected(false);
        rdnam.setSelected(false);
    }

    void setTxtcmnd(String ma_kh) {
        txtcmnd.setText(ma_kh);
        temp = txtcmnd.getText();
    }

    String gettxt() {
        return txtcmnd.getText();
    }

    void setTxtho(String ho) {
        txtho.setText(ho);
    }

    void setTxtten(String ten) {
        txtten.setText(ten);
    }

    void setTxtdiachi(String diachi) {
        txtdiachi.setText(diachi);
    }

    void setTxtdienthoai(String sdt) {
        txtdienthoai.setText(sdt);
    }

    void setRdnam(String gioitinh) {
        rdnam.setSelected(true);
    }

    void setRdnu(String gioitinh) {
        rdnu.setSelected(true);
    }

    void setRdkhac(String gioitinh) {
        rdkhac.setSelected(true);
    }

    void resetrdnam(String giotinh) {
        rdnam.setSelected(false);
    }
    private JLabel l_title;
    private JLabel l_ho;
    private JLabel l_ten;
    private JLabel l_maKH;
    private JLabel l_gioitinh;
    private JLabel l_ngaysinh;
    private JLabel l_dienthoai;
    private JLabel l_diachi;

    private JTextField txtho;
    private JTextField txtten;
    private JTextField txtcmnd;
    private JTextField txtdienthoai;
    private JTextField txtdiachi;

    private JRadioButton rdnam;
    private JRadioButton rdnu;
    private JRadioButton rdkhac;

    private ButtonGroup btngrgioitinh;

    private JButton btnluu;
    private JButton btnhuy;
    private JButton btnnhaplai;

    private JDateChooser jDateChooser1;

    void setbtnluu(String luu) {
        btnluu.setText(luu);
    }

}
