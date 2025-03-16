package org.skypro.skyshop.search;

import java.io.IOException;

public class BestResultNotFoundException extends IOException {
    String search;

    public BestResultNotFoundException(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "BestResultNotFoundException {Для запроса \"" + search + "\" ничего не нашлось}";
    }
}
