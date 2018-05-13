package com.gsc.recipes.domain.model;


public class Recipe {

    private String title;
    private String ingredients;
    private String url;
    /** Image url */
    private String image;


    public Recipe(String title, String ingredients, String url, String image) {
        this.title = title;
        this.ingredients = ingredients;
        this.url = url;
        this.image = image;
    }


    //region getters
    public String getTitle() {
        return title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }
    //endregion
}
