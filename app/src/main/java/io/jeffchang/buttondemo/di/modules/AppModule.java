package io.jeffchang.buttondemo.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.jeffchang.buttondemo.di.components.MainActivityComponent;

/**
 * Module that exposes the application context.
 */

@Module(subcomponents = {MainActivityComponent.class})
class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }
}
