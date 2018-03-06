package io.jeffchang.buttondemo.ui.usercreate

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.jeffchang.buttondemo.ui.usercreate.view.UserCreateFragment

/**
 * Provides dependencies into the list fragment.
 */

@Module
abstract class UserCreateFragmentProvider {

    @ContributesAndroidInjector(modules = [UserCreateFragmentModule::class])
    abstract fun provideUserCreateFragment(): UserCreateFragment
}