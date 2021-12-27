package Addresses;

public class BusinessAddress implements Address{
    String address;

    public BusinessAddress(String address) {
        this.address = address;
    }

    @Override
    public String showAddress() {
        return address;
    }
}
