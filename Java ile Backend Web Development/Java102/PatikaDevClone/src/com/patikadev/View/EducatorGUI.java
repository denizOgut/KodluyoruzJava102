package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EducatorGUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_welcome;
    private JTabbedPane tabbedPane1;
    private JTable tbl_course_list;
    private JTextField fld_content_title;
    private JTextField fld_content_description;
    private JTextField fld_content_link;
    private JTextField fld_content_quiz;
    private JTextField fld_content_info;
    private JComboBox cmb_content_patika;
    private JComboBox cmb_content_course;
    private JButton btn_save;
    private JTextField textField1;
    private final Educator educator;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;

    public EducatorGUI(Educator educator) throws HeadlessException, SQLException {
        this.educator = educator;
        add(wrapper);
        setSize(200, 200);
        setSize(new Dimension(1000, 500));
        this.setLocation(Helper.screenSize.width / 2 - this.getSize().width / 2, Helper.screenSize.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        lbl_welcome.setText(educator.getName() + " " + educator.getSurname());

        mdl_course_list = new DefaultTableModel();
        Object[] col_courseList = {"id", "Ders Adı", "Programlama Dili", "Patika", "Eğitmen"};
        mdl_course_list.setColumnIdentifiers(col_courseList);
        row_course_list = new Object[col_courseList.length];
        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        loadCourseModel();
        loadPatikaCombo();
        loadCourseCombo();
        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item patikaItem = (Item) cmb_content_patika.getSelectedItem();
                Item courseItem = (Item) cmb_content_course.getSelectedItem();
                if (fld_content_title.getText().isEmpty() || fld_content_info.getText().isEmpty() ||
                        fld_content_description.getText().isEmpty() || fld_content_link.getText().isEmpty() || fld_content_quiz.getText().isEmpty()) {
                    Helper.showMessage("fill");
                } else {
                    try {
                        if(Content.addContent(fld_content_title.getText(), fld_content_description.getText(),fld_content_link.getText(),fld_content_quiz.getText(),fld_content_info.getText(),courseItem.getKey(),patikaItem.getKey()))
                        {
                            Helper.showMessage("success");
                        }
                        loadCourseModel();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        });
    }


    private void loadCourseModel() throws SQLException {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        for (Course course : Course.showAllCourseByUser(this.educator.getId())) {
            row_course_list[0] = course.getId();
            row_course_list[1] = course.getName();
            row_course_list[2] = course.getLanguage();
            row_course_list[3] = course.getPatika().getName();
            row_course_list[4] = course.getEducator().getName() + " " + course.getEducator().getSurname();
            mdl_course_list.addRow(row_course_list);
        }
    }

    public void loadPatikaCombo() throws SQLException {

        cmb_content_course.removeAllItems();
        cmb_content_patika.addItem("");
        for (Course c : Course.showAllCourseByUser(educator.getId())) {
            cmb_content_patika.addItem(new Item(c.getId(),c.getPatika().getName()));
        }
    }

    public void loadCourseCombo() throws SQLException {
        cmb_content_course.removeAllItems();
        cmb_content_course.addItem("");
        for (Course c : Course.showAllCourseByUser(educator.getId())) {
            cmb_content_course.addItem(new Item(c.getId(), c.getName() ));
        }
    }


}
