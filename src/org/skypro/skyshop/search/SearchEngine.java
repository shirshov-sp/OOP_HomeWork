package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public void addSearchable(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String searchText) {
        Set<Searchable> searchResult = new TreeSet<>(new SearchResultComparator());
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().toLowerCase().contains(searchText.toLowerCase())) {
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

