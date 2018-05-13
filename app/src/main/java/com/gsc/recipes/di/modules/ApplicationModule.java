package com.gsc.recipes.di.modules;

import android.content.Context;

import com.gsc.recipes.RecipesApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

    private final RecipesApplication application;

    public ApplicationModule(RecipesApplication application) {
        this.application = application;
    }


    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return application;
    }
}
