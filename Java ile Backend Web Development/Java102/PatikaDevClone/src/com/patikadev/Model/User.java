package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name, surname, username, type, password;
    private int id;

    public User() {
    }

    public User(String name, String surname, String username, String type, int id, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.type = type;
        this.id = id;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<User> showAllUser() throws SQLException {
        String query = "SELECT * FROM public.\"user\"";
        ArrayList<User> userList = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            User user = new User();
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setUsername(resultSet.getString("username"));
            user.setType(resultSet.getString("type"));
            user.setId(resultSet.getInt("id"));
            user.setPassword(resultSet.getString("password"));
            userList.add(user);
        }
        return userList;
    }

    public static int addUser(User user) throws SQLException {
        int result;
        String columnNames[] = new String[]{"id"};
        String query = "INSERT INTO public.\"user\"(\n" +
                "\tusername, surname, name,  type, password)\n" +
                "\tVALUES (?, ?, ?, ?, ?);";
        User userCheck = User.getFetch(user.getUsername());
        if (userCheck != null) {
            Helper.showMessage("Duplicate Kayıt");
            result = -1;
            return result;
        }

        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query, columnNames);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setString(3, user.getName());
        preparedStatement.setString(4, user.getType());
        preparedStatement.setString(5, user.getPassword());
        result = preparedStatement.executeUpdate();
        if (result == 1) {
            java.sql.ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
                Helper.showMessage("success");
            }
        }
        return result;
    }

    public static User getFetch(String username) throws SQLException {
        User obj = null;
        String query = "SELECT * FROM public.\"user\" WHERE username = ?";
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            obj = new User();
            obj.setName(resultSet.getString("name"));
            obj.setSurname(resultSet.getString("surname"));
            obj.setUsername(resultSet.getString("username"));
            obj.setType(resultSet.getString("type"));
            obj.setId(resultSet.getInt("id"));
            obj.setPassword(resultSet.getString("password"));
        }
        return obj;
    }

    public static User getFetch(int id) throws SQLException {
        User obj = null;
        String query = "SELECT * FROM public.\"user\" WHERE id = ?";
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            obj = new User();
            obj.setName(resultSet.getString("name"));
            obj.setSurname(resultSet.getString("surname"));
            obj.setUsername(resultSet.getString("username"));
            obj.setType(resultSet.getString("type"));
            obj.setId(resultSet.getInt("id"));
            obj.setPassword(resultSet.getString("password"));
        }
        return obj;
    }

    public static User getFetch(String username,String password) throws SQLException {
        User obj = null;
        String query = "SELECT * FROM public.\"user\" WHERE username = ? AND password = ? ";
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            switch (resultSet.getString("type")) {
                case "operator":
                    obj = new Operator();
                    break;
                case "student":
                    obj = new Student();
                    break;
                case "educator":
                    obj = new Educator();
                    break;
                default:
                    obj = new User();
            }

            obj.setName(resultSet.getString("name"));
            obj.setSurname(resultSet.getString("surname"));
            obj.setUsername(resultSet.getString("username"));
            obj.setType(resultSet.getString("type"));
            obj.setId(resultSet.getInt("id"));
            obj.setPassword(resultSet.getString("password"));
        }

        return obj;
    }


    public static void deleteUserById(int deleteId) throws SQLException {
        ArrayList<Course> courseList = Course.showAllCourseByUser(deleteId);
        String query = "DELETE FROM public.\"user\"\n" +
                "\tWHERE id=?";
        for (Course c:courseList) {
            Course.deleteCourseById(c.getId());
        }
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        preparedStatement.setInt(1, deleteId);
        preparedStatement.executeQuery();
    }

    public static boolean updateUser(int id, String name, String surname, String username, String type, String password) throws SQLException {
        String query = "UPDATE public.\"user\"\n" +
                "\tSET username=?, surname=?, name=?,type=?, password=?\n" +
                "\tWHERE id = ?";
        User userCheck = User.getFetch(username);
        if (userCheck != null && userCheck.getId() != id) {
            Helper.showMessage("Duplicate Kayıt");
            return false;
        }
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DBConnecter.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, type);
            preparedStatement.setString(5, password);
            preparedStatement.setInt(6, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static ArrayList<User> searchUserList( String query) throws SQLException {

        ArrayList<User> userList = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            User user = new User();
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setUsername(resultSet.getString("username"));
            user.setType(resultSet.getString("type"));
            user.setId(resultSet.getInt("id"));
            user.setPassword(resultSet.getString("password"));
            userList.add(user);
        }
        return userList;
    }

    public static String searchQuery(String username , String type)
    {
        String query = "SELECT * FROM public.\"user\"\n" +
                "WHERE username LIKE '%{{username}}%' AND type LIKE '{{type}}' ";
        query = query.replace("{{username}}",username);
        query = query.replace("{{type}}",type);
        return query;
    }
}
