package io.jeffchang.buttondemo.ui.usercreate.presenter

import io.jeffchang.buttondemo.models.User
import io.jeffchang.buttondemo.network.remote.FakeButtonService
import io.jeffchang.buttondemo.network.remote.FakeButtonService.Companion.CANDIDATE_ID
import io.jeffchang.buttondemo.ui.usercreate.view.UserCreateView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Implementation of dog detail presenter.
 */

class UserCreatePresenterImpl(
        private val userListView: UserCreateView,
        private val fakeButtonService: FakeButtonService)
    : UserCreatePresenter {

    override fun postUser(name: String, email: String) {
        fakeButtonService
                .postUser(User(null, name, email, CANDIDATE_ID))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { userListView.postUserSuccess(it) },
                        { userListView.postUserFailure(it) })
    }
}
