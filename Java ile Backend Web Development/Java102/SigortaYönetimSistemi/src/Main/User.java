package Main;

import Addresses.Address;
import Addresses.BusinessAddress;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private String name, surname, email, password, job;
    private int age;
    private Date lastLogin;
    List<Address> addressList = new ArrayList<Address>();

    public User(String name, String surname, String email, String password, String job, int age, Date lastLogin, List<Address> addressList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.lastLogin = lastLogin;
        this.addressList = addressList;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList, BusinessAddress buisness) {
        this.addressList = addressList;
    }

}
