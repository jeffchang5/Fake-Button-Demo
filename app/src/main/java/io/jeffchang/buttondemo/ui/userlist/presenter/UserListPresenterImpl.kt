package io.jeffchang.buttondemo.ui.userlist.presenter

import io.jeffchang.buttondemo.network.remote.FakeButtonService
import io.jeffchang.buttondemo.network.remote.FakeButtonService.Companion.CANDIDATE_ID
import io.jeffchang.buttondemo.ui.userlist.view.UserListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Implementation of dog list presenter.
 */

class UserListPresenterImpl(private val userListView: UserListView,
                            private val fakeButtonService: FakeButtonService) : UserListPresenter {

    override fun getUsers() {
        fakeButtonService.getUsers(CANDIDATE_ID)
                .delay(300, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { userListView.onGetUsersSuccess(it) },
                        { userListView.onGetUsersFailure(it) })
    }
}
