package io.jeffchang.dogdemo.ui.doglist;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.jeffchang.dogdemo.ui.doglist.presenter.DogListPresenter;
import io.jeffchang.dogdemo.ui.doglist.presenter.DogListPresenterImpl;
import io.jeffchang.dogdemo.ui.doglist.view.DogBreedListView;
import io.jeffchang.dogdemo.ui.doglist.view.DogBreedListFragment;

/**
 * Provides dependencies for map fragment module.
 */

@Module
abstract class DogListFragmentModule {

    @Binds
    abstract DogBreedListView provideDogBreedListView(DogBreedListFragment dogBreedListFragment);

    @Provides
    static DogListPresenter provideDogListPresenter() {
        return new DogListPresenterImpl();
    }
}