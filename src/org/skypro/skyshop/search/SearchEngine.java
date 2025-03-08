package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchables;
    private int count;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
        count = 0;
    }

    public void addSearchable(Searchable searchable) {
        if (count == searchables.length) {
            System.out.println("Массив для поиска заполнен");
            return;
        }
        searchables[count] = searchable;
        count++;
    }

    public Searchable[] search(String searchText) {
        Searchable[] searchResult = new Searchable[5];
        int count = 0;
        for (Searchable searchable : searchables) {
            if (count == 5) {
                break;
            }
            if (searchable.getSearchTerm().contains(searchText)) {
                searchResult[count] = searchable;
                count++;
            }
        }
        return searchResult;
    }
}

