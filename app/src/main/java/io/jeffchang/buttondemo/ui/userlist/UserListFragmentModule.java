package io.jeffchang.buttondemo.ui.userlist;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.jeffchang.buttondemo.network.remote.FakeButtonService;
import io.jeffchang.buttondemo.ui.userlist.presenter.UserListPresenter;
import io.jeffchang.buttondemo.ui.userlist.presenter.UserListPresenterImpl;
import io.jeffchang.buttondemo.ui.userlist.view.UserListFragment;
import io.jeffchang.buttondemo.ui.userlist.view.UserListView;

/**
 * Provides dependencies for map fragment module.
 */

@Module
abstract class UserListFragmentModule {

    @Binds
    abstract UserListView provideDogBreedListView(UserListFragment dogBreedListFragment);

    @Provides
    static UserListPresenter provideDogListPresenter(UserListView view,
                                                     FakeButtonService fakeButtonService) {
        return new UserListPresenterImpl(view, fakeButtonService);
    }
}