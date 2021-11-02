package Products;

import Enums.Brands;
import Enums.Colours;

public class MobilePhone extends Product {
    private int cam;
    private double battery;
    private Colours colours;


    public MobilePhone(int id, String productName, double price, Brands brands, int storage, double screen, int ram,int cam, double battery, Colours colours) {
        this.setId(id);
        this.setProductName(productName);
        this.setPrice(price);
        this.setBrands(brands);
        this.setStorage(storage);
        this.setScreen(screen);
        this.setRam(ram);
        this.cam = cam;
        this.battery = battery;
        this.colours = colours;
    }

    public int getCam() {
        return cam;
    }

    public void setCam(int cam) {
        this.cam = cam;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public Colours getColours() {
        return colours;
    }

    public void setColours(Colours colours) {
        this.colours = colours;
    }

    public void print(){
        System.out.printf("|%2d  | %-30s| %.1f    | %-9s | %6d    | %7.1f   | %-9d | %-9b | %-10s|\n",getId(),getProductName(),getPrice(),getBrands(),getStorage(),getScreen(),getRam(),getBattery(),getColours());
    }
}
