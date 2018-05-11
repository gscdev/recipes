package com.gsc.recipes.di.modules;

import com.gsc.recipes.di.PerActivity;
import com.gsc.recipes.ui.base.BaseActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private BaseActivity activity;


    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    BaseActivity provideActivity() {
        return activity;
    }
}
