package com.gsc.recipes;

import android.app.Application;

import com.gsc.recipes.di.components.AppComponent;
import com.gsc.recipes.di.components.DaggerAppComponent;
import com.gsc.recipes.di.modules.AppModule;


public class RecipesApplication extends Application {

    private static AppComponent component;
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        component = buildComponent();
    }

    //region Dagger
    private AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
    //endregion
}
