package app;

import javax.persistence.*;

@Entity
@Table (name="Product")
public class Product {
    @Id
    @Column(name="Prod_ID")
    private int id;
    @Column(name="Prod_Name")
    private String name;
    @Column(name="Prod_Price")
    private double price;
    @Column (name="Cat_Code")
    private String category;
    @Column (name="Sup_Code")
    private String supplier;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getCategory() {
        return this.category;
    }

    public String getSupplier() { return this.supplier; }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private void setCategory(String category) {
        this.category = category;
    }

    private void setSupplier(String supplier) { this.supplier = supplier; }


    Product() {
    }

    Product(int id, String name, double price, int inStock, String category, String supplier) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setCategory(category);
        this.setSupplier(supplier);
    }
}