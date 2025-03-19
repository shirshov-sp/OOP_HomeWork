package org.skypro.skyshop.search;

public class BestResultNotFoundException extends RuntimeException {
    String search;

    public BestResultNotFoundException(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "BestResultNotFoundException {Для запроса \"" + search + "\" ничего не нашлось}";
    }
}
