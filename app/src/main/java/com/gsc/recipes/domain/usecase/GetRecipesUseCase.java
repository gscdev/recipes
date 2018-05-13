package com.gsc.recipes.domain.usecase;

import com.gsc.recipes.data.repository.DataRepository;
import com.gsc.recipes.data.response.RecipesResponse;
import com.gsc.recipes.domain.mapper.RecipeMapper;
import com.gsc.recipes.domain.model.Recipe;
import com.gsc.recipes.domain.model.SearchParams;
import com.gsc.recipes.domain.usecase.base.BaseUseCase;

import java.util.List;

import javax.inject.Inject;

import static com.gsc.recipes.utils.StringUtils.getString;


public class GetRecipesUseCase extends BaseUseCase<SearchParams, BaseUseCase.Callback> {

    private DataRepository dataRepository;
    private RecipeMapper recipeMapper;


    @Inject
    public GetRecipesUseCase(DataRepository dataRepository, RecipeMapper recipeMapper) {
        this.dataRepository = dataRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    protected void getData(SearchParams searchParams, Callback callback) {
        RecipesResponse recipesResponse = dataRepository.getRecipes(
                getString(searchParams.getIngredients()),
                getString(searchParams.getSearchText()),
                searchParams.getPage());

        List<Recipe> recipeList = recipeMapper.map(recipesResponse.recipeResponses);

        toMainThread(() -> callback.onSuccess(recipeList));
    }
}
