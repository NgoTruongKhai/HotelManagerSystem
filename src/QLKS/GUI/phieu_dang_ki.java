package QLKS.GUI;

import BUS.dichvuBUS;
import static BUS.dichvuBUS.dvList;
import BUS.khachhangBUS;
import static BUS.khachhangBUS.khList;
import BUS.phieudangkiBUS;
import static BUS.phieudangkiBUS.pdkList;
import BUS.phongBUS;
import static BUS.phongBUS.phongList;
import QLKS.DTO.khachhangDTO;
import QLKS.DTO.phieudangkiDTO;
import static QLKS.GUI.Login.taikhoan;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public final class phieu_dang_ki extends JFrame {

    java.util.Date date1 = new java.util.Date();
    public static phieu_dang_ki pdk;

    public phieu_dang_ki() throws Exception {
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

    public void init() throws Exception {
        this.setSize(510, 550);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setUndecorated(true);

        lmanv = new JLabel();
        lmanv.setText(taikhoan);

        pcontainer = new JPanel();
        ptitle = new JPanel();
        pmain = new JPanel();
        ltitle = new JLabel();
        btngrgioitinh = new ButtonGroup();
        jDateChooser1 = new JDateChooser();
        jDateChooser2 = new JDateChooser();

        pcontainer.setPreferredSize(new Dimension(510, 550));
        pcontainer.setLayout(new BorderLayout(0, 0));
        pcontainer.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        ptitle.setPreferredSize(new Dimension(510, 50));
        ptitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        ptitle.setBounds(0, 0, 510, 50);

        pmain.setPreferredSize(new Dimension(510, 549));
        pmain.setLayout(null);

        pmain.add(ptitle);
        ltitle.setFont(new Font("", Font.BOLD, 20));
        ltitle.setForeground(new Color(0, 172, 230));

        l_ho = new JLabel("Họ :");
        l_ten = new JLabel("Tên :");
        l_maKH = new JLabel("CMND :");
        l_gioitinh = new JLabel("Giới tính :");
        l_ngaysinh = new JLabel("Ngày sinh :");
        l_dienthoai = new JLabel("Điện thoại :");
        l_diachi = new JLabel("Địa chỉ :");
        l_ngaynhanphong = new JLabel("Ngày nhận phòng :");
        ldv = new JLabel("Dịch vụ :");
        lkhuyen_mai = new JLabel("Mã khuyến mãi :");

        txtho = new JTextField();
        txtten = new JTextField();
        txtcmnd = new JTextField();
        txtdienthoai = new JTextField();
        txtdiachi = new JTextField();
        txtkhuyenmai = new JTextField();

        rdnam = new JRadioButton("Nam");
        rdnu = new JRadioButton("Nữ");
        rdkhac = new JRadioButton("Khác");

        btnmo = new JButton("Mở");
        btndattruoc = new JButton("Đặt trước");
        btnhuy = new JButton("Hủy");

        l_ho.setFont(new Font("", Font.BOLD, 16));
        l_ten.setFont(new Font("", Font.BOLD, 16));
        l_maKH.setFont(new Font("", Font.BOLD, 16));
        l_gioitinh.setFont(new Font("", Font.BOLD, 16));
        l_ngaysinh.setFont(new Font("", Font.BOLD, 16));
        l_dienthoai.setFont(new Font("", Font.BOLD, 16));
        l_diachi.setFont(new Font("", Font.BOLD, 16));
        l_ngaynhanphong.setFont(new Font("", Font.BOLD, 16));
        ldv.setFont(new Font("", Font.BOLD, 16));
        lkhuyen_mai.setFont(new Font("", Font.BOLD, 16));

        l_ho.setBounds(50, 60, 40, 30);
        l_ten.setBounds(260, 70, 40, 30);
        l_maKH.setBounds(50, 110, 60, 30);
        l_gioitinh.setBounds(50, 150, 80, 30);
        l_ngaysinh.setBounds(50, 190, 90, 30);
        l_dienthoai.setBounds(50, 230, 90, 30);
        l_diachi.setBounds(50, 270, 90, 30);
        l_ngaynhanphong.setBounds(50, 310, 150, 30);
        ldv.setBounds(50, 350, 90, 30);
        lkhuyen_mai.setBounds(50, 390, 150, 30);

        txtho.setBounds(145, 73, 100, 25);
        txtten.setBounds(345, 73, 100, 25);
        txtcmnd.setBounds(145, 115, 300, 25);
        txtdienthoai.setBounds(145, 233, 300, 25);
        txtdiachi.setBounds(145, 273, 300, 25);
        txtkhuyenmai.setBounds(195, 390, 250, 25);

        rdnam.setBounds(145, 150, 60, 30);
        rdnu.setBounds(210, 150, 60, 30);
        rdkhac.setBounds(275, 150, 60, 30);

        btnmo.setBounds(50, 450, 190, 40);
        btndattruoc.setBounds(250, 450, 190, 40);
        btnhuy.setBounds(165, 500, 190, 40);

        jDateChooser1.setBounds(145, 193, 200, 25);
        jDateChooser2.setBounds(195, 313, 200, 25);

        btngrgioitinh.add(rdnam);
        btngrgioitinh.add(rdnu);
        btngrgioitinh.add(rdkhac);

        jDateChooser1.setDateFormatString("dd-MM-yyyy");
        jDateChooser1.setLocale(Locale.forLanguageTag("vi-VN"));

        jDateChooser2.setDateFormatString("dd-MM-yyyy");
        jDateChooser2.setLocale(Locale.forLanguageTag("vi-VN"));

        btnmo.setBackground(new Color(0, 164, 128));
        btndattruoc.setBackground(new Color(0, 164, 128));
        btnhuy.setBackground(new Color(0, 164, 128));

        DefaultComboBoxModel cityName = new DefaultComboBoxModel();
        dichvuBUS dv = new dichvuBUS();
        dv.dsdv();
        for (int i = 0; i < dvList.size(); i++) {
            cityName.addElement(dvList.get(i).getTen_dv());
        }

        cbdv = new JComboBox(cityName);
        cbdv.setBounds(145, 350, 300, 25);
        pcontainer.add(pmain, BorderLayout.SOUTH);
        ptitle.add(ltitle);

        pmain.add(l_ho);
        pmain.add(l_ten);
        pmain.add(l_maKH);
        pmain.add(l_gioitinh);
        pmain.add(l_ngaysinh);
        pmain.add(l_dienthoai);
        pmain.add(l_diachi);
        pmain.add(l_ngaynhanphong);
        pmain.add(ldv);
        pmain.add(lkhuyen_mai);

        pmain.add(txtho);
        pmain.add(txtten);
        pmain.add(txtcmnd);
        pmain.add(txtdienthoai);
        pmain.add(txtdiachi);
        pmain.add(txtkhuyenmai);

        pmain.add(rdkhac);
        pmain.add(rdnu);
        pmain.add(rdnam);

        pmain.add(btnmo);
        pmain.add(btndattruoc);
        pmain.add(btnhuy);

        pmain.add(jDateChooser1);
        pmain.add(jDateChooser2);

        pmain.add(cbdv);
        this.add(pcontainer);

        txtcmnd.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                try {
                    txtcmd(evt);
                } catch (Exception ex) {
                    Logger.getLogger(phieu_dang_ki.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        btnmo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    btnmo(evt);
                } catch (Exception ex) {
                    Logger.getLogger(phieu_dang_ki.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        btnhuy.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhuy(evt);
            }

        });

        btndattruoc.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    btndattruoc(evt);
                } catch (Exception ex) {
                    Logger.getLogger(phieu_dang_ki.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

    }


    private void btnmo(MouseEvent evt) throws Exception {
        khachhangBUS khbus = new khachhangBUS();
        khbus.dskh();
        phieudangkiBUS pdkbus = new phieudangkiBUS();
        pdkbus.dspdk();
        phongBUS ph = new phongBUS();
        ph.dsphong();

        khachhangDTO kh = new khachhangDTO();
        phieudangkiDTO dk = new phieudangkiDTO();
        String date = formatter1.format(jDateChooser1.getDate());

        kh.setHo(txtho.getText());
        kh.setTen(txtten.getText());
        if (rdnam.isSelected()) {
            kh.setGioitinh(rdnam.getText());
        }

        if (rdnu.isSelected()) {
            kh.setGioitinh(rdnu.getText());
        }
        if (rdkhac.isSelected()) {
            kh.setGioitinh(rdkhac.getText());
        }
        kh.setDiachi(txtdiachi.getText());
        kh.setMa_kh(txtcmnd.getText());
        kh.setNgaysinh(date);
        kh.setSdt(txtdienthoai.getText());
        dk.setMa_khach_hang(txtcmnd.getText());
//        dk.setMa_nv(date);
        dk.setMa_phong(ltitle.getText());
        dk.setMa_nv(lmanv.getText());
//        ArrayList<dichvuDTO> dvList=dichvuDAL.findall();
        dichvuBUS dvbus = new dichvuBUS();
        dvbus.dsdv();
        for (int i = 0; i < dvList.size(); i++) {
            if (dvList.get(i).getTen_dv().equalsIgnoreCase((String) cbdv.getSelectedItem())) {
                dk.setMa_dv(dvList.get(i).getMa_dv());
            }
        }

        dk.setMa_km(txtkhuyenmai.getText());
        if (btnmo.getText().equalsIgnoreCase("Mở phòng")) {
            for (int i = 0; i < phongList.size(); i++) {
                if (phongList.get(i).getMa_phong().equalsIgnoreCase(ltitle.getText())) {
                    ph.updatephong(phongList.get(i).getMa_phong(), 3);
                }
            }
            pdkbus.dspdk();
            for (int i = 0; i < pdkList.size(); i++) {
                if (pdkList.get(i).getMa_phieu() == x) {
                    dk.setMa_phieu(x);
                    dk.setNgaydatphong(pdkList.get(i).getNgaydatphong());
                    dk.setNgaynhanphong(formatter1.format(date1));
                    dk.setTrangthai(0);
                }
            }

            pdkbus.update(dk);
            if (insert() == true) {
                khbus.insert(kh);
            }
        }
        if (btnmo.getText().equalsIgnoreCase("Mở")) {
            dk.setNgaynhanphong(formatter1.format(date1));
            dk.setNgaydatphong(formatter1.format(date1));
            dk.setTrangthai(0);
            if (pdkbus.insert(dk, kh) == true) {
                for (int i = 0; i < phongList.size(); i++) {
                    if (phongList.get(i).getMa_phong().equalsIgnoreCase(ltitle.getText())) {
                        ph.updatephong(phongList.get(i).getMa_phong(), 3);
                    }
                }
                JOptionPane.showMessageDialog(null, "Mở phòng thành công !!");
            }
            if (insert() == true) {

                khbus.insert(kh);
            }
        }

//        if (btnmo.getText().equalsIgnoreCase("Thanh toán")) {
//            for (int i = 0; i < phList.size(); i++) {
//                if (phList.get(i).getMa_phong().equalsIgnoreCase(ltitle.getText())) {
//                    phongDAL.updatephong(phList.get(i).getMa_phong(), 1);
//                }
//            }
//            dk.setNgaytraphong(formatter1.format(date1));
//            dk.setTrangthai(1);
//            ArrayList<phieudangkiDTO> pdkList = phieudangkiDAL.findall();
//            for(int i=0;i<pdkList.size();i++){
//                if(pdkList.get(i).getMa_phieu()==x){
//                   dk.setMa_phieu(x);
//                   dk.setNgaydatphong(pdkList.get(i).getNgaydatphong());
//                   dk.setNgaynhanphong(pdkList.get(i).getNgaynhanphong());
//                }
//            }
//            phieudangkiDAL.update(dk);
//            
//        }
        Quan_Li_Khach_San.conection.reLoad();
        this.dispose();
    }

    private void btnhuy(MouseEvent evt) {
        this.dispose();
    }

    private void btndattruoc(MouseEvent evt) throws Exception {
        khachhangBUS khbus = new khachhangBUS();
        phieudangkiBUS pdkbus = new phieudangkiBUS();
        phongBUS ph = new phongBUS();
        ph.dsphong();

        khachhangDTO kh = new khachhangDTO();
        phieudangkiDTO dk = new phieudangkiDTO();
        String date = formatter1.format(jDateChooser1.getDate());

        kh.setHo(txtho.getText());
        kh.setTen(txtten.getText());
        if (rdnam.isSelected()) {
            kh.setGioitinh(rdnam.getText());
        }
        if (rdnu.isSelected()) {
            kh.setGioitinh(rdnu.getText());
        }
        if (rdkhac.isSelected()) {
            kh.setGioitinh(rdkhac.getText());
        }
        kh.setDiachi(txtdiachi.getText());
        kh.setMa_kh(txtcmnd.getText());
        kh.setNgaysinh(date);
        kh.setSdt(txtdienthoai.getText());
        dk.setMa_khach_hang(txtcmnd.getText());
//        dk.setMa_nv(date);
        dk.setMa_nv(lmanv.getText());
        dk.setMa_phong(ltitle.getText());
        dichvuBUS dv = new dichvuBUS();
        dv.dsdv();
        for (int i = 0; i < dvList.size(); i++) {
            if (dvList.get(i).getTen_dv().equalsIgnoreCase((String) cbdv.getSelectedItem())) {
                dk.setMa_dv(dvList.get(i).getMa_dv());
            }
        }

        dk.setMa_km(txtkhuyenmai.getText());
        if (btndattruoc.getText().equalsIgnoreCase("Đặt trước")) {

            dk.setNgaydatphong(formatter1.format(jDateChooser2.getDate()));
            dk.setTrangthai(0);
            if (pdkbus.insert(dk, kh) == true) {
                for (int i = 0; i < phongList.size(); i++) {
                    if (phongList.get(i).getMa_phong().equalsIgnoreCase(ltitle.getText())) {
                        ph.updatephong(phongList.get(i).getMa_phong(), 2);
                    }
                }
            }
            if (insert() == true) {
                khbus.insert(kh);
            }

        }
        if (btndattruoc.getText().equalsIgnoreCase("Hủy đặt phòng")) {
            for (int i = 0; i < phongList.size(); i++) {
                if (phongList.get(i).getMa_phong().equalsIgnoreCase(ltitle.getText())) {
                    ph.updatephong(phongList.get(i).getMa_phong(), 1);
                }
            }
            pdkbus.delete(x);
        }

        Quan_Li_Khach_San.conection.reLoad();
        this.dispose();
    }

    private void txtcmd(KeyEvent evt) throws Exception {
        setthongtin(txtcmnd.getText());
    }

    void setthongtin(String ma_kh) throws Exception {
        txtcmnd.setText(ma_kh);
        khachhangBUS khbus = new khachhangBUS();
        khbus.dskh();
        for (int i = 0; i < khList.size(); i++) {
            if (khList.get(i).getMa_kh().equalsIgnoreCase(ma_kh)) {
                txtho.setText(khList.get(i).getHo());
                txtten.setText(khList.get(i).getTen());
                txtdienthoai.setText(khList.get(i).getSdt());
                txtdiachi.setText(khList.get(i).getDiachi());
                Date date = new SimpleDateFormat("dd-MM-yyyy").parse(khList.get(i).getNgaysinh());
                jDateChooser1.setDate(date);
                if (khList.get(i).getGioitinh().equalsIgnoreCase("Nam")) {
                    rdnam.setSelected(true);
                }
                if (khList.get(i).getGioitinh().equalsIgnoreCase("Nữ")) {
                    rdnu.setSelected(true);
                }
                if (khList.get(i).getGioitinh().equalsIgnoreCase("khác")) {
                    rdkhac.setSelected(true);
                }
            }
        }
    }

    void settenphong(String title) {
        ltitle.setText(title);
    }

    void setbtndancokhach(String thanh_toan) {
        btnmo.setText(thanh_toan);
    }

    void setbtndanmophong(String mo_phong) {
        btnmo.setText(mo_phong);
    }

    void setbtndanhuyphong(String huy_dat_phong) {
        btndattruoc.setText(huy_dat_phong);
    }
//kiểm tra tồn tại khách hàng

    boolean insert() throws Exception {
        khachhangBUS kh = new khachhangBUS();
        kh.dskh();
        for (int i = 0; i < khList.size(); i++) {
            if (khList.get(i).getMa_kh().equalsIgnoreCase(txtcmnd.getText())) {
                return false;
            }
        }
        return true;
    }

    void setidphieudangki(int ma_phieu) throws Exception {
        x = ma_phieu;
        phieudangkiBUS pdkbus = new phieudangkiBUS();
        pdkbus.dspdk();
        for (int i = 0; i < pdkList.size(); i++) {
            if (pdkList.get(i).getMa_phieu() == ma_phieu) {
                khachhangBUS khbus = new khachhangBUS();
                khbus.dskh();
                for (int j = 0; j < khList.size(); j++) {
                    if (khList.get(j).getMa_kh().equalsIgnoreCase(pdkList.get(i).getMa_khach_hang())) {
                        setthongtin(khList.get(j).getMa_kh());

                    }
                }
                Date date = new SimpleDateFormat("dd-MM-yyyy").parse(pdkList.get(i).getNgaydatphong());
                jDateChooser2.setDate(date);
                txtkhuyenmai.setText(pdkList.get(i).getMa_dv());

            }

        }
    }
    JPanel pcontainer;
    JPanel ptitle;
    JPanel pmain;
    JLabel ltitle;

    private JLabel l_ho;
    private JLabel l_ten;
    private JLabel l_maKH;
    private JLabel l_gioitinh;
    private JLabel l_ngaysinh;
    private JLabel l_dienthoai;
    private JLabel l_diachi;
    private JLabel l_ngaynhanphong;
    private JLabel ldv;
    private JTextField txtho;
    private JTextField txtten;
    private JTextField txtcmnd;
    private JTextField txtdienthoai;
    private JTextField txtdiachi;

    private JRadioButton rdnam;
    private JRadioButton rdnu;
    private JRadioButton rdkhac;

    private ButtonGroup btngrgioitinh;

    private JButton btnmo;
    private JButton btndattruoc;
    private JButton btnhuy;

    private JDateChooser jDateChooser1;
    private JDateChooser jDateChooser2;

    private JComboBox cbdv;
    private JLabel lkhuyen_mai;
    private JTextField txtkhuyenmai;
    private JLabel lmanv;
    DateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");

    int x;
}
