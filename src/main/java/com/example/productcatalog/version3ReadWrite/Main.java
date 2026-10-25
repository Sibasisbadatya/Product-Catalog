package com.example.productcatalog.version3ReadWrite;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        List<Thread> threads = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Thread reader = new Thread(() -> {
                Product product = catalog.getProduct(101);
                if (product != null) {
                    double price = product.getPrice();
                }
            });

            threads.add(reader);
            reader.start();
        }

        for (int i = 0; i < 1000; i++) {
            final int writerId = i;

            Thread writer = new Thread(() -> {
                catalog.updatePrice(
                        101, 80000 + writerId+1
                );
            });

            threads.add(writer);
            writer.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("Final product: "
                + catalog.getProduct(101));

        System.out.println("Execution time: "
                + (end - start) + " ms");


    }

}
