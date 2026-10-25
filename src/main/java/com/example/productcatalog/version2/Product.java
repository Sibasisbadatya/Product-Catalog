package com.example.productcatalog.version2;

public class Product {
    private final int id;
    private String name;
    private Integer price;

    public Product(int id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public synchronized void updatePrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{id=" + id
                + ", name='" + name + '\''
                + ", price=" + price + '}';
    }
}
