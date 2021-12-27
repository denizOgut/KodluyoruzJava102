package Addresses;

public class HomeAddress implements Address {

    private String address;

    public HomeAddress(String address) {
        this.address = address;
    }

    @Override
    public String showAddress() {
        return address;
    }
}
