package com.gsc.recipes;

import android.app.Application;

import com.gsc.recipes.di.components.ApplicationComponent;
import com.gsc.recipes.di.components.DaggerApplicationComponent;
import com.gsc.recipes.di.modules.ApplicationModule;


public class RecipesApplication extends Application {

    private static ApplicationComponent component;
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        component = buildComponent();
    }

    //region Dagger
    private ApplicationComponent buildComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return component;
    }
    //endregion
}
