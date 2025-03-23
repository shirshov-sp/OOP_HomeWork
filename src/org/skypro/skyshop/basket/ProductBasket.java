package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ProductBasket {
    private List<Product> products;
    private String basketName;

    public ProductBasket(String basketName) {
        this.products = new LinkedList<>();
        this.basketName = basketName;
    }

    public String getName() {
        return basketName;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Продукт \"" + product.getName() + "\" успешно добавлен в " + basketName);
    }

    public int sumPrices() {
        int total = 0;
        for (Product eachProduct : products) {
            if (eachProduct != null) {
                total = total + eachProduct.getPrice();
            } else {
                break;
            }
        }
        return total;
    }

    public void printProductBasket() {
        int total = 0;
        int specialProductCount = 0;
        System.out.println(basketName + ":");
        for (Product eachProduct : products) {
            if (eachProduct != null) {
                System.out.println(eachProduct);
                total = total + eachProduct.getPrice();
                if (eachProduct.isSpecial()) {
                    specialProductCount++;
                }
            } else {
                break;
            }
        }
        if (total != 0) {
            System.out.println("Итого: " + total + " руб.");
            System.out.println("Специальных товаров: " + specialProductCount);
        } else {
            System.out.println("В корзине пусто.");
        }
    }


    public boolean isProductInBasket(String name) {
        for (Product eachProduct : products) {
            if (eachProduct == null) {
                return false;
            } else if (eachProduct.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        products.clear();
    }

    public List<Product> deleteProductByName(String name) {
        Iterator<Product> iterator = products.iterator();
        List<Product> deletedProducts = new ArrayList<>();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                deletedProducts.add(product);
                iterator.remove();
            }
        }
        return deletedProducts;
    }
}

