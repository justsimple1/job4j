package ru.job4j.pojo;

public class Shop {
    public Product[] delete(Product[] products, int index) {
       products[index] = null;
       return products;
    }

    public static void main(String[] args) {
        Shop shop = new Shop();

        Product[] products = new Product[4];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        products[3] = new Product("Oil", 11);

        shop.delete(products, 0);
        for (int index = 0; index < products.length; index++) {
            if (index < products.length - 1) {
                products[index] = products[index + 1];
            }
        }
        products[products.length - 1] = null;
        System.out.println("After delete Milk");
        for (int index = 0; index < products.length; index++) {
            Product product = products[index];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}
