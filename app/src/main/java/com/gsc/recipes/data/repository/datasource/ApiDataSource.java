package com.gsc.recipes.data.repository.datasource;

import com.gsc.recipes.data.repository.ws.ApiService;
import com.gsc.recipes.data.response.RecipesResponse;

import java.io.IOException;

import javax.inject.Inject;

public class ApiDataSource {

    private ApiService apiService;


    @Inject
    public ApiDataSource(ApiService apiService) {
        this.apiService = apiService;
    }


    public RecipesResponse getRecipes(String ingredients, String searchText, int page) {
        RecipesResponse response = null;

        try {
            response = apiService.getRecipes(ingredients, searchText, page).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return response;
    }
}
