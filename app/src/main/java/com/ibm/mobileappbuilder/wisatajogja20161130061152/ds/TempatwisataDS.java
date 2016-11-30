
package com.ibm.mobileappbuilder.wisatajogja20161130061152.ds;

import ibmmobileappbuilder.ds.Count;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.Distinct;
import ibmmobileappbuilder.ds.Pagination;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import ibmmobileappbuilder.util.FilterUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * "TempatwisataDS" static data source (1e098fda-b6a7-44d4-9313-6db719025394)
 */
public class TempatwisataDS implements Datasource<TempatwisataDSSchemaItem>, Count,
            Pagination<TempatwisataDSSchemaItem>, Distinct {

    private static final int PAGE_SIZE = 20;

    private SearchOptions searchOptions;

    public static TempatwisataDS getInstance(SearchOptions searchOptions){
        return new TempatwisataDS(searchOptions);
    }

    private TempatwisataDS(SearchOptions searchOptions){
        this.searchOptions = searchOptions;
    }

    @Override
    public void getItems(Listener<List<TempatwisataDSSchemaItem>> listener) {
        listener.onSuccess(TempatwisataDSItems.ITEMS);
    }

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

	@Override
	public void getItem(String id, Listener<TempatwisataDSSchemaItem> listener) {
		final int pos = Integer.parseInt(id);
		if(TempatwisataDSItems.ITEMS.size() <= pos){
			listener.onSuccess(new TempatwisataDSSchemaItem());
		} else {
			TempatwisataDSSchemaItem dc;
			List<TempatwisataDSSchemaItem> filteredItem = applySearchOptions(TempatwisataDSItems.ITEMS);
			
			if(filteredItem != null && !filteredItem.isEmpty()) {
				dc = filteredItem.get(0);
			} else {
				dc = TempatwisataDSItems.ITEMS.get(pos);
			}
			
			if( dc != null)
				listener.onSuccess(dc);
			else
				listener.onFailure(new IllegalArgumentException("TempatwisataDSSchemaItem not found: " + pos));
		}
	}

    @Override public int getCount(){
        return TempatwisataDSItems.ITEMS.size();
    }

    @Override
    public void getItems(int pagenum, Listener<List<TempatwisataDSSchemaItem>> listener) {
        int first = pagenum * PAGE_SIZE;
        int last = first + PAGE_SIZE;
        ArrayList<TempatwisataDSSchemaItem> result = new ArrayList<TempatwisataDSSchemaItem>();
        List<TempatwisataDSSchemaItem> filteredList = applySearchOptions(TempatwisataDSItems.ITEMS);
        if(first < filteredList.size())
            for (int i = first; (i < last) && (i < filteredList.size()); i++)
                result.add(filteredList.get(i));

        listener.onSuccess(result);
    }

    @Override
    public void onSearchTextChanged(String s){
        searchOptions.setSearchText(s);
    }

    @Override
    public void addFilter(Filter filter){
        searchOptions.addFilter(filter);
    }

    @Override
    public void clearFilters() {
        searchOptions.setFilters(null);
    }

    private List<TempatwisataDSSchemaItem> applySearchOptions(List<TempatwisataDSSchemaItem> result) {
        List<TempatwisataDSSchemaItem> filteredList = result;

        //Searching options
        String searchText = searchOptions.getSearchText();

        if(searchOptions.getFixedFilters() != null)
            filteredList = applyFilters(filteredList, searchOptions.getFixedFilters());

        if(searchOptions.getFilters() != null)
            filteredList = applyFilters(filteredList, searchOptions.getFilters());

        if (searchText != null && !"".equals(searchText))
            filteredList = applySearch(filteredList, searchText);

        //Sorting options
        Comparator comparator = searchOptions.getSortComparator();
        if (comparator != null) {
            if (searchOptions.isSortAscending()) {
                Collections.sort(filteredList, comparator);
            } else {
                Collections.sort(filteredList, Collections.reverseOrder(comparator));
            }
        }

        return filteredList;
    }

    private List<TempatwisataDSSchemaItem> applySearch(List<TempatwisataDSSchemaItem> items, String searchText) {
        List<TempatwisataDSSchemaItem> filteredList = new ArrayList<>();

        for (TempatwisataDSSchemaItem item : items) {
                        
            if (FilterUtils.searchInString(item.id, searchText) ||
            FilterUtils.searchInString(item.namaWisata, searchText) ||
            FilterUtils.searchInString(item.tempat, searchText) ||
            FilterUtils.searchInString(item.deskripsi, searchText))
            {
                filteredList.add(item);
            }
        }

        return filteredList;

    }

    private List<TempatwisataDSSchemaItem> applyFilters(List<TempatwisataDSSchemaItem> items, List<Filter> filters) {
        List<TempatwisataDSSchemaItem> filteredList = new ArrayList<>();

        for (TempatwisataDSSchemaItem item : items) {
            if (
                FilterUtils.applyFilters("id", item.id, filters) &&
                FilterUtils.applyFilters("namaWisata", item.namaWisata, filters) &&
                FilterUtils.applyFilters("tempat", item.tempat, filters) &&
                FilterUtils.applyFilters("deskripsi", item.deskripsi, filters) &&
                FilterUtils.applyFilters("gambar", item.gambar, filters) &&
                FilterUtils.applyFilters("lokasi", item.lokasi, filters)
                ){

                filteredList.add(item);
            }
        }

        return filteredList;
    }

    // Distinct interface

    @Override
    public void getUniqueValuesFor(String columnName, Listener<List<String>> listener) {
        List<TempatwisataDSSchemaItem> filteredList = applySearchOptions(TempatwisataDSItems.ITEMS);
        listener.onSuccess(mapItems(filteredList, columnName));
    }

    private List<String> mapItems(List<TempatwisataDSSchemaItem> items, String columnName){
        // return only unique values
        ArrayList<String> res = new ArrayList();
        for (TempatwisataDSSchemaItem item: items){
            String mapped = mapItem(item, columnName);
            if(mapped != null && !res.contains(mapped))
                res.add(mapped);
        }

        return res;
    }

    private String mapItem(TempatwisataDSSchemaItem item, String columnName){
        // get fields
        switch (columnName){
                        
            case "id":
                return item.id;
            
            case "namaWisata":
                return item.namaWisata;
            
            case "tempat":
                return item.tempat;
            
            case "deskripsi":
                return item.deskripsi;
            default:
               return null;
        }
    }
}

