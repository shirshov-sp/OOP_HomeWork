package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFoundException;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        basket1.addProduct(bread);
        basket1.addProduct(butter);
        basket1.addProduct(sausage);
        basket1.addProduct(juice);
        basket1.addProduct(iceCream);
        System.out.println();

        basket2.addProduct(chocolate);
        basket2.addProduct(iceCream);
        basket2.addProduct(juice);
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

        SearchEngine searchEngine1 = new SearchEngine();

        searchEngine1.addSearchable(milk);
        searchEngine1.addSearchable(bread);
        searchEngine1.addSearchable(butter);
        searchEngine1.addSearchable(chocolate);
        searchEngine1.addSearchable(iceCream);
        searchEngine1.addSearchable(sausage);
        searchEngine1.addSearchable(juice);

        Article aboutMilk = new Article("О молоке.", "Молоко полезно для ребенка!");
        Article aboutAlcohol = new Article("Про коньяк.", "Алкоголь вреден беременным.");
        Article aboutButter = new Article("Про масло.", "Кашу маслом не испортишь!");
        Article aboutBread = new Article("Хлеб.", "Хлеб - всему голова!");

        searchEngine1.addSearchable(aboutMilk);
        searchEngine1.addSearchable(aboutAlcohol);
        searchEngine1.addSearchable(aboutButter);
        searchEngine1.addSearchable(aboutBread);
        System.out.println();

        System.out.println(searchEngine1.search("Молоко"));
        System.out.println(searchEngine1.search("Алкоголь"));
        System.out.println(searchEngine1.search("Хлеб"));
        System.out.println(searchEngine1.search("а"));
        System.out.println(searchEngine1.search("батон"));

        System.out.println();
        System.out.println(aboutBread.getStringRepresentation());
        System.out.println(sausage.getStringRepresentation());

        System.out.println();
        System.out.println("__________________________________");
        System.out.println("ДЗ \"ООП. Исключения\"\n");

        try {
            Product pepper = new FixPriceProduct("  ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product salt = new SimpleProduct("Соль", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product potato = new DiscountedProduct("Картофель", 80, 120);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product meat = new DiscountedProduct("Мясо", -10, 20);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        String search = "масло";
        printBestSearchResultFor(search);
        try {
            System.out.println(searchEngine1.bestSearch(search));
        } catch (BestResultNotFoundException e) {
            System.out.println(e);
        }

        System.out.println();
        search = "водка";
        printBestSearchResultFor(search);
        try {
            System.out.println(searchEngine1.bestSearch(search));
        } catch (BestResultNotFoundException e) {
            System.out.println(e);
        }

        System.out.println();
        System.out.println("__________________________________");
        System.out.println("ДЗ \"ООП. Списки\"\n");

        demonstrationOfDeleteProduct(basket1, "молоко");
        demonstrationOfDeleteProduct(basket1, "хлеб");
        demonstrationOfDeleteProduct(basket1, "коньяк");

        System.out.println();
        System.out.println("__________________________________");
        System.out.println("ДЗ \"ООП. Map\"\n");

        search = "молоко";
        printSearchResult(search, searchEngine1);
        search = "мыло";
        printSearchResult(search, searchEngine1);
        search = "ле";
        printSearchResult(search, searchEngine1);

        System.out.println();
        System.out.println("__________________________________");
        System.out.println("ДЗ \"ООП. Set\"\n");

        printSearchResult("молоко", searchEngine1);
        printSearchResult("капуста", searchEngine1);
        printSearchResult("хлеб", searchEngine1);
        printSearchResult("ол", searchEngine1);
    }

    public static void printProductIsInBasket(String nameSearch, String basketName) {
        System.out.println("Продукт " + nameSearch + " есть в " + basketName);
    }

    public static void printProductNotInBasket(String nameSearch, String basketName) {
        System.out.println("Продукт " + nameSearch + " отсутсвует в " + basketName);
    }

    public static void printBestSearchResultFor(String search) {
        System.out.println("Результат лучшего поиска для \"" + search + "\":");
    }

    public static void demonstrationOfDeleteProduct(ProductBasket basket, String productToDelete) {
        System.out.println();
        System.out.println("Удаляем из корзины продукт: " + productToDelete);
        List<Product> deletedProducts = new ArrayList<>(basket.deleteProductByName(productToDelete));
        if (deletedProducts.isEmpty()) {
            System.out.println("Список удаленных продуктов пуст");
        } else {
            System.out.println("Удалено: \n" + deletedProducts);
        }
        System.out.println();
        System.out.println("Содержиое корзины после удаления продукта: " + productToDelete);
        basket.printProductBasket();
    }

    public static void printSearchResult(String search, SearchEngine searchEngine) {
        System.out.println("Результат поиска для \"" + search + "\":");
        Set<Searchable> searchResult = searchEngine.search(search);
        if (searchResult.isEmpty()) {
            System.out.println("Ничего не найдено\n");
        } else {
            System.out.println(searchResult + "\n");
        }
    }
}