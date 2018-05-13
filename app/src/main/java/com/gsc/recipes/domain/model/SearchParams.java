package com.gsc.recipes.domain.model;

public class SearchParams {

    private String ingredients;
    private String searchText;
    private int page;


    //region getters/setters
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    //endregion
}
