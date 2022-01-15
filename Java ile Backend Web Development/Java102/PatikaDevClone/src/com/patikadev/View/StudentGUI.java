package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;

import javax.swing.*;
import java.awt.*;

public class StudentGUI extends JFrame {
    private JPanel wrapper;

    public StudentGUI() throws HeadlessException {
        add(wrapper);
        setSize(200, 200);
        setSize(new Dimension(1000, 500));
        this.setLocation(Helper.screenSize.width / 2 - this.getSize().width / 2, Helper.screenSize.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
    }
}
