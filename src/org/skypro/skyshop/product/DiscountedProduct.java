package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountInPercents;

    public DiscountedProduct(String name, int basePrice, int discountInPercents) {
        super(name);
        if (basePrice < 1) {
            throw new IllegalArgumentException("Ошибка! Некорректная цена продукта!");
        }
        if (discountInPercents < 0 || discountInPercents > 100) {
            throw new IllegalArgumentException("Ошибка! Некорректная скидка!");
        }
        this.basePrice = basePrice;
        this.discountInPercents = discountInPercents;
    }

    @Override
    public int getPrice() {
        return basePrice * (100 - discountInPercents) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " руб. (скидка " + discountInPercents + "%)";
    }
}