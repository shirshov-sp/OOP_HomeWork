package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        System.out.println("ДЗ \"Введение в ООП\"\n");

        Product milk = new Product("Молоко", 60);
        Product bread = new Product("Хлеб", 45);
        Product butter = new Product("Масло", 150);
        Product chocolate = new Product("Шоколад", 80);
        Product iceCream = new Product("Мороженное", 130);
        Product sausage = new Product("Колбаса", 400);
        Product juice = new Product("Сок", 150);

        ProductBasket basket1 = new ProductBasket("Корзина №1");
        ProductBasket basket2 = new ProductBasket("Корзина №2");

        basket1.addProduct(milk);
        basket1.addProduct(bread);
        basket1.addProduct(butter);
        basket1.addProduct(sausage);
        basket1.addProduct(juice);
        System.out.println();

        basket2.addProduct(chocolate);
        basket2.addProduct(iceCream);
        basket2.addProduct(juice);
        System.out.println();

        basket1.addProduct(iceCream);
        System.out.println();

        basket1.printProductBasket();
        System.out.println();

        basket2.printProductBasket();
        System.out.println();

        System.out.println("Общая стоимость " + basket1.getName() + " " + basket1.sumPrices() + "р.");
        System.out.println("Общая стоимость " + basket2.getName() + " " + basket2.sumPrices() + "р.");
        System.out.println();

        String nameSearch = "Молоко";
        if (basket1.isProductInBasket(nameSearch)) {
            printProductIsInBasket(nameSearch,basket1.getName());
        } else {
            printProductNotInBasket(nameSearch,basket1.getName());
        }
        System.out.println();

        nameSearch = "Шоколад";
        if (basket1.isProductInBasket(nameSearch)) {
            printProductIsInBasket(nameSearch,basket1.getName());
        } else {
            printProductNotInBasket(nameSearch,basket1.getName());
        }
        System.out.println();

        basket2.cleanBasket();

        basket2.printProductBasket();

        System.out.println();
        System.out.println("Общая стоимость " + basket2.getName() + " " + basket2.sumPrices() + "р.");

        System.out.println();
        if (basket2.isProductInBasket(nameSearch)) {
            printProductIsInBasket(nameSearch,basket2.getName());
        } else {
            printProductNotInBasket(nameSearch,basket2.getName());
        }
        System.out.println();
    }

    public static void printProductIsInBasket (String nameSearch, String basketName){
        System.out.println("Продукт " + nameSearch + " есть в " + basketName);
    }

    public static void printProductNotInBasket (String nameSearch, String basketName){
        System.out.println("Продукт " + nameSearch + " отсутсвует в " + basketName);
    }
}