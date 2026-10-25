package com.example.productcatalog.version1;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private final Map<Integer, Product> products =
            new HashMap<>();

    public ProductCatalog(){
        products.put(101,new Product(101,"iPhone",1000));
        products.put(102,new Product(102,"Laptop",2000));
        products.put(103,new Product(103,"TV",3000));
    }

    public Product getProduct(Integer id){
        return products.get(id);
    }

    public void updatePrice(int id, int price) {
        Product product = products.get(id);

        if (product != null) {
            product.updatePrice(price);
        }
    }
}
