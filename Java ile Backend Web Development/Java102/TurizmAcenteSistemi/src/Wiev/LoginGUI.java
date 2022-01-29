package Wiev;

import Helper.Helper;
import Helper.Config;
import Model.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginGUI extends JFrame {
    private JPanel panel1;
    private JPanel wrapper;
    private JTextField txt_userName;
    private JPasswordField txt_password;
    private JButton btn_login;

    public LoginGUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        add(wrapper);
        setSize(new Dimension(400, 400));
        this.setLocation(Helper.screenSize.width / 2 - this.getSize().width / 2, Helper.screenSize.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        Helper.setLayOut();
        setVisible(true);

        txt_password.setEnabled(false);

        txt_userName.addActionListener(new ActionListener() {
            //capture the event on JTextField
            public void actionPerformed(ActionEvent e) {
                //get and display the contents of JTextField in the console
                System.out.println("Text=" + txt_userName.getText());
                if (txt_userName.getText().equals("admin")){
                    txt_password.setEnabled(true);
                }
            }
        });

        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txt_userName.getText().equals("admin") && txt_password.getText().equals("admin")) {
                    try {
                        HotelManagmentGUI hotelManagmentGUI = new HotelManagmentGUI();
                    } catch (UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (InstantiationException ex) {
                        ex.printStackTrace();
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    dispose();
                } else {
                    //Normal Kullanıcı Gırısı
                    if (txt_userName.getText().isEmpty()) {
                        Helper.showMessage("fill");
                    } else {
                        User user = null;
                        try {
                            user = User.getFetch(txt_userName.getText());
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        if (user == null) {
                            Helper.showMessage("Kullanıcı Bulunamadı");
                        } else {
                            try {
                                HotelSearchGUI hotelSearchGUI = new HotelSearchGUI();
                            } catch (UnsupportedLookAndFeelException ex) {
                                ex.printStackTrace();
                            } catch (ClassNotFoundException ex) {
                                ex.printStackTrace();
                            } catch (InstantiationException ex) {
                                ex.printStackTrace();
                            } catch (IllegalAccessException ex) {
                                ex.printStackTrace();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                            dispose();

                        }
                    }
                }
            }
        });
    }
}