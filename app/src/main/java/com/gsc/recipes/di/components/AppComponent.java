package com.gsc.recipes.di.components;

import com.gsc.recipes.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
}
