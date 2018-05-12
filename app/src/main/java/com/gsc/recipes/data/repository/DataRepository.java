package com.gsc.recipes.data.repository;


import com.gsc.recipes.data.repository.datasource.ApiDataSource;

import javax.inject.Inject;


public class DataRepository {

    private final ApiDataSource apiDataSource;

    @Inject
    public DataRepository(ApiDataSource apiDataSource) {
        this.apiDataSource = apiDataSource;
    }


    public void getRecipes(String ingredients, String searchText, int page) {
        apiDataSource.getRecipes(ingredients, searchText, page);
    }
}
