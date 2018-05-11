package com.gsc.recipes.di.components;

import com.gsc.recipes.di.modules.ApplicationModule;
import com.gsc.recipes.ui.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);
}
