package com.example.productcatalog.version1;

public class Main {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        long start = System.currentTimeMillis();
//    simulate 1000 requests
        for (int i = 0; i < 1000000; i++) {
            Product product = catalog.getProduct(101);
        }

        // Simulate 10 updates.
        for (int i = 0; i < 10; i++) {
            catalog.updatePrice(101, 80000 + i);
        }

        long end = System.currentTimeMillis();

        System.out.println("Final product: "
                + catalog.getProduct(101));

        System.out.println("Execution time: "
                + (end - start) + " ms");

    }

}
