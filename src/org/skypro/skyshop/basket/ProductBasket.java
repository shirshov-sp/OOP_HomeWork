package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private String basketName;
    private Map<String, List<Product>> products;

    public ProductBasket(String basketName) {
        this.basketName = basketName;
        this.products = new HashMap<>();
    }

    public String getName() {
        return basketName;
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName().toLowerCase(), k -> new LinkedList<>()).add(product);
        System.out.println("Продукт \"" + product.getName() + "\" успешно добавлен в " + basketName);
    }

    public int sumPrices() {
        int total = 0;
        total += products.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
        return total;
    }

    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    private Map<String, List<Product>> getProducts() {
        return products;
    }

    public void printProductBasket() {
        int total2 = 0;
        int specialProductCount = 0;
        System.out.println(basketName + ":");
        products.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
        int total = sumPrices();
        if (total != 0) {
            System.out.println("Итого: " + total + " руб.");
            System.out.println("Специальных товаров: " + getSpecialCount());
        } else {
            System.out.println("В корзине пусто.");
        }
    }

    public boolean isProductInBasket(String name) {
        return products.containsKey(name.toLowerCase());
    }

    public void cleanBasket() {
        products.clear();
    }

    public List<Product> deleteProductByName(String name) {
        List<Product> deletedProducts = new LinkedList<>();
        if (products.containsKey(name.toLowerCase())) {
            deletedProducts = products.get(name);
            products.remove(name.toLowerCase());
        }
        return deletedProducts;
    }
}