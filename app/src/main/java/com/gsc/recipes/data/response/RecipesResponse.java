package com.gsc.recipes.data.response;

import com.google.gson.annotations.SerializedName;
import com.gsc.recipes.data.response.base.BaseResponse;

import java.util.List;

public class RecipesResponse extends BaseResponse {

    @SerializedName("results")
    public List<Result> results = null;



    public class Result {

        @SerializedName("title")
        public String title;
        @SerializedName("href")
        public String href;
        @SerializedName("ingredients")
        public String ingredients;
        @SerializedName("thumbnail")
        public String thumbnail;
    }
}
