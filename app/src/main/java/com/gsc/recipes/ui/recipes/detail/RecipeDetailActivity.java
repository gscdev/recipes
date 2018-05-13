package com.gsc.recipes.ui.recipes.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gsc.recipes.R;
import com.gsc.recipes.domain.model.Recipe;
import com.gsc.recipes.ui.base.BaseActivity;

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

        presenter.create();
        presenter.setView(this);
    }

    private void initializeDagger() {
        getActivityComponent().inject(this);
    }

    @OnClick(R.id.fab)
    public void onFabClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
