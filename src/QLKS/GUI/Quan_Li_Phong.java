/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.GUI;

import BUS.phieudangkiBUS;
import static BUS.phieudangkiBUS.pdkList;
import BUS.phongBUS;
import static BUS.phongBUS.phongList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author ASUS
 */
public class Quan_Li_Phong extends JFrame {

    ArrayList<JPanel> phong1List;

    public Quan_Li_Phong(JPanel p) throws Exception {
        init(p);
    }

    public void init(JPanel p) throws Exception {
        phongBUS ph = new phongBUS();
        ph.dsphong();
        p.setLayout(new BorderLayout(0, 0));
        JPanel menu_phong = new JPanel();
        menu_phong.setPreferredSize(new Dimension(151, 570));
        menu_phong.setBackground(Color.WHITE);
        menu_phong.setLayout(null);
        menu_phong.setBorder(new MatteBorder(0, 0, 0, 1, Color.BLACK));
        p.add(menu_phong, BorderLayout.WEST);

        JPanel p_mota = new JPanel();
        p_mota.setPreferredSize(new Dimension(1050, 40));
        p_mota.setLayout(null);
        p.add(p_mota, BorderLayout.NORTH);

        ArrayList<JPanel> tangList = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < 5; i++) {
            JPanel temp = new JPanel();
            temp.setBounds(0, j, 150, 100);
            temp.setBackground(Color.WHITE);
            temp.setLayout(new BorderLayout(0, 0));
            tangList.add(temp);
            j += 105;
        }

        tangList.get(0).setBackground(new Color(227, 227, 227));

