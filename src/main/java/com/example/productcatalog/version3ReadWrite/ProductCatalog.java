package com.example.productcatalog.version3ReadWrite;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ProductCatalog {
    private final Map<Integer, Product> products =
            new HashMap<>();

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    Lock rLock = readWriteLock.readLock();
    Lock wLock = readWriteLock.writeLock();

    public ProductCatalog() {
        products.put(101, new Product(101, "iPhone", 1000));
        products.put(102, new Product(102, "Laptop", 2000));
        products.put(103, new Product(103, "TV", 3000));
    }

    public Product getProduct(Integer id) {
        rLock.lock();
        try {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return products.get(id);
        } finally {
            rLock.unlock();
        }
    }

    public void updatePrice(int id, int price) {

        wLock.lock();
        try {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Product product = products.get(id);

            if (product != null) {
                product.updatePrice(price);
            }
        }finally {
            wLock.unlock();
        }
    }
}
