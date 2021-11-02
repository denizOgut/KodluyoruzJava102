package Products;

import Enums.Brands;

import java.util.Comparator;

public abstract class Product {
    private String productName;
    private int id, storage, ram;
    private double price, screen;
    private Brands brands;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getScreen() {
        return screen;
    }

    public void setScreen(double screen) {
        this.screen = screen;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    public void print(){
        System.out.printf("|%2d  | %-30s| %.1s    | %-9s | %6d    | %7.1f   | %-6d |\n",this.getId(),this.getProductName(),this.getPrice(),this.getBrands(),this.getStorage(),this.getScreen(),this.getRam());
    }


}
