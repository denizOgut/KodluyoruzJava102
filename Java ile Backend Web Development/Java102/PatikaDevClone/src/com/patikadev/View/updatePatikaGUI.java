package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Patika;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class updatePatikaGUI extends JFrame {
    private JPanel wrapper;
    private JTextField fld_patika_name;
    private JButton btn_update;
    private Patika patika;

    public updatePatikaGUI(Patika patika) throws HeadlessException {
        this.patika = patika;
        add(wrapper);
        setSize(300, 150);
        this.setLocation(Helper.screenSize.width / 2 - this.getSize().width / 2, Helper.screenSize.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        fld_patika_name.setText(patika.getName());
        btn_update.addActionListener(e -> {
            if (fld_patika_name.getText().isEmpty()) {
                Helper.showMessage("fill");
            } else {
                try {
                    if (Patika.updatePatika(patika.getId(), fld_patika_name.getText())) {
                        Helper.showMessage("success");

                    } else {
                        dispose();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
