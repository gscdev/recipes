package com.gsc.recipes.di.components;


import com.gsc.recipes.di.PerActivity;
import com.gsc.recipes.di.modules.ActivityModule;
import com.gsc.recipes.ui.recipes.RecipeListActivity;
import com.gsc.recipes.ui.recipes.detail.RecipeDetailActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(RecipeListActivity activity);

    void inject(RecipeDetailActivity activity);
}
