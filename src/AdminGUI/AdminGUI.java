/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminGUI;

import QLKS.GUI.Login;
import QLKS.GUI.Quan_Li_Khach_San;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author ASUS
 */
public class AdminGUI extends JFrame {

    private static String taikhoan;

    public AdminGUI() throws HeadlessException {
        this.setSize(1402, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(0, 0));
        this.setUndecorated(true);
    }
    //Lấy tọa độ ứng dụng

    private void pressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    //cập nhập vị trí mới cho ứng dụng
    private void drag(MouseEvent e) {
        int xx = e.getXOnScreen();
        int yy = e.getYOnScreen();
        this.setLocation(xx - x, yy - y);
    }

    //Ẩn chương trình
    private void minimize(MouseEvent e) {
        this.setExtendedState(Quan_Li_Khach_San.ICONIFIED);

    }

    //Đóng chương trình
    private void exit(MouseEvent e) {
        System.exit(0);
    }

    private void resetColor(JPanel p) {
        p.setBackground(new java.awt.Color(227, 227, 227));
    }

    private void setColor(JPanel p) {
        p.setBackground(Color.WHITE);
    }

    public void init() throws Exception {

        jpanelList = new ArrayList<>();
        jlabelList = new ArrayList<>();
        p_title = new JPanel();
        p_title.setLayout(new BorderLayout(0, 0));
        p_title.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        p_title.setPreferredSize(new Dimension(1400, 30));
        p_title.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        p_drag = new JPanel();
        p_drag.setPreferredSize(new Dimension(1280, 28));
        p_drag.setLayout(null);
        p_drag.setBackground(Color.WHITE);
        p_title.add(p_drag);

        ImageIcon icon = new ImageIcon("src/img/icon_hotel1.png");

        l_title = new JLabel();
        l_title.setIcon(icon);
        l_title.setIconTextGap(10);
        l_title.setText("Quản lí khách sạn");
        l_title.setBounds(20, 0, 300, 28);
        l_title.setForeground(Color.BLACK);
        l_title.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 20));

        p_drag.add(l_title);

        p_minimize = new JPanel();
        p_minimize.setPreferredSize(new Dimension(40, 28));
        p_minimize.setBackground(Color.WHITE);
        p_title.add(p_minimize);

        l_minimize = new JLabel("-");
        p_minimize.add(l_minimize);

        p_maximize = new JPanel();
        p_maximize.setPreferredSize(new Dimension(40, 28));
        p_maximize.setBackground(Color.WHITE);
        p_title.add(p_maximize);

        l_maximize = new JLabel("=");
        p_maximize.add(l_maximize);

        p_exit = new JPanel();
        p_exit.setPreferredSize(new Dimension(40, 28));
        p_exit.setBackground(Color.WHITE);
        p_title.add(p_exit);

        l_exit = new JLabel("x");
        p_exit.add(l_exit);

        this.add(p_title, BorderLayout.NORTH);
        /*Menu*/
        p_menu = new JPanel();
        p_menu.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        p_menu.setPreferredSize(new Dimension(202, 570));
        p_menu.setBorder(new MatteBorder(0, 1, 1, 1, Color.BLACK));
        p_menu.setBackground(Color.WHITE);

        JPanel p_qlnv = new JPanel();
        p_qlnv.setLayout(new BorderLayout(0, 0));
        p_qlnv.setBackground(Color.WHITE);
        p_qlnv.setPreferredSize(new Dimension(200, 70));
        p_qlnv.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
        p_menu.add(p_qlnv);

        JPanel p_qlkm = new JPanel();
        p_qlkm.setLayout(new BorderLayout(0, 0));
        p_qlkm.setBackground(Color.WHITE);
        p_qlkm.setPreferredSize(new Dimension(200, 70));
        p_qlkm.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
        p_menu.add(p_qlkm);

        JPanel p_qltk = new JPanel();
        p_qltk.setLayout(new BorderLayout(0, 0));
        p_qltk.setBackground(Color.WHITE);
        p_qltk.setPreferredSize(new Dimension(200, 70));
        p_qltk.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
        p_menu.add(p_qltk);

        JLabel l_qlnv = new JLabel();
        l_qlnv.setText("Quản lí nhân viên");
        l_qlnv.setFont(new Font("", Font.ITALIC, 18));
        l_qlnv.setPreferredSize(new Dimension(200, 70));
        l_qlnv.setHorizontalAlignment(JLabel.CENTER);
        l_qlnv.setVerticalAlignment(JLabel.CENTER);
        p_qlnv.add(l_qlnv);

        JLabel l_qlkm = new JLabel();
        l_qlkm.setText("Quản lí Khuyến mãi");
        l_qlkm.setFont(new Font("", Font.ITALIC, 18));
        l_qlkm.setPreferredSize(new Dimension(200, 70));
        l_qlkm.setHorizontalAlignment(JLabel.CENTER);
        l_qlkm.setVerticalAlignment(JLabel.CENTER);
        p_qlkm.add(l_qlkm);

        JLabel l_qltk = new JLabel();
        l_qltk.setText("Quản lí Thống kê");
        l_qltk.setFont(new Font("", Font.ITALIC, 18));
        l_qltk.setPreferredSize(new Dimension(200, 70));
        l_qltk.setHorizontalAlignment(JLabel.CENTER);
        l_qltk.setVerticalAlignment(JLabel.CENTER);
        p_qltk.add(l_qltk);

        btn_dx = new JButton();
        btn_dx.setText("ĐĂng xuất");
        btn_dx.setHorizontalAlignment(JButton.CENTER);
        btn_dx.setVerticalAlignment(JButton.CENTER);
        btn_dx.setFont(new Font("", Font.ITALIC, 18));
        btn_dx.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    btn_dx(e);
                } catch (Exception ex) {
                    Logger.getLogger(Quan_Li_Khach_San.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        luser = new JLabel();
        luser.setFont(new Font("", Font.BOLD, 18));
        luser.setHorizontalAlignment(JLabel.CENTER);
        luser.setVerticalAlignment(JLabel.CENTER);

        p_menu.add(luser);
        p_menu.add(btn_dx);
        // Di chuyển ứng dụng
        p_drag.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pressed(e);
            }
        });

        p_drag.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                drag(e);
            }
        });
        // Ẩn chương trình
        p_minimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                minimize(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                resetColor(p_minimize);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setColor(p_minimize);
            }
        });
        // Thoát chương trình
        p_exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exit(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                resetColor(p_exit);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setColor(p_exit);
            }
        });

        resetColor(p_qlnv);
        p_qlnv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setColor(p_qlkm);
                setColor(p_qltk);
                resetColor(p_qlnv);
                Quan_Li_Nhan_Vien nv = null;
                try {
                    nv = new Quan_Li_Nhan_Vien();
                } catch (Exception ex) {
                    Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                pcontent.removeAll();
                pcontent.setPreferredSize(new Dimension(1200, 570));
                pcontent.setLayout(new BorderLayout(0, 0));
                pcontent.setBorder(new MatteBorder(0, 0, 1, 1, Color.BLACK));
                pcontent.add(nv);
                pcontent.repaint();
                nv.revalidate();
                nv.repaint();

            }

        });

        p_qlkm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setColor(p_qlnv);
                setColor(p_qltk);
                resetColor(p_qlkm);
                Quan_Li_Khuyen_mai km = new Quan_Li_Khuyen_mai();
                pcontent.removeAll();
                pcontent.setPreferredSize(new Dimension(1200, 570));
                pcontent.setLayout(new BorderLayout(0, 0));
                pcontent.setBorder(new MatteBorder(0, 0, 1, 1, Color.BLACK));
                pcontent.add(km);
                pcontent.repaint();
                km.revalidate();
                km.repaint();

            }

        });

        p_qltk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setColor(p_qlkm);
                setColor(p_qlnv);
                resetColor(p_qltk);
                Thong_Ke tk = null;
                try {
                    tk = new Thong_Ke();
                } catch (Exception ex) {
                    Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                pcontent.removeAll();
                pcontent.setPreferredSize(new Dimension(1200, 570));
                pcontent.setLayout(new BorderLayout(0, 0));
                pcontent.setBorder(new MatteBorder(0, 0, 1, 1, Color.BLACK));
                pcontent.add(tk);
                pcontent.repaint();
                tk.revalidate();
                tk.repaint();

            }

        });

        pcontent = new JPanel();
        pcontent.setPreferredSize(new Dimension(1200, 570));
        pcontent.setBackground(new Color(102, 217, 255));
        pcontent.setLayout(new BorderLayout(0, 0));
        pcontent.setBorder(new MatteBorder(0, 0, 1, 1, Color.BLACK));
        pcontent.add(new Quan_Li_Nhan_Vien());
        pcontent.repaint();
        this.add(pcontent, BorderLayout.EAST);
        this.add(p_menu, BorderLayout.WEST);
        this.repaint();
        this.setVisible(true);
    }

    private void btn_dx(MouseEvent e) throws Exception {
        this.setVisible(false);
        new Login().setVisible(true);
    }

    JPanel p_title;
    JPanel p_drag;
    JLabel l_title;
    JPanel p_minimize;
    JLabel l_minimize;
    JPanel p_maximize;
    JLabel l_maximize;
    JPanel p_exit;
    JLabel l_exit;
    JPanel p_menu;
    JButton btn_dx;
    JPanel pcontent;
    ArrayList<JPanel> jpanelList;
    ArrayList<JLabel> jlabelList;
    JLabel luser;
    int x, y;

    public static void main(String[] args) throws Exception {
        AdminGUI ad = new AdminGUI();
        ad.init();
    }

    public void setmanv(String taikhoan1) {
        taikhoan = taikhoan1;
        luser.setText("hello Admin " + taikhoan);

    }

}
