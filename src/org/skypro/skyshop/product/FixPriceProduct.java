package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private static final int FIX_PRICE = 49;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + getPrice() + " руб.";
    }
}
