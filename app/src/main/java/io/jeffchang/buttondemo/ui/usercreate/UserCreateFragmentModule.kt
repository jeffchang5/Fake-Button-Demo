package io.jeffchang.buttondemo.ui.usercreate

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.jeffchang.buttondemo.ui.usercreate.presenter.UserCreatePresenterImpl
import io.jeffchang.buttondemo.ui.usercreate.view.UserCreateFragment
import io.jeffchang.buttondemo.ui.usercreate.view.UserCreateView

/**
 * Provides dependencies for map fragment module.
 */

@Module
abstract class UserCreateFragmentModule {

    @Binds
    abstract fun provideUserCreateView(userCreateFragment: UserCreateFragment): UserCreateView

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideUserCreatePresenter() = UserCreatePresenterImpl()
    }
}