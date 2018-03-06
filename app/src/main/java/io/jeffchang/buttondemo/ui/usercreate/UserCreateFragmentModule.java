package io.jeffchang.buttondemo.ui.usercreate;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.jeffchang.buttondemo.ui.usercreate.presenter.UserCreatePresenter;
import io.jeffchang.buttondemo.ui.usercreate.presenter.UserCreatePresenterImpl;
import io.jeffchang.buttondemo.ui.usercreate.view.DogDetailFragment;
import io.jeffchang.buttondemo.ui.usercreate.view.DogDetailView;

/**
 * Provides dependencies for map fragment module.
 */

@Module
abstract class UserCreateFragmentModule {

    @Binds
    abstract DogDetailView provideDogDetailFragment(DogDetailFragment dogDetailFragment);

    @Provides
    static UserCreatePresenter provideDogDetailPresenter() {
        return new UserCreatePresenterImpl();
    }
}