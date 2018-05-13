package com.gsc.recipes.data.repository;


import com.gsc.recipes.data.repository.datasource.ApiDataSource;
import com.gsc.recipes.data.response.RecipesResponse;

import javax.inject.Inject;


public class DataRepository {

    private final ApiDataSource apiDataSource;

    @Inject
    public DataRepository(ApiDataSource apiDataSource) {
        this.apiDataSource = apiDataSource;
    }


    public RecipesResponse getRecipes(String ingredients, String searchText, int page) {
        return apiDataSource.getRecipes(ingredients, searchText, page);
    }
}
