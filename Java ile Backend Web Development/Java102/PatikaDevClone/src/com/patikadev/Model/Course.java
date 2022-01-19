package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Course {
    private int id, user_id, patika_id;
    private String name, language;

    User educator;
    Patika patika;

    public Course(int id, int user_id, int patika_id, String name, String language) throws SQLException {
        this.id = id;
        this.user_id = user_id;
        this.patika_id = patika_id;
        this.name = name;
        this.language = language;
        this.patika = Patika.getFetch(patika_id);
        this.educator = User.getFetch(user_id);
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPatika_id() {
        return patika_id;
    }

    public void setPatika_id(int patika_id) {
        this.patika_id = patika_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public User getEducator() {
        return educator;
    }

    public void setEducator(User educator) {
        this.educator = educator;
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }


    public static ArrayList<Course> showAllCourse() throws SQLException {
        String query = "SELECT * FROM public.course";
        ArrayList<Course> courseList = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int user_id = resultSet.getInt("user_id");
            int patika_id = resultSet.getInt("patika_id");
            String name = resultSet.getString("name");
            String language = resultSet.getString("language");
            Course course = new Course(id, user_id, patika_id, name, language);
            courseList.add(course);
        }
        return courseList;
    }


    public static ArrayList<Course> showAllCourseByUser(int user_id) throws SQLException {
        String query = "SELECT * FROM public.course WHERE user_id = " + user_id;
        ArrayList<Course> courseList = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt("user_id");
            int patika_id = resultSet.getInt("patika_id");
            String name = resultSet.getString("name");
            String language = resultSet.getString("language");
            Course course = new Course(id, userId, patika_id, name, language);
            courseList.add(course);
        }
        return courseList;
    }

    public static boolean addCourse(int user_id, int patika_id, String name, String language) throws SQLException {
        String query = "INSERT INTO public.course(\n" +
                "\tuser_id, patika_id, name, language)\n" +
                "\tVALUES (?, ?, ?, ?)";
        boolean result;
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setInt(2, patika_id);
        preparedStatement.setString(3, name);
        preparedStatement.setString(4, language);
        result = preparedStatement.execute();
        return result;
    }

    public static void deleteCourseById(int deleteId) throws SQLException {
        String query = "DELETE FROM public.\"course\"\n" +
                "\tWHERE id=?";
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        preparedStatement.setInt(1, deleteId);
        preparedStatement.executeQuery();
    }

    public static Course getFetch(int id) throws SQLException {
        Course obj = null;
        String query = "SELECT * FROM public.\"course\" WHERE id = ?";
        PreparedStatement preparedStatement = DBConnecter.getInstance().prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            obj = new Course();
            obj.setName(resultSet.getString("name"));
            obj.setLanguage(resultSet.getString("language"));
            obj.setPatika_id(resultSet.getInt("patika_id"));
            obj.setUser_id(resultSet.getInt("user_id"));
        }
        return obj;
    }

}
