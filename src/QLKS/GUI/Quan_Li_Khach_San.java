package QLKS.GUI;

import BUS.nhanvienBUS;
import static BUS.nhanvienBUS.nvList;
import static QLKS.GUI.Login.taikhoan;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
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
public final class Quan_Li_Khach_San extends JFrame {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    CardLayout cardLayout;
    private javax.swing.JPanel cardpanel;

    public static Quan_Li_Khach_San conection;

    public Quan_Li_Khach_San() throws Exception {
        init();
        cardLayout = (CardLayout) (cardpanel.getLayout());
        applicationcenter(true);
        conection = this;
        setmanv(taikhoan);
    }

    public void reLoad() throws Exception {
        this.setVisible(false);
        new Quan_Li_Khach_San().setVisible(true);
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
    private int x;
    private int y;

    private void resetColor(JPanel p) {
        p.setBackground(new java.awt.Color(227, 227, 227));
    }

    private void setColor(JPanel p) {
        p.setBackground(Color.WHITE);
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

    private int getWidthScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) this.screenSize.getWidth();
    }

    private int getHeightScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) this.screenSize.getHeight();
    }

    private void setSizeFullScreen() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private final Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);

    public void init() throws Exception {

        cardpanel = new javax.swing.JPanel();
        this.setSize(1402, 600);
        this.setLayout(new BorderLayout(0, 0));
        this.setUndecorated(true);

        jpanelList = new ArrayList<>();
        jlabelList = new ArrayList<>();

        /*Title*/
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

        for (int i = 0; i < 4; i++) {
            JPanel p_temp = new JPanel();
            p_temp.setLayout(new BorderLayout(0, 0));
            p_temp.setBackground(Color.WHITE);
            p_temp.setPreferredSize(new Dimension(200, 70));
            p_temp.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
            jpanelList.add(p_temp);
        }

        for (int i = 0; i < 4; i++) {
            JLabel l_temp = new JLabel();
            l_temp.setText("");
            l_temp.setFont(new Font("", Font.ITALIC, 18));
            l_temp.setPreferredSize(new Dimension(200, 70));
            l_temp.setHorizontalAlignment(JLabel.CENTER);
            l_temp.setVerticalAlignment(JLabel.CENTER);
            jlabelList.add(l_temp);
        }

        jlabelList.get(0).setText("Quản lí phòng");
        jlabelList.get(1).setText("Quản lí khách hàng");
        jlabelList.get(2).setText("Quản lí hóa đơn");
        jlabelList.get(3).setText("Phiếu Nhập");

        for (int i = 0; i < 4; i++) {
            jpanelList.get(i).add(jlabelList.get(i));
            p_menu.add(jpanelList.get(i));
        }

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
        luser.setText("Hello");
        luser.setFont(new Font("", Font.BOLD, 18));
        luser.setPreferredSize(new Dimension(200, 30));
        luser.setHorizontalAlignment(JLabel.CENTER);
        luser.setVerticalAlignment(JLabel.CENTER);

        p_menu.add(btn_dx);
        p_menu.add(luser);
        /*CARD*/

        for (int i = 0; i < 4; i++) {
            JPanel p_temp = new JPanel();
            p_temp.setPreferredSize(new Dimension(1200, 570));
            p_temp.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
            p_temp.setBorder(new MatteBorder(0, 0, 1, 1, Color.BLACK));
            cardList.add(p_temp);
        }
        cardpanel.setName("");
        cardpanel.setLayout(new java.awt.CardLayout());

        cardList.get(0).setBackground(Color.red);
        cardList.get(1).setBackground(Color.BLUE);
        cardList.get(2).setBackground(Color.CYAN);
        cardList.get(3).setBackground(Color.DARK_GRAY);

        for (int i = 0; i < 4; i++) {
            cardpanel.add(cardList.get(i), "cart" + i + "");
        }

        this.add(p_menu, BorderLayout.WEST);
        this.add(cardpanel, BorderLayout.EAST);

        /*Quản lí phòng*/
        new Quan_Li_Phong(cardList.get(0));
        /*Quản Lí Khách hàng*/
        new Quan_Li_Khach_Hang(cardList.get(1));
        /*Quản Lí Hóa đơn*/
        new Quan_Li_Hoa_Don(cardList.get(2));
        /*Quản Lí Thu Chi*/
        new Phieu_Nhap(cardList.get(3));
        /*Quản Lí thống kê*/
//        thong_Ke = new Thong_Ke(cardList.get(4));
        /*THống kê*/
 /*EVENT*/
        jpanelList.get(0).setBackground(new Color(227, 227, 227));
        for (int i = 0; i < 4; i++) {
            JPanel p = jpanelList.get(i);
            int index = i;
            jpanelList.get(i).addMouseListener(new MouseAdapter() {
                int temp;

                @Override

                public void mouseClicked(MouseEvent e) {
                    cardLayout.show(cardpanel, "cart" + index + "");
                    resetColor(p);
                    temp = index;
                    for (int j = 0; j < 4; j++) {
                        if (j != index) {
                            setColor(jpanelList.get(j));
                        }
                    }
                }

            });
        }

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
    }

    public static void main(String[] args) throws Exception {
        Login login = new Login();
        login.setVisible(true);
      


//       new Quan_Li_Khach_San().setVisible(true);
    }
    ArrayList<JPanel> cardList = new ArrayList<>();
    JLabel luser;

    void setmanv(String taikhoan) throws Exception {
        nhanvienBUS nv = new nhanvienBUS();
        nv.dsnv();
        for (int i = 0; i < nvList.size(); i++) {
            if (nvList.get(i).getMa_nv().equalsIgnoreCase(taikhoan)) {
                luser.setText("Hello " + nvList.get(i).getHo() + " " + nvList.get(i).getTen());
            }
        }
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
    ArrayList<JPanel> jpanelList;
    ArrayList<JLabel> jlabelList;

//    Thong_Ke thong_Ke;
}
