package Model;

import Helper.DBHelper;
import Model.Enum.UserType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String name, surname, userName, mail;
    private int age, kimlikNo, mobilePhone;
    private UserType userType;

    public User() {
    }

    public User(String name, String surname, String userName, String mail, int age, int idNo, int mobilePhone, UserType userType) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.mail = mail;
        this.age = age;
        this.kimlikNo = idNo;
        this.mobilePhone = mobilePhone;
        this.userType = userType;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(int kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public int getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(int mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType() {
        if (this.age < 12) {
            this.userType = UserType.COCUK;
        } else {
            this.userType = UserType.YETISKIN;
        }

    }

    public static User getFetch(String username) throws SQLException {
        User obj = null;
        String query = "SELECT * FROM [TurizmAcenteSistemi].[dbo].[user] WHERE [username] = ? ";
        PreparedStatement preparedStatement = DBHelper.getInstance().prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            obj = new User();
        }

        return obj;
    }
}
