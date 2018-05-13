package com.gsc.recipes.ui.recipes.detail;

import android.net.Uri;

import com.gsc.recipes.ui.base.BasePresenter;

public interface RecipeDetailView extends BasePresenter.View {

    void setImage(String imageUrl);

    void setTitle(String title);

    void setIngredients(String ingredients);

    void setUrl(String url);
    void openWeb(Uri uri);
}
