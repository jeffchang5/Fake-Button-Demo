package io.jeffchang.buttondemo

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.jeffchang.buttondemo.di.components.DaggerAppComponent
import timber.log.Timber

/**
 * Custom application to inject dependencies and logging tools.
 */

class FakeButtonApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
                .application(this)
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}
