package com.gsc.recipes.data.repository.ws;


import com.gsc.recipes.data.response.RecipesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {

    @GET("api/")
    Call<RecipesResponse> getRecipes(
            @Query("i") String ingredients,
            @Query("q") String searchText,
            @Query("p") int page);
}
