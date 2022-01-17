package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Operator extends User{
    public Operator() {
    }

    public Operator(String name, String surname, String username, String type, int id, String password) {
        super(name, surname, username, type, id, password);
    }

    public static int addOperator(Operator operator) throws SQLException {
        String type = "operator";
        int result;
        String columnNames[] = new String[]{"id"};
        String query = "INSERT INTO public.\"user\"(\n" +
                "\tusername, surname, name,  type, password)\n" +
                "\tVALUES (?, ?, ?,?, ?);";
        User userCheck = User.getFetch(operator.getUsername());
        if (userCheck != null) {
            Helper.showMessage("Duplicate Kayıt");
            result = -1;
            return result;
        }

        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query, columnNames);
        preparedStatement.setString(1, operator.getUsername());
        preparedStatement.setString(2, operator.getSurname());
        preparedStatement.setString(3, operator.getName());
        preparedStatement.setString(4, type);
        preparedStatement.setString(5, operator.getPassword());
        result = preparedStatement.executeUpdate();
        if (result == 1) {
            java.sql.ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                operator.setId(generatedKeys.getInt(1));
                Helper.showMessage("success");
            }
        }
        return result;
    }

}
