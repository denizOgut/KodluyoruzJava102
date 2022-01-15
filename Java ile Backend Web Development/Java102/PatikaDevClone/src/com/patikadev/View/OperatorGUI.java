package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.Course;
import com.patikadev.Model.Operator;
import com.patikadev.Model.Patika;
import com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane pnl_course_form;
    private JLabel lbl_welcome;
    private JPanel panel_user_list;
    private JButton button_logout;
    private JScrollPane scroll_user_list;
    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private JTextField fld_user_name;
    private JTextField fld_user_surname;
    private JTextField fld_user_username;
    private JPasswordField fld_user_password;
    private JComboBox cmb_user_type;
    private JButton btn_user_add;
    private JTextField fld_user_ıd;
    private JButton btn_user_delete;
    private JTextField fld_search_user_name;
    private JComboBox cmb_search_type;
    private JButton btn_search_user;
    private JPanel pnl_patika_list;
    private JScrollPane scrll_patika_list;
    private JTable tbl_patika_list;
    private JTextField fld_patika_name;
    private JButton btn_patika_add;
    private JPanel pnl_patika_add;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JPanel pnl_course_add;
    private JTextField fld_course_name;
    private JTextField fld_course_lang;
    private JComboBox cmb_course_patika;
    private JComboBox cmb_course_user;
    private JButton btn_course_add;
    private final Operator operator;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;
    private DefaultTableModel mdl_patika_list;
    private Object[] row_patika_list;
    private JPopupMenu patikaMenu;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;

    public OperatorGUI(Operator operator) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        this.operator = operator;
        add(wrapper);
        setSize(new Dimension(1000, 500));
        this.setLocation(Helper.screenSize.width / 2 - this.getSize().width / 2, Helper.screenSize.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);


        lbl_welcome.setText(lbl_welcome.getText() + ": " + operator.getName() + " " + operator.getSurname());
        //ModelUserList
        mdl_user_list = new DefaultTableModel();
        Object[] col_user_list = {"ID", "NAME", "SURNAME", "USERNAME", "TYPE", "PASSWORD"};
        row_user_list = new Object[col_user_list.length];
        mdl_user_list.setColumnIdentifiers(col_user_list);
        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);
        tbl_user_list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tbl_user_list.getSelectedRow() != -1) {
                    String selectedUserId = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString();
                    fld_user_ıd.setText(selectedUserId);
                }

            }
        });
        tbl_user_list.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int user_id = Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString());
                    String name = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 1).toString();
                    String sur_name = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 2).toString();
                    String user_name = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 3).toString();
                    String type = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 4).toString();
                    String password = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 5).toString();
                    try {
                        if (User.updateUser(user_id, name, sur_name, user_name, type, password)) {
                            Helper.showMessage("success");

                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        loadUserModel();
                        loadEducatorCombo();
                        loadCourseModel();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        loadUserModel();


        patikaMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Güncelle");
        JMenuItem deleteMenu = new JMenuItem("Sil");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);

        updateMenu.addActionListener(e -> {
            int selectId = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
            try {
                updatePatikaGUI updatePatikaGUI = new updatePatikaGUI(Patika.getFetch(selectId));
                updatePatikaGUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        try {
                            loadPatikaModel();
                            loadPatikaCombo();
                            loadCourseModel();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                    }
                });
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        deleteMenu.addActionListener(e -> {
            int selectId = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
            try {
                Patika.deletePatika(selectId);
                Helper.showMessage("success");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                loadPatikaModel();
                loadPatikaCombo();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        mdl_patika_list = new DefaultTableModel();
        Object[] col_patika_list = {"ID", "Patika Adı"};
        mdl_patika_list.setColumnIdentifiers(col_patika_list);
        row_patika_list = new Object[col_patika_list.length];
        tbl_patika_list.setModel(mdl_patika_list);
        tbl_patika_list.setComponentPopupMenu(patikaMenu);
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_patika_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                Point point = e.getPoint();
                int selectedRow = tbl_patika_list.rowAtPoint(point);
                tbl_patika_list.setRowSelectionInterval(selectedRow, selectedRow);

            }
        });


        mdl_course_list = new DefaultTableModel();
        Object[] col_courseList = {"id", "Ders Adı", "Programlama Dili", "Patika", "Eğitmen"};
        mdl_course_list.setColumnIdentifiers(col_courseList);
        row_course_list = new Object[col_courseList.length];
        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);


        loadPatikaModel();
        loadCourseModel();
        loadPatikaCombo();
        loadEducatorCombo();

        btn_user_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                if (fld_user_name.getText().isEmpty() || fld_user_username.getText().isEmpty() || fld_user_password.getText().isEmpty() ||
                        fld_user_surname.getText().isEmpty() || cmb_user_type.getSelectedItem() == null) {
                    Helper.showMessage("fill");
                } else {
                    user.setName(fld_user_name.getText());
                    user.setPassword(fld_user_password.getText());
                    user.setUsername(fld_user_username.getText());
                    user.setSurname(fld_user_surname.getText());
                    user.setType(cmb_user_type.getSelectedItem().toString());
                    try {
                        User.addUser(user);
                        loadUserModel();
                        loadEducatorCombo();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
                fld_user_name.setText(null);
                fld_user_password.setText(null);
                fld_user_surname.setText(null);
                fld_user_username.setText(null);
            }
        });
        btn_user_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fld_user_ıd.getText().isEmpty()) {
                    Helper.showMessage("fill");
                }
                try {
                    User.deleteUserById(Integer.parseInt(fld_user_ıd.getText()));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                Helper.showMessage("success");
                try {
                    loadUserModel();
                    loadEducatorCombo();
                    loadCourseModel();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                fld_user_ıd.setText(null);
            }
        });
        btn_search_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<User> searchingUser = null;
                String userName = fld_search_user_name.getText();
                String type = Objects.requireNonNull(cmb_user_type.getSelectedItem()).toString();
                String query = User.searchQuery(userName, type);
                try {
                    searchingUser = User.searchUserList(query);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                try {
                    assert searchingUser != null;
                    loadUserModel(searchingUser);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btn_patika_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Patika patika = new Patika();
                if (fld_patika_name.getText().isEmpty()) {
                    Helper.showMessage("fill");
                } else {
                    patika.setName(fld_patika_name.getText());
                    try {
                        Patika.addPatika(patika);
                        loadPatikaModel();
                        loadPatikaCombo();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
                fld_patika_name.setText(null);


            }
        });
        btn_course_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item patikaItem = (Item) cmb_course_patika.getSelectedItem();
                Item userItem = (Item) cmb_course_user.getSelectedItem();
                if (fld_course_name.getText().isEmpty() || fld_course_lang.getText().isEmpty()) {
                    Helper.showMessage("fill");
                } else {
                    try {
                        assert userItem != null;
                        assert patikaItem != null;
                        if (Course.addCourse(userItem.getKey(), patikaItem.getKey(), fld_course_name.getText(), fld_course_lang.getText())) {
                            Helper.showMessage("success");
                            loadCourseModel();
                        } else {
                            Helper.showMessage("error");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    fld_course_lang.setText(null);
                    fld_course_name.setText(null);
                }
            }
        });
        button_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginGUI loginGUI = new LoginGUI();
            }
        });
    }

    private void loadCourseModel() throws SQLException {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika_list.getModel();
        clearModel.setRowCount(0);
        for (Course course : Course.showAllCourse()) {
            row_course_list[0] = course.getId();
            row_course_list[1] = course.getName();
            row_course_list[2] = course.getLanguage();
            row_course_list[3] = course.getPatika().getName();
            row_course_list[4] = course.getEducator().getName() + " " + course.getEducator().getSurname();
            mdl_course_list.addRow(row_course_list);
        }
    }

    private void loadPatikaModel() throws SQLException {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika_list.getModel();
        clearModel.setRowCount(0);
        for (Patika patika : Patika.showAllPatika()) {
            row_patika_list[0] = patika.getId();
            row_patika_list[1] = patika.getName();
            mdl_patika_list.addRow(row_patika_list);
        }
    }

    public void loadPatikaCombo() throws SQLException {
        cmb_course_patika.removeAllItems();
        for (Patika p : Patika.showAllPatika()) {
            cmb_course_patika.addItem(new Item(p.getId(), p.getName()));
        }
    }

    public void loadEducatorCombo() throws SQLException {
        cmb_course_user.removeAllItems();
        for (User user : User.showAllUser()) {
            if (user.getType().equals("educator")) {
                cmb_course_user.addItem(new Item(user.getId(), user.getName() + " " + user.getSurname()));
            }
        }
    }

    public void loadUserModel() throws SQLException {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);
        for (User user : User.showAllUser()) {
            row_user_list[0] = user.getId();
            row_user_list[1] = user.getName();
            row_user_list[2] = user.getSurname();
            row_user_list[3] = user.getUsername();
            row_user_list[4] = user.getType();
            row_user_list[5] = user.getPassword();
            mdl_user_list.addRow(row_user_list);
        }
    }

    public void loadUserModel(ArrayList<User> userArrayList) throws SQLException {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);
        for (User user : userArrayList) {
            row_user_list[0] = user.getId();
            row_user_list[1] = user.getName();
            row_user_list[2] = user.getSurname();
            row_user_list[3] = user.getUsername();
            row_user_list[4] = user.getType();
            row_user_list[5] = user.getPassword();
            mdl_user_list.addRow(row_user_list);
        }
    }
}
