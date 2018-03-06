package io.jeffchang.buttondemo.ui.userlist;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.jeffchang.buttondemo.ui.userlist.view.UserListFragment;

/**
 * Provides dependencies into the list fragment.
 */

@Module
public abstract class UserListFragmentProvider {

    @ContributesAndroidInjector(modules = {UserListFragmentModule.class})
    abstract UserListFragment provideListFragment();
}