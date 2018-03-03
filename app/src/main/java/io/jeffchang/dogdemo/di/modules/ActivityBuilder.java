package io.jeffchang.dogdemo.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.jeffchang.dogdemo.ui.MainActivity;
import io.jeffchang.dogdemo.ui.dogdetail.DogDetailFragmentProvider;
import io.jeffchang.dogdemo.ui.doglist.DogListFragmentProvider;

/**
 * Module that exposes the main view components.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            DogListFragmentProvider.class,
            DogDetailFragmentProvider.class
    })
    abstract MainActivity bindMainActivity();
}
