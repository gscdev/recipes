package com.gsc.recipes.ui.recipes.detail;

import android.net.Uri;

import com.gsc.recipes.domain.model.Recipe;
import com.gsc.recipes.ui.base.BasePresenter;

import javax.inject.Inject;

import static android.text.TextUtils.isEmpty;

public class RecipeDetailPresenter extends BasePresenter<RecipeDetailView> {

    private Recipe recipe;

    @Inject
    public RecipeDetailPresenter() {
    }

    @Override
    public void create() {
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;

        if (!isEmpty(recipe.getImage())) {
            getView().setImage(recipe.getImage());
        }
        getView().setTitle(recipe.getTitle());
        getView().setIngredients(recipe.getIngredients());
        getView().setUrl(recipe.getUrl());
    }

    public void onWebClick() {
        getView().openWeb(Uri.parse(recipe.getUrl()));
    }
}
