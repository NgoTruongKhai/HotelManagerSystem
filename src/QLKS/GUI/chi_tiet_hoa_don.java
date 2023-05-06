/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.GUI;

import BUS.chitiethoadonBUS;
import BUS.dichvuBUS;
import static BUS.dichvuBUS.dvList;
import BUS.hoadonBUS;
import static BUS.hoadonBUS.hdList;
import BUS.khuyenmaiBUS;
import static BUS.khuyenmaiBUS.kmList;
import BUS.loaiphongBUS;
import static BUS.loaiphongBUS.lpList;
import BUS.phieudangkiBUS;
import static BUS.phieudangkiBUS.pdkList;
import BUS.phongBUS;
import static BUS.phongBUS.phongList;
import QLKS.DTO.chitiethoadonDTO;
import QLKS.DTO.hoadonDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public final class chi_tiet_hoa_don extends JFrame {

    public chi_tiet_hoa_don() throws HeadlessException {
        init();
        applicationcenter(true);

    }

    public void init() {
        this.setSize(500, 650);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout(0, 0));
        this.setUndecorated(true);
        ptitle = new JPanel();
        pmain = new JPanel();
        btnthanhtoan = new JButton("Thanh toán");
        btnhuy = new JButton("Hủy");

        ltitle = new JLabel("Chi Tiet hoa don");

        lma_hd = new JLabel("Mã hóa đơn :");
        lma_kh = new JLabel("Mã khách hàng :");
        lma_nv = new JLabel("Mã nhân viên :");
        lma_phong = new JLabel("Mã phòng :");
        ltien_phong = new JLabel("Tiền phòng :");
        ltong_ngay_o = new JLabel("Tổng ngày ở :");
        lma_dv = new JLabel("Dịch vụ :");
        ltien_dv = new JLabel("Tiền dịch vụ :");
        ltong_tien = new JLabel("Tổng tiền :");
        lma_km = new JLabel("Mã khuyến mãi :");
        ltien_km = new JLabel("Phần trăm khuyến mãi :");
        ltien_thuc = new JLabel("Cần thanh toán :");
        lngay_lap_hd = new JLabel("Ngày lập hóa đơn :");

        lma_hd1 = new JLabel();
        lma_kh1 = new JLabel();
        lma_nv1 = new JLabel();
        lma_phong1 = new JLabel();
        ltien_phong1 = new JLabel();
        ltong_ngay_o1 = new JLabel();
        lma_dv1 = new JLabel();
        ltien_dv1 = new JLabel();
        ltong_tien1 = new JLabel();
        lma_km1 = new JLabel();
        ltien_km1 = new JLabel();
        ltien_thuc1 = new JLabel();
        lngay_lap_hd1 = new JLabel();

        ptitle.setPreferredSize(new Dimension(500, 50));
        pmain.setPreferredSize(new Dimension(500, 600));

        lma_hd.setBounds(20, 10, 150, 30);
        lma_kh.setBounds(20, 50, 150, 30);
        lma_nv.setBounds(20, 90, 150, 30);
        lma_phong.setBounds(20, 130, 150, 30);
        ltien_phong.setBounds(20, 170, 150, 30);
        ltong_ngay_o.setBounds(20, 210, 150, 30);
        lma_dv.setBounds(20, 250, 150, 30);
        ltien_dv.setBounds(20, 290, 150, 30);
        ltong_tien.setBounds(20, 330, 150, 30);
        lma_km.setBounds(20, 370, 150, 30);
        ltien_km.setBounds(20, 410, 150, 30);
        ltien_thuc.setBounds(20, 450, 150, 30);
        lngay_lap_hd.setBounds(20, 490, 150, 30);

        lma_hd1.setBounds(180, 10, 150, 30);
        lma_kh1.setBounds(180, 50, 150, 30);
        lma_nv1.setBounds(180, 90, 150, 30);
        lma_phong1.setBounds(180, 130, 150, 30);
        ltien_phong1.setBounds(180, 170, 150, 30);
        ltong_ngay_o1.setBounds(180, 210, 150, 30);
        lma_dv1.setBounds(180, 250, 150, 30);
        ltien_dv1.setBounds(180, 290, 150, 30);
        ltong_tien1.setBounds(180, 330, 150, 30);
        lma_km1.setBounds(180, 370, 150, 30);
        ltien_km1.setBounds(180, 410, 150, 30);
        ltien_thuc1.setBounds(180, 450, 150, 30);
        lngay_lap_hd1.setBounds(180, 490, 150, 30);

        btnthanhtoan.setBounds(50, 530, 200, 40);
        btnhuy.setBounds(260, 530, 200, 40);

        lma_hd.setFont(new Font("", Font.BOLD, 16));
        lma_kh.setFont(new Font("", Font.BOLD, 16));
        lma_nv.setFont(new Font("", Font.BOLD, 16));
        lma_phong.setFont(new Font("", Font.BOLD, 16));
        ltien_phong.setFont(new Font("", Font.BOLD, 16));
        ltong_ngay_o.setFont(new Font("", Font.BOLD, 16));
        lma_dv.setFont(new Font("", Font.BOLD, 16));
        ltien_dv.setFont(new Font("", Font.BOLD, 16));
        ltong_tien.setFont(new Font("", Font.BOLD, 16));
        lma_km.setFont(new Font("", Font.BOLD, 16));
        ltien_km.setFont(new Font("", Font.BOLD, 16));
        ltien_thuc.setFont(new Font("", Font.BOLD, 16));
        lngay_lap_hd.setFont(new Font("", Font.BOLD, 16));
        ltitle.setFont(new Font("", Font.BOLD, 20));
        btnthanhtoan.setFont(new Font("", Font.BOLD, 20));
        btnhuy.setFont(new Font("", Font.BOLD, 20));

        lma_hd1.setFont(new Font("", Font.BOLD, 16));
        lma_kh1.setFont(new Font("", Font.BOLD, 16));
        lma_nv1.setFont(new Font("", Font.BOLD, 16));
        lma_phong1.setFont(new Font("", Font.BOLD, 16));
        ltien_phong1.setFont(new Font("", Font.BOLD, 16));
        ltong_ngay_o1.setFont(new Font("", Font.BOLD, 16));
        lma_dv1.setFont(new Font("", Font.BOLD, 16));
        ltien_dv1.setFont(new Font("", Font.BOLD, 16));
        ltong_tien1.setFont(new Font("", Font.BOLD, 16));
        lma_km1.setFont(new Font("", Font.BOLD, 16));
        ltien_km1.setFont(new Font("", Font.BOLD, 16));
        ltien_thuc1.setFont(new Font("", Font.BOLD, 16));
        lngay_lap_hd1.setFont(new Font("", Font.BOLD, 16));

        btnthanhtoan.setBackground(Color.green);
        btnhuy.setBackground(Color.green);
        ptitle.setBackground(new Color(102, 217, 255));
//        pmain.setBackground(Color.BLUE);

        ptitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        pmain.setLayout(null);

        ptitle.add(ltitle);

        pmain.add(lma_hd);
        pmain.add(lma_kh);
        pmain.add(lma_nv);
        pmain.add(lma_phong);
        pmain.add(ltien_phong);
        pmain.add(ltong_ngay_o);
        pmain.add(lma_dv);
        pmain.add(ltien_dv);
        pmain.add(ltong_tien);
        pmain.add(lma_km);
        pmain.add(ltien_km);
        pmain.add(ltien_thuc);
        pmain.add(lngay_lap_hd);

        pmain.add(lma_hd1);
        pmain.add(lma_kh1);
        pmain.add(lma_nv1);
        pmain.add(lma_phong1);
        pmain.add(ltien_phong1);
        pmain.add(ltong_ngay_o1);
        pmain.add(lma_dv1);
        pmain.add(ltien_dv1);
        pmain.add(ltong_tien1);
        pmain.add(lma_km1);
        pmain.add(ltien_km1);
        pmain.add(ltien_thuc1);
        pmain.add(lngay_lap_hd1);

        pmain.add(btnthanhtoan);
        pmain.add(btnhuy);

        this.add(pmain, BorderLayout.SOUTH);
        this.add(ptitle, BorderLayout.NORTH);

        btnthanhtoan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    btnthanhtoan(e);
                } catch (Exception ex) {
                    Logger.getLogger(chi_tiet_hoa_don.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        btnhuy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnhuy(e);
            }

        });

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


    private void btnthanhtoan(MouseEvent e) throws Exception {
//          ArrayList<phieudangkiDTO> pdkList = phieudangkiDAL.findall();
        phieudangkiBUS pdk = new phieudangkiBUS();
        pdk.dspdk();
        phongBUS ph = new phongBUS();
        ph.dsphong();
        for (int i = 0; i < pdkList.size(); i++) {
            if (pdkList.get(i).getMa_phieu() == x) {
                pdk.updatetrangthai(x, 1);
                for (int j = 0; j < phongList.size(); j++) {
                    if (pdkList.get(i).getMa_phong().equalsIgnoreCase(phongList.get(j).getMa_phong())) {
                        ph.updatephong(pdkList.get(i).getMa_phong(), 1);
                    }
                }
            }
        }
        String madv = null;
        dichvuBUS dv = new dichvuBUS();
        dv.dsdv();
        for (int i = 0; i < dvList.size(); i++) {
            if (dvList.get(i).getTen_dv().equalsIgnoreCase(lma_dv1.getText())) {
                madv = dvList.get(i).getMa_dv();
            }
        }
        double tienKM = 0;
        if (ltien_km1.getText().equalsIgnoreCase("")) {
            tienKM = 0;
        } else {
            tienKM = Double.valueOf(ltien_km1.getText());
        }
        hoadonDTO hd = new hoadonDTO(Integer.valueOf(lma_hd1.getText()), lma_kh1.getText(), lma_nv1.getText(), lngay_lap_hd1.getText(), lma_km1.getText(), Double.valueOf(ltong_tien1.getText()), tienKM, Double.valueOf(ltien_thuc1.getText()), 1);
        chitiethoadonDTO cthd = new chitiethoadonDTO(Integer.valueOf(lma_hd1.getText()), lma_phong1.getText(), Double.valueOf(ltien_phong1.getText()), Integer.valueOf(ltong_ngay_o1.getText()), madv, Double.valueOf(ltien_dv1.getText()), Double.valueOf(ltong_tien1.getText()), tienKM);
        hoadonBUS hdbus = new hoadonBUS();
        hdbus.insert(hd);
        chitiethoadonBUS cthdbus = new chitiethoadonBUS();
        cthdbus.insert(cthd);
        Quan_Li_Khach_San.conection.reLoad();
        this.dispose();
    }

    private void btnhuy(MouseEvent e) {
        this.dispose();
    }

    void setidphieudangki(int ma_phieu) throws Exception {
        x = ma_phieu;
        phieudangkiBUS pdk = new phieudangkiBUS();
        pdk.dspdk();
        for (int i = 0; i < pdkList.size(); i++) {
            if (pdkList.get(i).getMa_phieu() == ma_phieu) {
                lma_phong1.setText(pdkList.get(i).getMa_phong());
                lma_kh1.setText(pdkList.get(i).getMa_khach_hang());
                lma_nv1.setText(pdkList.get(i).getMa_nv());
                Date date = new SimpleDateFormat("dd-MM-yyyy").parse(pdkList.get(i).getNgaynhanphong());
                Date datengaylaphoadon = new java.util.Date();
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

//                phieudangkiDAL.updatengay(x,df.format(datengaylaphoadon));
                pdk.updatengay(x, df.format(datengaylaphoadon));
                Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(df.format(datengaylaphoadon));
                double getDiff = date1.getTime() - date.getTime();
                int getDaysDiff = (int) TimeUnit.MILLISECONDS.toDays((long) getDiff);
                String ngayo = String.valueOf(getDaysDiff);
                if (Integer.valueOf(ngayo) == 0) {
                    ltong_ngay_o1.setText("1");
                } else {
                    ltong_ngay_o1.setText(ngayo);
                }

                phongBUS ph = new phongBUS();
                ph.dsphong();

                for (int j = 0; j < phongList.size(); j++) {
                    if (phongList.get(j).getMa_phong().equals(pdkList.get(i).getMa_phong())) {

//                        ArrayList<loaiphongDTO> lpList=loaiphongDAL.findall();
                        loaiphongBUS lp = new loaiphongBUS();
                        lp.dslp();

                        for (int k = 0; k < lpList.size(); k++) {
                            if (phongList.get(j).getMa_loai() == lpList.get(k).getMa_loai_phong()) {
                                double tienphong = lpList.get(k).getGialoaiphong();
                                String tienphong1 = String.valueOf(tienphong);
                                ltien_phong1.setText(tienphong1);
                            }
                        }
                    }
                }

                lngay_lap_hd1.setText(df.format(datengaylaphoadon));

//                ArrayList<dichvuDTO> dvList=dichvuDAL.findall();
                dichvuBUS dv = new dichvuBUS();
                dv.dsdv();

                for (int h = 0; h < dvList.size(); h++) {
                    if (dvList.get(h).getMa_dv().equalsIgnoreCase(pdkList.get(i).getMa_dv())) {
                        lma_dv1.setText(dvList.get(h).getTen_dv());
                        ltien_dv1.setText(String.valueOf(dvList.get(h).getGia_dv()));
                    }
                }
                double tienphong = Double.valueOf(ltien_phong1.getText());
                int tongngauo = Integer.valueOf(ltong_ngay_o1.getText());
                double tiendichvu = Double.valueOf(ltien_dv1.getText());
                double tongtien = tienphong * tongngauo + tiendichvu;
                ltong_tien1.setText(String.valueOf(tongtien));
//            ArrayList<khuyenmaiDTO> kmList=khuyenmaiDAL.findall();
                khuyenmaiBUS km = new khuyenmaiBUS();
                km.dskm();
                for (int j = 0; j < kmList.size(); j++) {
                    if (pdkList.get(i).getMa_km().equalsIgnoreCase(kmList.get(j).getMa_km())) {
                        System.out.println(pdkList.get(i).getMa_dv());
                        lma_km1.setText(pdkList.get(i).getMa_km());
                        ltien_km1.setText(String.valueOf(kmList.get(j).getTienkm()));
                    }
                }
                int phantramkm;
                double tienthuc;
                if (ltien_km1.getText().equalsIgnoreCase("")) {
                    phantramkm = 0;
                    tienthuc = tongtien;
                } else {
                    phantramkm = Integer.valueOf(ltien_km1.getText());
                    tienthuc = tongtien - (tongtien / phantramkm);
                }
                ltien_thuc1.setText(String.valueOf(tienthuc));
//              ArrayList<hoadonDTO> hdList=hoadonDAL.findall();
                hoadonBUS hd = new hoadonBUS();
                hd.dshd();
                int temp = hdList.size();
//              System.out.println(temp);
                lma_hd1.setText(String.valueOf(temp + 1));
            }
        }
    }

    int x;
    private JPanel ptitle;
    private JPanel pmain;
    private JLabel ltitle;
    private JLabel lma_hd;
    private JLabel lma_kh;
    private JLabel lma_nv;
    private JLabel lma_phong;
    private JLabel ltien_phong;
    private JLabel ltong_ngay_o;
    private JLabel lma_dv;
    private JLabel ltien_dv;
    private JLabel ltong_tien;
    private JLabel lma_km;
    private JLabel ltien_km;
    private JLabel ltien_thuc;
    private JLabel lngay_lap_hd;

    private JLabel lma_hd1;
    private JLabel lma_kh1;
    private JLabel lma_nv1;
    private JLabel lma_phong1;
    private JLabel ltien_phong1;
    private JLabel ltong_ngay_o1;
    private JLabel lma_dv1;
    private JLabel ltien_dv1;
    private JLabel ltong_tien1;
    private JLabel lma_km1;
    private JLabel ltien_km1;
    private JLabel ltien_thuc1;
    private JLabel lngay_lap_hd1;
    JButton btnthanhtoan;
    JButton btnhuy;
}
