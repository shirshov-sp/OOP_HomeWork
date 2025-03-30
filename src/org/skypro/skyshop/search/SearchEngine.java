package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine() {
        searchables = new LinkedList<>();
    }

    public void addSearchable(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String searchText) {
        List<Searchable> searchResult = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(searchText)) {
                searchResult.add(searchable);
            }
        }
        return searchResult;
    }

    public Searchable bestSearch(String search) throws BestResultNotFoundException {
        Searchable bestSearchResult = null;
        int searchStringBestQuantity = 0;
        for (Searchable searchable : searchables) {
            int searchStringQuantity = 0;
            int index = 0;
            int searchStringIndex = searchable.getSearchTerm().indexOf(search, index);

            while (searchStringIndex != -1) {
                searchStringQuantity++;
                index = searchStringIndex + search.length();
                searchStringIndex = searchable.getSearchTerm().indexOf(search, index);
            }
            if (searchStringQuantity > searchStringBestQuantity) {
                searchStringBestQuantity = searchStringQuantity;
                bestSearchResult = searchable;
            }
        }
        if (bestSearchResult == null) {
            throw new BestResultNotFoundException(search);
        }
        return bestSearchResult;
    }
}

