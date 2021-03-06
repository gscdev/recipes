package com.gsc.recipes.ui.recipes;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;

import com.gsc.recipes.R;
import com.gsc.recipes.domain.model.Recipe;
import com.gsc.recipes.ui.base.BaseActivity;
import com.gsc.recipes.ui.recipes.detail.RecipeDetailActivity;
import com.gsc.recipes.ui.view.OnItemClickListener;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecipeListActivity extends BaseActivity implements RecipeListView,
        SearchView.OnQueryTextListener, OnItemClickListener<Integer> {

    @Inject
    RecipeListPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.without_recipes)
    View withoutRecipesView;
    @BindView(R.id.recipe_list)
    RecyclerView recyclerView;

    RecipesRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDagger();
        setContentView(R.layout.activity_recipe_list);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setUpView();

        presenter.create();
        presenter.setView(this);
    }

    private void setUpView() {
        adapter = new RecipesRecyclerViewAdapter(Collections.emptyList(), this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recipe_list, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
        recyclerView.setAdapter(null);
    }

    private void initializeDagger() {
        getActivityComponent().inject(this);
    }

    //region OnQueryTextListener
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        presenter.onSearchTextChange(newText);
        return true;
    }
    //endregion

    //region RecipeListView
    @Override
    public void showWithoutRecipesText() {
        withoutRecipesView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideWithoutRecipesText() {
        withoutRecipesView.setVisibility(View.GONE);
    }

    @Override
    public void setRecipes(List<Recipe> recipes) {
        adapter.refreshRecipes(recipes);
    }

    @Override
    public void showRecipe(Recipe recipe) {
        RecipeDetailActivity.open(this, recipe);
    }
    //endregion

    //region OnItemClickListener
    @Override
    public void onItemClick(Integer position) {
        presenter.onRecipeClick(position);
    }
    //endregion
}
