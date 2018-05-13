package com.gsc.recipes.ui.recipes;


import com.gsc.recipes.domain.model.Recipe;
import com.gsc.recipes.ui.base.BasePresenter;

import java.util.List;

public interface RecipeListView extends BasePresenter.View {

    void showWithoutRecipesText();
    void hideWithoutRecipesText();

    void setRecipes(List<Recipe> recipes);

    void showRecipe(Recipe recipe);
}
