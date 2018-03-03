package io.jeffchang.dogdemo.ui.doglist;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.jeffchang.dogdemo.ui.doglist.view.DogBreedListFragment;

/**
 * Provides dependencies into the list fragment.
 */

@Module
public abstract class DogListFragmentProvider {

    @ContributesAndroidInjector(modules = {DogListFragmentModule.class})
    abstract DogBreedListFragment provideListFragment();
}