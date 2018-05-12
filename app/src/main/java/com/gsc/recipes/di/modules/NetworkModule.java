package com.gsc.recipes.di.modules;

import com.gsc.recipes.data.repository.ws.ApiService;
import com.gsc.recipes.data.repository.ws.RestClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public ApiService provideApiService() {
        return RestClient.getClient().create(ApiService.class);
    }
}
