package io.jeffchang.buttondemo.ui.userlist.presenter

import io.jeffchang.buttondemo.network.remote.FakeButtonService
import io.jeffchang.buttondemo.ui.userlist.view.UserListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Implementation of dog list presenter.
 */

class UserListPresenterImpl(private val userListView: UserListView,
                            private val fakeButtonService: FakeButtonService) : UserListPresenter {

    override fun getUsers() {
        fakeButtonService.getUsers(CANDIDATE_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { userListView.onGetUsersSuccess(it) },
                        { userListView.onGetUsersFailure(it) })
    }

    companion object {
        private const val CANDIDATE_ID = "vbnguirofbm34!"
    }
}
