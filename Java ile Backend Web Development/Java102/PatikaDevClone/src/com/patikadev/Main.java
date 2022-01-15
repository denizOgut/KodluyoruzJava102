package com.patikadev;

import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;
import com.patikadev.View.OperatorGUI;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Operator operator = new Operator();
        operator.setName("Deniz");
        operator.setSurname("Ogut");
        Helper.setLayOut();
        OperatorGUI operatorGUI = new OperatorGUI(operator);

        for (User user:User.showAllUser()) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getSurname() + " " + user.getUsername() + " " + user.getType());
        }

    }
}
