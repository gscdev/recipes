package com.gsc.recipes.ui.recipes;

import com.gsc.recipes.domain.model.Recipe;
import com.gsc.recipes.domain.model.SearchParams;
import com.gsc.recipes.domain.usecase.GetRecipesUseCase;
import com.gsc.recipes.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import static java.util.Collections.emptyList;

public class RecipeListPresenter extends BasePresenter<RecipeListView>
        implements GetRecipesUseCase.Callback<List<Recipe>> {

    private GetRecipesUseCase getRecipesUseCase;

    private String lastSearchText = "";
    private SearchParams searchParams;
    private List<Recipe> recipeList;


    @Inject
    public RecipeListPresenter(GetRecipesUseCase getRecipesUseCase) {
        this.getRecipesUseCase = getRecipesUseCase;
    }

    @Override
    public void create() {
        searchParams = new SearchParams();
    }


    public void onSearchTextChange(String searchText) {
        if (isNewString(searchText)) {
            lastSearchText = searchText;
            getRecipes();
        }
    }

    private boolean isNewString(String searchText) {
        return !searchText.trim().equals(lastSearchText.trim());
    }

    private void getRecipes() {
        searchParams.setSearchText(lastSearchText);
        searchParams.setPage(1);

        getRecipesUseCase.execute(searchParams, this);
    }

    //region GetRecipesUseCase.Callback
    @Override
    public void onSuccess(List<Recipe> recipeList) {
        this.recipeList = recipeList;
        getView().setRecipes(recipeList);
    }

    @Override
    public void onError() {
        recipeList = emptyList();
    }
    //endregion

    public void onRecipeClick(int position) {
        getView().showRecipe(recipeList.get(position));
    }
}