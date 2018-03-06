package io.jeffchang.buttondemo.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.jeffchang.buttondemo.ui.MainActivity
import io.jeffchang.buttondemo.ui.usercreate.UserCreateFragmentProvider
import io.jeffchang.buttondemo.ui.userlist.UserListFragmentProvider

/**
 * Module that exposes the main view components.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [
        UserListFragmentProvider::class,
        UserCreateFragmentProvider::class
    ])
    internal abstract fun bindMainActivity(): MainActivity
}
