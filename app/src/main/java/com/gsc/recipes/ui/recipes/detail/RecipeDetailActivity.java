package com.gsc.recipes.ui.recipes.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsc.recipes.R;
import com.gsc.recipes.domain.model.Recipe;
import com.gsc.recipes.ui.base.BaseActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecipeDetailActivity extends BaseActivity implements RecipeDetailView {

    public static final String EXTRA_RECIPE = "com.gsc.recipes.ui.recipes.detail.Recipe";

    @Inject
    RecipeDetailPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.recipe_image)
    ImageView imageView;
    @BindView(R.id.recipe_title)
    TextView titleView;
    @BindView(R.id.recipe_ingredients)
    TextView ingredientsView;
    @BindView(R.id.recipe_url)
    TextView urlView;


    public static void open(Context context, Recipe recipe) {
        Intent intent = new Intent(context, RecipeDetailActivity.class);
        intent.putExtra(EXTRA_RECIPE, recipe);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDagger();
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);

        presenter.create();
        presenter.setView(this);
        presenter.setRecipe(getIntent().getParcelableExtra(EXTRA_RECIPE));
    }

    private void initializeDagger() {
        getActivityComponent().inject(this);
    }

    //region Events
    @OnClick(R.id.recipe_url)
    public void onWebClick() {
        presenter.onWebClick();
    }
    //endregion

    //region RecipeDetailView
    @Override
    public void setImage(String imageUrl) {
        Picasso.get().load(imageUrl).placeholder(R.drawable.recipe_placeholder).into(imageView);
    }

    @Override
    public void setTitle(String title) {
        titleView.setText(title);
    }

    @Override
    public void setIngredients(String ingredients) {
        ingredientsView.setText(ingredients);
    }

    @Override
    public void setUrl(String url) {
        urlView.setPaintFlags(urlView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        urlView.setText(url);
    }

    @Override
    public void openWeb(Uri uri) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(browserIntent);
    }
    //endregion
}
