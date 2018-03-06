package io.jeffchang.buttondemo.di.modules

import android.app.Application
import android.content.Context

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import io.jeffchang.buttondemo.di.components.MainActivityComponent

/**
 * Module that exposes the application context.
 */

@Module(subcomponents = [MainActivityComponent::class])
internal class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application) = application
}
