package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.Student;
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
    private JTabbedPane tabbedPane1;
    private JTextField fld_student_name;
    private JTextField fld_student_surname;
    private JTextField fld_student_uname;
    private JTextField fld_student_parola;
    private JButton btn_signIn;

    public LoginGUI() throws HeadlessException {
        add(wrapper);
        setSize(200, 200);
        setSize(new Dimension(1000, 500));
        this.setLocation(Helper.screenSize.width / 2 - this.getSize().width / 2, Helper.screenSize.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);


        btn_user_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fld_user_username.getText().isEmpty() || fld_user_parola.getText().isEmpty()) {
                    Helper.showMessage("fill");
                } else {
                    try {
                        User user = User.getFetch(fld_user_username.getText(), fld_user_parola.getText());
                        if (user == null) {
                            Helper.showMessage("Kullanıcı Bulunamadı");
                        } else {
                            switch (user.getType()) {
                                case "operator":
                                    OperatorGUI operatorGUI = new OperatorGUI((Operator) user);
                                    break;
                                case "educator":
                                    EducatorGUI educatorGUI = new EducatorGUI();
                                    break;
                                case "student":
                                    StudentGUI studentGUI = new StudentGUI((Student) user);
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
        btn_signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                if (fld_student_name.getText().isEmpty() || fld_student_surname.getText().isEmpty() || fld_student_uname.getText().isEmpty() ||
                        fld_student_parola.getText().isEmpty()) {
                    Helper.showMessage("fill");
                } else {
                    student.setName(fld_student_name.getText());
                    student.setPassword(fld_student_parola.getText());
                    student.setUsername(fld_student_uname.getText());
                    student.setSurname(fld_student_surname.getText());
                    try {
                        Student.addStudent(student);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                fld_student_name.setText(null);
                fld_student_surname.setText(null);
                fld_student_uname.setText(null);
                fld_student_parola.setText(null);
                StudentGUI studentGUI = new StudentGUI(student);
                dispose();


            }
        });

    }
        public static void main (String[]args){
            LoginGUI loginGUI = new LoginGUI();


        }
    }