        ArrayList<JLabel> l_tangList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            JLabel temp = new JLabel();
            temp.setText("");
            temp.setFont(new Font("", Font.BOLD, 16));
            temp.setPreferredSize(new Dimension(150, 100));
            temp.setHorizontalAlignment(JLabel.CENTER);
            temp.setVerticalAlignment(JLabel.CENTER);
            l_tangList.add(temp);
        }

        l_tangList.get(0).setText("Tất cả phòng");
        l_tangList.get(1).setText("Tầng 1");
        l_tangList.get(2).setText("Tầng 2");
        l_tangList.get(3).setText("Tầng 3");
        l_tangList.get(4).setText("Tầng 4");

        for (int i = 0; i < 5; i++) {
            menu_phong.add(tangList.get(i));
            tangList.get(i).add(l_tangList.get(i));
        }

        JLabel l_hientrang = new JLabel();
        l_hientrang.setBounds(10, 5, 160, 20);
        l_hientrang.setText("Hiện trạng của phòng :");
        l_hientrang.setFont(new Font("", Font.BOLD, 14));
        p_mota.add(l_hientrang);

        JPanel p_trong = new JPanel();
        p_trong.setBackground(new Color(0, 172, 230));
        p_trong.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        p_trong.setBounds(195, 5, 20, 20);
        p_mota.add(p_trong);

        JLabel l_trong = new JLabel();
        l_trong.setBounds(215, 5, 100, 20);
        l_trong.setText(" : Phòng trống ");
        l_trong.setFont(new Font("", Font.BOLD, 14));
        p_mota.add(l_trong);

        JPanel p_dat = new JPanel();
        p_dat.setBackground(Color.GRAY);
        p_dat.setBounds(320, 5, 20, 20);
        p_dat.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        p_mota.add(p_dat);

        JLabel l_dat = new JLabel();
        l_dat.setBounds(340, 5, 150, 20);
        l_dat.setText(" : Phòng đã được đặt");
        l_dat.setFont(new Font("", Font.BOLD, 14));
        p_mota.add(l_dat);

        JPanel p_cokhach = new JPanel();
        p_cokhach.setBackground(Color.RED);
        p_cokhach.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        p_cokhach.setBounds(495, 5, 20, 20);
        p_mota.add(p_cokhach);

        JLabel l_cokhach = new JLabel();
        l_cokhach.setBounds(520, 5, 150, 20);
        l_cokhach.setText(" : Có khách đang ở");
        l_cokhach.setFont(new Font("", Font.BOLD, 14));
        p_mota.add(l_cokhach);

        phong1List = new ArrayList<>();

        /*
            set trạng thái của từng phòng(trống-có khách-đặt trước)
         */
        for (int i = 0; i < phongList.size(); i++) {
            JPanel temp = new JPanel();
            temp.setPreferredSize(new Dimension(160, 110));
            if (phongList.get(i).getTrang_thai() == 1) {
                temp.setBackground(new Color(0, 172, 230));
            }
            if (phongList.get(i).getTrang_thai() == 2) {
                temp.setBackground(Color.GRAY);
            }
            if (phongList.get(i).getTrang_thai() == 3) {
                temp.setBackground(Color.RED);
            }
            temp.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            phong1List.add(temp);
        }

        JPanel phong = new JPanel();
        phong.setPreferredSize(new Dimension(1050, 570));
        phong.setBackground(new Color(102, 217, 255));
        phong.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 15));

        p.add(phong, BorderLayout.EAST);

        for (int i = 0; i < 24; i++) {
            phong.add(phong1List.get(i), FlowLayout.LEFT);
        }

        /*
            set ma từng phòng
         */
        for (int i = 0; i < 24; i++) {
            if (i < 6) {
                JLabel l = new JLabel();
                l.setText(phongList.get(i).getMa_phong());
                l.setFont(new Font("", Font.BOLD, 16));
                phong1List.get(i).add(l);
                if (phongList.get(i).getMa_loai() == 0) {
                    JLabel l2 = new JLabel();
                    l2.setText("- VIP");
                    l2.setFont(new Font("", Font.BOLD, 16));
                    phong1List.get(i).add(l2);
                }
            }
            if (6 <= i && i < 12) {
                JLabel l = new JLabel();
                l.setText(phongList.get(i).getMa_phong());
                l.setFont(new Font("", Font.BOLD, 16));
                phong1List.get(i).add(l);
                if (phongList.get(i).getMa_loai() == 0) {
                    JLabel l2 = new JLabel();
                    l2.setText("- VIP");
                    l2.setFont(new Font("", Font.BOLD, 16));
                    phong1List.get(i).add(l2);
                }
            }
            if (12 <= i && i < 18) {
                JLabel l = new JLabel();
                l.setText(phongList.get(i).getMa_phong());
                l.setFont(new Font("", Font.BOLD, 16));
                phong1List.get(i).add(l);
                if (phongList.get(i).getMa_loai() == 0) {
                    JLabel l2 = new JLabel();
                    l2.setText("- VIP");
                    l2.setFont(new Font("", Font.BOLD, 16));
                    phong1List.get(i).add(l2);
                }
            }
            if (18 <= i && i < 24) {
                JLabel l = new JLabel();
                l.setText(phongList.get(i).getMa_phong());
                l.setFont(new Font("", Font.BOLD, 16));
                phong1List.get(i).add(l);
                if (phongList.get(i).getMa_loai() == 0) {
                    JLabel l2 = new JLabel();
                    l2.setText("- VIP");
                    l2.setFont(new Font("", Font.BOLD, 16));
                    phong1List.get(i).add(l2);
                }
            }

        }

        /*
            dùng để đóng mở phòng
         */
        for (int i = 0; i < 24; i++) {
            int temp = i;
            phong1List.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    if (phongList.get(temp).getTrang_thai() == 3) {
                        try {
                            //                        try {
//                            phieu_dang_ki pdk = new phieu_dang_ki();
//                            ArrayList<phieudangkiDTO> pdkList = phieudangkiDAL.findall();
//                            for (int i = 0; i < pdkList.size(); i++) {                                
//                                if (pdkList.get(i).getMa_phong().equalsIgnoreCase(phongList.get(temp).getMa_phong()) && pdkList.get(i).getTrangthai() == 0) {
//                                    pdk.setidphieudangki(pdkList.get(i).getMa_phieu());
//                                }
//                            }
//                            
//                            pdk.settenphong(phongList.get(temp).getMa_phong());
//                            pdk.setbtndancokhach("Thanh toán");
//                            pdk.setVisible(true);
//                        } catch (Exception ex) {
//                            Logger.getLogger(Quan_Li_Phong.class.getName()).log(Level.SEVERE, null, ex);
//                        }

                            chi_tiet_hoa_don cthd = new chi_tiet_hoa_don();
                            phieudangkiBUS pdk = new phieudangkiBUS();
                            pdk.dspdk();
                            for (int i = 0; i < pdkList.size(); i++) {
                                if (pdkList.get(i).getMa_phong().equalsIgnoreCase(phongList.get(temp).getMa_phong()) && pdkList.get(i).getTrangthai() == 0) {
                                    cthd.setidphieudangki(pdkList.get(i).getMa_phieu());
                                }
                            }

                            cthd.setVisible(true);
                        } catch (Exception ex) {
                            Logger.getLogger(Quan_Li_Phong.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if (phongList.get(temp).getTrang_thai() == 2) {
                        try {
                            phieu_dang_ki pdk = new phieu_dang_ki();
                            phieudangkiBUS pdkbus = new phieudangkiBUS();
                            pdkbus.dspdk();
                            for (int i = 0; i < pdkList.size(); i++) {
                                if (pdkList.get(i).getMa_phong().equalsIgnoreCase(phongList.get(temp).getMa_phong()) && pdkList.get(i).getTrangthai() == 0) {
                                    pdk.setidphieudangki(pdkList.get(i).getMa_phieu());

                                }
                            }
                            pdk.settenphong(phongList.get(temp).getMa_phong());
                            pdk.setbtndanmophong("Mở phòng");
                            pdk.setbtndanhuyphong("Hủy đặt phòng");
                            pdk.setVisible(true);
                        } catch (Exception ex) {
                            Logger.getLogger(Quan_Li_Phong.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (phongList.get(temp).getTrang_thai() == 1) {
                        try {
                            phieu_dang_ki pdk = new phieu_dang_ki();
                            pdk.settenphong(phongList.get(temp).getMa_phong());
                            pdk.setVisible(true);
                        } catch (Exception ex) {
                            Logger.getLogger(Quan_Li_Phong.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }

        /*
            Phân tầng cho khách sạn
         */
        for (int i = 0; i < 5; i++) {
            int temp = i;
            tangList.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tangList.get(temp).setBackground(new Color(227, 227, 227));
                    for (int j = 0; j < 5; j++) {
                        if (j != temp) {
                            tangList.get(j).setBackground(Color.WHITE);
                        }
                    }
                    if (temp == 0) {
                        for (int i = 0; i < 24; i++) {
                            phong1List.get(i).setVisible(true);
                        }
                    }
                    if (temp == 1) {
                        for (int i = 0; i < 24; i++) {
                            if (i < 6) {
                                phong1List.get(i).setVisible(true);
                            } else {
                                phong1List.get(i).setVisible(false);
                            }
                        }
                    }
                    if (temp == 2) {
                        for (int i = 0; i < 24; i++) {
                            if (6 <= i && i < 12) {
                                phong1List.get(i).setVisible(true);
                            } else {
                                phong1List.get(i).setVisible(false);
                            }
                        }
                    }
                    if (temp == 3) {
                        for (int i = 0; i < 24; i++) {
                            if (12 <= i && i < 18) {
                                phong1List.get(i).setVisible(true);
                            } else {
                                phong1List.get(i).setVisible(false);
                            }
                        }
                    }
                    if (temp == 4) {
                        for (int i = 0; i < 24; i++) {
                            if (18 <= i && i < 24) {
                                phong1List.get(i).setVisible(true);
                            } else {
                                phong1List.get(i).setVisible(false);
                            }
                        }
                    }
                }
            });
        }
    }

}
