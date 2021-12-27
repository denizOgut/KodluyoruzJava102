package Account;

import Addresses.Address;
import Insurance.Insurance;
import Main.AuthenticationStatus;
import Main.InvalidAuthenticationException;
import Main.User;

import java.util.ArrayList;
import java.util.List;

abstract public class Account implements Comparable<Account>{
    AuthenticationStatus authenticationStatus = AuthenticationStatus.FAIL;
    private User user;
    private List<Insurance> insuranceList = new ArrayList<>();

    public Account(User user) {
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public final void showUserInfo(User user) {
        System.out.println("User's name: " + user.getName());
        System.out.println("User's surname: " + user.getSurname());
        System.out.println("User's age: " + user.getAge());
        System.out.println("User's job: " + user.getJob());
        System.out.println("User's email: " + user.getEmail());
        System.out.println("User's last login time: " + user.getLastLogin());
        user.getAddressList().forEach(address -> {
            System.out.println(address.showAddress());
        });

    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            authenticationStatus = AuthenticationStatus.SUCCESS;
            System.out.println("Login success");
        } else {
            throw new InvalidAuthenticationException("Invalid mail / password ");
        }
    }

    public void addAddress(Address address) {
        user.getAddressList().add(address);
    }

    public boolean removeAddress(Address address) {
        return user.getAddressList().remove(address);
    }

    public abstract boolean addInsurance(Insurance insurance);

}