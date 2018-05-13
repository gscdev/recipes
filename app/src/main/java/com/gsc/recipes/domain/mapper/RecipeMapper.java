package com.gsc.recipes.domain.mapper;

import com.gsc.recipes.data.response.RecipesResponse;
import com.gsc.recipes.domain.mapper.base.BaseMapper;
import com.gsc.recipes.domain.model.Recipe;

import javax.inject.Inject;

public class RecipeMapper extends BaseMapper<RecipesResponse.RecipeResponse, Recipe> {

    @Inject
    public RecipeMapper() {
    }


    @Override
    public Recipe map(RecipesResponse.RecipeResponse recipeResponse) {
        return new Recipe(
                recipeResponse.title,
                recipeResponse.ingredients,
                recipeResponse.href,
                recipeResponse.thumbnail
        );
    }
}
