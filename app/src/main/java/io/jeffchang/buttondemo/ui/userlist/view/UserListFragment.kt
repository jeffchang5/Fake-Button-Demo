package io.jeffchang.buttondemo.ui.userlist.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View

import io.jeffchang.buttondemo.R
import io.jeffchang.buttondemo.models.User
import io.jeffchang.buttondemo.ui.common.BaseFragment
import io.jeffchang.buttondemo.ui.userlist.presenter.UserListPresenter
import kotlinx.android.synthetic.main.fragment_user_list.*

import javax.inject.Inject

/**
 * Fragment that displays a list of dog breeds.
 */

class UserListFragment : BaseFragment(), UserListView {

    @Inject lateinit var userListPresenter: UserListPresenter

    private var userListRecyclerViewAdapter: UserListRecyclerViewAdapter? = null

    override var layoutResourceID: Int = R.layout.fragment_user_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgressBar(getString(R.string.loading_users))
        userListPresenter.getUsers()
    }

    override fun onGetUsersSuccess(users: List<User>) {
        context?.let {
            user_list_fragment_recycler_view.layoutManager = LinearLayoutManager(it)
            userListRecyclerViewAdapter = UserListRecyclerViewAdapter(it, users)
            user_list_fragment_recycler_view.adapter = userListRecyclerViewAdapter
            showMainContent()
        }
    }

    override fun onGetUsersFailure(throwable: Throwable) {

    }

    companion object {

        fun newInstance(): UserListFragment {
            val args = Bundle()
            val fragment = UserListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
