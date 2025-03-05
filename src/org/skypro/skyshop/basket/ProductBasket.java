package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private Product[] products;
    private String basketName;

    public ProductBasket(String basketName) {
        this.products = new Product[5];
        this.basketName = basketName;
    }

    public String getName() {
        return basketName;
    }

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                System.out.println("Продукт \"" + product.getName() + "\" успешно добавлен в " + basketName);
                return;
            }
        }
        System.out.println("Невозможно добавить продукт в " + basketName);
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
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                products[i] = null;
            } else {
                return;
            }
        }
    }
}
