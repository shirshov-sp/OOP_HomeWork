package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine() {
        searchables = new LinkedList<>();
    }

    public void addSearchable(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String searchText) {
        Map<String, Searchable> searchResult = new TreeMap<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().toLowerCase().contains(searchText.toLowerCase())) {
                searchResult.put(searchable.getName(), searchable);
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

