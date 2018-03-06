package io.jeffchang.buttondemo.ui.usercreate

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.jeffchang.buttondemo.network.remote.FakeButtonService
import io.jeffchang.buttondemo.ui.usercreate.presenter.UserCreatePresenter
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
        fun provideUserCreatePresenter(userCreateView: UserCreateView,
                                       fakeButtonService: FakeButtonService): UserCreatePresenter
                = UserCreatePresenterImpl(userCreateView, fakeButtonService)
    }
}