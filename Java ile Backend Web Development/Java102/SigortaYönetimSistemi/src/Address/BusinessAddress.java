package Address;

public class BusinessAddress implements Address{
    private String businessAddress;

    public BusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    @Override
    public String getAddress() {
        return this.businessAddress;
    }
}
