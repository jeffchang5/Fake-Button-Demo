package io.jeffchang.buttondemo.ui.userlist

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.jeffchang.buttondemo.network.remote.FakeButtonService
import io.jeffchang.buttondemo.ui.userlist.presenter.UserListPresenter
import io.jeffchang.buttondemo.ui.userlist.presenter.UserListPresenterImpl
import io.jeffchang.buttondemo.ui.userlist.view.UserListFragment
import io.jeffchang.buttondemo.ui.userlist.view.UserListView

/**
 * Provides dependencies for map fragment module.
 */

@Module
abstract class UserListFragmentModule {

    @Binds
    abstract fun provideUserListView(userListFragment: UserListFragment): UserListView

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideDogListPresenter(view: UserListView,
                                    fakeButtonService: FakeButtonService): UserListPresenter {
            return UserListPresenterImpl(view, fakeButtonService)
        }
    }
}