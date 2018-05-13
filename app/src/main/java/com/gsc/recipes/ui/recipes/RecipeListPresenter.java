package com.gsc.recipes.ui.recipes;

import com.gsc.recipes.domain.model.Recipe;
import com.gsc.recipes.domain.model.SearchParams;
import com.gsc.recipes.domain.usecase.GetRecipesUseCase;
import com.gsc.recipes.ui.base.BasePresenter;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import static android.text.TextUtils.isEmpty;
import static java.util.Collections.emptyList;


public class RecipeListPresenter extends BasePresenter<RecipeListView>
        implements GetRecipesUseCase.Callback<List<Recipe>> {

    public static final int DEFAULT_PAGE = 1;

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
        if (isEmptyString(searchText)) {
            getView().showWithoutRecipesText();
            getView().setRecipes(Collections.emptyList());
        } else if (isNewString(searchText)) {
            lastSearchText = searchText;
            getRecipes();
        }
    }

    private boolean isEmptyString(String searchText) {
        return (searchText == null) || isEmpty(searchText.trim());
    }

    private boolean isNewString(String searchText) {
        return !searchText.trim().equals(lastSearchText.trim());
    }

    private void getRecipes() {
        searchParams.setSearchText(lastSearchText);
        searchParams.setPage(DEFAULT_PAGE);

        getRecipesUseCase.execute(searchParams, this);
    }

    //region GetRecipesUseCase.Callback
    @Override
    public void onSuccess(List<Recipe> recipeList) {
        this.recipeList = recipeList;

        getView().hideWithoutRecipesText();
        getView().setRecipes(recipeList);
    }

    @Override
    public void onError() {
        getView().showErrorMessage();
    }
    //endregion

    public void onRecipeClick(int position) {
        getView().showRecipe(recipeList.get(position));
    }
}