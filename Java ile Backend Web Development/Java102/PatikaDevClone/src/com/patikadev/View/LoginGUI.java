package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wTop;
    private JPanel wBottom;
    private JTextField fld_user_username;
    private JPasswordField fld_user_parola;
    private JButton btn_user_login;

    public LoginGUI() throws HeadlessException {
        add(wrapper);
        setSize(200,200);
        setSize(new Dimension(1000, 500));
        this.setLocation(Helper.screenSize.width / 2 - this.getSize().width / 2, Helper.screenSize.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);


        btn_user_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fld_user_username.getText().isEmpty() || fld_user_parola.getText().isEmpty()){
                    Helper.showMessage("fill");
                }else{
                    try {
                     User user = User.getFetch(fld_user_username.getText(), fld_user_parola.getText());
                        if (user == null)
                        {
                            Helper.showMessage("Kullanıcı Bulunamadı");
                        }else{
                            switch (user.getType())
                            {
                                case "operator":
                                    OperatorGUI operatorGUI = new OperatorGUI((Operator) user);
                                    break;
                                case "educator":
                                    EducatorGUI educatorGUI = new EducatorGUI();
                                    break;
                                case "student":
                                    StudentGUI studentGUI = new StudentGUI();
                                    break;
                            }
                            dispose();

                        }
                    } catch (SQLException | UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        LoginGUI loginGUI = new LoginGUI();


    }
}
