package Address;

public class HomeAddress implements Address{
    private String homeAddress;
    public HomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    @Override
    public String getAddress() {
        return this.homeAddress;
    }
}
