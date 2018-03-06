package io.jeffchang.buttondemo.ui.userlist.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast

import io.jeffchang.buttondemo.R
import io.jeffchang.buttondemo.models.User
import io.jeffchang.buttondemo.ui.common.BaseFragment
import io.jeffchang.buttondemo.ui.common.LineItemDecoration
import io.jeffchang.buttondemo.ui.userlist.presenter.UserListPresenter
import kotlinx.android.synthetic.main.fragment_user_list.*
import retrofit2.HttpException
import java.net.UnknownHostException

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
            user_list_fragment_recycler_view.addItemDecoration(LineItemDecoration(it))
            userListRecyclerViewAdapter = UserListRecyclerViewAdapter(it, users)
            user_list_fragment_recycler_view.adapter = userListRecyclerViewAdapter
            showMainContent()
        }
    }

    override fun onGetUsersFailure(throwable: Throwable) {
        when (throwable) {
            is HttpException -> {
                if (throwable.code() == 401) {
                    Toast.makeText(context, "Unauthorized", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Unknown error", Toast.LENGTH_LONG).show()
                }
            }
            is UnknownHostException ->
                showErrorView(
                    R.drawable.ic_cloud_off_black_24dp,
                    R.string.no_internet_connection, {
                showProgressBar(getString(R.string.loading_users))
                userListPresenter.getUsers()
            })
        }
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
