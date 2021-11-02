package Products;

import Enums.Brands;

public class Notebook extends Product{
    public Notebook(int id, String productName, double price, Brands brands,int storage,double screen, int ram) {
        this.setId(id);
        this.setProductName(productName);
        this.setPrice(price);
        this.setBrands(brands);
        this.setStorage(storage);
        this.setScreen(screen);
        this.setRam(ram);
    }
}
