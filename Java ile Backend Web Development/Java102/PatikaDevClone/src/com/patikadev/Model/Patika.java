package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Patika {
    private int id;
    private String name;

    public Patika() {
    }

    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Patika> showAllPatika() throws SQLException {
        String query = "SELECT * FROM public.patika";
        ArrayList<Patika> patikaList = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Patika patika = new Patika(resultSet.getInt("id"), resultSet.getString("name"));
            patikaList.add(patika);
        }
        return patikaList;
    }

    public static ArrayList<Patika> showAllPatikaByUser(int patika_id) throws SQLException {
        String query = "SELECT * FROM public.patika WHERE id = " + patika_id;
        ArrayList<Patika> patikaList = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            Patika patika = new Patika(id, name);
            patikaList.add(patika);
        }
        return patikaList;
    }

    public static int addPatika(Patika patika) throws SQLException {
        int result = 0;
        String columnNames[] = new String[]{"id"};
        String query = "INSERT INTO public.patika(name)VALUES (?)";
        Patika patikaCheck = Patika.getFetch(patika.getId());
        if (patikaCheck != null) {
            Helper.showMessage("Duplicate Kayıt");
            result = -1;
            return result;
        }
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query, columnNames);
        preparedStatement.setString(1, patika.getName());
        result = preparedStatement.executeUpdate();
        if (result == 1) {
            java.sql.ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                patika.setId(generatedKeys.getInt(1));
                Helper.showMessage("success");
            }
        }
        return result;
    }

    public static Patika getFetch(int id) throws SQLException {
        Patika obj = null;
        String query = "SELECT * FROM public.patika WHERE id = ?";
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            obj = new Patika(resultSet.getInt("id"), resultSet.getString("name"));


        }
        return obj;
    }

    public static boolean updatePatika(int id, String name) throws SQLException {
        String query = "UPDATE public.patika\n" +
                "\tSET  name=?\n" +
                "\tWHERE id=?;";

        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = DBConnecter.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void deletePatika(int id) throws SQLException {
        String query = "DELETE FROM public.patika\n" +
                "\tWHERE id=?";
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeQuery();

    }

}
