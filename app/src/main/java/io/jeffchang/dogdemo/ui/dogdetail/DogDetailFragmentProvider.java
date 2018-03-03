package io.jeffchang.dogdemo.ui.dogdetail;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.jeffchang.dogdemo.ui.dogdetail.view.DogDetailFragment;

/**
 * Provides dependencies into the list fragment.
 */

@Module
public abstract class DogDetailFragmentProvider {

    @ContributesAndroidInjector(modules = {DogDetailFragmentModule.class})
    abstract DogDetailFragment provideDogDetailFragment();
}