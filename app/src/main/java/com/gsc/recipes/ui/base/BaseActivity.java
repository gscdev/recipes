package com.gsc.recipes.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gsc.recipes.R;
import com.gsc.recipes.RecipesApplication;
import com.gsc.recipes.di.components.ActivityComponent;
import com.gsc.recipes.di.components.ApplicationComponent;
import com.gsc.recipes.di.components.DaggerActivityComponent;
import com.gsc.recipes.di.modules.ActivityModule;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getapplicationComponent().inject(this);
    }

    private ApplicationComponent getapplicationComponent() {
        return ((RecipesApplication) getApplication()).getApplicationComponent();
    }


    public ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(RecipesApplication.getApplicationComponent())
                .build();
    }

    public void showErrorMessage() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_SHORT).show();
    }
}
