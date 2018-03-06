package io.jeffchang.buttondemo.ui.userlist.presenter;

import io.jeffchang.buttondemo.network.remote.FakeButtonService;
import io.jeffchang.buttondemo.ui.userlist.view.UserListView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Implementation of dog list presenter.
 */

public class UserListPresenterImpl implements UserListPresenter {

    private final String CANDIDATE_ID = "vbnguirofbm34!";

    private FakeButtonService fakeButtonService;
    private UserListView userListView;

    public UserListPresenterImpl(UserListView userListView,
                                 FakeButtonService fakeButtonService) {
        this.userListView = userListView;
        this.fakeButtonService = fakeButtonService;
    }

    @Override
    public void getUsers() {
        fakeButtonService.getUsers(CANDIDATE_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((userListResponse) -> {
                    userListView.onGetUsersSuccess(userListResponse);
                }, (throwable -> {
                    userListView.onGetUsersFailure(throwable);
                }));
    }
}
