package io.jeffchang.buttondemo.ui.usercreate;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.jeffchang.buttondemo.ui.usercreate.view.DogDetailFragment;

/**
 * Provides dependencies into the list fragment.
 */

@Module
public abstract class UserCreateFragmentProvider {

    @ContributesAndroidInjector(modules = {UserCreateFragmentModule.class})
    abstract DogDetailFragment provideDogDetailFragment();
}