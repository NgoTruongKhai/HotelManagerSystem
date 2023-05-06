/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminGUI;

import static AdminGUI.Quan_Li_Nhan_Vien.qlnv;
import BUS.nhanvienBUS;
import QLKS.DTO.nhanvienDTO;
import QLKS.GUI.thongtin;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class nhanvien extends JPanel {

    public nhanvien() {

        this.setSize(510, 470);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JPanel pcontainer = new JPanel();
        pcontainer.setPreferredSize(new Dimension(510, 470));
        pcontainer.setLayout(null);
        pcontainer.setBorder(new MatteBorder(0, 1, 0, 1, Color.BLACK));
        pmanv = new JPanel();
        l_title = new JLabel("THÔNG TIN NHÂN VIÊN");
        l_ho = new JLabel("Họ :");
        l_ten = new JLabel("Tên :");
        l_maKH = new JLabel("MaNV :");
        l_gioitinh = new JLabel("Giới tính :");
        l_ngaysinh = new JLabel("Ngày sinh :");
        l_dienthoai = new JLabel("Điện thoại :");
        l_diachi = new JLabel("Địa chỉ :");
        lcv = new JLabel("Chức Vụ :");
        lluong = new JLabel("Lương :");

        txtho = new JTextField();
        txtten = new JTextField();
        txtcmnd = new JTextField();
        txtdienthoai = new JTextField();
        txtdiachi = new JTextField();
        txtluong = new JTextField();
        txtluong.setText("0");
        rdnam = new JRadioButton("Nam");
        rdnu = new JRadioButton("Nữ");
        rdkhac = new JRadioButton("Khác");

        btngrgioitinh = new ButtonGroup();
        btnluu = new JButton("Thêm");
        btnnhaplai = new JButton("Nhập lại");

        jDateChooser1 = new JDateChooser();
        DefaultComboBoxModel cityName = new DefaultComboBoxModel();
        cityName.addElement("Phục vụ");
        cityName.addElement("Thu ngân");
        cityName.addElement("Bảo vệ");
        cityName.addElement("Tạp vụ");

        cbcv = new JComboBox(cityName);

        l_title.setFont(new Font("", Font.BOLD, 18));
        l_ho.setFont(new Font("", Font.BOLD, 16));
        l_ten.setFont(new Font("", Font.BOLD, 16));
        l_maKH.setFont(new Font("", Font.BOLD, 16));
        l_gioitinh.setFont(new Font("", Font.BOLD, 16));
        l_title.setBounds(140, 0, 250, 40);
        l_ngaysinh.setFont(new Font("", Font.BOLD, 16));
        l_dienthoai.setFont(new Font("", Font.BOLD, 16));
        l_diachi.setFont(new Font("", Font.BOLD, 16));
        lcv.setFont(new Font("", Font.BOLD, 16));
        lluong.setFont(new Font("", Font.BOLD, 16));

        btnluu.setFont(new Font("", Font.BOLD, 18));
        btnnhaplai.setFont(new Font("", Font.BOLD, 18));

        l_ho.setBounds(50, 50, 40, 30);
        l_ten.setBounds(260, 50, 40, 30);
        l_maKH.setBounds(50, 90, 60, 30);
        l_gioitinh.setBounds(50, 130, 80, 30);
        l_ngaysinh.setBounds(50, 170, 90, 30);
        l_dienthoai.setBounds(50, 210, 90, 30);
        l_diachi.setBounds(50, 250, 90, 30);
        lcv.setBounds(50, 290, 90, 30);
        lluong.setBounds(50, 330, 90, 30);

        txtho.setBounds(145, 53, 100, 25);
        txtten.setBounds(345, 53, 100, 25);
        pmanv.setBounds(145, 95, 300, 25);
        txtdienthoai.setBounds(145, 213, 300, 25);
        txtdiachi.setBounds(145, 253, 300, 25);
        txtluong.setBounds(145, 335, 300, 25);

        jDateChooser1.setBounds(145, 173, 200, 25);

        rdnam.setBounds(145, 130, 60, 30);
        rdnu.setBounds(210, 130, 60, 30);
        rdkhac.setBounds(275, 130, 60, 30);

        cbcv.setBounds(145, 290, 300, 30);

        btnluu.setBounds(50, 370, 190, 40);
        btnnhaplai.setBounds(250, 370, 190, 40);

        btngrgioitinh.add(rdnam);
        btngrgioitinh.add(rdnu);
        btngrgioitinh.add(rdkhac);

        rdnam.setSelected(true);

        btnluu.setBackground(new Color(0, 164, 128));
        btnnhaplai.setBackground(new Color(0, 164, 128));
        pmanv.setBackground(Color.DARK_GRAY);
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
        pcontainer.add(lcv);
        pcontainer.add(lluong);

        pcontainer.add(txtho);
        pcontainer.add(txtten);
        pcontainer.add(pmanv);
        pcontainer.add(txtdienthoai);
        pcontainer.add(txtdiachi);
        pcontainer.add(txtluong);
        pcontainer.add(rdkhac);
        pcontainer.add(rdnu);
        pcontainer.add(rdnam);

        pcontainer.add(btnnhaplai);
        pcontainer.add(btnluu);

        pcontainer.add(jDateChooser1);

        pcontainer.add(cbcv);

        this.add(pcontainer);

    }

    private void btn_luu(MouseEvent evt) throws Exception {
        nhanvienDTO nv = new nhanvienDTO();
        nv.setHo(txtho.getText());
        nv.setTen(txtten.getText());
        String date = formatter1.format(jDateChooser1.getDate());
        nv.setNgaysinh(date);
        nv.setSdt(txtdienthoai.getText());
        nv.setChucvu((String) cbcv.getSelectedItem());
        nv.setLuong(Integer.valueOf(txtluong.getText()));
        if (rdnam.isSelected()) {
            nv.setGioitinh(rdnam.getText());
        }
        if (rdnu.isSelected()) {
            nv.setGioitinh(rdnu.getText());
        }
        if (rdkhac.isSelected()) {
            nv.setGioitinh(rdkhac.getText());
        }
        nhanvienBUS nvbus = new nhanvienBUS();

        nv.setMa_nv(nvbus.newma_nv());
        nv.setDiachi(txtdiachi.getText());

        if (btnluu.getText().equalsIgnoreCase("Thêm")) {
            if (nvbus.insert(nv) == true) {
                JOptionPane.showMessageDialog(null, "Thêm thàng công !!");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm không thàng công !!");
            }
        }
        if (btnluu.getText().equalsIgnoreCase("Lưu")) {
            nv.setId(id);
            if (nvbus.update(nv) == true) {
                JOptionPane.showMessageDialog(null, "Sửa thàng công !!");
            } else {
                JOptionPane.showMessageDialog(null, "Sửa không thàng công !!");
            }
        }

    }

    private void btn_nhaplai(MouseEvent evt) {
        txtcmnd.setText("");
        txtdiachi.setText("");
        txtdienthoai.setText("");
        txtho.setText("");
        txtluong.setText("0");
        txtten.setText("");
        rdnam.setSelected(false);
        rdnu.setSelected(false);
        rdkhac.setSelected(false);
    }

    JLabel l_title;
    JLabel l_ho;
    JLabel l_ten;
    JLabel l_maKH;
    JLabel l_gioitinh;
    JLabel l_ngaysinh;
    JLabel l_dienthoai;
    JLabel l_diachi;
    JLabel lcv;
    JLabel lluong;

    JTextField txtho;
    JTextField txtten;
    JTextField txtcmnd;
    JTextField txtdienthoai;
    JTextField txtdiachi;
    JTextField txtluong;
    JComboBox cbcv;

    JRadioButton rdnam;
    JRadioButton rdnu;
    JRadioButton rdkhac;

    ButtonGroup btngrgioitinh;

    JButton btnluu;
    JButton btnnhaplai;

    JDateChooser jDateChooser1;
    DateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {
        new nhanvien().setVisible(true);
    }

    void setall(nhanvienDTO nv) {

        txtcmnd.setText(nv.getMa_nv());
        txtdiachi.setText(nv.getDiachi());
        txtdienthoai.setText(nv.getSdt());
        txtho.setText(nv.getHo());
        txtten.setText(nv.getTen());
        txtluong.setText(String.valueOf(nv.getLuong()));
        id = nv.getId();

    }
    int id;
    JPanel pmanv;

    void setbtnluu(String luu) {
        btnluu.setText(luu);
    }
}
