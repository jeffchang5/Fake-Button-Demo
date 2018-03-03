package io.jeffchang.dogdemo;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import io.jeffchang.dogdemo.di.components.DaggerAppComponent;
import timber.log.Timber;

/**
 *  Custom application to inject dependencies and logging tools.
 */

public class DogDemoApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder()
                .application(this)
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());
    }
}
