package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchResultComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int compareResult = Integer.compare(o1.getName().length(), o2.getName().length());
        if (compareResult != 0) {
            return compareResult;
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
