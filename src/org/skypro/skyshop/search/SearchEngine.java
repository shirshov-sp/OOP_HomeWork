package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public void addSearchable(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String searchText) {
        return searchables.stream()
                .filter(searchable -> searchable.getSearchTerm().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchResultComparator())));
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

