package Main;

import Account.Individual;
import Addresses.Address;
import Addresses.BusinessAddress;
import Addresses.HomeAddress;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BusinessAddress businessAddress = new BusinessAddress("buisness");
        HomeAddress homeAddress = new HomeAddress("Home");
        List<Address> addressList = new ArrayList<>();
        addressList.add(homeAddress);
        addressList.add(businessAddress);
        User user = new User("Deniz", "Ogut", "deniz@gmail.com", "123456", "Yazılım Geliştirici", 28, new Date(),addressList);

        Individual individual = new Individual(user);
        individual.showUserInfo(user);
    }
}
