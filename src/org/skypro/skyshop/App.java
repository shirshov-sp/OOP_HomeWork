package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("ДЗ \"Введение в ООП\"\n");

        Product milk = new FixPriceProduct("Молоко");
        Product bread = new FixPriceProduct("Хлеб");
        Product butter = new SimpleProduct("Масло", 150);
        Product chocolate = new DiscountedProduct("Шоколад", 80, 10);
        Product iceCream = new DiscountedProduct("Мороженное", 130, 20);
        Product sausage = new SimpleProduct("Колбаса", 400);
        Product juice = new SimpleProduct("Сок", 150);

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
            printProductIsInBasket(nameSearch, basket1.getName());
        } else {
            printProductNotInBasket(nameSearch, basket1.getName());
        }
        System.out.println();

        nameSearch = "Шоколад";
        if (basket1.isProductInBasket(nameSearch)) {
            printProductIsInBasket(nameSearch, basket1.getName());
        } else {
            printProductNotInBasket(nameSearch, basket1.getName());
        }
        System.out.println();

        basket2.cleanBasket();

        basket2.printProductBasket();

        System.out.println();
        System.out.println("Общая стоимость " + basket2.getName() + " " + basket2.sumPrices() + "р.");

        System.out.println();
        if (basket2.isProductInBasket(nameSearch)) {
            printProductIsInBasket(nameSearch, basket2.getName());
        } else {
            printProductNotInBasket(nameSearch, basket2.getName());
        }
        System.out.println();

        System.out.println("__________________________________");
        System.out.println("ДЗ \"ООП. Полиморфизм. Интерфейсы.\"\n");

        SearchEngine searchEngine1 = new SearchEngine(10);

        searchEngine1.addSearchable(milk);
        searchEngine1.addSearchable(bread);
        searchEngine1.addSearchable(butter);
        searchEngine1.addSearchable(chocolate);
        searchEngine1.addSearchable(iceCream);
        searchEngine1.addSearchable(sausage);
        searchEngine1.addSearchable(juice);

        Article aboutMilk = new Article("О молоке.", "Молоко полезно для ребенка!");
        Article aboutAlcohol = new Article("Про коньяк", "Алкоголь вреден беременным.");
        Article aboutButter = new Article("Про масло", "Кашу маслом не испортишь!");
        Article aboutBread = new Article("Хлеб", "Хлеб - всему голова!");

        searchEngine1.addSearchable(aboutMilk);
        searchEngine1.addSearchable(aboutAlcohol);
        searchEngine1.addSearchable(aboutButter);
        searchEngine1.addSearchable(aboutBread);
        System.out.println();

        System.out.println(Arrays.toString(searchEngine1.search("Молоко")));
        System.out.println(Arrays.toString(searchEngine1.search("Алкоголь")));
        System.out.println(Arrays.toString(searchEngine1.search("Хлеб")));
        System.out.println(Arrays.toString(searchEngine1.search("а")));
        System.out.println(Arrays.toString(searchEngine1.search("батон")));

        System.out.println();
        System.out.println(aboutBread.getStringRepresentation());
        System.out.println(sausage.getStringRepresentation());
    }

    public static void printProductIsInBasket(String nameSearch, String basketName) {
        System.out.println("Продукт " + nameSearch + " есть в " + basketName);
    }

    public static void printProductNotInBasket(String nameSearch, String basketName) {
        System.out.println("Продукт " + nameSearch + " отсутсвует в " + basketName);
    }
}