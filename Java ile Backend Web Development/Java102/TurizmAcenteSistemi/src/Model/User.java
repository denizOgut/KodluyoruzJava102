package Model;

import Model.Enum.UserType;

public class User {
    private String name,surname,userName,mail;
    private int age,idNo,mobilePhone;
    private UserType userType;

    public User() {
    }

    public User(String name, String surname, String userName, String mail, int age, int idNo, int mobilePhone, UserType userType) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.mail = mail;
        this.age = age;
        this.idNo = idNo;
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

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
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
        if (this.age < 12){
            this.userType = UserType.COCUK;
        }else{
            this.userType = UserType.YETISKIN;
        }

    }
}
