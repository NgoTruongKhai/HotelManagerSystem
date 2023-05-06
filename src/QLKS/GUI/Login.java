/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.GUI;

import AdminGUI.AdminGUI;
import BUS.taikhoanBUS;
import static BUS.taikhoanBUS.taikhoanList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public final class Login extends JFrame {

    public static String taikhoan;

    public Login() {
        init();
        applicationcenter();
    }

    private void exit() {
        System.exit(0);
    }

    private void applicationcenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getWidth();
        int h = this.getHeight() + 250;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        this.setLocation(x, y);
    }

    public void init() {
        this.setSize(400, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelcontainer = new JPanel();
        panelcontainer.setLayout(null);

        lb_title = new Label();
        lb_title.setText("Đăng nhập");
        lb_title.setFont(new Font("Tahoma", Font.BOLD, 20));
        lb_title.setBounds(130, 10, 120, 50);

        lb_username = new JLabel();
        lb_username.setText("Tài khoản :");
        lb_username.setFont(new Font("Tahoma", Font.BOLD, 16));
        lb_username.setBounds(40, 80, 90, 30);

        txt_username = new JTextField();
        txt_username.setBounds(140, 81, 200, 25);

        lb_password = new JLabel();
        lb_password.setText("Mật khẩu :");
        lb_password.setFont(new Font("Tahoma", Font.BOLD, 16));
        lb_password.setBounds(40, 130, 90, 30);

        txt_password = new JPasswordField();
        txt_password.setBounds(140, 130, 200, 25);

        btn_login = new JButton();
        btn_login.setText("Đăng nhập");
        btn_login.setBounds(130, 200, 100, 30);

        lb_err = new JLabel();
        lb_err.setForeground(Color.red);
        lb_err.setBounds(80, 160, 300, 30);
        lb_err.setText("");

        panelcontainer.add(lb_title);
        panelcontainer.add(lb_username);
        panelcontainer.add(txt_username);
        panelcontainer.add(lb_password);
        panelcontainer.add(txt_password);
        panelcontainer.add(btn_login);
        panelcontainer.add(lb_err);

        this.add(panelcontainer);

        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txt_username.getText();
                String password = txt_password.getText();
                if (username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                    lb_err.setText("Vui lòng nhập đầy đủ thông tin đăng nhập !");
                    Login login = new Login();
                } else {
                    try {
                        taikhoanBUS tk = new taikhoanBUS();
                        tk.dstk();
                        for (int i = 0; i < taikhoanList.size(); i++) {
                            String taikhoan1 = taikhoanList.get(i).getMa_nv();
                            String matkhau = taikhoanList.get(i).getMa_khkau();
                            int level = taikhoanList.get(i).getLevel();
                            if (username.equalsIgnoreCase(taikhoan1) && password.equalsIgnoreCase(matkhau)) {
                                if (level == 1) {
                                    taikhoan = taikhoan1;
                                    Quan_Li_Khach_San qlks = new Quan_Li_Khach_San();
                                    qlks.setmanv(taikhoan);
                                    qlks.setVisible(true);
                                    exit1();
                                }
                                if (level == 0) {
                                    taikhoan = taikhoan1;
                                    AdminGUI admin = new AdminGUI();

                                    admin.init();
                                    admin.setmanv(taikhoan);
                                    exit1();
                                    break;
                                }
                            } else {
                                lb_err.setText("Tài khoản hoặc mật khẩu không đúng !");
                                Login login = new Login();
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        });
    }

    private void exit1() {
        this.setVisible(false);
    }
    Label lb_title;
    JLabel lb_username;
    JTextField txt_username;
    JLabel lb_password;
    JPasswordField txt_password;
    JButton btn_login;
    JLabel lb_err;
    JPanel panelcontainer;
}
